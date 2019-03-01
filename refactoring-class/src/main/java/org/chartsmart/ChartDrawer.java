package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartDrawer extends JPanel {

    private static final String SINGLE_MODE = "rpfll";
    private static final int BAR_CHART = 406;
    private String chartMode;
    private String chartTitle;
    private int chartType;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        setChartTitle();
    }

    private void setChartTitle() {
        if (chartType == BAR_CHART) {
            chartTitle = new BarChart().title(chartMode.equals(SINGLE_MODE));
        } else {
            chartTitle = new PieChart().title(chartMode.equals(SINGLE_MODE));
        }
    }

    String getTitle() {
        return chartTitle;
    }

    public void initializeChart(int chartType, String chartMode, boolean initializeFlag) {
        this.chartType = chartType;
        this.chartMode = chartMode;
        if (initializeFlag) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics graphics) {
        if (chartType == BAR_CHART) {
            new BarChart().drawBarChart(graphics, chartMode.equals(SINGLE_MODE), getWidth());
        } else {
            new PieChart().drawPieChart(graphics, chartMode.equals(SINGLE_MODE), getHeight());
        }
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
