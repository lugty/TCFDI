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
        propOrder = {"domicilioFiscal", "expedidoEn", "regimenFiscal"}
)
public class DataEmisor {
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
            name = "DomicilioFiscal"
    )
    private DataDomicilioFiscal domicilioFiscal; // OPTIONAL

    @XmlElement(
            name = "ExpedidoEn"
    )
    private DataExpedidoEn expedidoEn; // OPTIONAL

    @XmlElement(
            name = "RegimenFiscal",
            required = true
    )
    private List<DataRegimenFiscal> regimenFiscal = new ArrayList<DataRegimenFiscal>(); // REQUIRED

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

    public DataDomicilioFiscal getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(DataDomicilioFiscal domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public DataExpedidoEn getExpedidoEn() {
        return expedidoEn;
    }

    public void setExpedidoEn(DataExpedidoEn expedidoEn) {
        this.expedidoEn = expedidoEn;
    }

    public List<DataRegimenFiscal> getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(List<DataRegimenFiscal> regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
}
