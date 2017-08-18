package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * Created by lugty on 12/9/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataOtroPago {

    @XmlAttribute(name = "TipoOtroPago", required = true)
    private String tipoOtroPago;

    @XmlAttribute(name = "Clave", required = true)
    private String clave;

    @XmlAttribute(name = "Concepto", required = true)
    private String concepto;

    @XmlAttribute(name = "Importe", required = true)
    private BigDecimal importe;

    @XmlElement(name = "SubsidioAlEmpleo", required = false)
    private DataSubsidioAlEmpleo dataSubsidioAlEmpleo;

    @XmlElement(name = "CompensacionSaldosAFavor", required = false)
    private DataCompensacionSaldosAFavor dataCompensacionSaldosAFavor;

    public String getTipoOtroPago() {
        return tipoOtroPago;
    }

    public void setTipoOtroPago(String tipoOtroPago) {
        this.tipoOtroPago = tipoOtroPago;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public DataSubsidioAlEmpleo getDataSubsidioAlEmpleo() {
        return dataSubsidioAlEmpleo;
    }

    public void setDataSubsidioAlEmpleo(DataSubsidioAlEmpleo dataSubsidioAlEmpleo) {
        this.dataSubsidioAlEmpleo = dataSubsidioAlEmpleo;
    }

    public DataCompensacionSaldosAFavor getDataCompensacionSaldosAFavor() {
        return dataCompensacionSaldosAFavor;
    }

    public void setDataCompensacionSaldosAFavor(DataCompensacionSaldosAFavor dataCompensacionSaldosAFavor) {
        this.dataCompensacionSaldosAFavor = dataCompensacionSaldosAFavor;
    }
}
