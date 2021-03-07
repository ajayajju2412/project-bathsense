package com.adobe.aem.guides.bathsense.core.models;

import com.adobe.aem.guides.bathsense.core.services.MultiService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Filter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiServiceModel {

    //filet for specific service impl among multiple impls of a service
    @OSGiService(filter = "(component.name = ServiceA)")
    MultiService multiService;

    public String getNameFromService(){
        return multiService.getName();
    }
}
