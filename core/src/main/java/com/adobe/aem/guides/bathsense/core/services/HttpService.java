package com.adobe.aem.guides.bathsense.core.services;

/*
* This interface exposes the functionality of calling a JSON Web Service
*
* */
public interface HttpService {
    //This method reads values from config and makes a HTTP call to url formed from the values
    public String makeHttpCall();
}
