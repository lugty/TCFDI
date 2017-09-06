package com.tsccfdi.properties;

import com.tscfdi.cfdi.*;
import com.tscfdi.clientWS.TimbradoCFDIStub;
import com.tscfdi.comprobante.DataComplemento;
import com.tscfdi.comprobante.TimbreFiscalDigital;
import com.tscfdi.comprobante.DataComprobante;
import com.tscfdi.comprobante.complementos.DataImpuestosLocales;
import com.tscfdi.keys.PrivateKeyLoader;
import com.tscfdi.keys.PublicKeyLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lugty on 29/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_test/app-context.xml")
public class CFDIKeysTest {
    @Autowired
    TimbradoCFDI timbradoCFDI;

    @Autowired
    CancelacionCFDI cancelacionCFDI;

    @Test
    public void testCFDIKeys() throws Exception{
        InputStream privateInput = getClass().getResourceAsStream("/csd/private.key");
        InputStream publicInput = getClass().getResourceAsStream("/csd/public.cer");



        PublicKeyLoader publicKeyLoader = new PublicKeyLoader(publicInput);
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader(privateInput, "Zalli902");

        System.out.println("******************************************** Llave publica **********************************************");
        System.out.println(publicKeyLoader.key.toString());
        System.out.println("******************************************** Llave privada **********************************************");
        System.out.println(privateKeyLoader.key.toString());
        System.out.println(privateKeyLoader.key.getAlgorithm());
        System.out.println(new String(privateKeyLoader.key.getEncoded()));
    }

    @Test
    public void testSellado() throws Exception{
        InputStream privateInput = getClass().getResourceAsStream("/csd/private.key");
        InputStream publicInput = getClass().getResourceAsStream("/csd/public.cer");

        PublicKeyLoader publicKeyLoader = new PublicKeyLoader(publicInput);
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader(privateInput, "Zalli902");

        DataComprobante comprobante =  CfdiXmlTest.getCfdiObjectData();

        CFDI cfdi = new CFDI(comprobante);
        cfdi.sellar(privateKeyLoader.key, publicKeyLoader.key);


        byte[] xmlBytes = cfdi.getBytesXML();
        String xml = new String(xmlBytes);
        System.out.println(xml);

        System.out.println(cfdi.getCadenaOriginal());

        /***************************** validaor de CFDI *********************************************/
        //ValidadorCFDI validadorCFDI = new ValidadorCFDI(comprobante);
        //validadorCFDI.validar();
    }

    @Test
    public void testComplementoTimbrado() throws Exception{
        InputStream privateInput = getClass().getResourceAsStream("/csd/private.key");
        InputStream publicInput = getClass().getResourceAsStream("/csd/public.cer");

        PublicKeyLoader publicKeyLoader = new PublicKeyLoader(publicInput);
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader(privateInput, "Zalli902");

        DataComprobante comprobante =  CfdiXmlTest.getCfdiObjectData();

        /** add complementos **/
        List<Object> listComplementos = new ArrayList<Object>();

        /** Complemento Impuestos Locales **/
        DataImpuestosLocales dataImpuestosLocales = new DataImpuestosLocales();
        dataImpuestosLocales.setVersion("1.0");
        dataImpuestosLocales.setTotalDeRetenciones(new BigDecimal(100));
        dataImpuestosLocales.setTotalDeTraslados(new BigDecimal(100));

        listComplementos.add(dataImpuestosLocales);

        /** add complemento object **/
        DataComplemento complemento = new DataComplemento();
        complemento.setAny(listComplementos);
        comprobante.setComplemento(complemento);

        /** **/

        CFDI cfdi = new CFDI(comprobante, "com.tscfdi.comprobante.complementos");
        cfdi.sellar(privateKeyLoader.key, publicKeyLoader.key);

        byte[] xmlBytes = cfdi.getBytesXML();
        String xml = new String(xmlBytes);

        System.out.println(xml);
        System.out.println(cfdi.getCadenaOriginal());

        ValidadorCFDI validadorCFDI = new ValidadorCFDI(comprobante, "com.tscfdi.comprobante.complementos");
        //validadorCFDI.validar();
    }

    @Test
    public void testTimbrado() throws Exception{
        InputStream privateInput = getClass().getResourceAsStream("/csd/private.key");
        InputStream publicInput = getClass().getResourceAsStream("/csd/public.cer");

        PublicKeyLoader publicKeyLoader = new PublicKeyLoader(publicInput);
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader(privateInput, "Zalli902");

        DataComprobante comprobante =  CfdiXmlTest.getCfdiObjectData();

        CFDI cfdi = new CFDI(comprobante);
        cfdi.sellar(privateKeyLoader.key, publicKeyLoader.key);


        byte[] xmlBytes = cfdi.getBytesXML();
        String xml = new String(xmlBytes);
        System.out.println(xml);

        System.out.println(cfdi.getCadenaOriginal());

        /***************************** validaor de CFDI *********************************************/
        //ValidadorCFDI validadorCFDI = new ValidadorCFDI(comprobante);
        //validadorCFDI.validar();

        /***************************** prueba timbrado ********************************/
        //byte[] timbradoCFDI = this.timbradoCFDI.timbrarCFDI(cfdi);

        String selladoString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><cfdi:Comprobante xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" LugarExpedicion=\"93294\" MetodoPago=\"PUE\" TipoDeComprobante=\"I\" Total=\"127600.00\" Moneda=\"MXN\" SubTotal=\"110000.00\" CondicionesDePago=\"Contado\" Certificado=\"MIIElzCCA3+gAwIBAgIUMDAwMDEwMDAwMDAzMDQ5ODc0NDkwDQYJKoZIhvcNAQEFBQAwggGKMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMR8wHQYJKoZIhvcNAQkBFhBhY29kc0BzYXQuZ29iLm14MSYwJAYDVQQJDB1Bdi4gSGlkYWxnbyA3NywgQ29sLiBHdWVycmVybzEOMAwGA1UEEQwFMDYzMDAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBEaXN0cml0byBGZWRlcmFsMRQwEgYDVQQHDAtDdWF1aHTDqW1vYzEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTUwMwYJKoZIhvcNAQkCDCZSZXNwb25zYWJsZTogQ2xhdWRpYSBDb3ZhcnJ1YmlhcyBPY2hvYTAeFw0xNDA4MjcxNzIyNThaFw0xODA4MjcxNzIyNThaMIHjMSUwIwYDVQQDExxWSUNHQVIgSU5NT0JJTElBUklBIFNBIERFIENWMSUwIwYDVQQpExxWSUNHQVIgSU5NT0JJTElBUklBIFNBIERFIENWMSUwIwYDVQQKExxWSUNHQVIgSU5NT0JJTElBUklBIFNBIERFIENWMSUwIwYDVQQtExxWSU45NjA5MTIyRzIgLyBNQU1ONzExMjEwNEE3MR4wHAYDVQQFExUgLyBNQU1ONzExMjEwTURGTk5SMDQxJTAjBgNVBAsTHFZJQ0dBUiBJTk1PQklMSUFSSUEgU0EgREUgQ1YwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAJN3bMowdwJIXym802dkwcEJ9DpNX1ViVgEh2GTcc4xpY1/bzMOPJg+/9WOv7aaLCRH78G8sGI7Dqcd4MoA2iLDjrtODjrYqFielO/St02K1l1Or4RQIUMIojD/t1y7jxRf777cnSxcZgYsKIDMnNLnOhorbl5evnNr5uo6YhbSJAgMBAAGjHTAbMAwGA1UdEwEB/wQCMAAwCwYDVR0PBAQDAgbAMA0GCSqGSIb3DQEBBQUAA4IBAQAou2kohZFI9VerhQv3Dtp3sQrvz3sEqmfC51jkJPsuzDmpz3DTPb9nvQH82JiSM/H3gJOzWNjPFJ7fMJ4Rr5XGO7v1ohrd6zQdgg1NnoYaozEOwhYCbCviMqifiUGOrkx1hF46P3BjZe7SoKcG9VM8C+xCdgPvieLo3AQjj0TxccY+l7D/ADUx2C9KMhzjcDLOjrFEwkb/3M148o+FnElWOUEfXnLcb7etHC0JZvBiCrxVcyMclUzyJfDNQ3ZJQHjJtotU+mEj2d0923g2ZmioRDb/H+z26ECno7h/9e61G2SShp/6AIf6/5oKZXqJ+YPWs3apVYSJal5IVxGx89ky\" NoCertificado=\"00001000000304987449\" FormaPago=\"03\" Sello=\"Tt9q2Q7tV9yqCWKFSBcIFCHEO2am7qlrMnUeKWsTvJz9ia0WIJniBxuY1rQ6wmm7YKbPJJ36r/uU1lAd4YdqlQWDd6MebMJ5cJbvhObz3dWn97rSXWth6G3Pn+Tw0XojDwtJ56hTEfbjuw3z4Y4w+YRrSfO03dQWPVsi3Xr+vwA=\" Fecha=\"2017-09-05T15:00:25\" Folio=\"246\" Serie=\"V\" Version=\"3.3\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3  http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd \"><cfdi:Emisor RegimenFiscal=\"601\" Nombre=\"VICGAR INMOBILIARIA SA DE CV \" Rfc=\"VIN9609122G2\" /><cfdi:Receptor UsoCFDI=\"G03\" Nombre=\"PHI AUTOMATION SA DE CV \" Rfc=\"PAU071004FL7\" /><cfdi:Conceptos><cfdi:Concepto Importe=\"110000.000000\" ValorUnitario=\"27500.000000\" Descripcion=\"Renta de 4 Camionetas.&#xA;Correspondiente al mes de Febrero 2017\" Unidad=\"Servicio\" ClaveUnidad=\"C62\" Cantidad=\"4.000000\" NoIdentificacion=\"03\" ClaveProdServ=\"78111808\"><cfdi:Impuestos><cfdi:Traslados><cfdi:Traslado Importe=\"17600.00\" TasaOCuota=\"0.160000\" TipoFactor=\"Tasa\" Impuesto=\"002\" Base=\"110000.000000\" /></cfdi:Traslados></cfdi:Impuestos></cfdi:Concepto></cfdi:Conceptos><cfdi:Impuestos TotalImpuestosTrasladados=\"17600.00\"><cfdi:Traslados><cfdi:Traslado Importe=\"17600.00\" TasaOCuota=\"0.160000\" TipoFactor=\"Tasa\" Impuesto=\"002\" /></cfdi:Traslados></cfdi:Impuestos><cfdi:Complemento><tfd:TimbreFiscalDigital xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/cfd/TimbreFiscalDigital/TimbreFiscalDigitalv11.xsd\" Version=\"1.1\" UUID=\"A103B06D-44D5-446A-834F-45892B2C88D0\" FechaTimbrado=\"2017-09-05T15:00:23\" RfcProvCertif=\"SED1102088J7\" SelloCFD=\"Tt9q2Q7tV9yqCWKFSBcIFCHEO2am7qlrMnUeKWsTvJz9ia0WIJniBxuY1rQ6wmm7YKbPJJ36r/uU1lAd4YdqlQWDd6MebMJ5cJbvhObz3dWn97rSXWth6G3Pn+Tw0XojDwtJ56hTEfbjuw3z4Y4w+YRrSfO03dQWPVsi3Xr+vwA=\" NoCertificadoSAT=\"00001000000402846635\" SelloSAT=\"Zw6x/cxghBqSA+DLN/u5lObgDJ5e7ehUGAoFNowvyteYwD677XfafFkWBDStOMrku8JubVqg54MF301WRzXM9nqUHBUUKI/m2u1Dm+QNi3yqnjkYVDB025FmgaRiziCeU5o23adkLu+bnjjIN84DZUVzyEsL1tLz4xWGeJ+Nh5A9N5RcJwbuX+z3JPfdynHcORFtkcT1AbptMwSozgWoP2Y2itfUtmVbjqx3B0dqqLBVjkk2Gb1osqyDh0E9ErxU8d7iJClfMuruHr0XwnfaEtqtkByv8eamyU4uhIPC0XtXfTS1jsWMfvYM2KU5/B4eyHCxlbDfGcYuReEodSPcXg==\" /></cfdi:Complemento></cfdi:Comprobante>";
        byte[] timbradoCFDI = selladoString.getBytes();

        System.out.println("************************ TIMBRADO *************************");
        System.out.println(new String(timbradoCFDI));


        CFDI parsed = new CFDI(new ByteArrayInputStream(timbradoCFDI));

        System.out.println("************************ PARSED TIMBRADO *************************");
        System.out.println(new String(parsed.getBytesXML()));

        TimbreFiscalDigital tim= parsed.getTimbrado();

        TFD tfc = new TFD(tim);
        System.out.println(tfc.getCadenaOriginal());

        System.out.println("************************ FIN *************************");
    }

    @Test
    public void testCancelacion() throws Exception{
        InputStream privateInput = getClass().getResourceAsStream("/csd/private.key");
        InputStream publicInput = getClass().getResourceAsStream("/csd/public.cer");

        PublicKeyLoader publicKeyLoader = new PublicKeyLoader(publicInput);
        PrivateKeyLoader privateKeyLoader = new PrivateKeyLoader(privateInput, "Zalli902");

        cancelacionCFDI.cancelaCFDI("913B71DB-E1C1-4B2D-AE3F-1C9231EADCAF", "LOJI820529325", publicKeyLoader.key, privateKeyLoader.key);
    }

}
