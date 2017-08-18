package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/8/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataEntidadSNCF {
    @XmlAttribute(name = "OrigenRecurso", required = true)
    private String origenRecurso;

    @XmlAttribute(name = "MontoRecursoPropio", required = false)
    private BigDecimal montoRecursoPropio;

    public String getOrigenRecurso() {
        return origenRecurso;
    }

    public void setOrigenRecurso(String origenRecurso) {
        this.origenRecurso = origenRecurso;
    }

    public BigDecimal getMontoRecursoPropio() {
        return montoRecursoPropio;
    }

    public void setMontoRecursoPropio(BigDecimal montoRecursoPropio) {
        this.montoRecursoPropio = montoRecursoPropio;
    }
}
