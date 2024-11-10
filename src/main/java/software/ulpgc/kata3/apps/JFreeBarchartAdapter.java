package software.ulpgc.kata3.apps;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.architecture.model.Barchart;

import java.awt.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        JFreeChart chart = ChartFactory.createBarChart(
                barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetOf(barchart)
        );
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(0, 230, 255));
        return chart;
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        SortedMap<String,Integer> sortedMap = new TreeMap<>(barchart.getData());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String,Integer> entry : sortedMap.entrySet()){
            dataset.addValue(entry.getValue(), "", entry.getKey());
        }
        return dataset;
    }

}
