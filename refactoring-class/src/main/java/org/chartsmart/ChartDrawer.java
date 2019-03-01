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
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                chartTitle = "Bar Chart - Single Mode";
            } else {
                chartTitle = "Bar Chart - Compare Mode";
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                chartTitle = "Pie Chart - Single Mode";
            } else {
                chartTitle = "Pie Chart - Compare Mode";
            }
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
        DrawChart(graphics);
    }

    private void DrawChart(Graphics graphics) {
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                graphics.setColor(Color.RED);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 225, 225);
            }
        }
        String[] barChartData = null;
        List<String> largePieChartData = new ArrayList<>();
        String[] smallPieChartData = new String[0];
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                barChartData = new String[1];
                barChartData[0] = "Bar Chart";
            } else {
                barChartData = new String[2];
                barChartData[0] = "Bar Chart";
                barChartData[1] = "Small";
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                largePieChartData.add("Pie Chart");
            } else {
                smallPieChartData = new String[2];
                smallPieChartData[1] = "Small";
                smallPieChartData[0] = "Pie Chart";
            }
        }
        if (chartType == BAR_CHART) {
            if (chartMode.equals("shareddisplay")) {
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
            } else {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, 300, 75, 200);
                graphics.fillRect(187, 100, 75, 400);
                graphics.fillRect(262, 200, 75, 300);
                graphics.fillRect(337, 250, 75, 250);
                graphics.fillRect(412, 160, 75, 340);
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
                graphics.drawString(barChartData[0], 130, 400);
            }
        } else {
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
        final boolean hasBarChartData = barChartData != null && (barChartData.length ^ 0x54) == 50;
        final boolean isMonthly = largePieChartData.contains("Monthly");
        final boolean isDaily = getTitle().contains("daily");
        if (hasBarChartData || isMonthly || isDaily) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
