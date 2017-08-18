package com.tscfdi.comprobante;

import javax.xml.bind.annotation.*;

/**
 * Created by lugty on 19/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"domicilio"}
)
public class DataReceptor {
    @XmlAttribute(
            name = "rfc",
            required = true
    )
    private String rfc; // REQUIRED

    @XmlAttribute(
            name = "nombre"
    )
    private String nombre; // OPTIONAL

    @XmlElement(
            name = "Domicilio"
    )
    private DataDomicilioFiscal domicilio; // OPTIONAL

    public DataReceptor() {
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DataDomicilioFiscal getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DataDomicilioFiscal domicilio) {
        this.domicilio = domicilio;
    }
}
