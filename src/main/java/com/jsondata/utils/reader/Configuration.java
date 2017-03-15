package com.jsondata.utils.reader;

import org.json.simple.JSONObject;

/**
 * Created by Shreya Srinivas.
 */
public class Configuration {

    private static int noThreads;
    private static int noRecords;
    private static String outFormat;
    private static String outLocation;
    private static Configuration conObj ;

    private Configuration(JSONObject obj){

        this.noThreads = (int)(long) obj.get("NumberOfThreads");
        this.noRecords = (int)(long) obj.get("NumberOfRecords");
        this.outFormat = obj.get("OutputFormat").toString();
        this.outLocation = obj.get("OutputLocation").toString();
    }

    public static Configuration getInstance(JSONObject obj){

        if(conObj == null)
            conObj = new Configuration(obj);
        return conObj;
    }

    public Integer getNoThreads() {
        return noThreads;
    }

    public Integer getNoRecords() {
        return noRecords;
    }

    public String getOutFormat() {
        return outFormat;
    }

    public String getOutLocation() {
        return outLocation;
    }
}
