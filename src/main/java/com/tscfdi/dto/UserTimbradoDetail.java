package com.tscfdi.dto;

import java.util.Date;

/**
 * Created by lugty on 1/17/17.
 */
public class UserTimbradoDetail {
    private String rfc;
    private String name;
    private int timbresUsed;
    private int totalTimbres;
    private boolean status;
    private Date createdAt;

    private String password;

    private boolean hasError;
    private String errorMessage;

    public UserTimbradoDetail() {
    }

    public UserTimbradoDetail(String rfc, String name, int timbresUsed, int totalTimbres, boolean status, Date createdAt) {
        this.rfc = rfc;
        this.name = name;
        this.timbresUsed = timbresUsed;
        this.totalTimbres = totalTimbres;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UserTimbradoDetail(String rfc, String name, int timbresUsed, int totalTimbres, boolean status, Date createdAt, String password) {
        this.rfc = rfc;
        this.name = name;
        this.timbresUsed = timbresUsed;
        this.totalTimbres = totalTimbres;
        this.status = status;
        this.createdAt = createdAt;
        this.password = password;
    }

    public UserTimbradoDetail(boolean hasError, String errorMessage) {
        this.hasError = hasError;
        this.errorMessage = errorMessage;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimbresUsed() {
        return timbresUsed;
    }

    public void setTimbresUsed(int timbresUsed) {
        this.timbresUsed = timbresUsed;
    }

    public int getTotalTimbres() {
        return totalTimbres;
    }

    public void setTotalTimbres(int totalTimbres) {
        this.totalTimbres = totalTimbres;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
