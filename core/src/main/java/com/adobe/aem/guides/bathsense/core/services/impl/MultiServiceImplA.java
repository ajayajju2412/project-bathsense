package com.adobe.aem.guides.bathsense.core.services.impl;

import com.adobe.aem.guides.bathsense.core.services.MultiService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

@Component(service = MultiService.class, immediate = true,name = "ServiceA")
@ServiceRanking(1000)
public class MultiServiceImplA implements MultiService {
    @Override
    public String getName() {
        return "Multi Service impl A";
    }
}
