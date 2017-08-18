package com.tscfdi.dto;

import java.util.Date;

/**
 * Created by lugty on 1/17/17.
 */
public class CertificateStateLCODetail {
    private String rfc;
    private String noSerie;
    private String status;
    private Date intiDate;
    private Date finalDate;
    private boolean isFound;

    private boolean hasError;
    private String errorMessage;

    public CertificateStateLCODetail() {
    }

    public CertificateStateLCODetail(String rfc, String noSerie, String status, Date intiDate, Date finalDate, boolean isFound) {
        this.rfc = rfc;
        this.noSerie = noSerie;
        this.status = status;
        this.intiDate = intiDate;
        this.finalDate = finalDate;
        this.isFound = isFound;
    }

    public CertificateStateLCODetail(boolean hasError, String errorMessage, boolean isFound) {
        this.hasError = hasError;
        this.errorMessage = errorMessage;
        this.isFound = isFound;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getIntiDate() {
        return intiDate;
    }

    public void setIntiDate(Date intiDate) {
        this.intiDate = intiDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
