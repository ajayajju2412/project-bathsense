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

import com.adobe.aem.guides.bathsense.core.models.UserListModel;
import com.adobe.aem.guides.bathsense.core.services.UserListService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */

@Component(service=Servlet.class,
           property={
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.paths="+ "/bin/bathsense/userlist",
                   "sling.servlet.extensions=" + "txt"
           })
@ServiceDescription("User List Servlet")
public class UserListServlet extends SlingSafeMethodsServlet {

    @Reference
    UserListService userListService;

    private static final long serialVersionUID = 1L;
    protected static final Logger LOG = LoggerFactory.getLogger(UserListServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp){

        try {
            LOG.debug("Entry in Servlet");

            String pageNumber = req.getParameter("page");
            String response = userListService.getAPIDetails(pageNumber);
            resp.setContentType("text/plain");

            //Adapting request or resource to a sling model
            //UserListModel model = req.adaptTo(UserListModel.class);

            resp.getWriter().write(response);


        } catch (IOException ioException) {
            LOG.error("IO Exception in UserList Servlet",ioException);
        } catch (Exception exc){
            LOG.error("Exception in exception",exc);
        }
    }
}
