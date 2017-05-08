package com.jsondata.utils.driver;

import com.jsondata.utils.reader.Configuration;
import com.jsondata.utils.reader.FileTemplate;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by home on 4/28/2017.
 */
public class ThreadTest extends Thread {

    private Thread t;
    private String threadName;
    private Configuration data;
    private JSONObject fileObject;

    ThreadTest(String name, Configuration data1, JSONObject fileObject1) {
        threadName = name;
        data = data1;
        fileObject = fileObject1;
    }

    public void run() {
        try {
            JSONArray objArr = new JSONArray();
            for(int i=0; i<data.getNoRecords(); i++){
                FileTemplate temp = new FileTemplate();
                temp.fileLoad(data,fileObject, objArr);
            }
                Thread.sleep(50);
            } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
