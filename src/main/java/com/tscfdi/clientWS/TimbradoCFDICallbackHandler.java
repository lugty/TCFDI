/**
 * TimbradoCFDICallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */
package com.tscfdi.clientWS;


/**
 *  TimbradoCFDICallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class TimbradoCFDICallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public TimbradoCFDICallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public TimbradoCFDICallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for timbreTFD method
     * override this method for handling normal response from timbreTFD operation
     */
    public void receiveResulttimbreTFD(
        com.tscfdi.clientWS.TimbradoCFDIStub.TimbreTFDResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbreTFD operation
     */
    public void receiveErrortimbreTFD(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for resetPasswordAccount method
     * override this method for handling normal response from resetPasswordAccount operation
     */
    public void receiveResultresetPasswordAccount(
        com.tscfdi.clientWS.TimbradoCFDIStub.ResetPasswordAccountResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from resetPasswordAccount operation
     */
    public void receiveErrorresetPasswordAccount(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for authenticateUser method
     * override this method for handling normal response from authenticateUser operation
     */
    public void receiveResultauthenticateUser(
        com.tscfdi.clientWS.TimbradoCFDIStub.AuthenticateUserResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from authenticateUser operation
     */
    public void receiveErrorauthenticateUser(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbreTestTFD method
     * override this method for handling normal response from timbreTestTFD operation
     */
    public void receiveResulttimbreTestTFD(
        com.tscfdi.clientWS.TimbradoCFDIStub.TimbreTestTFDResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbreTestTFD operation
     */
    public void receiveErrortimbreTestTFD(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addTimbres method
     * override this method for handling normal response from addTimbres operation
     */
    public void receiveResultaddTimbres(
        com.tscfdi.clientWS.TimbradoCFDIStub.AddTimbresResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addTimbres operation
     */
    public void receiveErroraddTimbres(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for logOut method
     * override this method for handling normal response from logOut operation
     */
    public void receiveResultlogOut(
        com.tscfdi.clientWS.TimbradoCFDIStub.LogOutResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from logOut operation
     */
    public void receiveErrorlogOut(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for changeTimbresTotal method
     * override this method for handling normal response from changeTimbresTotal operation
     */
    public void receiveResultchangeTimbresTotal(
        com.tscfdi.clientWS.TimbradoCFDIStub.ChangeTimbresTotalResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from changeTimbresTotal operation
     */
    public void receiveErrorchangeTimbresTotal(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for changeAccountState method
     * override this method for handling normal response from changeAccountState operation
     */
    public void receiveResultchangeAccountState(
        com.tscfdi.clientWS.TimbradoCFDIStub.ChangeAccountStateResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from changeAccountState operation
     */
    public void receiveErrorchangeAccountState(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbreCFDI method
     * override this method for handling normal response from timbreCFDI operation
     */
    public void receiveResulttimbreCFDI(
        com.tscfdi.clientWS.TimbradoCFDIStub.TimbreCFDIResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbreCFDI operation
     */
    public void receiveErrortimbreCFDI(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for isAuthenticated method
     * override this method for handling normal response from isAuthenticated operation
     */
    public void receiveResultisAuthenticated(
        com.tscfdi.clientWS.TimbradoCFDIStub.IsAuthenticatedResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from isAuthenticated operation
     */
    public void receiveErrorisAuthenticated(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createAccount method
     * override this method for handling normal response from createAccount operation
     */
    public void receiveResultcreateAccount(
        com.tscfdi.clientWS.TimbradoCFDIStub.CreateAccountResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createAccount operation
     */
    public void receiveErrorcreateAccount(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbreTestCFDI method
     * override this method for handling normal response from timbreTestCFDI operation
     */
    public void receiveResulttimbreTestCFDI(
        com.tscfdi.clientWS.TimbradoCFDIStub.TimbreTestCFDIResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbreTestCFDI operation
     */
    public void receiveErrortimbreTestCFDI(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCertificateStateLCO method
     * override this method for handling normal response from getCertificateStateLCO operation
     */
    public void receiveResultgetCertificateStateLCO(
        com.tscfdi.clientWS.TimbradoCFDIStub.GetCertificateStateLCOResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCertificateStateLCO operation
     */
    public void receiveErrorgetCertificateStateLCO(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for cancelaCFDI method
     * override this method for handling normal response from cancelaCFDI operation
     */
    public void receiveResultcancelaCFDI(
        com.tscfdi.clientWS.TimbradoCFDIStub.CancelaCFDIResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelaCFDI operation
     */
    public void receiveErrorcancelaCFDI(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUserStatusInformation method
     * override this method for handling normal response from getUserStatusInformation operation
     */
    public void receiveResultgetUserStatusInformation(
        com.tscfdi.clientWS.TimbradoCFDIStub.GetUserStatusInformationResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUserStatusInformation operation
     */
    public void receiveErrorgetUserStatusInformation(java.lang.Exception e) {
    }
}
