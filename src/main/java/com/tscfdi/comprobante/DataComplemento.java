package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lugty on 22/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"any"}
)
public class DataComplemento {
    @XmlAnyElement(
            lax = true
    )
    protected List<Object> any;

    public DataComplemento() {
    }

    public List<Object> getAny() {
        if(this.any == null) {
            this.any = new ArrayList();
        }

        return this.any;
    }

    public void setAny(List<Object> any) {
        this.any = any;
    }
}
