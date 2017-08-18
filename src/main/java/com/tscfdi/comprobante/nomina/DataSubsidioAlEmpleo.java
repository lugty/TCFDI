package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSubsidioAlEmpleo {

    @XmlAttribute(name = "SubsidioCausado")
    private BigDecimal subsidioCausado;

    public DataSubsidioAlEmpleo() {
    }

    public DataSubsidioAlEmpleo(BigDecimal subsidioCausado) {
        this.subsidioCausado = subsidioCausado;
    }

    public BigDecimal getSubsidioCausado() {
        return subsidioCausado;
    }

    public void setSubsidioCausado(BigDecimal subsidioCausado) {
        this.subsidioCausado = subsidioCausado;
    }
}
