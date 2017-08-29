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
public class DataRetencionesLocales {
    @XmlAttribute(
            name = "ImpLocRetenido",
            required = true
    )
    private String impLocRetenido;

    @XmlAttribute(
            name = "TasadeRetencion",
            required = true
    )
    private BigDecimal tasaDeRetencion;

    @XmlAttribute(
            name = "Importe",
            required = true
    )
    private BigDecimal importe;

    public String getImpLocRetenido() {
        return impLocRetenido;
    }

    public void setImpLocRetenido(String impLocRetenido) {
        this.impLocRetenido = impLocRetenido;
    }

    public BigDecimal getTasaDeRetencion() {
        return tasaDeRetencion;
    }

    public void setTasaDeRetencion(BigDecimal tasaDeRetencion) {
        this.tasaDeRetencion = tasaDeRetencion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
}
