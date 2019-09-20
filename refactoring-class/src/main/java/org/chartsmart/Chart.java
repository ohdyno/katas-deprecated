package org.chartsmart;

import java.awt.*;

public interface Chart {
    void renderChart(Graphics graphics, String chartMode, String singleMode);

    void renderChartBackground(Graphics graphics, String chartMode, String singleMode, int width);

    String setChartTitle(String chartMode, String singleMode);
}
