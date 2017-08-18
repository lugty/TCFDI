package com.tscfdi.cfdi;

import com.tscfdi.clientWS.TimbradoCFDIStub;
import com.tscfdi.settings.TScfdiSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.UUID;

/**
 * Created by lugty on 31/08/16.
 */
@Component
public class CancelacionCFDI {

    //@Autowired
    private TScfdiSettings properties = new TScfdiSettings();

    public boolean cancelaCFDI(String uuid, String rfc, X509Certificate cert, PrivateKey privateKey) throws Exception{
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth= new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(properties.getUserNameTimbradoTest());
        headerAuth.setPassword(properties.getPasswordTimbradoTest());
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE= new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** cancel ws consume service **/
        TimbradoCFDIStub.Guid uuidToCancel = new TimbradoCFDIStub.Guid();
        uuidToCancel.setGuid(uuid);

        String passwd = UUID.randomUUID().toString();
        String pfx = getPFXString(cert, privateKey, passwd);

        TimbradoCFDIStub.CancelaCFDI cancelaCFDI = new TimbradoCFDIStub.CancelaCFDI();
        cancelaCFDI.setUuid(uuidToCancel);
        cancelaCFDI.setRfcEmisor(rfc);
        cancelaCFDI.setPassPfx(passwd);
        cancelaCFDI.setPfx_base64(pfx);

        TimbradoCFDIStub.CancelaCFDIResponse responseCancela = serviceStub.cancelaCFDI(cancelaCFDI, headerE);
        TimbradoCFDIStub.ResponseCancelacion cancelaCFDIResult = responseCancela.getCancelaCFDIResult();

        if(cancelaCFDIResult.getIsCancelado()){
            return true;
        }else{
            throw new Exception(cancelaCFDIResult.getError());
        }
    }

    private String getPFXString(X509Certificate cert, PrivateKey privateKey, String passwd) throws Exception{
        try{
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(null, null);
            keyStore.setCertificateEntry("", cert);

            Key kk = (Key)privateKey;

            keyStore.setKeyEntry("", kk, passwd.toCharArray(), new Certificate[]{cert});

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            keyStore.store(outputStream, passwd.toCharArray());

            String result = new BASE64Encoder().encode(outputStream.toByteArray());
            return result;
        }catch(Exception e){
            throw new Exception("No se pudo obtener el PFX de las llaves");
        }
    }
}
