package com.tscfdi.dto;

/**
 * Created by lugty on 5/22/17.
 */
public class CreateAccountInformation {
    private String username;
    private String rfc;
    private String name;
    private int timbres;

    public CreateAccountInformation() {
    }

    public CreateAccountInformation(String username, String rfc, String name, int timbres) {
        this.username = username;
        this.rfc = rfc;
        this.name = name;
        this.timbres = timbres;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getTimbres() {
        return timbres;
    }

    public void setTimbres(int timbres) {
        this.timbres = timbres;
    }
}
