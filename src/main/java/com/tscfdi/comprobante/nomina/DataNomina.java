package com.tscfdi.comprobante.nomina;

import com.tscfdi.common.DateOnlyAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lugty on 12/8/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = ""
)
@XmlRootElement(name = "Nomina")
public class DataNomina {
    @XmlAttribute(
            name = "Version",
            required = true
    )
    private String version;

    @XmlAttribute(
            name = "TipoNomina",
            required = true
    )
    private String tipoNomina;

    @XmlAttribute(
            name = "FechaPago",
            required = true
    )
    @XmlJavaTypeAdapter(DateOnlyAdapter.class)
    private Date fechaPago;

    @XmlAttribute(
            name = "FechaInicialPago",
            required = true
    )
    @XmlJavaTypeAdapter(DateOnlyAdapter.class)
    private Date fechaInicialPago;

    @XmlAttribute(
            name = "FechaFinalPago",
            required = true
    )
    @XmlJavaTypeAdapter(DateOnlyAdapter.class)
    private Date fechaFinalPago;

    @XmlAttribute(
            name = "NumDiasPagados",
            required = true
    )
    private BigDecimal numDiasPagados;

    @XmlAttribute(
            name = "TotalPercepciones",
            required = false
    )
    private BigDecimal totalPercepciones;

    @XmlAttribute(
            name = "TotalDeducciones",
            required = false
    )
    private BigDecimal totalDeducciones;

    @XmlAttribute(
            name = "TotalOtrosPagos",
            required = false
    )
    private BigDecimal totalOtrosPagos;

    @XmlElement(
            name = "Emisor",
            required = false
    )
    private DataNominaEmisor dataNominaEmisor;

    @XmlElement(
            name = "Receptor",
            required = true
    )
    private DataNominaReceptor dataNominaReceptor;

    @XmlElement(
            name = "Percepciones",
            required = true
    )
    private DataPercepciones dataPercepciones;

    @XmlElement(
            name = "Deducciones",
            required = false
    )
    private DataDeducciones dataDeducciones;

    @XmlElementWrapper(name = "OtrosPagos", required = false)
    @XmlElement(
            name = "OtroPago",
            required = false
    )
    private List<DataOtroPago> dataOtrosPagos;

    @XmlElementWrapper(name = "Incapacidades", required = false)
    @XmlElement(name = "Incapacidad", required = false)
    private List<DataIncapacidad> dataIncapacidades;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTipoNomina() {
        return tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaInicialPago() {
        return fechaInicialPago;
    }

    public void setFechaInicialPago(Date fechaInicialPago) {
        this.fechaInicialPago = fechaInicialPago;
    }

    public Date getFechaFinalPago() {
        return fechaFinalPago;
    }

    public void setFechaFinalPago(Date fechaFinalPago) {
        this.fechaFinalPago = fechaFinalPago;
    }

    public BigDecimal getNumDiasPagados() {
        return numDiasPagados;
    }

    public void setNumDiasPagados(BigDecimal numDiasPagados) {
        this.numDiasPagados = numDiasPagados;
    }

    public BigDecimal getTotalPercepciones() {
        return totalPercepciones;
    }

    public void setTotalPercepciones(BigDecimal totalPercepciones) {
        this.totalPercepciones = totalPercepciones;
    }

    public BigDecimal getTotalDeducciones() {
        return totalDeducciones;
    }

    public void setTotalDeducciones(BigDecimal totalDeducciones) {
        this.totalDeducciones = totalDeducciones;
    }

    public BigDecimal getTotalOtrosPagos() {
        return totalOtrosPagos;
    }

    public void setTotalOtrosPagos(BigDecimal totalOtrosPagos) {
        this.totalOtrosPagos = totalOtrosPagos;
    }

    public DataNominaEmisor getDataNominaEmisor() {
        return dataNominaEmisor;
    }

    public void setDataNominaEmisor(DataNominaEmisor dataNominaEmisor) {
        this.dataNominaEmisor = dataNominaEmisor;
    }

    public DataNominaReceptor getDataNominaReceptor() {
        return dataNominaReceptor;
    }

    public void setDataNominaReceptor(DataNominaReceptor dataNominaReceptor) {
        this.dataNominaReceptor = dataNominaReceptor;
    }

    public DataPercepciones getDataPercepciones() {
        return dataPercepciones;
    }

    public void setDataPercepciones(DataPercepciones dataPercepciones) {
        this.dataPercepciones = dataPercepciones;
    }

    public DataDeducciones getDataDeducciones() {
        return dataDeducciones;
    }

    public void setDataDeducciones(DataDeducciones dataDeducciones) {
        this.dataDeducciones = dataDeducciones;
    }

    public List<DataOtroPago> getDataOtrosPagos() {
        return dataOtrosPagos;
    }

    public void setDataOtrosPagos(List<DataOtroPago> dataOtrosPagos) {
        this.dataOtrosPagos = dataOtrosPagos;
    }

    public List<DataIncapacidad> getDataIncapacidades() {
        return dataIncapacidades;
    }

    public void setDataIncapacidades(List<DataIncapacidad> dataIncapacidades) {
        this.dataIncapacidades = dataIncapacidades;
    }
}
