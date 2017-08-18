package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataAccionesOTitulos {

    @XmlAttribute( name = "ValorMercado", required = true)
    private BigDecimal valorMercado;

    @XmlAttribute( name = "ValorAlOtorgarse", required = true)
    private BigDecimal valorAlOtorgarse;

    public DataAccionesOTitulos() {
    }

    public DataAccionesOTitulos(BigDecimal valorMercado, BigDecimal valorAlOtorgarse) {
        this.valorMercado = valorMercado;
        this.valorAlOtorgarse = valorAlOtorgarse;
    }

    public BigDecimal getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(BigDecimal valorMercado) {
        this.valorMercado = valorMercado;
    }

    public BigDecimal getValorAlOtorgarse() {
        return valorAlOtorgarse;
    }

    public void setValorAlOtorgarse(BigDecimal valorAlOtorgarse) {
        this.valorAlOtorgarse = valorAlOtorgarse;
    }
}
