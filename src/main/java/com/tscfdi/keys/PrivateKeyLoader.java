package com.tscfdi.keys;

import com.google.common.io.ByteStreams;
import org.apache.commons.ssl.PKCS8Key;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Created by lugty on 22/08/16.
 */
public class PrivateKeyLoader {
    public PrivateKey key;

    public PrivateKeyLoader(InputStream privateKeyInputStream, String keyPassword) {
        this.setPrivateKey(privateKeyInputStream, keyPassword);
    }

    public void setPrivateKey(InputStream privateKeyInputStream, String password){
        byte[] privateKeyByte = this.extractProtectedPrivateKey(privateKeyInputStream, password);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyByte);

        try{
            key = KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec);
        }catch(GeneralSecurityException e){
            throw new KeyException(
                    "Error al obtener la información del certificado debido a su codificación",
                    e.getCause());
        }
    }

    private byte[] extractProtectedPrivateKey(InputStream privateKeyInputStream, String keyPassword){
        byte[] bytes;
        try{
            if(keyPassword == null)
                bytes = ByteStreams.toByteArray(privateKeyInputStream);
            else
                bytes = new PKCS8Key(privateKeyInputStream, keyPassword.toCharArray()).getDecryptedBytes();
        }catch (GeneralSecurityException e){
            throw new KeyException("La contraseña del certificado no es correcta", e.getCause());
        }catch (IOException ioe){
            throw new KeyException(ioe.getMessage(), ioe.getCause());
        }
        return bytes;
    }

    public PrivateKey getKey() {
        return key;
    }

    public void setKey(PrivateKey key) {
        this.key = key;
    }
}
