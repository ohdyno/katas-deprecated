package org.chartsmart;

import java.awt.*;

interface Chart {
    String SINGLE_MODE = "rpfll";
    int BAR_CHART = 406;

    void drawChart(Graphics graphics, int width, int height);

    String createTitle();
}
