package com.adobe.aem.guides.bathsense.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserListModel {

    // Inject the products node under the current node
    @Inject
    @Optional
    public Resource userListItems;

    // No need of a post construct as we don't have anything to modify after the
    // model is constructed
}
