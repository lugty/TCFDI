package com.tscfdi.comprobante;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lugty on 8/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"cfdiRelacionado"}
)
public class DataCfdiRelacionados {

    @XmlAttribute(
            name = "TipoRelacion",
            required = true
    )
    private String tipoRelacion;

    @XmlElement(
            name = "CfdiRelacionado",
            required = true
    )
    private List<DataCfdiRelacionado> cfdiRelacionado;

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    public List<DataCfdiRelacionado> getCfdiRelacionado() {
        return cfdiRelacionado;
    }

    public void setCfdiRelacionado(List<DataCfdiRelacionado> cfdiRelacionado) {
        this.cfdiRelacionado = cfdiRelacionado;
    }
}
