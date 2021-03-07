package com.adobe.aem.guides.bathsense.core.services;

import com.adobe.aem.guides.bathsense.core.daos.Event;

import java.util.List;

public interface TagService {

    public String getTitle(String resourcePath);
    public List<String> getAllTitles();
}
