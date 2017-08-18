package com.tscfdi.common;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lugty on 12/12/16.
 */
public class DateOnlyAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
