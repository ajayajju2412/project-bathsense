"use strict";

use(function () {
    if(resource.getChild("userListItems")!=null){
         const userListItems = resource.getChild("userListItems").listChildren();
            return {
                userListItems: userListItems
            };
    }

});