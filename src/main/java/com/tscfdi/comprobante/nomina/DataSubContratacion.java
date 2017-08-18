package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSubContratacion {

    @XmlAttribute(
            name = "RfcLaboral",
            required = true
    )
    private String rfcLaboral;

    @XmlAttribute(
            name = "PorcentajeTiempo",
            required = true
    )
    private BigDecimal procentajeTiempo;

    public DataSubContratacion() {
    }

    public DataSubContratacion(String rfcLaboral, BigDecimal procentajeTiempo) {
        this.rfcLaboral = rfcLaboral;
        this.procentajeTiempo = procentajeTiempo;
    }

    public String getRfcLaboral() {
        return rfcLaboral;
    }

    public void setRfcLaboral(String rfcLaboral) {
        this.rfcLaboral = rfcLaboral;
    }

    public BigDecimal getProcentajeTiempo() {
        return procentajeTiempo;
    }

    public void setProcentajeTiempo(BigDecimal procentajeTiempo) {
        this.procentajeTiempo = procentajeTiempo;
    }
}
