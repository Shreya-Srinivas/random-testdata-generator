package com.jsondata.utils.formatter;

import com.jsondata.utils.reader.Configuration;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Shreya Srinivas.
 */
public class PrintFormatter {

    public void header(Configuration data, JSONArray arr) throws IOException {
        FileWriter file = new FileWriter(data.getOutLocation()+"."+data.getOutFormat());
        try {
            for (int i=0 ; i<arr.length(); i++) {
                file.write(arr.get(i).toString()+"\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        file.close();
    }


}
