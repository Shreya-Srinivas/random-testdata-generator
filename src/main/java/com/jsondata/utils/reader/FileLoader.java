package com.jsondata.utils.reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Shreya Srinivas.
 */
public class FileLoader {

    @SuppressWarnings("unchecked")
    public JSONObject load(String file) throws IOException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {

            Object obj = parser.parse(new FileReader(file));
            jsonObject = (JSONObject) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
