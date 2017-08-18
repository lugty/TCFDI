package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 12/8/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
public class DataPercepciones {

    @XmlAttribute(
            name = "TotalSueldos",
            required = false
    )
    private BigDecimal totalSueldos;

    @XmlAttribute(
            name = "TotalSeparacionIndemnizacion",
            required = false
    )
    private BigDecimal totalSerparacionIndemnizacion;

    @XmlAttribute(
            name = "TotalJubilacionPensionRetiro",
            required = false
    )
    private BigDecimal totalJubilacionPensionRetiro;


    @XmlAttribute(
            name = "TotalGravado",
            required = true
    )
    private BigDecimal totalGravado;

    @XmlAttribute(
            name = "TotalExento",
            required = true
    )
    private BigDecimal totalExento;

    @XmlElement(
            name = "Percepcion",
            required = true
    )
    private List<DataPercepcion> dataPercepcions;

    @XmlElement(
            name = "JubilacionPensionRetiro",
            required = false
    )
    private DataJubilacionPensionRetiro dataJubilacionPensionRetiro;

    @XmlElement(
            name = "SeparacionIndemnizacion",
            required = false
    )
    private DataSeparacionIndemnizacion dataSeparacionIndemnizacion;

    public BigDecimal getTotalSueldos() {
        return totalSueldos;
    }

    public void setTotalSueldos(BigDecimal totalSueldos) {
        this.totalSueldos = totalSueldos;
    }

    public BigDecimal getTotalSerparacionIndemnizacion() {
        return totalSerparacionIndemnizacion;
    }

    public void setTotalSerparacionIndemnizacion(BigDecimal totalSerparacionIndemnizacion) {
        this.totalSerparacionIndemnizacion = totalSerparacionIndemnizacion;
    }

    public BigDecimal getTotalJubilacionPensionRetiro() {
        return totalJubilacionPensionRetiro;
    }

    public void setTotalJubilacionPensionRetiro(BigDecimal totalJubilacionPensionRetiro) {
        this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
    }

    public BigDecimal getTotalGravado() {
        return totalGravado;
    }

    public void setTotalGravado(BigDecimal totalGravado) {
        this.totalGravado = totalGravado;
    }

    public BigDecimal getTotalExento() {
        return totalExento;
    }

    public void setTotalExento(BigDecimal totalExento) {
        this.totalExento = totalExento;
    }

    public List<DataPercepcion> getDataPercepcions() {
        return dataPercepcions;
    }

    public void setDataPercepcions(List<DataPercepcion> dataPercepcions) {
        this.dataPercepcions = dataPercepcions;
    }

    public DataJubilacionPensionRetiro getDataJubilacionPensionRetiro() {
        return dataJubilacionPensionRetiro;
    }

    public void setDataJubilacionPensionRetiro(DataJubilacionPensionRetiro dataJubilacionPensionRetiro) {
        this.dataJubilacionPensionRetiro = dataJubilacionPensionRetiro;
    }

    public DataSeparacionIndemnizacion getDataSeparacionIndemnizacion() {
        return dataSeparacionIndemnizacion;
    }

    public void setDataSeparacionIndemnizacion(DataSeparacionIndemnizacion dataSeparacionIndemnizacion) {
        this.dataSeparacionIndemnizacion = dataSeparacionIndemnizacion;
    }
}
