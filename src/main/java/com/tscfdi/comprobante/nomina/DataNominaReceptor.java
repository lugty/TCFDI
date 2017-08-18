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
@XmlRootElement(name = "Receptor")
public class DataNominaReceptor {

    @XmlAttribute(
            name = "Curp",
            required = true
    )
    private String curp;

    @XmlAttribute(
            name = "NumSeguridadSocial",
            required = false
    )
    private String numSeguridadSocial;

    @XmlAttribute(
            name = "FechaInicioRelLaboral",
            required = false
    )
    @XmlJavaTypeAdapter(DateOnlyAdapter.class)
    private Date fechaInicioRelLaborral;

    @XmlAttribute(
            name = "Antigüedad",
            required = false
    )
    private String antiguedad;

    @XmlAttribute(
            name = "TipoContrato",
            required = true
    )
    private String tipoContrato;

    @XmlAttribute(
            name = "Sindicalizado",
            required = false
    )
    private String sindicalizado;

    @XmlAttribute(
            name = "TipoJornada",
            required = false
    )
    private String tipoJornada;

    @XmlAttribute(
            name = "TipoRegimen",
            required = true
    )
    private String tipoRegimen;

    @XmlAttribute(
            name = "NumEmpleado",
            required = true
    )
    private String numEmpleado;

    @XmlAttribute(
            name = "Departamento",
            required = false
    )
    private String departamento;

    @XmlAttribute(
            name = "Puesto",
            required = false
    )
    private String puest;

    @XmlAttribute(
            name = "RiesgoPuesto",
            required = false
    )
    private String riesgoPuesto;

    @XmlAttribute(
            name = "PeriodicidadPago",
            required = true
    )
    private String periodicidadPago;

    @XmlAttribute(
            name = "Banco",
            required = false
    )
    private String banco;

    @XmlAttribute(
            name = "CuentaBancaria",
            required = false
    )
    private String cuentaBancaria;

    @XmlAttribute(
            name = "SalarioBaseCotApor",
            required = false
    )
    private BigDecimal salarioBaseCotApor;

    @XmlAttribute(
            name = "SalarioDiarioIntegrado",
            required = false
    )
    private BigDecimal salarioDiarioIntegrado;

    @XmlAttribute(
            name = "ClaveEntFed",
            required = false
    )
    private String claveEntFed;

    @XmlElement(
            name = "SubContratacion",
            required = false
    )
    private List<DataSubContratacion> dataSubContratacion;

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    public void setNumSeguridadSocial(String numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }

    public Date getFechaInicioRelLaborral() {
        return fechaInicioRelLaborral;
    }

    public void setFechaInicioRelLaborral(Date fechaInicioRelLaborral) {
        this.fechaInicioRelLaborral = fechaInicioRelLaborral;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getSindicalizado() {
        return sindicalizado;
    }

    public void setSindicalizado(String sindicalizado) {
        this.sindicalizado = sindicalizado;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public String getTipoRegimen() {
        return tipoRegimen;
    }

    public void setTipoRegimen(String tipoRegimen) {
        this.tipoRegimen = tipoRegimen;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuest() {
        return puest;
    }

    public void setPuest(String puest) {
        this.puest = puest;
    }

    public String getRiesgoPuesto() {
        return riesgoPuesto;
    }

    public void setRiesgoPuesto(String riesgoPuesto) {
        this.riesgoPuesto = riesgoPuesto;
    }

    public String getPeriodicidadPago() {
        return periodicidadPago;
    }

    public void setPeriodicidadPago(String periodicidadPago) {
        this.periodicidadPago = periodicidadPago;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public BigDecimal getSalarioBaseCotApor() {
        return salarioBaseCotApor;
    }

    public void setSalarioBaseCotApor(BigDecimal salarioBaseCotApor) {
        this.salarioBaseCotApor = salarioBaseCotApor;
    }

    public BigDecimal getSalarioDiarioIntegrado() {
        return salarioDiarioIntegrado;
    }

    public void setSalarioDiarioIntegrado(BigDecimal salarioDiarioIntegrado) {
        this.salarioDiarioIntegrado = salarioDiarioIntegrado;
    }

    public String getClaveEntFed() {
        return claveEntFed;
    }

    public void setClaveEntFed(String claveEntFed) {
        this.claveEntFed = claveEntFed;
    }

    public List<DataSubContratacion> getDataSubContratacion() {
        return dataSubContratacion;
    }

    public void setDataSubContratacion(List<DataSubContratacion> dataSubContratacion) {
        this.dataSubContratacion = dataSubContratacion;
    }
}
