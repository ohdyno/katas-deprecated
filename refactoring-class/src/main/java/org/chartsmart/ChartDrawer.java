package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartDrawer extends JPanel {

    private static final String SINGLE_MODE = "rpfll";
    private static final int BAR_CHART = 406;
    private String chartMode;
    private Chart chart;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
    }

    String getTitle() {
        return chart.title(chartMode.equals(SINGLE_MODE));
    }

    public void initializeChart(int chartType, String chartMode, boolean initializeFlag) {
        this.chartMode = chartMode;
        if (chartType == BAR_CHART) {
            chart = new BarChart(chartMode);
        } else {
            chart = new PieChart(chartMode);
        }
        if (initializeFlag) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics graphics) {
        chart.draw(graphics, chartMode.equals(SINGLE_MODE), getWidth(), getHeight());
        repaintChart();
    }

    private void repaintChart() {
        try {
            repaint(200);
        } catch (Throwable e) {
            repaint();
        }
    }
}
