package org.chartsmart;

import java.awt.*;

public interface Chart {

    String SINGLE_MODE = "rpfll";

    String title();

    void draw(Graphics graphics, int width, int height);
}
