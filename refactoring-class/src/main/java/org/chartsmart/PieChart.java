package org.chartsmart;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PieChart {
    void renderChart(Graphics graphics, String chartMode, String singleMode) {
        String[] pieTitle = new String[0];
        List<String> pieTitle2 = new ArrayList<>();
        if (chartMode.equals(singleMode)) {
            pieTitle2.add("Pie Chart");
        } else {
            pieTitle = new String[2];
            pieTitle[1] = "Small";
            pieTitle[0] = "Pie Chart";
        }
        if (chartMode.equals(singleMode)) {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            graphics.drawString(pieTitle2.get(0), 200, 340);
        } else {
            graphics.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            graphics.setColor(Color.WHITE);
            graphics.drawString(pieTitle[0], 145, 205);
            graphics.drawString(pieTitle[1], 170, 235);
        }
    }
}
