package com.tscfdi.comprobante.complementoPago;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 9/8/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"retenciones", "traslados"}
)
public class DataPagoImpuestos {
    @XmlAttribute(
            name = "TotalImpuestosRetenidos"
    )
    private BigDecimal totalImpuestosRetenidos;

    @XmlAttribute(
            name = "TotalImpuestosTrasladados"
    )
    private BigDecimal totalImpuestosTrasladados;

    @XmlElementWrapper(name = "Retenciones")
    @XmlElement(
            name = "Retencion"
    )
    private List<DataPagoImpRetencion> retenciones;

    @XmlElementWrapper(name = "Traslados")
    @XmlElement(
            name = "Traslado"
    )
    private List<DataPagoImpTrasladado> traslados;

    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public BigDecimal getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    public void setTotalImpuestosTrasladados(BigDecimal totalImpuestosTrasladados) {
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }

    public List<DataPagoImpRetencion> getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(List<DataPagoImpRetencion> retenciones) {
        this.retenciones = retenciones;
    }

    public List<DataPagoImpTrasladado> getTraslados() {
        return traslados;
    }

    public void setTraslados(List<DataPagoImpTrasladado> traslados) {
        this.traslados = traslados;
    }
}
