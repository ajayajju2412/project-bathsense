package com.adobe.aem.guides.bathsense.core.models;

import com.adobe.aem.guides.bathsense.core.services.UserListService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


//My Userlist Back-end controller
//adaptables -> Resource/SlingHttpServlet Request class
//adapters -> interface(optional)
@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserListModel {

    @Inject
    @Via("resource")
    @Named("userid")
    int userID;

    String firstName;

    String lastName;

    String email;

    String avatar;

    @OSGiService
    UserListService userListService;

    //protected static final Logger LOG = LoggerFactory.getLogger(UserListModel.class);

    @PostConstruct
    public void init(){
        String response = userListService.getUserDetails(userID);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(response);

        JsonArray arr = jsonObject.getAsJsonArray("data");
        email = arr.get(0).getAsJsonObject().get("email").getAsString();
        firstName = arr.get(0).getAsJsonObject().get("first_name").getAsString();
        lastName = arr.get(0).getAsJsonObject().get("last_name").getAsString();
        avatar = arr.get(0).getAsJsonObject().get("avatar").getAsString();

    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

}
