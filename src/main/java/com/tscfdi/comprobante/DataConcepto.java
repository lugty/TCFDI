package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * Created by lugty on 19/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {}
)
public class DataConcepto {
    @XmlAttribute(
            name = "cantidad",
            required = true
    )
    private BigDecimal cantidad;

    @XmlAttribute(
            name = "unidad",
            required = true
    )
    private String unidades;

    @XmlAttribute(
            name = "noIdentificacion"
    )
    private String noIdentificacion;

    @XmlAttribute(
            name = "descripcion",
            required = true
    )
    private String descripcion;

    @XmlAttribute(
            name = "valorUnitario",
            required = true
    )
    private BigDecimal valorUnitario;

    @XmlAttribute(
            name = "importe",
            required = true
    )
    private BigDecimal importe;

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

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
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
}
