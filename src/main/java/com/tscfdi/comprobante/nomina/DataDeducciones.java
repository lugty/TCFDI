package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataDeducciones {

    @XmlAttribute(name = "TotalOtrasDeducciones", required = false)
    private BigDecimal totalOtrasDeducciones;

    @XmlAttribute(name = "TotalImpuestosRetenidos", required = false)
    private BigDecimal totalImpuestosRetenidos;

    @XmlElement(
            name = "Deduccion",
            required = true
    )
    private List<DataDeduccion> dataDeduccion;

    public BigDecimal getTotalOtrasDeducciones() {
        return totalOtrasDeducciones;
    }

    public void setTotalOtrasDeducciones(BigDecimal totalOtrasDeducciones) {
        this.totalOtrasDeducciones = totalOtrasDeducciones;
    }

    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public List<DataDeduccion> getDataDeduccion() {
        return dataDeduccion;
    }

    public void setDataDeduccion(List<DataDeduccion> dataDeduccion) {
        this.dataDeduccion = dataDeduccion;
    }
}
