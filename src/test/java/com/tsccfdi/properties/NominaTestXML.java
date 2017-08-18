package com.tsccfdi.properties;

import com.tscfdi.cfdi.CFDI;
import com.tscfdi.cfdi.TimbradoCFDI;
import com.tscfdi.cfdi.ValidadorCFDI;
import com.tscfdi.comprobante.DataComplemento;
import com.tscfdi.comprobante.DataComprobante;
import com.tscfdi.comprobante.nomina.*;
import com.tscfdi.keys.PrivateKeyLoader;
import com.tscfdi.keys.PublicKeyLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lugty on 12/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_test/app-context.xml")
public class NominaTestXML {

    @Test
    public void testBuildNomina() throws Exception{
        DataComprobante comprobante = CfdiXmlTest.getCfdiObjectData();
        DataNomina dataNomina = NominaTestXML.getDataNomina();


        DataComplemento complemento = new DataComplemento();
        List<Object> any = new ArrayList();
        any.add(dataNomina);
        complemento.setAny(any);

        comprobante.setComplemento(complemento);

        CFDI cfdi = new CFDI(comprobante, "com.tscfdi.comprobante.nomina");

        byte[] xmlBytes = cfdi.getBytesXML();
        String xml = new String(xmlBytes);
        System.out.println(xml);

        System.out.println(cfdi.getCadenaOriginal());

        /**************************** sellado ******************************************************/
        InputStream privateInput = getClass().getResourceAsStream("/csd/private.key");
        InputStream publicInput = getClass().getResourceAsStream("/csd/public.cer");

        PublicKeyLoader publicKeyLoader = new PublicKeyLoader(publicInput);
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader(privateInput, "Zalli902");

        cfdi.sellar(privateKeyLoader.key, publicKeyLoader.key);
        byte[] xmlBytesSellado = cfdi.getBytesXML();
        String xmlSellado = new String(xmlBytesSellado);
        System.out.println(xmlSellado);

        System.out.println(cfdi.getCadenaOriginal());


        /***************************** validaor de CFDI *********************************************/
        //ValidadorCFDI validadorCFDI = new ValidadorCFDI(comprobante, "com.tscfdi.comprobante.nomina");
        //validadorCFDI.validarNomina();

        /************************************  timbrado de prueba ***********************************/
        TimbradoCFDI timbradoCFDI = new TimbradoCFDI("APR0412108C5", "5LtrG#%r");
        //byte[] timbradoCFDIBytes = timbradoCFDI.timbrarCFDITest(cfdi);

        System.out.println("************************ TIMBRADO *************************");
        //System.out.println(new String(timbradoCFDIBytes));


        //CFDI parsed = new CFDI(new ByteArrayInputStream(timbradoCFDI));
    }

    private static DataNomina getDataNomina() throws Exception{
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        DataNomina data = new DataNomina();

        data.setVersion("1.2");
        data.setTipoNomina("O");
        data.setFechaPago(format.parse("15-12-2016"));
        data.setFechaInicialPago(format.parse("01-12-2016"));
        data.setFechaFinalPago(format.parse("15-12-2016"));
        data.setNumDiasPagados(new BigDecimal(0.001));
        data.setTotalPercepciones(new BigDecimal(1000));

        DataNominaEmisor emisor = new DataNominaEmisor();
        emisor.setCurp("GUTL870220HGTTVS02");

        data.setDataNominaEmisor(emisor);

        DataNominaReceptor receptor = new DataNominaReceptor();
        receptor.setCurp("GUTL870220HGTTVS09");
        receptor.setTipoContrato("09");
        receptor.setTipoRegimen("02");
        receptor.setNumEmpleado("01");
        receptor.setPeriodicidadPago("04");
        receptor.setClaveEntFed("QUE");
        //receptor.setFechaInicioRelLaborral(null);

        data.setDataNominaReceptor(receptor);

        DataPercepciones percepciones = new DataPercepciones();
        percepciones.setTotalSueldos(new BigDecimal(1000));
        percepciones.setTotalGravado(new BigDecimal(500));
        percepciones.setTotalExento(new BigDecimal(500));

        List<DataPercepcion> listPer = new ArrayList<DataPercepcion>();

        DataPercepcion per1= new DataPercepcion();
        per1.setTipoPercepcion("001");
        per1.setClave("005");
        per1.setConcepto("Sueldo");
        per1.setImporteGravado(new BigDecimal(500));
        per1.setImporteExento(new BigDecimal(500));
        listPer.add(per1);

        percepciones.setDataPercepcions(listPer);
        data.setDataPercepciones(percepciones);


        DataDeducciones deducciones = new DataDeducciones();
        deducciones.setTotalImpuestosRetenidos(new BigDecimal(500));

        List<DataDeduccion> listDeduc = new ArrayList<DataDeduccion>();

        DataDeduccion deduc1 = new DataDeduccion();
        deduc1.setTipoDeduccion("001");
        deduc1.setClave("00301");
        deduc1.setConcepto("Seguridad social");
        deduc1.setImporte(new BigDecimal(500));
        listDeduc.add(deduc1);

        deducciones.setDataDeduccion(listDeduc);
        data.setDataDeducciones(deducciones);

        return data;
    }

}
