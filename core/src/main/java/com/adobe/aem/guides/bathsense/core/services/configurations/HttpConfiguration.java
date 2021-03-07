package com.adobe.aem.guides.bathsense.core.services.configurations;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

/*
*This interface represents an OSGi configuration which can be found at ./system/console/configMgr
*
* */
@ObjectClassDefinition(
        name = "My Http Configuration",
        description = "This configuration reads the values to make an HTTP call to a JSON webservice")
public @interface HttpConfiguration {

    /*
    *A checkbox
    *
    * */
    @AttributeDefinition(
            name = "Enable Config",
            description = "This property indicates whether the configuration values will taken into account or not",
            type = AttributeType.BOOLEAN
    )
    public boolean enableConfig();

    /*
    *A dropdown
    *
    * */
    @AttributeDefinition(
            name = "Protocol",
            description = "Choose Protocol",
            options = {
                    @Option(value = "http",label = "HTTP"),
                    @Option(value = "https",label = "HTTPS")
            }
    )
    public String getProtocol();


    /*
    *A text field
    *
    * */
    @AttributeDefinition(
            name = "Server",
            description = "Enter the server name"
    )
    public String getServer();

    /*
    *A text field
    *
    * */
    @AttributeDefinition(
            name = "Endpoint",
            description = "Enter the endpoint"
    )
    public String getEndpoint();
}
