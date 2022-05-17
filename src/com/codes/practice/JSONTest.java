//package com.codes.practice;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class JSONTest {
//    public static void main(String[] args) {
//
//        JSONParser parser = new JSONParser();
//        String s = "[0,{\"abc\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
//
//        try{
//            Object obj = parser.parse(s);
//            JSONArray array = (JSONArray)obj;
//
//            System.out.println("The 2nd element of array");
//            System.out.println(array.get(1));
//            System.out.println();
//
//            JSONObject obj2 = (JSONObject)array.get(1);
//            System.out.println("Field \"1\"");
//            System.out.println(obj2.get("abc"));
//
//            s = "{\"abc\":123}";
//            obj = parser.parse(s);
//            JSONObject obj3 = (JSONObject)obj;
//            System.out.println(obj3.get("abc"));
//
//            s = "[5,]";
//            obj = parser.parse(s);
//            System.out.println(obj);
//
//            s = "[5,,2]";
//            obj = parser.parse(s);
//            System.out.println(obj);
//        }catch(ParseException pe) {
//
//            System.out.println("position: " + pe.getPosition());
//            System.out.println(pe);
//        }
//    }
//}
