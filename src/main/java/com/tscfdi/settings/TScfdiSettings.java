package com.tscfdi.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by lugty on 23/08/16.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class TScfdiSettings {

    //@Autowired
    //private Environment env;

    private static final String SERVICE_ENDPOINT = "tscfdi.service_endpoint";

    private static final String TIMBRADO_USER_TEST = "tscfdi.timbradoTestUser";
    private static final String TIMBRADO_PASS_TEST = "tscfdi.timbradoTestPass";

    public String getServiceEndpoint(){
        Properties env =  getProperties();
        return env.getProperty(SERVICE_ENDPOINT);
    }

    public String getUserNameTimbradoTest(){
        Properties env =  getProperties();
        return env.getProperty(TIMBRADO_USER_TEST);
    }

    public String getPasswordTimbradoTest(){
        Properties env =  getProperties();
        return env.getProperty(TIMBRADO_PASS_TEST);
    }

    private Properties getProperties(){
        try {
            Properties p =  new Properties();
            InputStream stream = getClass().getResourceAsStream("/application.properties");
            p.load(stream);
            return p;
        }catch (Exception e){
            return null;
        }
    }
}
