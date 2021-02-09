"use strict";

use(function () {
    if(resource.getChild("faqsItems")!=null){
         const faqsItems = resource.getChild("faqsItems").listChildren();
            return {
                faqsItems: faqsItems
            };
    }

});