package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lugty on 12/8/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPercepcion {

    @XmlAttribute(
            name = "TipoPercepcion",
            required = true
    )
    private String tipoPercepcion;

    @XmlAttribute(
            name = "Clave",
            required = true
    )
    private String clave;

    @XmlAttribute(
            name = "Concepto",
            required = true
    )
    private String concepto;

    @XmlAttribute(
            name = "ImporteGravado",
            required = true
    )
    private BigDecimal importeGravado;

    @XmlAttribute(
            name = "ImporteExento",
            required = true
    )
    private BigDecimal importeExento;

    @XmlElement(
            name = "AccionesOTitulos",
            required = true
    )
    private DataAccionesOTitulos dataAccionesOTitulos;

    @XmlElement(
            name = "HorasExtra",
            required = true
    )
    private List<DataHorasExtra> dataHorasExtra;

    public String getTipoPercepcion() {
        return tipoPercepcion;
    }

    public void setTipoPercepcion(String tipoPercepcion) {
        this.tipoPercepcion = tipoPercepcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getImporteGravado() {
        return importeGravado;
    }

    public void setImporteGravado(BigDecimal importeGravado) {
        this.importeGravado = importeGravado;
    }

    public BigDecimal getImporteExento() {
        return importeExento;
    }

    public void setImporteExento(BigDecimal importeExento) {
        this.importeExento = importeExento;
    }

    public DataAccionesOTitulos getDataAccionesOTitulos() {
        return dataAccionesOTitulos;
    }

    public void setDataAccionesOTitulos(DataAccionesOTitulos dataAccionesOTitulos) {
        this.dataAccionesOTitulos = dataAccionesOTitulos;
    }

    public List<DataHorasExtra> getDataHorasExtra() {
        return dataHorasExtra;
    }

    public void setDataHorasExtra(List<DataHorasExtra> dataHorasExtra) {
        this.dataHorasExtra = dataHorasExtra;
    }
}
