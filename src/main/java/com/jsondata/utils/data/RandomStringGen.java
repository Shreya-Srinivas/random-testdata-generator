package com.jsondata.utils.data;

import org.json.simple.JSONObject;

import java.util.Random;

/**
 * Created by Shreya Srinivas.
 */
public class RandomStringGen {

    final static String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final static Random rand = new Random();

    public void randomIdentifier(Object keys, JSONObject newObj, String[] arr){
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(arr[1]);
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(n)+n;
            for(int i = 0; i < length; i++) {
                builder.append(AB.charAt(rand.nextInt(AB.length())));
            }
        }
        newObj.put(keys, builder.toString());
    }
}
