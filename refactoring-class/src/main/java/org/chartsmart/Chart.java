package org.chartsmart;

import java.awt.*;

public interface Chart {

    String title(boolean isSingleMode);

    void draw(Graphics graphics, boolean isSingleMode, int width, int height);
}
