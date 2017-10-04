package com.tscfdi.comprobante.complementoSPC;

import javax.xml.bind.annotation.*;

/**
 * Created by lugty on 9/26/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "parcialesconstruccion",
        propOrder = { }
)
@XmlRootElement(name = "parcialesconstruccion")
public class DataParcialesConstruccion {
    @XmlAttribute(
            name = "Version",
            required = true
    )
    private String version;

    @XmlAttribute(
            name = "NumPerLicoAut",
            required = true
    )
    private String numPerLicoAut;

    @XmlElement(
            name = "Inmueble",
            required = true
    )
    private DataInmueble dataInmueble;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNumPerLicoAut() {
        return numPerLicoAut;
    }

    public void setNumPerLicoAut(String numPerLicoAut) {
        this.numPerLicoAut = numPerLicoAut;
    }

    public DataInmueble getDataInmueble() {
        return dataInmueble;
    }

    public void setDataInmueble(DataInmueble dataInmueble) {
        this.dataInmueble = dataInmueble;
    }
}
