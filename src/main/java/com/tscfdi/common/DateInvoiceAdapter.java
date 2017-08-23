package com.tscfdi.common;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lugty on 2/1/17.
 */
public class DateInvoiceAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public Date unmarshal(String v) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.parse(v);
        }
    }

    public String marshal(Date v) throws Exception {
        if(v == null)
            return null;
        return dateFormat.format(v);
    }
}
