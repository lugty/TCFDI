package com.tscfdi.comprobante;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 8/23/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"informacionAduanera"}
)
public class DataParte {

    @XmlAttribute(
            name = "ClaveProdServ",
            required = true
    )
    private String claveProdServ;

    @XmlAttribute(
            name = "NoIdentificacion"
    )
    private String noIdentificacion;

    @XmlAttribute(
            name = "Cantidad",
            required = true
    )
    private BigDecimal cantidad;

    @XmlAttribute(
            name = "Unidad"
    )
    private String unidades;

    @XmlAttribute(
            name = "Descripcion",
            required = true
    )
    private String descripcion;

    @XmlAttribute(
            name = "ValorUnitario"
    )
    private BigDecimal valorUnitario;

    @XmlAttribute(
            name = "Importe"
    )
    private BigDecimal importe;

    @XmlElement(
            name = "InformacionAduanera"
    )
    private List<DataInformacionAduanera> informacionAduanera;

    public String getClaveProdServ() {
        return claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public List<DataInformacionAduanera> getInformacionAduanera() {
        return informacionAduanera;
    }

    public void setInformacionAduanera(List<DataInformacionAduanera> informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }
}
