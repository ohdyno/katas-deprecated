package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {

    private static final String SHARED_DISPLAY = "shareddisplay";
    private static final int BAR_CHART = 406;
    private static final String SINGLE_MODE = "rpfll";
    private String chartMode;
    private String title;
    private int chartType;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        setChartTitle();
    }

    private void setChartTitle() {
        if (chartType == BAR_CHART) {
            setBarChartTitle();
        } else {
            setPieChartTitle();
        }
    }

    String getTitle() {
        return title;
    }

    public void showChart(int chartType, String chartMode, boolean shouldDraw) {
        this.chartType = chartType;
        this.chartMode = chartMode;
        if (shouldDraw) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics graphics) {
        renderChartBackground(graphics);
        renderChart(graphics);
    }

    private void renderChartBackground(Graphics graphics) {
        Chart chart;
        if (chartType == BAR_CHART) {
            chart = new BarChart();
        } else {
            chart = new PieChart();
        }
        chart.renderChartBackground(graphics, chartMode, SINGLE_MODE, getHeight());
    }

    private void renderChart(Graphics graphics) {
        Chart chart;
        if (chartType == BAR_CHART) {
            chart = new BarChart();
        } else {
            chart = new PieChart();
        }
        chart.renderChart(graphics, chartMode, SINGLE_MODE);
    }

    private void setBarChartTitle() {
        if (chartMode.equals(SINGLE_MODE)) {
            title = "Bar Chart - Single Mode";
        } else {
            title = "Bar Chart - Compare Mode";
        }
    }

    private void setPieChartTitle() {
        if (chartMode.equals(SINGLE_MODE)) {
            title = "Pie Chart - Single Mode";
        } else {
            title = "Pie Chart - Compare Mode";
        }
    }

}
