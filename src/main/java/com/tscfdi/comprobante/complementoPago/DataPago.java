package com.tscfdi.comprobante.complementoPago;

import com.tscfdi.common.DateInvoiceAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lugty on 9/7/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = { }
)
public class DataPago {

    @XmlAttribute(
            name = "FechaPago",
            required = true
    )
    @XmlJavaTypeAdapter(DateInvoiceAdapter.class)
    private Date fecha;

    @XmlAttribute(
            name = "FormaDePagoP",
            required = true
    )
    private String formaDePagoP;

    @XmlAttribute(
            name = "MonedaP",
            required = true
    )
    private String monedaP;

    @XmlAttribute(
            name = "TipoCambioP"
    )
    private BigDecimal tipoCambioP;

    @XmlAttribute(
            name = "Monto",
            required = true
    )
    private BigDecimal monto;

    @XmlAttribute(
            name = "NumOperacion"
    )
    private String numOperacion;

    @XmlAttribute(
            name = "RfcEmisorCtaOrd"
    )
    private String rfcEmisorCtaOrd;

    @XmlAttribute(
            name = "NomBancoOrdExt"
    )
    private String nomBancoOrdExt;

    @XmlAttribute(
            name = "CtaOrdenamente"
    )
    private String ctaOrdenamente;

    @XmlAttribute(
            name = "RfcEmisorCtaBen"
    )
    private String rfcEmisorCtaBen;

    @XmlAttribute(
            name = "CtaBeneficiario"
    )
    private String CtaBeneficiario;

    @XmlAttribute(
            name = "TipoCadPago"
    )
    private String tipoCadPago;

    @XmlAttribute(
            name = "CertPago"
    )
    private String certPago;

    @XmlAttribute(
            name = "CadPago"
    )
    private String CadPago;

    @XmlAttribute(
            name = "SelloPago"
    )
    private String SelloPago;

    @XmlElement(
            name = "DoctoRelacionado"
    )
    private List<DataDoctoRelacionado> dataDoctoRelacionados;

    @XmlElement(
            name = "Impuestos"
    )
    private List<DataPagoImpuestos> dataPagoImpuestos;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFormaDePagoP() {
        return formaDePagoP;
    }

    public void setFormaDePagoP(String formaDePagoP) {
        this.formaDePagoP = formaDePagoP;
    }

    public String getMonedaP() {
        return monedaP;
    }

    public void setMonedaP(String monedaP) {
        this.monedaP = monedaP;
    }

    public BigDecimal getTipoCambioP() {
        return tipoCambioP;
    }

    public void setTipoCambioP(BigDecimal tipoCambioP) {
        this.tipoCambioP = tipoCambioP;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getNumOperacion() {
        return numOperacion;
    }

    public void setNumOperacion(String numOperacion) {
        this.numOperacion = numOperacion;
    }

    public String getRfcEmisorCtaOrd() {
        return rfcEmisorCtaOrd;
    }

    public void setRfcEmisorCtaOrd(String rfcEmisorCtaOrd) {
        this.rfcEmisorCtaOrd = rfcEmisorCtaOrd;
    }

    public String getNomBancoOrdExt() {
        return nomBancoOrdExt;
    }

    public void setNomBancoOrdExt(String nomBancoOrdExt) {
        this.nomBancoOrdExt = nomBancoOrdExt;
    }

    public String getCtaOrdenamente() {
        return ctaOrdenamente;
    }

    public void setCtaOrdenamente(String ctaOrdenamente) {
        this.ctaOrdenamente = ctaOrdenamente;
    }

    public String getRfcEmisorCtaBen() {
        return rfcEmisorCtaBen;
    }

    public void setRfcEmisorCtaBen(String rfcEmisorCtaBen) {
        this.rfcEmisorCtaBen = rfcEmisorCtaBen;
    }

    public String getCtaBeneficiario() {
        return CtaBeneficiario;
    }

    public void setCtaBeneficiario(String ctaBeneficiario) {
        CtaBeneficiario = ctaBeneficiario;
    }

    public String getTipoCadPago() {
        return tipoCadPago;
    }

    public void setTipoCadPago(String tipoCadPago) {
        this.tipoCadPago = tipoCadPago;
    }

    public String getCertPago() {
        return certPago;
    }

    public void setCertPago(String certPago) {
        this.certPago = certPago;
    }

    public String getCadPago() {
        return CadPago;
    }

    public void setCadPago(String cadPago) {
        CadPago = cadPago;
    }

    public String getSelloPago() {
        return SelloPago;
    }

    public void setSelloPago(String selloPago) {
        SelloPago = selloPago;
    }

    public List<DataDoctoRelacionado> getDataDoctoRelacionados() {
        return dataDoctoRelacionados;
    }

    public void setDataDoctoRelacionados(List<DataDoctoRelacionado> dataDoctoRelacionados) {
        this.dataDoctoRelacionados = dataDoctoRelacionados;
    }

    public List<DataPagoImpuestos> getDataPagoImpuestos() {
        return dataPagoImpuestos;
    }

    public void setDataPagoImpuestos(List<DataPagoImpuestos> dataPagoImpuestos) {
        this.dataPagoImpuestos = dataPagoImpuestos;
    }
}
