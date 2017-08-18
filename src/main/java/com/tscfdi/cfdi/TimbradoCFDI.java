package com.tscfdi.cfdi;

import com.sun.istack.ByteArrayDataSource;
import com.tscfdi.clientWS.TimbradoCFDIStub;
import com.tscfdi.settings.TScfdiSettings;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import java.io.InputStream;

/**
 * Created by lugty on 22/08/16.
 */
@Component
public class TimbradoCFDI {
    //@Autowired
    private TScfdiSettings properties = new TScfdiSettings();
    private String usernameSignature;
    private String passwordSignature;

    public TimbradoCFDI(){}

    public TimbradoCFDI(String user, String password){
        this.usernameSignature = user;
        this.passwordSignature = password;
    }

    public byte[] timbrarCFDI(CFDI cfdiXML) throws Exception{
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth= new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE= new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** timbrado ws consume service **/

        DataSource source = new ByteArrayDataSource(cfdiXML.getBytesXML(), "");
        DataHandler dataHandler = new DataHandler(source);

        TimbradoCFDIStub.TimbreCFDI cfdiToTimbrar = new TimbradoCFDIStub.TimbreCFDI();
        cfdiToTimbrar.setCfdi(dataHandler);

        TimbradoCFDIStub.TimbreCFDIResponse responseTimbrado = serviceStub.timbreCFDI(cfdiToTimbrar, headerE);
        TimbradoCFDIStub.ResponceTimbrado responseCFDITimbrado = responseTimbrado.getTimbreCFDIResult();

        if(responseCFDITimbrado.getIsTimbrado()){
            DataHandler dataResponse = responseCFDITimbrado.getTimbradoCFDI();
            InputStream responseStream = dataResponse.getInputStream();
            byte[] response = IOUtils.toByteArray(responseStream);

            return response;
        }else{
            throw new Exception(responseCFDITimbrado.getError());
        }
    }

    public byte[] timbrarCFDITest(CFDI cfdiXML) throws Exception{
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth= new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE= new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        DataSource source = new ByteArrayDataSource(cfdiXML.getBytesXML(), "");
        DataHandler dataHandler = new DataHandler(source);

        TimbradoCFDIStub.TimbreTestCFDI cfdiToTimbrar = new TimbradoCFDIStub.TimbreTestCFDI();
        cfdiToTimbrar.setCfdi(dataHandler);

        TimbradoCFDIStub.TimbreTestCFDIResponse responseTimbrado = serviceStub.timbreTestCFDI(cfdiToTimbrar, headerE);
        TimbradoCFDIStub.ResponceTimbrado responseCFDITimbrado = responseTimbrado.getTimbreTestCFDIResult();

        if(responseCFDITimbrado.getIsTimbrado()){
            DataHandler dataResponse = responseCFDITimbrado.getTimbradoCFDI();
            InputStream responseStream = dataResponse.getInputStream();
            byte[] response = IOUtils.toByteArray(responseStream);

            return response;
        }else{
            throw new Exception(responseCFDITimbrado.getError());
        }
    }
}
