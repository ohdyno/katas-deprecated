package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {

    private Chart chart;

    public void initialize(int chartType, String displayType, boolean shouldSetPreferredSize) {
        if (chartType == Chart.BAR_CHART) {
            chart = new BarChart(this, displayType);
        } else {
            chart = new PieChart(this, displayType);
        }

        if (shouldSetPreferredSize) {
            this.setPreferredSize(new Dimension(600, 600));
        }
    }

    public void paint(Graphics graphics) {
        chart.drawChart(graphics);
    }

    String getTitle() {
        return chart.createTitle();
    }
}
