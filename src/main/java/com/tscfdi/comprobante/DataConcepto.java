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
        propOrder = {"impuestos", "informacionAduanera", "cuentaPredial", "complementoConcepto", "parte"}
)
public class DataConcepto {
    @XmlAttribute(
            name = "ClaveProdServ",
            required = true
    )
    private String claveProdServ;

    @XmlAttribute(
            name = "NoIdentificacion"
    )
    private String noIdentificacion;

    @XmlAttribute(
            name = "Cantidad",
            required = true
    )
    private BigDecimal cantidad;

    @XmlAttribute(
            name = "ClaveUnidad",
            required = true
    )
    private String claveUnidad;

    @XmlAttribute(
            name = "Unidad"
    )
    private String unidades;

    @XmlAttribute(
            name = "Descripcion",
            required = true
    )
    private String descripcion;

    @XmlAttribute(
            name = "ValorUnitario",
            required = true
    )
    private BigDecimal valorUnitario;

    @XmlAttribute(
            name = "Importe",
            required = true
    )
    private BigDecimal importe;

    @XmlAttribute(
            name = "Descuento"
    )
    private BigDecimal descuento;





    @XmlElement(
            name = "Impuestos"
    )
    private DataImpuestosConcepto impuestos;

    @XmlElement(
            name = "InformacionAduanera"
    )
    private List<DataInformacionAduanera> informacionAduanera;

    @XmlElement(
            name = "CuentaPredial"
    )
    private DataCuentaPredial cuentaPredial;

    @XmlElement(
            name = "ComplementoConcepto"
    )
    private DataComplementoConcepto complementoConcepto;

    @XmlElement(
            name = "Parte"
    )
    private DataParte parte;






    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getClaveProdServ() {
        return claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public DataImpuestosConcepto getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(DataImpuestosConcepto impuestos) {
        this.impuestos = impuestos;
    }

    public List<DataInformacionAduanera> getInformacionAduanera() {
        return informacionAduanera;
    }

    public void setInformacionAduanera(List<DataInformacionAduanera> informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }

    public DataCuentaPredial getCuentaPredial() {
        return cuentaPredial;
    }

    public void setCuentaPredial(DataCuentaPredial cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }

    public DataComplementoConcepto getComplementoConcepto() {
        return complementoConcepto;
    }

    public void setComplementoConcepto(DataComplementoConcepto complementoConcepto) {
        this.complementoConcepto = complementoConcepto;
    }

    public DataParte getParte() {
        return parte;
    }

    public void setParte(DataParte parte) {
        this.parte = parte;
    }
}
