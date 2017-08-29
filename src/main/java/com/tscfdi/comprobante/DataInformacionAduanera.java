package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by lugty on 8/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {}
)
public class DataInformacionAduanera {
    @XmlAttribute(
            name = "NumeroPedimento",
            required = true
    )
    private String numeroPedimento;

    public String getNumeroPedimento() {
        return numeroPedimento;
    }

    public void setNumeroPedimento(String numeroPedimento) {
        this.numeroPedimento = numeroPedimento;
    }
}
