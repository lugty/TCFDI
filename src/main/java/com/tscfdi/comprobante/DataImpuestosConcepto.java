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
        propOrder = {"traslados", "retenciones"}
)
public class DataImpuestosConcepto {
    @XmlElementWrapper(name = "Retenciones")
    @XmlElement(
            name = "Retencion"
    )
    private List<DataImpRetencionConcepto> retenciones;

    @XmlElementWrapper(name = "Traslados")
    @XmlElement(
            name = "Traslado"
    )
    private List<DataImpTrasladadoConcepto> traslados;

    public DataImpuestosConcepto() {
    }

    public List<DataImpRetencionConcepto> getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(List<DataImpRetencionConcepto> retenciones) {
        this.retenciones = retenciones;
    }

    public List<DataImpTrasladadoConcepto> getTraslados() {
        return traslados;
    }

    public void setTraslados(List<DataImpTrasladadoConcepto> traslados) {
        this.traslados = traslados;
    }
}
