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
        propOrder = { "emisor", "receptor", "conceptos", "impuestos", "complemento", "addenda" }
)
@XmlRootElement(name = "Comprobante")
public class DataComprobante {

    @XmlAttribute(
            name = "version",
            required = true
    )
    private String version;

    @XmlAttribute(
            name = "serie"
    )
    private String serie;

    @XmlAttribute(
            name = "folio"
    )
    private String folio;

    @XmlAttribute(
            name = "fecha",
            required = true
    )
    @XmlJavaTypeAdapter(DateInvoiceAdapter.class)
    private Date fecha;

    @XmlAttribute(
            name = "sello",
            required = true
    )
    private String sello; // private readonly

    @XmlAttribute(
            name = "formaDePago",
            required = true
    )
    private String formaDePago;

    @XmlAttribute(
            name = "noCertificado",
            required = true
    )
    private String noCertificado; // private readonly

    @XmlAttribute(
            name = "certificado",
            required = true
    )
    private String certificado; //private readonly

    @XmlAttribute(
            name = "condicionesDePago"
    )
    private String condicionesDePago;

    @XmlAttribute(
            name = "subTotal",
            required = true
    )
    private BigDecimal subTotal;

    @XmlAttribute(
            name = "descuento",
            required = true
    )
    private BigDecimal descuento;

    @XmlAttribute(
            name = "motivoDescuento"
    )
    private String motivoDescuento;

    @XmlAttribute(
            name = "TipoCambio"
    )
    private String tipoCambio;

    @XmlAttribute(
            name = "Moneda"
    )
    private String moneda;

    @XmlAttribute(
            name = "total",
            required = true
    )
    private BigDecimal total;


    @XmlAttribute(
            name = "tipoDeComprobante",
            required = true
    )
    private String tipoDeComprobante;

    @XmlAttribute(
            name = "metodoDePago",
            required = true
    )
    private String metodoDePago;

    @XmlAttribute(
            name = "LugarExpedicion",
            required = true
    )
    private String lugarExpedicion;

    @XmlAttribute(
            name = "NumCtaPago"
    )
    private String NumCtaPago;

    /** para pagos en parcialidades **/

    @XmlAttribute(
            name = "FolioFiscalOrig"
    )
    private String folioFiscalOrig;

    @XmlAttribute(
            name = "SerieFolioFiscalOrig"
    )
    private String serieFolioFiscalOrig;

    @XmlAttribute(
            name = "FechaFolioFiscalOrig"
    )
    private Date fechaFolioFiscalOrig;

    @XmlAttribute(
            name = "MontoFolioFiscalOrig"
    )
    private BigDecimal montoFolioFicalOrig;

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
            name = "Impuestos",
            required = true
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

    public DataComprobante() { }

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

    public String getMotivoDescuento() {
        return motivoDescuento;
    }

    public void setMotivoDescuento(String motivoDescuento) {
        this.motivoDescuento = motivoDescuento;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getNumCtaPago() {
        return NumCtaPago;
    }

    public void setNumCtaPago(String numCtaPago) {
        NumCtaPago = numCtaPago;
    }

    public String getFolioFiscalOrig() {
        return folioFiscalOrig;
    }

    public void setFolioFiscalOrig(String folioFiscalOrig) {
        this.folioFiscalOrig = folioFiscalOrig;
    }

    public String getSerieFolioFiscalOrig() {
        return serieFolioFiscalOrig;
    }

    public void setSerieFolioFiscalOrig(String serieFolioFiscalOrig) {
        this.serieFolioFiscalOrig = serieFolioFiscalOrig;
    }

    public Date getFechaFolioFiscalOrig() {
        return fechaFolioFiscalOrig;
    }

    public void setFechaFolioFiscalOrig(Date fechaFolioFiscalOrig) {
        this.fechaFolioFiscalOrig = fechaFolioFiscalOrig;
    }

    public BigDecimal getMontoFolioFicalOrig() {
        return montoFolioFicalOrig;
    }

    public void setMontoFolioFicalOrig(BigDecimal montoFolioFicalOrig) {
        this.montoFolioFicalOrig = montoFolioFicalOrig;
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
