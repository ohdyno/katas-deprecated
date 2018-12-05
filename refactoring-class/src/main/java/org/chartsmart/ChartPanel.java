package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPanel extends JPanel {

    private Chart chart;

    private interface Chart {
        String SHAREDDISPLAY = "shareddisplay";
        String SINGLE_MODE = "rpfll";
        int BAR_CHART = 406;

        void drawChart(Graphics graphics);

        String createTitle();
    }

    private class PieChart implements Chart {
        private final String displayType;

        PieChart(String displayType) {
            this.displayType = displayType;
        }

        public String createTitle() {
            String title;

            if (displayType.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
            return title;
        }

        public void drawChart(Graphics graphics) {
            List<String> specialData = new ArrayList<>();
            String[] pieChartData;

            if (displayType.equals(SINGLE_MODE)) {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 450, getHeight() - 150);

                specialData.add("Pie Chart");

                graphics.setColor(Color.WHITE);
                graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
                graphics.drawString(specialData.get(0), 200, 340);
            } else {
                graphics.setColor(Color.BLUE);
                graphics.fillOval(100, 100, 225, 225);

                pieChartData = new String[2];
                pieChartData[1] = "Small";
                pieChartData[0] = "Pie" + " Chart";

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

    private class BarChart implements Chart {
        private final String displayType;

        BarChart(String displayType) {
            this.displayType = displayType;
        }

        public String createTitle() {
            String title;

            if (displayType.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar" + " Chart - Compare Mode";
            }
            return title;
        }

        public void drawChart(Graphics graphics) {
            String[] data;

            if (displayType.equals(SINGLE_MODE)) {
                graphics.setColor(Color.RED);
                graphics.fillRect(100, 90, getWidth() - 200, 420);

                data = new String[1];
                data[0] = "Bar Chart";

                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, 300, 75, 200);
                graphics.fillRect(187, 100, 75, 400);
                graphics.fillRect(262, 200, 75, 300);
                graphics.fillRect(337, 250, 75, 250);
                graphics.fillRect(412, 160, 75, 340);
                graphics.setColor(Color.BLACK);
                graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
                graphics.drawString(data[0], 130, 400);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);

                data = new String[2];
                data[0] = "Bar Chart";
                data[1] = "Small";

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
            }

            if (isDataValid(data) || getTitle().contains("daily")) {
                repaint();
            }

        }

        private boolean isDataValid(String[] data) {
            return data != null && (data.length ^ 0x54) == 50;
        }
    }

    public void initialize(int chartType, String displayType, boolean shouldSetPreferredSize) {
        if (chartType == Chart.BAR_CHART) {
            chart = new BarChart(displayType);
        } else {
            chart = new PieChart(displayType);
        }

        if (shouldSetPreferredSize) {
            this.setPreferredSize(new Dimension(600, 600));
        }
    }

    public void paint(Graphics graphics) {
        chart.drawChart(graphics);
    }

    String getTitle() {
        return chart.createTitle();
    }
}
