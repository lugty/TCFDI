package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataIncapacidad {

    @XmlAttribute(name = "DiasIncapacidad", required = true)
    private int diasIncapacidad;

    @XmlAttribute(name = "TipoIncapacidad", required = true)
    private String tipoIncapacidad;

    @XmlAttribute(name = "ImporteMonetario", required = false)
    private BigDecimal importeMonetario;

    public int getDiasIncapacidad() {
        return diasIncapacidad;
    }

    public void setDiasIncapacidad(int diasIncapacidad) {
        this.diasIncapacidad = diasIncapacidad;
    }

    public String getTipoIncapacidad() {
        return tipoIncapacidad;
    }

    public void setTipoIncapacidad(String tipoIncapacidad) {
        this.tipoIncapacidad = tipoIncapacidad;
    }

    public BigDecimal getImporteMonetario() {
        return importeMonetario;
    }

    public void setImporteMonetario(BigDecimal importeMonetario) {
        this.importeMonetario = importeMonetario;
    }
}
