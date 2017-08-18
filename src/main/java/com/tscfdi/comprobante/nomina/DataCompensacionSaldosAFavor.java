package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCompensacionSaldosAFavor {

    @XmlAttribute(name = "SaldoAFavor", required = true)
    private BigDecimal saldoAFavor;

    @XmlAttribute(name = "Año", required = true)
    private int ano;

    @XmlAttribute(name = "RemanenteSalFav", required = true)
    private BigDecimal remanenteSalFav;

    public DataCompensacionSaldosAFavor() {
    }

    public DataCompensacionSaldosAFavor(BigDecimal saldoAFavor, int ano, BigDecimal remanenteSalFav) {
        this.saldoAFavor = saldoAFavor;
        this.ano = ano;
        this.remanenteSalFav = remanenteSalFav;
    }

    public BigDecimal getSaldoAFavor() {
        return saldoAFavor;
    }

    public void setSaldoAFavor(BigDecimal saldoAFavor) {
        this.saldoAFavor = saldoAFavor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public BigDecimal getRemanenteSalFav() {
        return remanenteSalFav;
    }

    public void setRemanenteSalFav(BigDecimal remanenteSalFav) {
        this.remanenteSalFav = remanenteSalFav;
    }
}
