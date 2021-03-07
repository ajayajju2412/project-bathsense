/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.bathsense.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service=Servlet.class,
           property={
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.resourceTypes="+ "bathsense/components/structure/page",
                   "sling.servlet.selectors=" + "demo",
                   "sling.servlet.extensions=" + "txt"
           })

@ServiceDescription("My Demo Servlet")
public class MyDemoServlet extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MyDemoServlet.class);

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();//resource is a page we're getting here

        resp.setContentType("text/plain");
        resp.getWriter().write("My Social Media Partner = " + resource.getValueMap().get("socialMedia",""));
        /*Go to
        * http://localhost:4502/content/wknd/us/en/jcr:content.demo.txt*/

    }

    //Not working
    @Override
    protected void doPost(SlingHttpServletRequest request,
                          SlingHttpServletResponse response) throws ServletException, IOException {
        //To use this,change sling servlet methods to METHODS_POST

        response.getWriter().write("Month Submitted");

        /* Give /content/wknd/us/en/jcr:content.demo.txt to form action and
        Go to Homepage and click on submit button
        It'll submit the form values to
         * http://localhost:4502/content/wknd/us/en/jcr:content.demo.txt*/
    }
}
