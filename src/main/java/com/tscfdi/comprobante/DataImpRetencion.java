package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * Created by lugty on 22/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
public class DataImpRetencion {
    @XmlAttribute(
            name = "impuesto",
            required = true
    )
    private String impuesto; // REQUERIDO

    @XmlAttribute(
            name = "importe",
            required = true
    )
    private BigDecimal importe; // REQUERIDO

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
}
