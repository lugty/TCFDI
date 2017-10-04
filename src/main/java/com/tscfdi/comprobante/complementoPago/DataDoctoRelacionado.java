package com.tscfdi.comprobante.complementoPago;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * Created by lugty on 9/7/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = { }
)
public class DataDoctoRelacionado {
    @XmlAttribute(
            name = "IdDocumento",
            required = true
    )
    private String idDocumento;

    @XmlAttribute(
            name = "Serie"
    )
    private String serie;

    @XmlAttribute(
            name = "Folio"
    )
    private String folio;

    @XmlAttribute(
            name = "MonedaDR",
            required = true
    )
    private String monedaDR;

    @XmlAttribute(
            name = "TipoCambioDR"
    )
    private BigDecimal tipoCambioDR;

    @XmlAttribute(
            name = "MetodoDePagoDR",
            required = true
    )
    private String metodoDePagoDR;

    @XmlAttribute(
            name = "NumParcialidad"
    )
    private Integer numParcialidad;

    @XmlAttribute(
            name = "ImpSaldoAnt"
    )
    private BigDecimal impSaldoAnt;

    @XmlAttribute(
            name = "ImpPagado"
    )
    private BigDecimal impPagado;

    @XmlAttribute(
            name = "ImpSaldoInsoluto"
    )
    private BigDecimal impSaldoInsoluto;

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getMonedaDR() {
        return monedaDR;
    }

    public void setMonedaDR(String monedaDR) {
        this.monedaDR = monedaDR;
    }

    public BigDecimal getTipoCambioDR() {
        return tipoCambioDR;
    }

    public void setTipoCambioDR(BigDecimal tipoCambioDR) {
        this.tipoCambioDR = tipoCambioDR;
    }

    public String getMetodoDePagoDR() {
        return metodoDePagoDR;
    }

    public void setMetodoDePagoDR(String metodoDePagoDR) {
        this.metodoDePagoDR = metodoDePagoDR;
    }

    public Integer getNumParcialidad() {
        return numParcialidad;
    }

    public void setNumParcialidad(Integer numParcialidad) {
        this.numParcialidad = numParcialidad;
    }

    public BigDecimal getImpSaldoAnt() {
        return impSaldoAnt;
    }

    public void setImpSaldoAnt(BigDecimal impSaldoAnt) {
        this.impSaldoAnt = impSaldoAnt;
    }

    public BigDecimal getImpPagado() {
        return impPagado;
    }

    public void setImpPagado(BigDecimal impPagado) {
        this.impPagado = impPagado;
    }

    public BigDecimal getImpSaldoInsoluto() {
        return impSaldoInsoluto;
    }

    public void setImpSaldoInsoluto(BigDecimal impSaldoInsoluto) {
        this.impSaldoInsoluto = impSaldoInsoluto;
    }
}