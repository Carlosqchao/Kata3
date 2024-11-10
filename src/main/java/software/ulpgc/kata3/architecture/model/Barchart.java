package software.ulpgc.kata3.architecture.model;

import java.util.HashMap;
import java.util.Map;

public class Barchart {
    private final String title;
    private final String xAxis;
    private final String yAxis;
    private final Map<String,Integer> data;

    public Barchart(String title, String xAxis, String yAxis) {
        this.title = title;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.data = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public void put(String category, int value){
        data.put(category,value);
    }

    public Map<String, Integer> getData() {
        return data;
    }
}
