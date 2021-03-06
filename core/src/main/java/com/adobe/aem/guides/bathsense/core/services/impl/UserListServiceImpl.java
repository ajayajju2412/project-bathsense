package com.adobe.aem.guides.bathsense.core.services.impl;

import com.adobe.aem.guides.bathsense.core.services.UserListService;
import com.adobe.aem.guides.bathsense.core.utils.HTTPUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//My service

@Component(service = UserListService.class,immediate = true)
public class UserListServiceImpl implements UserListService {

    protected static final Logger LOGGER = LoggerFactory.getLogger(UserListServiceImpl.class);

    @Override
    public String getUserDetails(int pageNumber) {
        LOGGER.debug("Entry in getUserDetails Method");
        //return HTTPUtils.executeRequest("https://reqres.in/api/users?page=1");
        return HTTPUtils.executeRequest("https://reqres.in/api/users?page="+ pageNumber);
    }

    public String getAPIDetails(String pageNumber){
        return HTTPUtils.executeRequest("https://reqres.in/api/users?page=".concat(pageNumber));
    }
}
