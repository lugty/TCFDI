package com.tscfdi.comprobante;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 19/08/16.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"retenciones", "traslados"}
)
public class DataImpuesto {
    @XmlAttribute(
            name = "totalImpuestosRetenidos"
    )
    private BigDecimal totalImpuestosRetenidos; // OPTIONAL

    @XmlAttribute(
            name = "totalImpuestosTrasladados"
    )
    private BigDecimal totalInpuestosTrasladados; // OPTIONAL

    @XmlElementWrapper(name = "Retenciones")
    @XmlElement(
            name = "Retencion"
    )
    private List<DataImpRetencion> retenciones;

    @XmlElementWrapper(name = "Traslados")
    @XmlElement(
            name = "Traslado"
    )
    private List<DataImpTrasladado> traslados;

    public DataImpuesto() {
    }

    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public BigDecimal getTotalInpuestosTrasladados() {
        return totalInpuestosTrasladados;
    }

    public void setTotalInpuestosTrasladados(BigDecimal totalInpuestosTrasladados) {
        this.totalInpuestosTrasladados = totalInpuestosTrasladados;
    }

    public List<DataImpRetencion> getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(List<DataImpRetencion> retenciones) {
        this.retenciones = retenciones;
    }

    public List<DataImpTrasladado> getTraslados() {
        return traslados;
    }

    public void setTraslados(List<DataImpTrasladado> traslados) {
        this.traslados = traslados;
    }
}
