package com.tscfdi.comprobante.complementoSPC;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by lugty on 9/26/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = { }
)
public class DataInmueble {
    @XmlAttribute(
            name = "Calle",
            required = true
    )
    private String calle;

    @XmlAttribute(
            name = "NoExterior"
    )
    private String noExterior;

    @XmlAttribute(
            name = "NoInterior"
    )
    private String noInterior;

    @XmlAttribute(
            name = "Colonia"
    )
    private String colonia;

    @XmlAttribute(
            name = "Localidad"
    )
    private String localidad;

    @XmlAttribute(
            name = "Referencia"
    )
    private String referencia;

    @XmlAttribute(
            name = "Municipio",
            required = true
    )
    private String municipio;

    @XmlAttribute(
            name = "Estado",
            required = true
    )
    private String estado;

    @XmlAttribute(
            name = "CodigoPostal",
            required = true
    )
    private String codigoPostal;

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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
