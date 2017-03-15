package com.jsondata.utils.formatter;

import com.jsondata.utils.reader.Configuration;
import org.json.JSONArray;

import java.io.IOException;

/**
 * Created by home on 3/15/2017.
 */
public class PrintOutput {

    public void output(Configuration data, JSONArray arr) throws IOException {
        switch (data.getOutFormat()){
            case "json" :
                PrintFormatter outform = new PrintFormatter();
                outform.header(data, arr);
                break;
            case "csv" :
                PrintFormatterCsv outform1 = new PrintFormatterCsv();
                outform1.header(data, arr);
                break;
            default : throw new IllegalArgumentException("Invalid output format"+data.getOutFormat()+"\n");
        }
    }
}
