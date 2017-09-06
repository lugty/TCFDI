package com.tscfdi.cfdi;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.tscfdi.common.CustomResourceResolver;
import com.tscfdi.common.URIResolverImpl;
import com.tscfdi.comprobante.DataComprobante;
import com.tscfdi.keys.PublicKeyLoader;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.ErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Created by lugty on 29/08/16.
 */
public class ValidadorCFDI {
    private DataComprobante comprobante;
    private final JAXBContext context;

    private static final String XSLT = "/xslt/cadenaoriginal_3_3.xslt";

    private static final String BASE_CONTEXT = "com.tscfdi.comprobante";
    private final static Joiner JOINER = Joiner.on(':');

    private static final String[] XSD = new String[] {
            "/xsd/cfdv33/cfdv33.xsd",
            "/xsd/TimbreFiscalDigitalv11.xsd",
            "/xsd/complementos/implocal.xsd"
            /*"/xsd/common/TuristaPasajeroExtranjero/TuristaPasajeroExtranjero.xsd",
            "/xsd/common/detallista/detallista.xsd",
            "/xsd/common/divisas/divisas.xsd",
            "/xsd/common/donat/donat11.xsd",
            "/xsd/common/ecb/ecb.xsd",
            "/xsd/common/ecc/ecc.xsd",
            "/xsd/common/iedu/iedu.xsd",
            "/xsd/common/implocal/implocal.xsd",
            "/xsd/common/leyendasFisc/leyendasFisc.xsd",
            "/xsd/common/pfic/pfic.xsd",
            "/xsd/common/psgcfdsp/psgcfdsp.xsd",
            "/xsd/common/psgecfd/psgecfd.xsd",
            "/xsd/common/terceros/terceros11.xsd",
            "/xsd/common/ventavehiculos/ventavehiculos.xsd",
            "/xsd/common/nomina/nomina11.xsd"*/
    };

    private static final String[] XSD_NOMINA = new String[] {
            "/xsd/cfdv33/cfdv33.xsd",
            "/xsd/TimbreFiscalDigitalv11.xsd",
            "/xsd/nomina/nomina12.xsd"
    };

    public ValidadorCFDI(DataComprobante comprobante, String... contexts) throws Exception{
        this.comprobante = comprobante;
        this.context = getContext(contexts);
    }

    public void validar() throws Exception {
        validar(null);
    }

    public void validarNomina() throws Exception {
        validarNomina(null);
    }

    public void validar(ErrorHandler handler) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        sf.setResourceResolver(new CustomResourceResolver());

        Source[] schemas = new Source[XSD.length];
        for (int i = 0; i < XSD.length; i++) {
            schemas[i] = new StreamSource(getClass().getResourceAsStream(XSD[i]));
        }

        Schema schema = sf.newSchema(schemas);
        Validator validator = schema.newValidator();
        if (handler != null) {
            validator.setErrorHandler(handler);
        }
        validator.validate(new JAXBSource(context, comprobante));
    }

    public void validarNomina(ErrorHandler handler) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        sf.setResourceResolver(new CustomResourceResolver());
        Source[] schemas = new Source[XSD_NOMINA.length];
        for (int i = 0; i < XSD_NOMINA.length; i++) {
            schemas[i] = new StreamSource(getClass().getResourceAsStream(XSD_NOMINA[i]));
        }

        sf.setResourceResolver(new CustomResourceResolver());
        Schema schema = sf.newSchema(schemas);
        Validator validator = schema.newValidator();
        if (handler != null) {
            validator.setErrorHandler(handler);
        }
        validator.validate(new JAXBSource(context, comprobante));
    }


    public void verificar() throws Exception {
        String certStr = comprobante.getCertificado();
        Base64 b64 = new Base64();
        byte[] cbs = b64.decode(certStr);

        /*X509Certificate cert = KeyLoaderFactory.createInstance(
                KeyLoaderEnumeration.PUBLIC_KEY_LOADER,
                new ByteArrayInputStream(cbs)
        ).getKey();
        */

        PublicKeyLoader pLoader = new PublicKeyLoader(new ByteArrayInputStream(cbs));
        X509Certificate cert = pLoader.getKey();

        String sigStr = comprobante.getSello();
        byte[] signature = b64.decode(sigStr);

        byte[] bytes = getBytesCadenaOriginal();
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(cert);
        sig.update(bytes);
        boolean bool = sig.verify(signature);
        if (!bool) {
            throw new Exception("Invalid signature");
        }
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

    private static JAXBContext getContext(String[] contexts) throws Exception {
        List<String> ctx = Lists.asList(BASE_CONTEXT, contexts);
        return JAXBContext.newInstance(JOINER.join(ctx));
    }
}
