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
            setBarChartTitle();
        } else {
            setPieChartTitle();
        }
    }

    private void setPieChartTitle() {
        if (chartMode.equals(SINGLE_MODE)) {
            chartTitle = "Pie Chart - Single Mode";
        } else {
            chartTitle = "Pie Chart - Compare Mode";
        }
    }

    private void setBarChartTitle() {
        if (chartMode.equals(SINGLE_MODE)) {
            chartTitle = "Bar Chart - Single Mode";
        } else {
            chartTitle = "Bar Chart - Compare Mode";
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
        } else {
            drawPieChart(graphics);
        }
    }

    private void drawPieChart(Graphics graphics) {
        setPieChartColor(graphics);
        setPieChartHeader(graphics);
    }

    private void drawBarChart(Graphics graphics) {
        setBarChartColor(graphics);
        setBarChartHeader(graphics);
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
        repaintPieChart(largePieChartTitle);
    }

    private void setBarChartHeader(Graphics graphics) {
        String[] barChartTitle;
        if (chartMode.equals(SINGLE_MODE)) {
            barChartTitle = new String[1];
            barChartTitle[0] = "Bar Chart";
        } else {
            barChartTitle = new String[2];
            barChartTitle[0] = "Bar Chart";
            barChartTitle[1] = "Small";
        }
        drawBarChartData(graphics, barChartTitle);
        repaintBarChart(barChartTitle);
    }

    private void repaintBarChart(String[] barChartTitle) {
        final boolean hasBarChartData = barChartTitle != null && (barChartTitle.length ^ 0x54) == 50;
        final boolean isDaily = getTitle().contains("daily");
        if (hasBarChartData || isDaily) {
            repaintChart();
        }
    }

    private void repaintChart() {
        try {
            repaint(200);
        } catch (Throwable e) {
            repaint();
        }
    }

    private void repaintPieChart(List<String> largePieChartTitle) {
        final boolean isMonthly = largePieChartTitle.contains("Monthly");
        final boolean isDaily = getTitle().contains("daily");
        if (isMonthly || isDaily) {
            repaintChart();
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

    private void drawBarChartData(Graphics graphics, String[] barChartData) {
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.CYAN);
            graphics.fillRect(112, 300, 75, 200);
            graphics.fillRect(187, 100, 75, 400);
            graphics.fillRect(262, 200, 75, 300);
            graphics.fillRect(337, 250, 75, 250);
            graphics.fillRect(412, 160, 75, 340);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
            graphics.drawString(barChartData[0], 130, 400);
        } else {
            if (barChartData != null) {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(100, 200, 40, 100);
                graphics.fillRect(140, 100, 40, 200);
                graphics.fillRect(180, 150, 40, 150);
                graphics.fillRect(220, 175, 40, 125);
                graphics.fillRect(260, 130, 40, 170);
                graphics.setColor(Color.RED);
                graphics.setFont(new Font("Arial Black", Font.BOLD, 25));
                graphics.drawString(barChartData[0], 130, 250);
                graphics.drawString(barChartData[1], 130, 270);
            }
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

    private void setBarChartColor(Graphics graphics) {
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.RED);
            graphics.fillRect(100, 90, getWidth() - 200, 420);
        } else {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(95, 95, 210, 210);
        }
    }
}
