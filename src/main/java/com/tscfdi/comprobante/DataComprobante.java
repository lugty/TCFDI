package com.tscfdi.comprobante;

import com.tscfdi.common.DateInvoiceAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lugty on 19/08/16.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Comprobante",
        propOrder = { "cfdiRelacionados", "emisor", "receptor", "conceptos", "impuestos", "complemento", "addenda" }
)
@XmlRootElement(name = "Comprobante")
public class DataComprobante {

    @XmlAttribute(
            name = "Version",
            required = true
    )
    private String version;

    @XmlAttribute(
            name = "Serie"
    )
    private String serie;

    @XmlAttribute(
            name = "Folio"
    )
    private String folio;

    @XmlAttribute(
            name = "Fecha",
            required = true
    )
    @XmlJavaTypeAdapter(DateInvoiceAdapter.class)
    private Date fecha;

    @XmlAttribute(
            name = "Sello",
            required = true
    )
    private String sello; // private readonly

    @XmlAttribute(
            name = "formaDePago",
            required = true
    )
    private String formaDePago;

    @XmlAttribute(
            name = "NoCertificado",
            required = true
    )
    private String noCertificado; // private readonly

    @XmlAttribute(
            name = "Certificado",
            required = true
    )
    private String certificado; //private readonly

    @XmlAttribute(
            name = "CondicionesDePago"
    )
    private String condicionesDePago;

    @XmlAttribute(
            name = "SubTotal",
            required = true
    )
    private BigDecimal subTotal;

    @XmlAttribute(
            name = "Descuento"
    )
    private BigDecimal descuento;

    @XmlAttribute(
            name = "Moneda",
            required = true
    )
    private String moneda;

    @XmlAttribute(
            name = "TipoCambio"
    )
    private String tipoCambio;

    @XmlAttribute(
            name = "Total",
            required = true
    )
    private BigDecimal total;

    @XmlAttribute(
            name = "TipoDeComprobante",
            required = true
    )
    private String tipoDeComprobante;

    @XmlAttribute(
            name = "MetodoPago"
    )
    private String metodoPago;

    @XmlAttribute(
            name = "LugarExpedicion",
            required = true
    )
    private String lugarExpedicion;

    @XmlAttribute(
            name = "Confirmacion"
    )
    private String confirmacion;


    @XmlElement(
            name = "CfdiRelacionados"
    )
    private DataCfdiRelacionados cfdiRelacionados;

    @XmlElement(
            name = "Emisor",
            required = true
    )
    private DataEmisor emisor;

    @XmlElement(
            name = "Receptor",
            required = true
    )
    private DataReceptor receptor;

    @XmlElementWrapper(name = "Conceptos", required = true)
    @XmlElement(
            name = "Concepto",
            required = true
    )
    private List<DataConcepto> conceptos = new ArrayList<DataConcepto>();

    @XmlElement(
            name = "Impuestos"
    )
    private DataImpuesto impuestos;

    @XmlElement(
            name = "Complemento"
    )
    private DataComplemento complemento;

    @XmlElement(
            name = "Addenda"
    )
    private DataAddenda addenda;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    public void setCondicionesDePago(String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public DataCfdiRelacionados getCfdiRelacionados() {
        return cfdiRelacionados;
    }

    public void setCfdiRelacionados(DataCfdiRelacionados cfdiRelacionados) {
        this.cfdiRelacionados = cfdiRelacionados;
    }

    public DataEmisor getEmisor() {
        return emisor;
    }

    public void setEmisor(DataEmisor emisor) {
        this.emisor = emisor;
    }

    public DataReceptor getReceptor() {
        return receptor;
    }

    public void setReceptor(DataReceptor receptor) {
        this.receptor = receptor;
    }

    public List<DataConcepto> getConceptos() {
        return conceptos;
    }

    public void setConceptos(List<DataConcepto> conceptos) {
        this.conceptos = conceptos;
    }

    public DataImpuesto getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(DataImpuesto impuestos) {
        this.impuestos = impuestos;
    }

    public DataComplemento getComplemento() {
        return complemento;
    }

    public void setComplemento(DataComplemento complemento) {
        this.complemento = complemento;
    }

    public DataAddenda getAddenda() {
        return addenda;
    }

    public void setAddenda(DataAddenda addenda) {
        this.addenda = addenda;
    }
}
