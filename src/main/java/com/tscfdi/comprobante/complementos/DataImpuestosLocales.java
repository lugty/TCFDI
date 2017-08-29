package com.tscfdi.comprobante.complementos;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 8/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
@XmlRootElement(name = "ImpuestosLocales")
public class DataImpuestosLocales {
    @XmlAttribute(
            name = "version",
            required = true
    )
    private String version;

    @XmlAttribute(
            name = "TotaldeRetenciones",
            required = true
    )
    private BigDecimal totalDeRetenciones;

    @XmlAttribute(
            name = "TotaldeTraslados",
            required = true
    )
    private BigDecimal totalDeTraslados;

    @XmlElement(
            name = "RetencionesLocales"
    )
    private List<DataRetencionesLocales> retencionesLocales;

    @XmlElement(
            name = "TrasladosLocales"
    )
    private List<DataTrasladosLocales> trasladosLocales;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getTotalDeRetenciones() {
        return totalDeRetenciones;
    }

    public void setTotalDeRetenciones(BigDecimal totalDeRetenciones) {
        this.totalDeRetenciones = totalDeRetenciones;
    }

    public BigDecimal getTotalDeTraslados() {
        return totalDeTraslados;
    }

    public void setTotalDeTraslados(BigDecimal totalDeTraslados) {
        this.totalDeTraslados = totalDeTraslados;
    }

    public List<DataRetencionesLocales> getRetencionesLocales() {
        return retencionesLocales;
    }

    public void setRetencionesLocales(List<DataRetencionesLocales> retencionesLocales) {
        this.retencionesLocales = retencionesLocales;
    }

    public List<DataTrasladosLocales> getTrasladosLocales() {
        return trasladosLocales;
    }

    public void setTrasladosLocales(List<DataTrasladosLocales> trasladosLocales) {
        this.trasladosLocales = trasladosLocales;
    }
}
