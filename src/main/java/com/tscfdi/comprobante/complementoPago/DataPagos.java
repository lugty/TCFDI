package com.tscfdi.comprobante.complementoPago;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lugty on 9/7/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Pagos",
        propOrder = { }
)
@XmlRootElement(name = "Pagos")
public class DataPagos {
    @XmlAttribute(
            name = "Version",
            required = true
    )
    private String version;

    @XmlElement(
            name = "Pago",
            required = true
    )
    private List<DataPago> dataPagoList;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<DataPago> getDataPagoList() {
        return dataPagoList;
    }

    public void setDataPagoList(List<DataPago> dataPagoList) {
        this.dataPagoList = dataPagoList;
    }
}
