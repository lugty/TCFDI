package com.tscfdi.cfdi;

import com.tscfdi.clientWS.TimbradoCFDIStub;
import com.tscfdi.dto.CertificateStateLCODetail;
import com.tscfdi.dto.CreateAccountInformation;
import com.tscfdi.dto.UserTimbradoDetail;
import com.tscfdi.settings.TScfdiSettings;

/**
 * Created by lugty on 1/17/17.
 */
public class ServicesACFDI {
    private TScfdiSettings properties = new TScfdiSettings();
    private String usernameSignature;
    private String passwordSignature;

    public ServicesACFDI(String user, String password){
        this.usernameSignature = user;
        this.passwordSignature = password;
    }

    public UserTimbradoDetail addCFDITimbres(int amount) throws Exception {
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth = new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE = new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** add CFDI timbres **/
        TimbradoCFDIStub.AddTimbres addTimbres = new TimbradoCFDIStub.AddTimbres();
        addTimbres.setUsername(this.usernameSignature);
        addTimbres.setAmount(amount);

        TimbradoCFDIStub.AddTimbresResponse addResponse = serviceStub.addTimbres(addTimbres, headerE);
        TimbradoCFDIStub.UserStatusInformationDetail dataUser =  addResponse.getAddTimbresResult();

        if(dataUser == null){
            return new UserTimbradoDetail(true, "No devolvio respuesta");
        }else if (dataUser.getHasError()){
            return new UserTimbradoDetail(true, dataUser.getErrorMessage());
        }
        return new UserTimbradoDetail(dataUser.getRfc(), dataUser.getName(), dataUser.getUsed_timbres(), dataUser.getTotal_timbres(), dataUser.getStatus(), dataUser.getCreation_date().getTime());
    }

    public UserTimbradoDetail changeCFDITimbres(int amount) throws Exception {
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth = new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE = new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** add CFDI timbres **/
        TimbradoCFDIStub.ChangeTimbresTotal setTimbres = new TimbradoCFDIStub.ChangeTimbresTotal();
        setTimbres.setUsername(this.usernameSignature);
        setTimbres.setAmount(amount);

        TimbradoCFDIStub.ChangeTimbresTotalResponse setResponse = serviceStub.changeTimbresTotal(setTimbres, headerE);
        TimbradoCFDIStub.UserStatusInformationDetail dataUser =  setResponse.getChangeTimbresTotalResult();

        if(dataUser == null){
            return new UserTimbradoDetail(true, "No devolvio respuesta");
        }else if (dataUser.getHasError()){
            return new UserTimbradoDetail(true, dataUser.getErrorMessage());
        }
        return new UserTimbradoDetail(dataUser.getRfc(), dataUser.getName(), dataUser.getUsed_timbres(), dataUser.getTotal_timbres(), dataUser.getStatus(), dataUser.getCreation_date().getTime());
    }

    public UserTimbradoDetail getUserInformationDetail() throws Exception {
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth = new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE = new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** add CFDI timbres **/
        TimbradoCFDIStub.GetUserStatusInformation getUserInfo = new TimbradoCFDIStub.GetUserStatusInformation();
        getUserInfo.setUsername(this.usernameSignature);

        TimbradoCFDIStub.GetUserStatusInformationResponse getResponse = serviceStub.getUserStatusInformation(getUserInfo, headerE);
        TimbradoCFDIStub.UserStatusInformationDetail dataUser =  getResponse.getGetUserStatusInformationResult();

        if(dataUser == null){
            return new UserTimbradoDetail(true, "No devolvio respuesta");
        }else if (dataUser.getHasError()){
            return new UserTimbradoDetail(true, dataUser.getErrorMessage());
        }
        return new UserTimbradoDetail(dataUser.getRfc(), dataUser.getName(), dataUser.getUsed_timbres(), dataUser.getTotal_timbres(), dataUser.getStatus(), dataUser.getCreation_date().getTime());
    }

    public CertificateStateLCODetail getCSDStatusLCO(String noSerie) throws Exception {
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth = new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE = new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** add CFDI timbres **/
        TimbradoCFDIStub.GetCertificateStateLCO getCerInfo = new TimbradoCFDIStub.GetCertificateStateLCO();
        getCerInfo.setNoSerie(noSerie);

        TimbradoCFDIStub.GetCertificateStateLCOResponse getCerResponse = serviceStub.getCertificateStateLCO(getCerInfo, headerE);
        TimbradoCFDIStub.CertificateStateLCO dataCer =  getCerResponse.getGetCertificateStateLCOResult();

        if(dataCer == null){
            return new CertificateStateLCODetail(true, "No devolvio respuesta", false);
        }else if (dataCer.getHasError()){
            return new CertificateStateLCODetail(true, dataCer.getErrorMessage(), false);
        }
        return new CertificateStateLCODetail(dataCer.getRfc(), dataCer.getNo_serie(), dataCer.getState_certificado(), dataCer.getInit_date().getTime(), dataCer.getFinal_date().getTime(), dataCer.getIs_found());
    }

    public UserTimbradoDetail createAccount(CreateAccountInformation createAccountInformation) throws Exception {
        TimbradoCFDIStub serviceStub = new TimbradoCFDIStub(properties.getServiceEndpoint());
        TimbradoCFDIStub.AuthenticateUser authUser = new TimbradoCFDIStub.AuthenticateUser();

        TimbradoCFDIStub.SecureWebServiceHeader headerAuth = new TimbradoCFDIStub.SecureWebServiceHeader();
        headerAuth.setUsername(this.usernameSignature);
        headerAuth.setPassword(this.passwordSignature);
        TimbradoCFDIStub.SecureWebServiceHeaderE headerE = new TimbradoCFDIStub.SecureWebServiceHeaderE();
        headerE.setSecureWebServiceHeader(headerAuth);

        TimbradoCFDIStub.AuthenticateUserResponse authResponse = serviceStub.authenticateUser(authUser, headerE);
        String token = authResponse.getAuthenticateUserResult();
        headerAuth.setAuthenticatedToken(token);

        /** account info **/
        TimbradoCFDIStub.UserInformation info = new TimbradoCFDIStub.UserInformation();
        info.setNombre(createAccountInformation.getName());
        info.setRfc(createAccountInformation.getRfc());
        info.setUserName(createAccountInformation.getUsername());
        info.setTimbres(createAccountInformation.getTimbres());

        /** create account **/
        TimbradoCFDIStub.CreateAccount createAccount = new TimbradoCFDIStub.CreateAccount();
        createAccount.setUData(info);

        TimbradoCFDIStub.CreateAccountResponse response = serviceStub.createAccount(createAccount, headerE);
        TimbradoCFDIStub.UserInformationResponse dataUser =  response.getCreateAccountResult();

        if(dataUser == null){
            return new UserTimbradoDetail(true, "No devolvio respuesta");
        }else if (dataUser.isErrorSpecified()){
            return new UserTimbradoDetail(true, dataUser.getError());
        }
        return new UserTimbradoDetail(dataUser.getRfc(), dataUser.getNombre(), dataUser.getTimbres(), dataUser.getTimbres(), dataUser.getEstado(), dataUser.getCreate_Time().getTime(), dataUser.getPassword());
    }

}
