package com.jsondata.utils.data;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Shreya Srinivas.
 */
public class RandomListGen extends RandomStringGen {

    public void randomIdentifier(Object keys, JSONObject newObj, String[] arr){

        List<String> names = new ArrayList<>();
        for(int i=1; i<arr.length; i++) {
            names.add(arr[i]);
        }
        int index = new Random().nextInt(names.size());
        newObj.put(keys, names.get(index));
    }
}
