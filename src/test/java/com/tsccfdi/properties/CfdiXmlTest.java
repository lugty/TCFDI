package com.tsccfdi.properties;

import com.tscfdi.cfdi.CFDI;
import com.tscfdi.comprobante.*;
import com.tscfdi.comprobante.complementos.DataImpuestosLocales;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lugty on 24/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_test/app-context.xml")
public class CfdiXmlTest {

    @Test
    public void testCfdiXml() throws Exception{
        DataComprobante comprobante = getCfdiObjectData();
        CFDI cfdi = new CFDI(comprobante);
        byte[] xmlBytes = cfdi.getBytesXML();
        String xml = new String(xmlBytes);
        System.out.println(xml);

        System.out.println(cfdi.getCadenaOriginal());
    }


    public static DataComprobante getCfdiObjectData(){
        DataComprobante comprobante = new DataComprobante();
        comprobante.setVersion("3.3");
        comprobante.setSerie("A");
        comprobante.setFolio("1");
        comprobante.setFecha(new Date());
        comprobante.setFormaDePago("efectivo");
        comprobante.setCondicionesDePago("pago en una sola exivision");
        comprobante.setSubTotal(new BigDecimal("1.1"));
        comprobante.setDescuento(new BigDecimal("1.1"));
        comprobante.setMoneda("MXN");
        comprobante.setTotal(new BigDecimal("1.1"));
        comprobante.setTipoDeComprobante("ingreso");
        comprobante.setLugarExpedicion("Queretaro");

        DataEmisor emisor = new DataEmisor();
        emisor.setNombre("ITZEL LOPEZ JIMENEZ");
        emisor.setRfc("LOJI820529325");

        comprobante.setEmisor(emisor);

        DataReceptor receptor = new DataReceptor();
        receptor.setRfc("PAU071004FL7");
        receptor.setNombre("PHI IT");
        comprobante.setReceptor(receptor);

        DataConcepto concepto1 = new DataConcepto();
        concepto1.setCantidad(new BigDecimal("1"));
        concepto1.setDescripcion("Producto de prueba");
        concepto1.setImporte(new BigDecimal("1"));
        concepto1.setNoIdentificacion("001");
        concepto1.setUnidades("UNI");
        concepto1.setValorUnitario(new BigDecimal("1"));
        comprobante.getConceptos().add(concepto1);

        DataImpuesto impuestos = new DataImpuesto();
        impuestos.setTotalImpuestosRetenidos(new BigDecimal(".1"));
        impuestos.setTotalInpuestosTrasladados(new BigDecimal(".1"));
        comprobante.setImpuestos(impuestos);

        DataImpTrasladado impT1 = new DataImpTrasladado();
        impT1.setImporte(new BigDecimal(".1"));
        impT1.setImpuesto("IVA");

        List<DataImpTrasladado> traslados = new ArrayList<DataImpTrasladado>();
        traslados.add(impT1);

        DataImpRetencion impR1 = new DataImpRetencion();
        impR1.setImporte(new BigDecimal(".1"));
        impR1.setImpuesto("IVA");

        List<DataImpRetencion> retenciones = new ArrayList<DataImpRetencion>();
        retenciones.add(impR1);

        impuestos.setRetenciones(retenciones);
        impuestos.setTraslados(traslados);


        return comprobante;
    }
}
