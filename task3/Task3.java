package task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Task3 {
    public static void main(String[] args) throws IOException, ParseException {
        String path = args[2];
        JSONParser parser = new JSONParser();
        try(PrintWriter out = new PrintWriter(new FileWriter(path))) {
            JSONObject root1 = (JSONObject) parser.parse(new FileReader(args[0]));
            JSONObject root2 = (JSONObject) parser.parse(new FileReader(args[1]));
            JSONArray items1 = (JSONArray) root1.get("values");
            JSONArray items2 = (JSONArray) root2.get("tests");

            for (Object item1 : items1) {
                JSONObject jsonObject1 = (JSONObject) item1;
                loop:
                for (Object item2 : items2) {
                    JSONObject jsonObject2 = (JSONObject) item2;
                    if (jsonObject1.get("id") == jsonObject2.get("id")) {
                        jsonObject2.put("value", jsonObject1.get("value"));
                        break;
                    }
                    if (jsonObject2.get("values") != null) {
                        JSONArray items3 = (JSONArray) jsonObject2.get("values");
                        for (Object item3 : items3) {
                            JSONObject jsonObject3 = (JSONObject) item3;
                            if (jsonObject1.get("id") == jsonObject3.get("id")) {
                                jsonObject3.put("value", jsonObject1.get("value"));
                                break loop;
                            }
                            if (jsonObject3.get("values") != null) {
                                JSONArray items4 = (JSONArray) jsonObject3.get("values");
                                for (Object item4 : items4) {
                                    JSONObject jsonObject4 = (JSONObject) item4;
                                    if (jsonObject1.get("id") == jsonObject4.get("id")) {
                                        jsonObject4.put("value", jsonObject1.get("value"));
                                        break loop;
                                    }
                                    if (jsonObject4.get("values") != null) {
                                        JSONArray items5 = (JSONArray) jsonObject4.get("values");
                                        for (Object item5 : items5) {
                                            JSONObject jsonObject5 = (JSONObject) item5;
                                            if (jsonObject1.get("id") == jsonObject5.get("id")) {
                                                jsonObject5.put("value", jsonObject1.get("value"));
                                                break loop;
                                            }
                                            if (jsonObject5.get("values") != null) {
                                                JSONArray items6 = (JSONArray) jsonObject5.get("values");
                                                for (Object item6 : items6) {
                                                    JSONObject jsonObject6 = (JSONObject) item6;
                                                    if (jsonObject1.get("id") == jsonObject6.get("id")) {
                                                        jsonObject6.put("value", jsonObject1.get("value"));
                                                        break loop;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(root2);
            out.write(root2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
