package com.tscfdi.comprobante.addenda;

import javax.xml.bind.annotation.*;

/**
 * Created by lugty on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
@XmlRootElement(name = "Documento")
public class DataDocumento {
    @XmlValue
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
