package com.adobe.aem.guides.bathsense.core.models;

import com.adobe.aem.guides.bathsense.core.daos.Event;
import com.adobe.aem.guides.bathsense.core.services.EventService;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;


@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EventModel {

    //part2
    List<Event> eventItems;

    @OSGiService
    EventService eventService;

    protected static final Logger LOG = LoggerFactory.getLogger(EventModel.class);

    @PostConstruct
    public void init(){
        LOG.info("Inside init method");

        //part2
        eventItems = eventService.getData();
    }

    public List<Event> getEventItems() {
        return eventItems;
    }


}
