package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataJubilacionPensionRetiro {

    @XmlAttribute(name = "TotalEnaExhibicion", required = false)
    private BigDecimal totalUnaExhibicion;

    @XmlAttribute(name = "TotalParcialidad", required = false)
    private BigDecimal totalParcialidad;

    @XmlAttribute(name = "montoDiario", required = false)
    private BigDecimal montoDiario;

    @XmlAttribute(name = "IngresoAcumulable", required = true)
    private BigDecimal ingresoAcumulable;

    @XmlAttribute(name = "IngresoNoAcumulable", required = true)
    private BigDecimal ingresoNoAcumulable;

    public BigDecimal getTotalUnaExhibicion() {
        return totalUnaExhibicion;
    }

    public void setTotalUnaExhibicion(BigDecimal totalUnaExhibicion) {
        this.totalUnaExhibicion = totalUnaExhibicion;
    }

    public BigDecimal getTotalParcialidad() {
        return totalParcialidad;
    }

    public void setTotalParcialidad(BigDecimal totalParcialidad) {
        this.totalParcialidad = totalParcialidad;
    }

    public BigDecimal getMontoDiario() {
        return montoDiario;
    }

    public void setMontoDiario(BigDecimal montoDiario) {
        this.montoDiario = montoDiario;
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
