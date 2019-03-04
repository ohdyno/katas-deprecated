package org.chartsmart;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PieChart implements Chart {
    @Override
    public String title(boolean isSingleMode) {
        if (isSingleMode) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }

    private void setHeader(Graphics graphics, boolean isSingleMode) {
        List<String> largePieChartTitle = new ArrayList<>();
        String[] smallPieChartTitle = new String[0];
        if (isSingleMode) {
            largePieChartTitle.add("Pie Chart");
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            graphics.drawString(largePieChartTitle.get(0), 200, 340);

        } else {
            smallPieChartTitle = new String[2];
            smallPieChartTitle[1] = "Small";
            smallPieChartTitle[0] = "Pie Chart";
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            graphics.setColor(Color.WHITE);
            graphics.drawString(smallPieChartTitle[0], 145, 205);
            graphics.drawString(smallPieChartTitle[1], 170, 235);
        }
    }

    private void setColor(Graphics graphics, boolean isSingleMode, int height) {
        if (isSingleMode) {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 450, height - 150);
        } else {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 225, 225);
        }
    }

    @Override
    public void draw(Graphics graphics, boolean isSingleMode, int width, int height) {
        setColor(graphics, isSingleMode, height);
        setHeader(graphics, isSingleMode);
    }
}
