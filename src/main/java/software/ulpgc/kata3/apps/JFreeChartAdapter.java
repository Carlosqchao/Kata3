package software.ulpgc.kata3.apps;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.architecture.model.Barchart;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class JFreeChartAdapter {
    public static JFreeChart adapt (Barchart barchart){
        JFreeChart chart = ChartFactory.createBarChart(
                barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetOf(barchart)
        );
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(-3);
        renderer.setMaximumBarWidth(0.2);
        return chart;
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        SortedMap<String,Integer> sortedData = new TreeMap<>(barchart.getData());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String,Integer> entry: sortedData.entrySet()){
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }
        return dataset;
    }
}
