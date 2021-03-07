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

import com.adobe.aem.guides.bathsense.core.daos.Event;
import com.adobe.aem.guides.bathsense.core.services.EventService;
import com.day.cq.wcm.api.Page;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;

@Component(service=Servlet.class,
           property={
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.resourceTypes="+ "bathsense/components/structure/page",
                   "sling.servlet.selectors=" + "events",
                   "sling.servlet.extensions=" + "txt"
           })

@ServiceDescription("My Event Servlet")
public class EventServlet extends SlingSafeMethodsServlet {

    @Reference
    EventService eventService;

    private static final Logger LOG = LoggerFactory.getLogger(EventServlet.class);

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        //final Resource resource = req.getResource();

        LOG.info("Inside doGet method");

        List<Event> list = new ArrayList<>();

        ResourceResolver resourceResolver = req.getResourceResolver();
        //String resourcePath = req.getRequestURI();
        Resource resource = resourceResolver.getResource("/content/wknd/us/en");
        Page myPage = resource.adaptTo(Page.class);

        Iterator<Page> eventChildren  = myPage.listChildren(null,true);
        while(eventChildren.hasNext()) {
            Page child = eventChildren.next();
            String path  = child.getPath();

            Resource resource1 = resourceResolver.getResource(path+"/jcr:content/root/text");
            ValueMap props1 = ResourceUtil.getValueMap(resource1);
            String text = props1.get("text","");
            Resource resource2 = resourceResolver.getResource(path+ "/jcr:content/root/text_1904068910");
            ValueMap props2 = ResourceUtil.getValueMap(resource2);
            String desc = props2.get("text","").substring(0,500);
            Resource resource3 = resourceResolver.getResource(path+"/jcr:content/root/image");
            ValueMap props3 = ResourceUtil.getValueMap(resource3);
            String img = props3.get("fileReference","");
            //Resource img = resourceResolver.getResource(imgPath);
            //Node imgNode = img.adaptTo(Node.class);
            //Asset asset  = img.adaptTo(Asset.class);
            //ValueMap props3i = img.get
            ///Resource imgRes = props3i.get

            Event event = new Event();
            event.setText(text);
            event.setDescription(desc);
            event.setImage(img);
            list.add(event);

            LOG.info("Fetched Data of List!!");

        }

        Comparator<Event> compareByText = new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getText().compareTo(o2.getText());
            }
        };

        Collections.sort(list,compareByText);
        LOG.info("List sorted!!");

        try {
            String json = new Gson().toJson(list);
            LOG.info("json for list created successfully!!");
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }catch (Exception e){
            LOG.error("Some exception in list json ");
        }

    }

}
