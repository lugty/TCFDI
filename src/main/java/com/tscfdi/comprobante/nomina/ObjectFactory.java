package com.tscfdi.comprobante.nomina;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by lugty on 12/12/16.
 */
@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }
    public DataNomina createNomina(){return new DataNomina();}
}
