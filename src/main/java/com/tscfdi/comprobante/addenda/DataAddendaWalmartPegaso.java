package com.tscfdi.comprobante.addenda;

import javax.xml.bind.annotation.*;

/**
 * Created by lugty on 6/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        namespace = "http://www.pegasotecnologia.com/secfd/Schemas/Receptor/Walmart"
)
@XmlRootElement(name = "AddendaWalmart")
public class DataAddendaWalmartPegaso {
    @XmlAttribute(name = "unidadCEDIS", required = true)
    private String unidadCEDIS;

    @XmlAttribute(name = "ordenCompra", required = true)
    private String ordenCompra;

    @XmlAttribute(name = "FolioRecibo", required = true)
    private String folioRecibo;

    @XmlAttribute(name = "numeroProveedor", required = true)
    private String numeroProveedor;

    @XmlAttribute(name = "Anio", required = true)
    private String anio;

    @XmlAttribute(name="xmlns")
    public String xmlns="http://www.pegasotecnologia.com/secfd/Schemas/Receptor/Walmart";

    @XmlAttribute(name="xsi:schemaLocation")
    public String namespace_value="http://www.pegasotecnologia.com/secfd/Schemas/Receptor/Walmart http://www.pegasotecnologia.com/secfd/Schemas/Receptor/AddendaWalmart.xsd";

    public String getUnidadCEDIS() {
        return unidadCEDIS;
    }

    public void setUnidadCEDIS(String unidadCEDIS) {
        this.unidadCEDIS = unidadCEDIS;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getFolioRecibo() {
        return folioRecibo;
    }

    public void setFolioRecibo(String folioRecibo) {
        this.folioRecibo = folioRecibo;
    }

    public String getNumeroProveedor() {
        return numeroProveedor;
    }

    public void setNumeroProveedor(String numeroProveedor) {
        this.numeroProveedor = numeroProveedor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
