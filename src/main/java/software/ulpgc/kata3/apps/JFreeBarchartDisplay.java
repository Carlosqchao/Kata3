package software.ulpgc.kata3.apps;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

import javax.swing.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    @Override
    public void show(Barchart barchart) {
        removeAll();
        add(new ChartPanel(adapt(barchart)));
        revalidate();
    }
    private JFreeChart adapt(Barchart barchart){
        return JFreeChartAdapter.adapt(barchart);
    }
}
