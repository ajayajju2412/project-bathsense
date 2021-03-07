package com.adobe.aem.guides.bathsense.core.models;

import com.adobe.aem.guides.bathsense.core.daos.Event;
import com.adobe.aem.guides.bathsense.core.services.EventService;
import com.adobe.aem.guides.bathsense.core.services.TagService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;


@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TagModel {

    @Inject
    private String tag;

    private String title;

    private List<String> titles;

    @OSGiService
    TagService tagService;

    protected static final Logger LOG = LoggerFactory.getLogger(TagModel.class);

    @PostConstruct
    public void init(){
        LOG.info("Inside init method of Tag Model");


        //General way
        /*String tagID = tag;
        String namespace = tagID.split(":")[0];
        LOG.info(namespace);
        String localID = tagID.split(":")[1];
        LOG.info(localID);
        String absolutePath = "/content/cq:tags/" + namespace + "/" + localID;
        title = tagService.getTitle(absolutePath);
        LOG.info(title);*/

        //Getting Title
        //Using TagManager
        String tagID = tag;
        title = tagService.getTitle(tagID);
        LOG.info(title);

        //Getting All Titles
        titles = tagService.getAllTitles();

    }

    public String getTag() {
        return tag;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTitles() {
        return titles;
    }
}
