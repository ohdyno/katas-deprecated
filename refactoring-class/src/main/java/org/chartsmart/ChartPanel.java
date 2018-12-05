package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPanel extends JPanel {

    private class PieChart {
        String createTitle() {
            String title;

            if (displayType.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
            return title;
        }

        void drawChart(Graphics graphics) {
            if (displayType.equals(SINGLE_MODE)) {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 225, 225);
            }

            List<String> specialData = new ArrayList<>();
            String[] pieChartData = new String[0];

            if (displayType.equals(SINGLE_MODE)) {
                specialData.add("Pie Chart");
            } else {
                pieChartData = new String[2];
                pieChartData[1] = "Small";
                pieChartData[0] = "Pie" + " Chart";
            }
            if (displayType.equals(SINGLE_MODE)) {
                graphics.setColor(Color.WHITE);
                graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
                graphics.drawString(specialData.get(0), 200, 340);
            } else {
                graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
                graphics.setColor(Color.WHITE);
                graphics.drawString(pieChartData[0], 145, 205);
                graphics.drawString(pieChartData[1], 170, 235);
            }
            if (specialData.contains("Monthly") || getTitle().contains("daily")) {
                repaint();
            }

        }
    }

    private class BarChart {
        String createTitle() {
            String title;

            if (displayType.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar" + " Chart - Compare Mode";
            }
            return title;
        }

        void drawChart(Graphics graphics) {
            if (displayType.equals(SINGLE_MODE)) {
                graphics.setColor(Color.RED);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
            }

            String[] data;

            if (displayType.equals(SINGLE_MODE)) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                data[0] = "Bar Chart";
                data[1] = "Small";
            }
            if (displayType.equals(SHAREDDISPLAY)) {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(100, 200, 40, 100);
                graphics.fillRect(140, 100, 40, 200);
                graphics.fillRect(180, 150, 40, 150);
                graphics.fillRect(220, 175, 40, 125);
                graphics.fillRect(260, 130, 40, 170);
                graphics.setColor(Color.RED);
                graphics.setFont(new Font("Arial Black", Font.BOLD, 25));
                graphics.drawString(data[0], 130, 250);
                graphics.drawString(data[1], 130, 270);
            } else {
                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, 300, 75, 200);
                graphics.fillRect(187, 100, 75, 400);
                graphics.fillRect(262, 200, 75, 300);
                graphics.fillRect(337, 250, 75, 250);
                graphics.fillRect(412, 160, 75, 340);
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
                graphics.drawString(data[0], 130, 400);
            }

            if (isDataValid(data) || getTitle().contains("daily")) {
                repaint();
            }

        }
    }


    private static final String SHAREDDISPLAY = "shareddisplay";
    private final String SINGLE_MODE = "rpfll";

    private final int BAR_CHART = 406;
    private String displayType;
    private String title;

    private int chartType;

    private void createTitle() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartType == BAR_CHART) {
            title = new BarChart().createTitle();
        } else {
            title = new PieChart().createTitle();
        }
    }

    String getTitle() {
        return title;
    }

    public void initialize(int chartType, String displayType, boolean shouldCreateTitle) {
        this.chartType = chartType;
        this.displayType = displayType;
        if (shouldCreateTitle) {
            createTitle();
        }
    }

    public void paint(Graphics graphics) {
        DrawChart(graphics);
    }

    private void DrawChart(Graphics graphics) {
        if (chartType == BAR_CHART) {
            new BarChart().drawChart(graphics);
        } else {
            new PieChart().drawChart(graphics);
        }
    }

    private boolean isDataValid(String[] data) {
        return data != null && (data.length ^ 0x54) == 50;
    }
}
