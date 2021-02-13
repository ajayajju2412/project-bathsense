package com.adobe.aem.guides.bathsense.core.utils;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * The type Http utils.
 */
public final class HTTPUtils {

    /**
     * The Log.
     */
    protected static final Logger log = LoggerFactory.getLogger(HTTPUtils.class);

    private HTTPUtils() {
    }

    /**
     * Execute request string.
     *
     * @param endPoint
     *            the end point
     * @return the string
     */
    public static String executeRequest(String endPoint) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet getRequest = new HttpGet(endPoint);
            getRequest.addHeader(BathSenseConstants.ACCEPT, BathSenseConstants.APPLICATION_JSON);

            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() == BathSenseConstants.STATUS_OK) {

                BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String outPutJSON = "";
                String output;
                while ((output = br.readLine()) != null) {
                    outPutJSON = outPutJSON + output;
                }

                return outPutJSON;
            }
        } catch (Exception exception) {
            log.error("Exception in execute get : ", exception);
        }
        return null;
    }

    /**
     * Execute request string.
     *
     * @param endPoint
     *            the end point
     * @return the string
     */
    public static String executeRequest(String endPoint, String payLoad, Map<String, String> header) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            StringEntity entity = new StringEntity(payLoad, ContentType.APPLICATION_FORM_URLENCODED);
            HttpPost postRequest = new HttpPost(endPoint);
            postRequest.addHeader(BathSenseConstants.ACCEPT, BathSenseConstants.APPLICATION_JSON);
            postRequest.addHeader(BathSenseConstants.CONTENT_TYPE, BathSenseConstants.APPLICATION_JSON);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                postRequest.addHeader(entry.getKey(), entry.getValue());
            }
            postRequest.setEntity(entity);
            log.error("Request entity finaly is "+postRequest.getEntity().toString()+" "+payLoad);
            HttpResponse response = httpClient.execute(postRequest);
            String resonseBody = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
            return resonseBody;
        } catch (Exception exception) {
            log.error("Exception in execute get : ", exception);
        }
        return null;

    }
}

