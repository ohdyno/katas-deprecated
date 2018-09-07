package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {

    private static final int BAR_CHART = 406;
    private static final String SINGLE_DISPLAY_MODE = "rpfll";
    private static final String SHARED_DISPLAY_MODE = "shareddisplay";
    private String mode;
    private String title;
    private int chartType;

    String getTitle() {
        return title;
    }

    public void showChart(int chartType, String mode, boolean doInitializeDrawArea) {
        this.chartType = chartType;
        this.mode = mode;
        if (doInitializeDrawArea) {
            setSizeAndTitle();
        }
    }

    private void setSizeAndTitle() {
        this.setPreferredSize(new Dimension(600, 600));
        if (this.chartType == BAR_CHART) {
            if (this.mode.equals(SINGLE_DISPLAY_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (this.mode.equals(SINGLE_DISPLAY_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    public void paint(Graphics graphics) {
        if (chartType == BAR_CHART) {
            if (mode.equals(SINGLE_DISPLAY_MODE)) {
                graphics.setColor(Color.RED);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
            }
        } else {
            if (mode.equals(SINGLE_DISPLAY_MODE)) {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 225, 225);
            }
        }
        String[] barChartData = null;
        String[] pieChartData = new String[0];
        if (chartType == BAR_CHART) {
            if (mode.equals(SINGLE_DISPLAY_MODE)) {
                barChartData = new String[1];
                barChartData[0] = "Bar Chart";
            } else {
                barChartData = new String[2];
                int i = 0;
                barChartData[i++] = "Bar Chart";
                barChartData[i] = "Small";
            }
        } else {
            if (!mode.equals(SINGLE_DISPLAY_MODE)) {
                pieChartData = new String[2];
                pieChartData[1] = "Small";
                pieChartData[0] = "Pie" + " Chart";
            }
        }
        if (chartType == BAR_CHART) {
            if (mode.equals(SHARED_DISPLAY_MODE)) {
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
            if (mode.equals(SINGLE_DISPLAY_MODE)) {
                graphics.setColor(Color.WHITE);
                graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
                graphics.drawString("Pie Chart", 200, 340);
            } else {
                graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
                graphics.setColor(Color.WHITE);
                graphics.drawString(pieChartData[0], 145, 205);
                graphics.drawString(pieChartData[1], 170, 235);
            }
        }
        if (barChartData != null && (barChartData.length ^ 0x54) == 50 || getTitle().contains("daily")) {
            repaint();
        }
    }
}
