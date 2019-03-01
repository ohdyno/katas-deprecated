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
        setBarChartHeader(new BarChart(), graphics, chartMode.equals(SINGLE_MODE));
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

    private void setBarChartHeader(BarChart barChart, Graphics graphics, boolean isSingleMode) {
        String[] barChartTitle;
        if (isSingleMode) {
            barChartTitle = new String[1];
            barChartTitle[0] = "Bar Chart";
        } else {
            barChartTitle = new String[2];
            barChartTitle[0] = "Bar Chart";
            barChartTitle[1] = "Small";
        }
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.CYAN);
            graphics.fillRect(112, 300, 75, 200);
            graphics.fillRect(187, 100, 75, 400);
            graphics.fillRect(262, 200, 75, 300);
            graphics.fillRect(337, 250, 75, 250);
            graphics.fillRect(412, 160, 75, 340);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
            graphics.drawString(barChartTitle[0], 130, 400);
        } else {
            graphics.setColor(Color.CYAN);
            graphics.fillRect(100, 200, 40, 100);
            graphics.fillRect(140, 100, 40, 200);
            graphics.fillRect(180, 150, 40, 150);
            graphics.fillRect(220, 175, 40, 125);
            graphics.fillRect(260, 130, 40, 170);
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 25));
            graphics.drawString(barChartTitle[0], 130, 250);
            graphics.drawString(barChartTitle[1], 130, 270);
        }
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
