package com.jsondata.utils.reader;

import com.jsondata.utils.data.RandomDateGen;
import com.jsondata.utils.data.RandomIntGen;
import com.jsondata.utils.data.RandomListGen;
import com.jsondata.utils.data.RandomStringGen;
import com.jsondata.utils.formatter.PrintOutput;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;


/**
 * Created by Shreya Srinivas.
 */
public class FileTemplate {

    public void fileLoad(Configuration data, JSONObject obj, JSONArray arr) throws IOException {

        Iterator<String> keys = obj.keySet().iterator();
        JSONObject newObj = new JSONObject();
        while(keys.hasNext()){

            Object key1 = keys.next();
            String value = obj.get(key1).toString();
            String[] str = value.split(",");
            switch (str[0]){
                case "String": RandomStringGen ran = new RandomStringGen();
                                ran.randomIdentifier(key1, newObj, str);
                                break;
                case "Integer": RandomIntGen ran1 = new RandomIntGen();
                                ran1.randomIdentifier(key1, newObj, str);
                                break;
                case "List" :   RandomListGen ran2 = new RandomListGen();
                                ran2.randomIdentifier(key1, newObj, str);
                                break;
                case "Date" :   RandomDateGen ran3 = new RandomDateGen();
                                ran3.randomIdentifier(key1, newObj, str);
                                break;
                case "Increment": break;
                case "Contact": newObj.put(key1, (long) Math.floor(Math.random() * 9000000000L) + 1000000000L);
                                break;
                case "Uid": String uid = UUID.randomUUID().toString();
                            newObj.put(key1, uid);
                            break;
                default: throw new IllegalArgumentException("Invalid type of data"+str[0]+"\n");
            }

        }
        arr.put(newObj);
        PrintOutput output = new PrintOutput();
        output.output(data,arr);
    }
}
