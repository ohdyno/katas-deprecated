package org.chartsmart;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class PieChart implements Chart {
    private ChartPanel chartPanel;
    private final String displayType;

    PieChart(ChartPanel chartPanel, String displayType) {
        this.chartPanel = chartPanel;
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
            graphics.fillOval(100, 100, 450, chartPanel.getHeight() - 150);

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


        if (specialData.contains("Monthly") || chartPanel.getTitle().contains("daily")) {
            chartPanel.repaint();
        }

    }
}
