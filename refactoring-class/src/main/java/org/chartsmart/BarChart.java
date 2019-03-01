package org.chartsmart;

import java.awt.*;

public class BarChart {
    String title(boolean isSingleMode) {
        if (isSingleMode) {
            return "Bar Chart - Single Mode";
        } else {
            return "Bar Chart - Compare Mode";
        }
    }

    void setBarChartColor(Graphics graphics, boolean isSingleMode, int width) {
        if (isSingleMode) {
            graphics.setColor(Color.RED);
            graphics.fillRect(100, 90, width - 200, 420);
        } else {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(95, 95, 210, 210);
        }
    }
}
