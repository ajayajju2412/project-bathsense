package com.adobe.aem.guides.bathsense.core.servlets;

import com.adobe.aem.guides.bathsense.core.services.HttpService;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Servlet;

@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/demo/httpcall"
        })
@ServiceDescription("HTTP Servlet")
public class HttpServlet extends SlingSafeMethodsServlet {


    private static final long serialVersionUID = -2014397651676211439L;


    private static final Logger log = LoggerFactory.getLogger(HttpServlet.class);

    @Reference
    private HttpService httpService;


    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        try {

            String jsonResponse = httpService.makeHttpCall();

            response.getWriter().println(jsonResponse);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
        }
    }

}
