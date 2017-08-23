package com.tscfdi.comprobante;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lugty on 19/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {}
)
public class DataEmisor {
    @XmlAttribute(
            name = "rfc",
            required = true
    )
    private String rfc; // REQUIRED

    @XmlAttribute(
            name = "Nombre"
    )
    private String nombre; // OPTIONAL

    @XmlAttribute(
            name = "RegimenFiscal",
            required = true
    )
    private String regimenFiscal; // REQUIRED

    public DataEmisor() {
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

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
}
