package com.tscfdi.common;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by lugty on 26/08/16.
 */
public class URIResolverImpl implements URIResolver {
    public Source resolve(String href, String base) throws TransformerException {
        return new StreamSource(getClass().getResourceAsStream(href));
    }
}