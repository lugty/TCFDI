package com.tscfdi.comprobante;

import javax.xml.bind.annotation.*;

/**
 * Created by lugty on 19/08/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {}
)
public class DataReceptor {
    @XmlAttribute(
            name = "Rfc",
            required = true
    )
    private String rfc; // REQUIRED

    @XmlAttribute(
            name = "Nombre"
    )
    private String nombre; // OPTIONAL

    @XmlAttribute(
            name = "ResidenciaFiscal"
    )
    private String residenciaFiscal;

    @XmlAttribute(
            name = "NumRegIdTrib"
    )
    private String numRegIdTrib;

    @XmlAttribute(
            name = "UsoCFDI",
            required = true
    )
    private String usoCFDI;

    public DataReceptor() {
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResidenciaFiscal() {
        return residenciaFiscal;
    }

    public void setResidenciaFiscal(String residenciaFiscal) {
        this.residenciaFiscal = residenciaFiscal;
    }

    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    public String getUsoCFDI() {
        return usoCFDI;
    }

    public void setUsoCFDI(String usoCFDI) {
        this.usoCFDI = usoCFDI;
    }
}
