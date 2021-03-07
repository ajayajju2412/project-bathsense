package com.adobe.aem.guides.bathsense.core.services.impl;

import com.adobe.aem.guides.bathsense.core.services.HttpService;
import com.adobe.aem.guides.bathsense.core.services.configurations.HttpConfiguration;
import com.adobe.aem.guides.bathsense.core.utils.Network;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* This is an OSGI component which reads values from OSGI configuration - HttpConfiguration
*
* */
@Component(service = HttpService.class, immediate = true)
@Designate(ocd = HttpConfiguration.class)
public class HttpServiceImpl implements HttpService {

    private static final Logger log = LoggerFactory.getLogger(HttpServiceImpl.class);

    private HttpConfiguration configuration;

    @Activate
    protected void activate(HttpConfiguration configuration) {
        this.configuration = configuration;
    }


    @Override
    public String makeHttpCall() {

        log.info("----------< Reading the config values >----------");

        try {

            /**
             * Reading values from the configuration
             */
            boolean enable = configuration.enableConfig();
            String protocol = configuration.getProtocol();
            String server = configuration.getServer();
            String endpoint = configuration.getEndpoint();


            String url = protocol + "://" + server + "/" + endpoint;


            if (enable) {
                /**
                 * Making the actual HTTP call
                 */
                String response = Network.readJson(url);

                log.info("----------< JSON response from the webservice is >----------");
                log.info(response);

                return response;

            } else {

                log.info("----------< Configuration is not enabled >----------");

                return "Configuration not enabled";
            }

        } catch (Exception e) {

            log.error(e.getMessage(), e);

            return "Error occurred" + e.getMessage();
        }
    }

}
