package com.jsondata.utils;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsonData {

    final static String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    final static String[] bGroup = {"O+","O-","B+","B-","A+","A-","AB+","AB-"};
    final static String[] edu = {"Literate","Illiterate"};
    final static String[] tf = {"True","False"};
    final static String[] yn = {"Yes","No"};
    final static String[] tab = {"Continued","Discontinued"};
    final static String[] cst = {"SC","ST","OBC","general","others"};
    final static String[] sch = {"scheme1","scheme2","scheme3","others"};
    final static Random rand = new Random();

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int dataDB = sc.nextInt();
        int vitalDB = sc.nextInt();
        String fName = sc.next();

        try {
            FileWriter file = new FileWriter("C:\\Users\\home\\Documents\\"+fName+".json");
            File filec=new File("C:\\Users\\home\\Documents\\fromJSON.csv");
            JSONArray docs = new JSONArray();
            for (int j = 0; j < dataDB; j++) {
                JSONObject obj = new JSONObject();
                String uid = UUID.randomUUID().toString();
                //obj.put("_id", uid.toUpperCase());
                obj.put("_rev", "11-0c8f5443ee069efd28be6f5eb31c3362");
                obj.put("thayicardno", (int) (Math.random() * (5000 - 1)) + 1);
                obj.put("ancregno", (int) (Math.random() * (5000 - 1)) + 1);
                obj.put("patientname", randomIdentifier());
                obj.put("address", randomIdentifier());
                obj.put("contactnumber", (long) Math.floor(Math.random() * 9000000000L) + 1000000000L);
                obj.put("phcname", randomIdentifier());
                obj.put("ashaname", randomIdentifier());
                obj.put("ashacontactnumber", (long) Math.floor(Math.random() * 9000000000L) + 1000000000L);
                int age = (int) (Math.random() * (50 - 18)) + 18;
                obj.put("age", age);
                obj.put("paritynumber", (int) (Math.random() * (6 - 1)) + 1);
                obj.put("bloodgroup", randomValue(bGroup));
                obj.put("ageatmarriage", (int) (Math.random() * (age - 18)) + 18);
                obj.put("lmp", timeGenerator("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
                String tim = timeGenerator("dd/MM/YYYY");
                obj.put("edd", uid);
                obj.put("socialgroup", randomValue(cst));
                obj.put("education", randomValue(edu));
                obj.put("educationtxt", (int) (Math.random() * (100 - 1)) + 1);
                obj.put("weight", (int) (Math.random() * (100 - 40)) + 40);
                int height = (int) (Math.random() * (10 - 3)) + 3;
                obj.put("height", height);
                obj.put("heightunit", "feet");

                int weight = (int) (Math.random() * (100 - 40)) + 40;
                obj.put("bmi_weight", weight);
                obj.put("bmi_bmi", (weight / height) + "[Under weight]");
                obj.put("bmi_timestamp", timeGenerator("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

                obj.put("ancvisits", randomIdentifier());
                obj.put("placeofdelivery", "both");
                obj.put("usg", randomValue(yn));
                obj.put("usgtxt", "private");
                obj.put("ifa", randomValue(yn));
                obj.put("sourceifa", "government");
                obj.put("ifatablets", randomValue(tab));
                obj.put("discountinuedtxt", "dontknow");

                obj.put("sym_vaginalbleeding", randomValue(tf));
                obj.put("sym_childdoesnotmove", randomValue(tf));
                obj.put("sym_severeheadache", randomValue(tf));
                obj.put("sym_lossofconsciousness", randomValue(tf));
                obj.put("sym_severeabdominalpain", randomValue(tf));
                obj.put("sym_swellingoffeet", randomValue(tf));
                obj.put("sym_prolongedlabour", randomValue(tf));
                obj.put("sym_fastheartbeat", randomValue(tf));
                obj.put("sym_fits", randomValue(tf));
                obj.put("sym_diabetes", randomValue(tf));
                obj.put("sym_doesnotknowanyoftheabove", randomValue(tf));

                obj.put("governmentscheme", randomValue(yn));
                obj.put("governmentschemetxt", randomValue(sch));
                obj.put("$$hashKey", "Object:" + ((int) (Math.random() * (5000 - 1)) + 1));

                for(int i=0; i<vitalDB; i++) {

                    obj.put("vital_type", "hemoglobin");
                    obj.put("vital_value", (float)((Math.random() * (17.5 - 12)) + 12));
                    obj.put("vital_timestamp", timeGenerator("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));

                    docs.put(obj);

                    String objs = "curl -XPOST \"http://192.168.99.100:9200/nhpatientsurvey/bangalore\" -d '" +obj.toJSONString().replace(uid,tim)+"'";
                    System.out.println("\nJSON Object: " + objs);
                    file.write(objs+"\n");

                    obj.remove("vital_type");
                    obj.remove("vital_value");
                    obj.remove("vital_timestamp");

                }
            }
            String csv = CDL.toString(docs);
            FileUtils.writeStringToFile(filec, csv);
            file.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Successfully Copied JSON Object to File...");

    }

    public static String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(AB.charAt(rand.nextInt(AB.length())));
            }
        }
        return builder.toString();
    }

    public static String randomValue(String[] datas){

        List<String> names = Arrays.asList(datas);
        int index = new Random().nextInt(names.size());
        return names.get(index);

    }

    public static String timeGenerator(String pattern ){

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2016, 2016);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(gc.getTime()) ;
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
