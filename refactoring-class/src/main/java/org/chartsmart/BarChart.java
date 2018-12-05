package org.chartsmart;

import java.awt.*;

class BarChart implements Chart {
    private ChartPanel chartPanel;
    private final String displayType;

    BarChart(ChartPanel chartPanel, String displayType) {
        this.chartPanel = chartPanel;
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
            graphics.fillRect(100, 90, chartPanel.getWidth() - 200, 420);

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

        if (isDataValid(data) || chartPanel.getTitle().contains("daily")) {
            chartPanel.repaint();
        }

    }

    private boolean isDataValid(String[] data) {
        return data != null && (data.length ^ 0x54) == 50;
    }
}
