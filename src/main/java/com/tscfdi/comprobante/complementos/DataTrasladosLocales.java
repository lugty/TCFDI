package com.tscfdi.comprobante.complementos;

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
public class DataTrasladosLocales {
    @XmlAttribute(
            name = "ImpLocTrasladado",
            required = true
    )
    private String impLocTrasladado;

    @XmlAttribute(
            name = "TasadeTraslado",
            required = true
    )
    private BigDecimal tasaDeTraslado;

    @XmlAttribute(
            name = "Importe",
            required = true
    )
    private BigDecimal importe;

    public String getImpLocTrasladado() {
        return impLocTrasladado;
    }

    public void setImpLocTrasladado(String impLocTrasladado) {
        this.impLocTrasladado = impLocTrasladado;
    }

    public BigDecimal getTasaDeTraslado() {
        return tasaDeTraslado;
    }

    public void setTasaDeTraslado(BigDecimal tasaDeTraslado) {
        this.tasaDeTraslado = tasaDeTraslado;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
}
