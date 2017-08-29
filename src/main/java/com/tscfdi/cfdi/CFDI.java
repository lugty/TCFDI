package com.tscfdi.cfdi;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tscfdi.common.NamespacePrefixMapperImpl;
import com.tscfdi.common.URIResolverImpl;
import com.tscfdi.comprobante.DataComplemento;
import com.tscfdi.comprobante.DataComprobante;

import com.tscfdi.comprobante.TimbreFiscalDigital;
import com.tscfdi.comprobante.complementos.DataImpuestosLocales;
import com.tscfdi.comprobante.nomina.DataNomina;

import org.apache.commons.codec.binary.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

/**
 * Created by lugty on 19/08/16.
 */
public class CFDI {
    private DataComprobante comprobante;
    private static final String XSLT = "/xslt/cadenaoriginal_3_3.xslt";
    private final JAXBContext context;

    private static final String BASE_CONTEXT = "com.tscfdi.comprobante";
    private final static Joiner JOINER = Joiner.on(':');

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String SCHEMA_LOCATION_CFDI = "http://www.sat.gob.mx/cfd/3  http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd ";
    private static final String SCHEMA_LOCATION_NOMINA = "http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd ";
    private static final String SCHEMA_LOCATION_IMP_LOCALES = "http://www.sat.gob.mx/implocal http://www.sat.gob.mx/sitio_internet/cfd/implocal/implocal.xsd";

    public static final ImmutableMap<String, String> PREFIXES =
            ImmutableMap.of(
                    "http://www.sat.gob.mx/TimbreFiscalDigital", "tfd"
            );

    private Map<String, String> localPrefixes;

    public CFDI(DataComprobante comprobante, String... contexts) throws Exception{
        this.localPrefixes = Maps.newHashMap(PREFIXES);
        this.comprobante = comprobante;
        this.context = getContext(contexts);
    }

    public CFDI(InputStream in, String... contexts) throws Exception{
        this.localPrefixes = Maps.newHashMap(PREFIXES);
        this.context = getContext(contexts);
        this.comprobante = loadComprobante(in, contexts);
    }

    public void addNamespace(String uri, String prefix) {
        this.localPrefixes.put(uri, prefix);
    }

    public void sellar(PrivateKey key, X509Certificate cert) throws Exception {
        cert.checkValidity();
        String signature = getSignature(key);
        comprobante.setSello(signature);
        byte[] bytes = cert.getEncoded();
        Base64 b64 = new Base64(-1);
        String certStr = b64.encodeToString(bytes);
        comprobante.setCertificado(certStr);
        BigInteger bi = cert.getSerialNumber();
        comprobante.setNoCertificado(new String(bi.toByteArray()));
    }

    private String getSignature(PrivateKey key) throws Exception {
        byte[] bytes = getBytesCadenaOriginal();
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(key);
        sig.update(bytes);
        byte[] signed = sig.sign();
        Base64 b64 = new Base64(-1);
        return b64.encodeToString(signed);
    }

    public byte[] getBytesCadenaOriginal() throws Exception{
        JAXBSource in = new JAXBSource(context, comprobante);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Result out = new StreamResult(baos);

        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setURIResolver(new URIResolverImpl());

        Transformer transformer = factory.newTransformer(new StreamSource(getClass().getResourceAsStream(XSLT)));
        transformer.transform(in, out);

        return baos.toByteArray();
    }

    public String getCadenaOriginal(){
        try {
            byte[] bCO = this.getBytesCadenaOriginal();
            return new String(bCO, "UTF8");
        } catch (Exception e){
            return "Error, "+e.getMessage();
        }
    }

    public byte[] getBytesXML() throws Exception{
        Marshaller m = context.createMarshaller();

        m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapperImpl(localPrefixes));
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, this.getApplicableNS(this.getComprobante()));
        byte[] xmlHeaderBytes = XML_HEADER.getBytes("UTF8");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(xmlHeaderBytes);
        m.marshal(comprobante, baos);

        return baos.toByteArray();
    }

    private static JAXBContext getContext(String[] contexts) throws Exception {
        List<String> ctx = Lists.asList(BASE_CONTEXT, contexts);
        return JAXBContext.newInstance(JOINER.join(ctx));
    }

    /*********** xml to object **********/
    private static DataComprobante loadComprobante(InputStream source, String... contexts) throws Exception {
        JAXBContext context = getContext(contexts);
        DataComprobante var4;
        try {
            Unmarshaller u = context.createUnmarshaller();
            var4 = (DataComprobante)u.unmarshal(source);
        } finally {
            source.close();
        }
        return var4;
    }

    /** get Timbrado Fiscal **/
    public TimbreFiscalDigital getTimbrado(String... contexts) throws Exception{
        if(this.comprobante.getComplemento() == null)
            return null;

        List<Object> objComp = this.comprobante.getComplemento().getAny();
        if(objComp.size() == 0) return null;

        Object timbradoObj = objComp.get(0);

        JAXBContext context = JAXBContext.newInstance(com.tscfdi.comprobante.TimbreFiscalDigital.class);
        TimbreFiscalDigital t = (TimbreFiscalDigital)context.createUnmarshaller().unmarshal((org.w3c.dom.Node) timbradoObj);
        return t;
    }

    public DataComprobante getComprobante() {
        return comprobante;
    }

    /** get NS LOCATION applicable **/
    private String getApplicableNS(DataComprobante comp){
        String nm = this.SCHEMA_LOCATION_CFDI;

        DataComplemento cmp = comp.getComplemento();
        if(cmp != null){
            List<Object> any = cmp.getAny();
            if(any != null && any.size() > 0){
                for(Object obj: any){
                    if(obj instanceof DataNomina)
                        nm += this.SCHEMA_LOCATION_NOMINA;
                    if(obj instanceof DataImpuestosLocales)
                        nm += this.SCHEMA_LOCATION_IMP_LOCALES;
                }
            }
        }
        return nm;
    }
}
