package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataHorasExtra {

    @XmlAttribute(name = "Dias", required = true)
    private int dias;

    @XmlAttribute(name = "TipoHoras", required = true)
    private String tipoHoras;

    @XmlAttribute(name = "HorasExtra", required = true)
    private int horasExtra;

    @XmlAttribute(name = "ImportePagado", required = true)
    private BigDecimal importePagado;

    public DataHorasExtra() {
    }

    public DataHorasExtra(int dias, String tipoHoras, int horasExtra, BigDecimal importePagado) {
        this.dias = dias;
        this.tipoHoras = tipoHoras;
        this.horasExtra = horasExtra;
        this.importePagado = importePagado;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getTipoHoras() {
        return tipoHoras;
    }

    public void setTipoHoras(String tipoHoras) {
        this.tipoHoras = tipoHoras;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public BigDecimal getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(BigDecimal importePagado) {
        this.importePagado = importePagado;
    }
}
