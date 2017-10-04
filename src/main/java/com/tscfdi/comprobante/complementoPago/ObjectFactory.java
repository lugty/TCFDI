package com.tscfdi.comprobante.complementoPago;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by lugty on 6/26/17.
 */
@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {}
    public DataPagos createPagos(){ return new DataPagos(); }
}
