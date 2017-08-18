package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by lugty on 19/08/16.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "t_Ubicacion"
)
public class DataDomicilioFiscal {
    @XmlAttribute(
            name = "calle"
    )
    private String calle; //OPCIONAL

    @XmlAttribute(
            name = "noExterior"
    )
    private String noExterior; //OPCIONAL

    @XmlAttribute(
            name = "noInterior"
    )
    private String noInterior; //OPCIONAL

    @XmlAttribute(
            name = "colonia"
    )
    private String colonia; //OPCIONAL

    @XmlAttribute(
            name = "localidad"
    )
    private String localidad; //OPCIONAL

    @XmlAttribute(
            name = "referencia"
    )
    private String referencia; //OPCIONAL

    @XmlAttribute(
            name = "municipio"
    )
    private String municipio; //OPCIONAL

    @XmlAttribute(
            name = "estado"
    )
    private String estado; //OPCIONAL

    @XmlAttribute(
            name = "pais",
            required = true
    )
    private String pais; //REQUERIDO

    @XmlAttribute(
            name = "codigoPostal"
    )
    private String codigoPostal; //OPCIONAL

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
