package com.tscfdi.comprobante.complementoSPC;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by lugty on 6/26/17.
 */
@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {}

    public DataParcialesConstruccion createParcialesConstruccion(){ return new DataParcialesConstruccion(); }
}
