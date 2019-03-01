package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
            drawBarChart(graphics);
            repaintChart();
        } else {
            drawPieChart(graphics);
        }
    }

    private void drawPieChart(Graphics graphics) {
        setPieChartColor(graphics);
        setPieChartHeader(graphics);
    }

    private void drawBarChart(Graphics graphics) {
        new BarChart().setBarChartColor(graphics, chartMode.equals(SINGLE_MODE), getWidth());
        new BarChart().setBarChartHeader(graphics, chartMode.equals(SINGLE_MODE));
    }

    private void setPieChartHeader(Graphics graphics) {
        List<String> largePieChartTitle = new ArrayList<>();
        String[] smallPieChartTitle = new String[0];
        if (chartMode.equals(SINGLE_MODE)) {
            largePieChartTitle.add("Pie Chart");
        } else {
            smallPieChartTitle = new String[2];
            smallPieChartTitle[1] = "Small";
            smallPieChartTitle[0] = "Pie Chart";
        }
        drawPieChartData(graphics, largePieChartTitle, smallPieChartTitle);
        repaintChart();
    }

    private void repaintChart() {
        try {
            repaint(200);
        } catch (Throwable e) {
            repaint();
        }
    }


    private void drawPieChartData(Graphics graphics, List<String> largePieChartData, String[] smallPieChartData) {
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            graphics.drawString(largePieChartData.get(0), 200, 340);
        } else {
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            graphics.setColor(Color.WHITE);
            graphics.drawString(smallPieChartData[0], 145, 205);
            graphics.drawString(smallPieChartData[1], 170, 235);
        }
    }

    private void setPieChartColor(Graphics graphics) {
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 450, getHeight() - 150);
        } else {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 225, 225);
        }
    }

}
