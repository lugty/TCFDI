package com.tscfdi.comprobante;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by lugty on 24/08/16.
 */
@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {}

    public DataComprobante createComprobante(){return new DataComprobante();}
}
