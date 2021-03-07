package com.adobe.aem.guides.bathsense.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;

//Using this as Sling model Exporter
//http://localhost:4502/content/wknd/language-masters/en/fifth-Page/_jcr_content/root/responsivegrid/slingmodelexample.model.json
@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = "bathsense/components/content/slingModelExample")
@Exporter(name = "jackson",extensions = "json")
public class SlingModelExample {

    @Inject
    @Named("heading")
    String heading;

    @Inject
    @Named("subHeading")
    String subHeading;

    @Inject
    @Named("buttonText")
    String buttonText;

    @Inject
    @Named("heading2")
    String heading2;

    @Inject
    @Named("subHeading2")
    String subHeading2;

    @Inject
    @Named("buttonText2")
    String buttonText2;

    public String getHeading() {
        return heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getHeading2() {
        return heading2;
    }

    public String getSubHeading2() {
        return subHeading2;
    }

    public String getButtonText2() {
        return buttonText2;
    }
}
