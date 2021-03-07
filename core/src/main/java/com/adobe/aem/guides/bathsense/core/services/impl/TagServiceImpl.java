package com.adobe.aem.guides.bathsense.core.services.impl;

import com.adobe.aem.guides.bathsense.core.daos.Event;
import com.adobe.aem.guides.bathsense.core.services.EventService;
import com.adobe.aem.guides.bathsense.core.services.TagService;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Component(service = TagService.class, immediate = true)
public class TagServiceImpl implements TagService {

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    protected static final Logger LOG = LoggerFactory.getLogger(TagServiceImpl.class);
    Locale locale = Locale.GERMANY;

    @Override
    public String getTitle(String resourcePath){
        LOG.info("Inside getTitle method");

        try {
            //General way
            /*Map<String,Object> param = new HashMap<>();
            param.put(ResourceResolverFactory.SUBSERVICE,"eventService");
            ResourceResolver resourceResolver = null;
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
            Resource resource = resourceResolver.getResource(resourcePath);
            //adapt resource to Tag
            Tag myTag = resource.adaptTo(Tag.class);*/

            //Using TagManager
            Map<String,Object> param = new HashMap<>();
            param.put(ResourceResolverFactory.SUBSERVICE,"eventService");
            ResourceResolver resourceResolver = null;
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
            //adapt resourceResolver to TagManager
            TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
            Tag myTag = tagManager.resolve(resourcePath);

            /*String title = myTag.getLocalizedTitle(locale);
            return title;*/

            String localTagID = myTag.getLocalTagID();
            return localTagID;

        } catch (LoginException e) {
            LOG.error("Error fetching Tag title");
        }
        return "No Tag Title";
    }

    @Override
    public List<String> getAllTitles() {
            List<String> list = new ArrayList<>();
        try {
            Map<String,Object> param = new HashMap<>();
            param.put(ResourceResolverFactory.SUBSERVICE,"eventService");
            ResourceResolver resourceResolver = null;
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
            //adapt resourceResolver to TagManager
            TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
            Tag myTag = tagManager.resolve("bathsense:event-page");

            Iterator<Tag> tagList = myTag.listAllSubTags();
            while(tagList.hasNext()){
                Tag childTag = tagList.next();
                String title = childTag.getTitle();
                list.add(title);
            }
        } catch (LoginException e) {
            LOG.error("Error fetching All Tag titles");
        }

        Collections.sort(list);

        return list;
    }
}
