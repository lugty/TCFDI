package com.tsccfdi.properties;

import com.tscfdi.settings.TScfdiSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lugty on 23/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_test/app-context.xml")
public class ApplicationPropertiesTest {
    //@Autowired
    //private TScfdiSettings properties;

    @Test
    public void testApplicationProperties(){
        // Using application properties through properties wrappers
        //System.out.println(properties.toString());
        TScfdiSettings properties = new TScfdiSettings();
        System.out.println(properties.getServiceEndpoint());
    }
}
