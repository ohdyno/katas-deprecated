package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {

    private static final int BAR_CHART = 406;
    private Chart chart;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
    }


    String getTitle() {
        return chart.getTitle();
    }

    public void showChart(int chartType, String chartMode, boolean shouldDraw) {
        if (chartType == BAR_CHART) {
            chart = new BarChart(chartMode);
        } else {
            chart = new PieChart(chartMode);
        }
        if (shouldDraw) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics g) {
        chart.renderChartBackground(g, getWidth(), getHeight());
        chart.renderChart(g);
    }
}