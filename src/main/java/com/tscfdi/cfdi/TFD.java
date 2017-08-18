package com.tscfdi.cfdi;

import com.tscfdi.comprobante.TimbreFiscalDigital;
import org.xml.sax.ErrorHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayOutputStream;

/**
 * Created by lugty on 31/08/16.
 */
public class TFD {
    private static final String XSLT = "/xslt/cadenaoriginal_TFD_1_0.xslt";
    private static final String XSD = "/xsd/TimbreFiscalDigital.xsd";

    private TransformerFactory tf;

    private static final JAXBContext CONTEXT = createContext();
    private static final JAXBContext createContext() {
        try {
            return JAXBContext.newInstance(com.tscfdi.comprobante.TimbreFiscalDigital.class);
        } catch (Exception var1) {
            throw new Error(var1);
        }
    }


    private CFDI cfdi;
    private TimbreFiscalDigital timbreFiscalDigital;


    public TFD(CFDI cfdi)throws Exception{
        this.cfdi = cfdi;
        this.timbreFiscalDigital = cfdi.getTimbrado();
    }

    public TFD(TimbreFiscalDigital tfd)throws Exception{
        this.timbreFiscalDigital = tfd;
    }

    public void validar() throws Exception {
        this.validar((ErrorHandler)null);
    }

    public void validar(ErrorHandler handler) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = sf.newSchema(this.getClass().getResource("/xsd/TimbreFiscalDigital.xsd"));
        Validator validator = schema.newValidator();
        if(handler != null) {
            validator.setErrorHandler(handler);
        }

        validator.validate(new JAXBSource(CONTEXT, this.timbreFiscalDigital));
    }

    public String getCadenaOriginal() throws Exception {
        byte[] bytes = this.getOriginalBytes();
        return new String(bytes);
    }

    public byte[] getOriginalBytes() throws Exception {
        JAXBSource in = new JAXBSource(CONTEXT, this.timbreFiscalDigital);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StreamResult out = new StreamResult(baos);
        TransformerFactory factory = this.tf;
        if(factory == null) {
            factory = TransformerFactory.newInstance();
        }

        Transformer transformer = factory.newTransformer(new StreamSource(this.getClass().getResourceAsStream("/xslt/cadenaoriginal_TFD_1_0.xslt")));
        transformer.transform(in, out);
        return baos.toByteArray();
    }
}
