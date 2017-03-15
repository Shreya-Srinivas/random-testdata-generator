package com.jsondata.utils.data;

import org.json.simple.JSONObject;

/**
 * Created by Shreya Srinivas.
 */
public class RandomIntGen extends RandomStringGen{
    public void randomIdentifier (Object keys, JSONObject newObj, String[] arr){

        int m = Integer.parseInt(arr[1]);
        int n = Integer.parseInt(arr[2]);
        newObj.put(keys, (int) (Math.random() * (m - n)) + n);

    }
}
