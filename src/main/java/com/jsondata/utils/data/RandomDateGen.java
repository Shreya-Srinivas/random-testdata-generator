package com.jsondata.utils.data;

import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Shreya Srinivas.
 */
public class RandomDateGen extends RandomStringGen {

    public void randomIdentifier(Object keys, JSONObject newObj, String[] arr){

        try {
            SimpleDateFormat format = new SimpleDateFormat(arr[1]);
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            GregorianCalendar gc = new GregorianCalendar();
            Date start = format1.parse(arr[2].toString());
            Date end = format1.parse(arr[3].toString());
            int year = randBetween(getYear(start), getYear(end));
            gc.set(gc.YEAR, year);
            int dayOfYear = randBetween(start.getDate(), end.getDate());
            gc.set(gc.DAY_OF_YEAR, dayOfYear);

            newObj.put(keys, format.format(gc.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getYear(Date dates){
        Calendar cal = Calendar.getInstance();
        cal.setTime(dates);
        return cal.get(Calendar.YEAR);
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
