package com.jsondata.utils.formatter;

import com.jsondata.utils.reader.Configuration;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Shreya Srinivas.
 */
public class PrintFormatterCsv extends PrintFormatter {

    public void header(Configuration data, JSONArray arr) throws IOException {
        File file = new File(data.getOutLocation()+"."+data.getOutFormat());
        String csv = null;
        try {
            csv = CDL.toString(arr);
            FileUtils.writeStringToFile(file, csv);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
