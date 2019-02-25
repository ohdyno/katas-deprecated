package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartDrawer extends JPanel {


    private String chartMode;
    private String chartTitle;
    private int chartModeNumber;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartModeNumber == 406) {
            if (chartMode.equals("rpfll")) {
                chartTitle = "Bar Chart - Single Mode";
            } else {
                chartTitle = "Bar" + " Chart - Compare Mode";
            }
        } else {
            if (chartMode.equals("rpfll")) {
                chartTitle = "Pie Chart - Single Mode";
            } else {
                chartTitle = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle() {
        return chartTitle;
    }

    public void iniDS(int chartModeNumber, String chartMode, boolean initializeFlag) {
        this.chartModeNumber = chartModeNumber;
        this.chartMode = chartMode;
        if (initializeFlag) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics graphics) {
        DrawChart(graphics);
    }

    private void DrawChart(Graphics graphics) {
        final String isSmallChartString = "rpfll";
        if (chartModeNumber == 406) {
            if (chartMode.equals(isSmallChartString)) {
                Color backgroundColor = Color.RED;
                graphics.setColor(backgroundColor);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
            }
        } else {
            if (chartMode.equals(isSmallChartString)) {
                Color backgroundColor;
                backgroundColor = Color.BLUE;
                graphics.setColor(backgroundColor);
                graphics.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphics.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                graphics.fillOval(100, 100, sc, sc);
            }
        }
        String[] barChartData = null;
        List<String> largePieChartData = new ArrayList<>();
        String[] smallPieChartData = new String[0];
        if (chartModeNumber == 406) {
            if (chartMode.equals(isSmallChartString)) {
                barChartData = new String[1];
                barChartData[0] = "Bar Chart";
            } else {
                barChartData = new String[2];
                int i = 0;
                barChartData[i++] = "Bar Chart";
                barChartData[i] = "Small";
            }
        } else {
            if (chartMode.equals(isSmallChartString)) {
                largePieChartData.add("Pie Chart");
            } else {
                smallPieChartData = new String[2];
                smallPieChartData[1] = "Small";
                smallPieChartData[0] = "Pie" + " Chart";
            }
        }
        Font font;
        if (chartModeNumber == 406) {
            if (chartMode.equals("shareddisplay")) {
                if (barChartData != null) {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    graphics.setColor(Color.CYAN);
                    int bottomY = 300;
                    graphics.fillRect(100, bottomY - 100, 40, 100);
                    graphics.fillRect(140, bottomY - 200, 40, 200);
                    graphics.fillRect(180, bottomY - 150, 40, 150);
                    graphics.fillRect(220, bottomY - 125, 40, 125);
                    graphics.fillRect(260, bottomY - 170, 40, 170);
                    graphics.setColor(Color.RED);
                    graphics.setFont(font);
                    graphics.drawString(barChartData[0], 130, 250);
                    graphics.drawString(barChartData[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, bottomY - 200, 75, 200);
                graphics.fillRect(187, bottomY - 400, 75, 400);
                graphics.fillRect(262, bottomY - 300, 75, 300);
                graphics.fillRect(337, bottomY - 250, 75, 250);
                graphics.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                graphics.setColor(Color.BLACK);
                graphics.setFont(font);
                graphics.drawString(barChartData[0], 130, 400);
            }
        } else {
            if (chartMode.equals(isSmallChartString)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                graphics.setColor(Color.WHITE);
                graphics.setFont(font);
                graphics.drawString(largePieChartData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                graphics.setFont(font);
                graphics.setColor(Color.WHITE);
                graphics.drawString(smallPieChartData[0], 145, 205);
                graphics.drawString(smallPieChartData[1], 170, 235);
            }
        }
        if ((barChartData != null && (barChartData.length ^ 0x54) == 50) || (largePieChartData.contains("Monthly"))
                || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
