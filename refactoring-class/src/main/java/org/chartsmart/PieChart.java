package org.chartsmart;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PieChart {
    String title(boolean isSingleMode) {
        if (isSingleMode) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }

    private void setPieChartHeader(Graphics graphics, boolean isSingleMode) {
        List<String> largePieChartTitle = new ArrayList<>();
        String[] smallPieChartTitle = new String[0];
        if (isSingleMode) {
            largePieChartTitle.add("Pie Chart");
        } else {
            smallPieChartTitle = new String[2];
            smallPieChartTitle[1] = "Small";
            smallPieChartTitle[0] = "Pie Chart";
        }
        if (isSingleMode) {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            graphics.drawString(largePieChartTitle.get(0), 200, 340);
        } else {
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            graphics.setColor(Color.WHITE);
            graphics.drawString(smallPieChartTitle[0], 145, 205);
            graphics.drawString(smallPieChartTitle[1], 170, 235);
        }
    }

    private void setPieChartColor(Graphics graphics, boolean isSingleMode, int height) {
        if (isSingleMode) {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 450, height - 150);
        } else {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 225, 225);
        }
    }

    void drawPieChart(Graphics graphics, boolean isSingleMode, int height) {
        setPieChartColor(graphics, isSingleMode, height);
        setPieChartHeader(graphics, isSingleMode);
    }
}
