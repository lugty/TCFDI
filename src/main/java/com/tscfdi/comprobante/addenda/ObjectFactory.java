package com.tscfdi.comprobante.addenda;

import com.tscfdi.comprobante.DataComprobante;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by lugty on 6/26/17.
 */
@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {}

    public DataDocumento createDataDocumento(){return new DataDocumento();}
    public  DataAddendaWalmartPegaso createDataAddendaWalmartPegaso(){return new DataAddendaWalmartPegaso();}

}
