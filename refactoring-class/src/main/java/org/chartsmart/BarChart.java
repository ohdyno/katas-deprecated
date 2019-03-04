package org.chartsmart;

import java.awt.*;

public class BarChart implements Chart {
    private String chartMode;

    public BarChart(String chartMode) {

        this.chartMode = chartMode;
    }

    @Override
    public String title(boolean isSingleMode) {
        if (isSingleMode) {
            return "Bar Chart - Single Mode";
        } else {
            return "Bar Chart - Compare Mode";
        }
    }

    private void setColor(Graphics graphics, boolean isSingleMode, int width) {
        if (isSingleMode) {
            graphics.setColor(Color.RED);
            graphics.fillRect(100, 90, width - 200, 420);
        } else {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(95, 95, 210, 210);
        }
    }

    private void setHeader(Graphics graphics, boolean isSingleMode) {
        String[] barChartTitle;
        if (isSingleMode) {
            barChartTitle = new String[1];
            barChartTitle[0] = "Bar Chart";
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
            barChartTitle = new String[2];
            barChartTitle[0] = "Bar Chart";
            barChartTitle[1] = "Small";
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

    @Override
    public void draw(Graphics graphics, boolean isSingleMode, int width, int height) {
        setColor(graphics, isSingleMode, width);
        setHeader(graphics, isSingleMode);
    }
}
