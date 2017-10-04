package com.tscfdi.comprobante.complementoPago;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * Created by lugty on 8/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
public class DataPagoImpTrasladado {
    @XmlAttribute(
            name = "Impuesto",
            required = true
    )
    private String impuesto;

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
    private BigDecimal importe;

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
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

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

}
