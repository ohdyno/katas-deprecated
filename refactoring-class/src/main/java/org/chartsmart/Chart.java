package org.chartsmart;

import java.awt.*;

public interface Chart {
    String SINGLE_MODE = "rpfll";

    void renderChart(Graphics graphics);

    void renderChartBackground(Graphics graphics, int width, int height);

    String getTitle();
}
