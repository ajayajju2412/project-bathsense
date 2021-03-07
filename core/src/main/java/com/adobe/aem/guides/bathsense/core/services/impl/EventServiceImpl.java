package com.adobe.aem.guides.bathsense.core.services.impl;

import com.adobe.aem.guides.bathsense.core.daos.Event;
import com.adobe.aem.guides.bathsense.core.services.EventService;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@Component(service = EventService.class, immediate = true)
public class EventServiceImpl implements EventService {

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    protected static final Logger LOG = LoggerFactory.getLogger(EventServiceImpl.class);


    @Override
    public List<Event> getData(){

        List<Event> list = new ArrayList<>();

    try {
        Map<String,Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE,"eventService");
        ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);

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

            LOG.info("Fetched Data of All children");

            Comparator<Event> compareByText = new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return o1.getText().compareTo(o2.getText());
                }
            };
            Collections.sort(list,compareByText);

        }

    } catch (Exception e) {
        LOG.error("Exception in fetching Title",e);
    }
        return list;
    }



}
