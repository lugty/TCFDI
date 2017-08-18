package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.*;

/**
 * Created by lugty on 12/8/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Receptor")
public class DataNominaEmisor {

    @XmlAttribute(name = "Curp", required = false)
    private String curp;

    @XmlAttribute(name = "RegistroPatronal", required = false)
    private String registroPatronal;

    @XmlAttribute(name = "RfcPatronOrigen", required = false)
    private String rfcPatronOrigen;

    @XmlElement(
            name = "EntidadSNCF",
            required = false
    )
    private DataEntidadSNCF dataEntidadSNCF;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRegistroPatronal() {
        return registroPatronal;
    }

    public void setRegistroPatronal(String registroPatronal) {
        this.registroPatronal = registroPatronal;
    }

    public String getRfcPatronOrigen() {
        return rfcPatronOrigen;
    }

    public void setRfcPatronOrigen(String rfcPatronOrigen) {
        this.rfcPatronOrigen = rfcPatronOrigen;
    }

    public DataEntidadSNCF getDataEntidadSNCF() {
        return dataEntidadSNCF;
    }

    public void setDataEntidadSNCF(DataEntidadSNCF dataEntidadSNCF) {
        this.dataEntidadSNCF = dataEntidadSNCF;
    }
}
