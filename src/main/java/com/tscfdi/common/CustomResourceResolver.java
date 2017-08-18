package com.tscfdi.common;

import com.sun.org.apache.xerces.internal.dom.DOMInputImpl;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

import java.io.InputStream;

/**
 * Created by lugty on 12/12/16.
 */
public class CustomResourceResolver implements LSResourceResolver {
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
        InputStream resourceAsStream = getClass().getResourceAsStream(systemId);

        LSInput input = new DOMInputImpl();
        input.setByteStream(resourceAsStream);
        return input;
    }
}