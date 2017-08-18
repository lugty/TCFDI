package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by lugty on 19/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
public class DataRegimenFiscal {
    @XmlAttribute(
            name = "Regimen",
            required = true
    )
    private String regimen; // REQUIRED

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }
}
