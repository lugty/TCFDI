package com.tscfdi.comprobante.complementos;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created by lugty on 6/26/17.
 */
@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {}

    public DataImpuestosLocales createImpuestosLocales(){return new DataImpuestosLocales();}

}
