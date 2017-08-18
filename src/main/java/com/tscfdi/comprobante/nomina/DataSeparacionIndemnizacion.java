package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSeparacionIndemnizacion {

    @XmlAttribute(name = "TotalPagado", required = true)
    private BigDecimal totalPagado;

    @XmlAttribute(name = "NumAñosServicio", required = true)
    private int numAnosServicio;

    @XmlAttribute(name = "UltimoSueldoMensOrd", required = true)
    private BigDecimal ultimoSueldoMensOrd;

    @XmlAttribute(name = "IngresoAcumulable", required = true)
    private BigDecimal ingresoAcumulable;

    @XmlAttribute(name = "IngresoNoAcumulable")
    private BigDecimal ingresoNoAcumulable;

    public BigDecimal getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(BigDecimal totalPagado) {
        this.totalPagado = totalPagado;
    }

    public int getNumAnosServicio() {
        return numAnosServicio;
    }

    public void setNumAnosServicio(int numAnosServicio) {
        this.numAnosServicio = numAnosServicio;
    }

    public BigDecimal getUltimoSueldoMensOrd() {
        return ultimoSueldoMensOrd;
    }

    public void setUltimoSueldoMensOrd(BigDecimal ultimoSueldoMensOrd) {
        this.ultimoSueldoMensOrd = ultimoSueldoMensOrd;
    }

    public BigDecimal getIngresoAcumulable() {
        return ingresoAcumulable;
    }

    public void setIngresoAcumulable(BigDecimal ingresoAcumulable) {
        this.ingresoAcumulable = ingresoAcumulable;
    }

    public BigDecimal getIngresoNoAcumulable() {
        return ingresoNoAcumulable;
    }

    public void setIngresoNoAcumulable(BigDecimal ingresoNoAcumulable) {
        this.ingresoNoAcumulable = ingresoNoAcumulable;
    }
}
