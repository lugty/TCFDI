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
public class DataImpRetencionConcepto {
    @XmlAttribute(
            name = "Base",
            required = true
    )
    private BigDecimal base;

    @XmlAttribute(
            name = "Impuesto",
            required = true
    )
    private String impuesto; // REQUERIDO

    @XmlAttribute(
            name = "TipoFactor",
            required = true
    )
    private String tipoFactor;

    @XmlAttribute(
            name = "TasaOCuota",
            required = true
    )
    private BigDecimal tasaOCuota;

    @XmlAttribute(
            name = "Importe",
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

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public String getTipoFactor() {
        return tipoFactor;
    }

    public void setTipoFactor(String tipoFactor) {
        this.tipoFactor = tipoFactor;
    }

    public BigDecimal getTasaOCuota() {
        return tasaOCuota;
    }

    public void setTasaOCuota(BigDecimal tasaOCuota) {
        this.tasaOCuota = tasaOCuota;
    }
}
