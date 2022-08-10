package util;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AttributeGetter {
    public static ArrayList<String> getAllModifiableEmployeeAttributes() {
        ArrayList<String> attributes = new ArrayList<>();
        JSONArray results = SQLHelper.getQueryResultsAsJSON(Query.LOCATIONS_INFO.query, new ArrayList<>());
        for (String s: results.getJSONObject(0).keySet()) {
            if (!s.equalsIgnoreCase("LocationID")) {
                attributes.add(s);
            }
        }
        return attributes;
    }

    public static HashMap<Integer, String> getAllLocationIDsAndNames() {
        HashMap<Integer, String> locationMap = new HashMap<>();
        JSONArray results = SQLHelper.getQueryResultsAsJSON(Query.LOCATIONS_INFO.query, new ArrayList<>());
        for (int i = 0; i < results.length(); i++) {
            int id = results.getJSONObject(i).getInt("LocationID");
            String name = results.getJSONObject(i).getString("LocationName");
            locationMap.put(id, name);
        }
        return locationMap;
    }

    public static String getLocationIDFromName(String locationName) {
        String id = "";
        for (Map.Entry<Integer, String> entry: AttributeGetter.getAllLocationIDsAndNames().entrySet()) {
            if(entry.getValue().equalsIgnoreCase(locationName)) {
                id = String.valueOf(entry.getKey());
            }
        }
        return id;
    }
}
