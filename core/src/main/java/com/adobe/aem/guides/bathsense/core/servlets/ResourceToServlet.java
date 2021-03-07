package com.adobe.aem.guides.bathsense.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class,
            property={"sling.servlet.methods="+ HttpConstants.METHOD_GET,
                    "sling.servlet.paths="+"/bin/bathsense/resource"})
@ServiceDescription("Resource Accessing Servlet")
public class ResourceToServlet extends SlingSafeMethodsServlet{

    private static final long serialVersionUID = 1L;
    protected static final Logger LOG = LoggerFactory.getLogger(ResourceToServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp){

        try {
            ResourceResolver resolver = req.getResourceResolver();
            Resource resource = resolver.getResource("/apps/bathsense/components/content/helloworld");
            Node node = resource.adaptTo(Node.class);
            String response = "Node property is: "+node.getProperty("jcr:title").getString();
            resp.getWriter().write(response);
            LOG.info("Response successful");
        } catch (Exception exc){
            LOG.error("Exception in accessing Resource",exc);
        }
    }


}
