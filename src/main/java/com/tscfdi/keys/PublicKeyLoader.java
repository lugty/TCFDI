package com.tscfdi.keys;

import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by lugty on 22/08/16.
 */
public class PublicKeyLoader {
    public X509Certificate key;

    public PublicKeyLoader(InputStream crtInputStream) {
        this.setX509Certificate(crtInputStream);
    }

    public void setX509Certificate(InputStream crtInputStream) {
        try {
            this.key = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(crtInputStream);
        } catch (CertificateException e) {
            throw new KeyException("Error al obtener el certificado x.509. La codificación puede ser incorrecta.", e.getCause());
        }
    }

    public X509Certificate getKey() {
        return key;
    }

    public void setKey(X509Certificate key) {
        this.key = key;
    }
}
