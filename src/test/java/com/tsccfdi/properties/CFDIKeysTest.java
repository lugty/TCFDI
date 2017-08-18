package com.tsccfdi.properties;

import com.tscfdi.cfdi.*;
import com.tscfdi.clientWS.TimbradoCFDIStub;
import com.tscfdi.comprobante.TimbreFiscalDigital;
import com.tscfdi.comprobante.DataComprobante;
import com.tscfdi.keys.PrivateKeyLoader;
import com.tscfdi.keys.PublicKeyLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
        ValidadorCFDI validadorCFDI = new ValidadorCFDI(comprobante);
        validadorCFDI.validar();

        /***************************** prueba timbrado ********************************/
        //byte[] timbradoCFDI = this.timbradoCFDI.timbrarCFDI(cfdi);

        String selladoString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><cfdi:Comprobante xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" NumCtaPago=\"0000\" LugarExpedicion=\"Queretaro\" metodoDePago=\"Efectivo\" tipoDeComprobante=\"ingreso\" total=\"1.1\" Moneda=\"MXN\" motivoDescuento=\"Prueba descuento\" descuento=\"1.1\" subTotal=\"1.1\" condicionesDePago=\"pago en una sola exivision\" certificado=\"MIIEWTCCA0GgAwIBAgIUMDAwMDEwMDAwMDAzMDY2NjAyNjIwDQYJKoZIhvcNAQEFBQAwggGKMTgwNgYDVQQDDC9BLkMuIGRlbCBTZXJ2aWNpbyBkZSBBZG1pbmlzdHJhY2nDs24gVHJpYnV0YXJpYTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgbGEgSW5mb3JtYWNpw7NuMR8wHQYJKoZIhvcNAQkBFhBhY29kc0BzYXQuZ29iLm14MSYwJAYDVQQJDB1Bdi4gSGlkYWxnbyA3NywgQ29sLiBHdWVycmVybzEOMAwGA1UEEQwFMDYzMDAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBEaXN0cml0byBGZWRlcmFsMRQwEgYDVQQHDAtDdWF1aHTDqW1vYzEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTUwMwYJKoZIhvcNAQkCDCZSZXNwb25zYWJsZTogQ2xhdWRpYSBDb3ZhcnJ1YmlhcyBPY2hvYTAeFw0xNTA0MDYxNjI0MTBaFw0xOTA0MDYxNjI0MTBaMIGlMRwwGgYDVQQDExNJVFpFTCBMT1BFWiBKSU1FTkVaMRwwGgYDVQQpExNJVFpFTCBMT1BFWiBKSU1FTkVaMRwwGgYDVQQKExNJVFpFTCBMT1BFWiBKSU1FTkVaMRYwFAYDVQQtEw1MT0pJODIwNTI5MzI1MRswGQYDVQQFExJMT0pJODIwNTI5TURGUE1UMDQxFDASBgNVBAsTC0lUWkVMIExPUEVaMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCr7rmsIxecjfVpwI6VLhBASims+YLzPKPK2m/Ote8iokxrOSC3dkk5hZWzdeBJgLn9McNac8hyHsl1S9UTNQ7LhQQtc9PdCU40XDDV/RpGOLKDTag4eMM0a5fqjXjd9xKYkV7+nh+1P3ZTLgQtYI9KC1VDat+rcWIEHd9BlEtYQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQUFAAOCAQEAanJ9YRHIq3/Hgvq0ZNPKhhCmF9gJm/GR5sLakhzdXfDj6P/vcrwMP7Bs4eEp6dXOYkLYLqORVPwx2iWzHSdxHFSge0qIJh5Rhuip3TEEf2G35Mwi5qG+4Jh5NhDJRo0jDdmlSdV7R0fuTBN2qywjO5x7dfIW4Z7Y7vqHpoMeo92KarRvr4luUqeH1yNWoOAHo9m2e71iOo9xdoZ3yt/kle+L/jKnf395SR8HLb1oxr9nuImDjqF/TmtU9XsNA8b1uI028mEGRPS2+LUE6a+CubnuV/9TYoA7pI7+UPo3uZMMhvFmxYR9axfkMzZLnj5gEpL4ENWHTGmXFNYk4XtE5w==\" noCertificado=\"00001000000306660262\" formaDePago=\"efectivo\" sello=\"Qd1pCsG0fgpH+L3iVIq3OnuPMXbuUch7wDGMCBbYzHL2VQ/+4TPszN55ffxPA/3jTxPSr9DIlgX745vn+PHOzXRWRRATwKrS++5LZht/5zaIQcL6qQ0NWuBesXInm9U1y6v60CmJM0wQzhscMAVzk4gLdUdEPG8s7HWgLZS92Bs=\" fecha=\"2016-08-30T20:59:31.398-05:00\" folio=\"1\" serie=\"A\" version=\"3.2\" xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3  http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd\"><cfdi:Emisor nombre=\"ITZEL LOPEZ JIMENEZ\" rfc=\"LOJI820529325\"><cfdi:RegimenFiscal Regimen=\"Empresarial\" /></cfdi:Emisor><cfdi:Receptor nombre=\"PHI IT\" rfc=\"PAU071004FL7\" /><cfdi:Conceptos><cfdi:Concepto importe=\"1\" valorUnitario=\"1\" descripcion=\"Producto de prueba\" noIdentificacion=\"001\" unidad=\"UNI\" cantidad=\"1\" /></cfdi:Conceptos><cfdi:Impuestos totalImpuestosTrasladados=\"0.1\" totalImpuestosRetenidos=\"0.1\"><cfdi:Retenciones><cfdi:Retencion importe=\"0.1\" impuesto=\"IVA\" /></cfdi:Retenciones><cfdi:Traslados><cfdi:Traslado importe=\"0.1\" tasa=\"1\" impuesto=\"IVA\" /></cfdi:Traslados></cfdi:Impuestos><cfdi:Complemento><tfd:TimbreFiscalDigital xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/TimbreFiscalDigital/TimbreFiscalDigital.xsd\" version=\"1.0\" UUID=\"913B71DB-E1C1-4B2D-AE3F-1C9231EADCAF\" FechaTimbrado=\"2016-08-30T20:59:47\" selloCFD=\"Qd1pCsG0fgpH+L3iVIq3OnuPMXbuUch7wDGMCBbYzHL2VQ/+4TPszN55ffxPA/3jTxPSr9DIlgX745vn+PHOzXRWRRATwKrS++5LZht/5zaIQcL6qQ0NWuBesXInm9U1y6v60CmJM0wQzhscMAVzk4gLdUdEPG8s7HWgLZS92Bs=\" noCertificadoSAT=\"00001000000402846635\" selloSAT=\"LnuQYVI1dvtkk4OtrbOef492DrUenGSt7dVEG1ni9q6V+NXzZyG+Sk/MMro4L7s4tqjzK/XZpdyAOSpkX8tAKMl/rYLpIS4OWFGDYMZqVVVWlV6FICm/Q1lDdwfZDx7Crip841XByaXDCr9Mz7IsziKJzgKYm5xy2nyRB6MCp29NwSSZkQKoap8Kc6pxiSP/XYwsyNRjEFHGRuxUDqQa3momIXjJ0GBdRWB/uMKY2YA5KZZensWG5PRHHN+fHEt8t+iXT9IOtFppTYdiYpyaUotZLx7gUyXJoMZ3AMIzeoWTnh455Hkcimw0Xxi2VWCUrd0XRPQ6v5Xdtl8BD/xXfQ==\" xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" /></cfdi:Complemento></cfdi:Comprobante>";
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
