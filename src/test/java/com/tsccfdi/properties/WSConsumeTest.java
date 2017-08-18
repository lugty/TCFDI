package com.tsccfdi.properties;

import com.tscfdi.cfdi.ServicesACFDI;
import com.tscfdi.cfdi.TimbradoCFDI;
import com.tscfdi.clientWS.TimbradoCFDIStub;
import com.tscfdi.settings.TScfdiSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.RemoteException;

/**
 * Created by lugty on 23/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_test/app-context.xml")
public class WSConsumeTest {
    @Autowired
    private TScfdiSettings properties;

    @Test
    public void testWSConsume() throws RemoteException, InterruptedException {
        System.out.println(properties.getServiceEndpoint());

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

    }

    @Test
    public void createAccount(){
        try {
            ServicesACFDI timbradoCFDI = new ServicesACFDI("APR0412108C5", "5LtrG#%r");
            timbradoCFDI.addCFDITimbres(5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
