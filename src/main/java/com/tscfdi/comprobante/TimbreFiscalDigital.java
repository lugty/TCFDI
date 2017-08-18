package com.tscfdi.comprobante;


import com.tscfdi.common.DateInvoiceAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by lugty on 30/08/16.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "TimbreFiscalDigital"
)
@XmlRootElement(
        name = "TimbreFiscalDigital",
        namespace = "http://www.sat.gob.mx/TimbreFiscalDigital"
)
public class TimbreFiscalDigital {
    @XmlAttribute(
            name = "version",
            required = true
    )
    @XmlSchemaType(
            name = "anySimpleType"
    )
    protected String version;
    @XmlAttribute(
            name = "UUID",
            required = true
    )
    protected String uuid;
    @XmlAttribute(
            name = "FechaTimbrado",
            required = true
    )
    @XmlJavaTypeAdapter(DateInvoiceAdapter.class)
    protected Date fechaTimbrado;
    @XmlAttribute(
            name = "selloCFD",
            required = true
    )
    protected String selloCFD;
    @XmlAttribute(
            name = "noCertificadoSAT",
            required = true
    )
    protected String noCertificadoSAT;
    @XmlAttribute(
            name = "selloSAT",
            required = true
    )
    protected String selloSAT;

    public TimbreFiscalDigital() { }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(Date fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getSelloCFD() {
        return selloCFD;
    }

    public void setSelloCFD(String selloCFD) {
        this.selloCFD = selloCFD;
    }

    public String getNoCertificadoSAT() {
        return noCertificadoSAT;
    }

    public void setNoCertificadoSAT(String noCertificadoSAT) {
        this.noCertificadoSAT = noCertificadoSAT;
    }

    public String getSelloSAT() {
        return selloSAT;
    }

    public void setSelloSAT(String selloSAT) {
        this.selloSAT = selloSAT;
    }
}
