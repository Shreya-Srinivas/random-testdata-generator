package com.jsondata.utils.driver;

import com.jsondata.utils.reader.Configuration;
import com.jsondata.utils.reader.FileLoader;
import com.jsondata.utils.reader.FileTemplate;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Shreya Srinivas.
 */
public class DriverMain {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        String config = sc.nextLine();
        JSONObject fileObject = new JSONObject();
        JSONObject confObject = new JSONObject();

        FileLoader fileLoad = new FileLoader();
        try {
            fileObject = fileLoad.load(file);
            confObject = fileLoad.load(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration data = Configuration.getInstance(confObject);

        JSONArray objArr = new JSONArray();
        for(int i=0; i<data.getNoRecords(); i++){
            FileTemplate temp = new FileTemplate();
            temp.fileLoad(data,fileObject, objArr);
        }

    }
}
