package org.chartsmart;

import java.awt.*;

public class BarChart {
    void renderChart(Graphics graphics, String chartMode, String singleMode) {
        String[] barTitle;
        if (chartMode.equals(singleMode)) {
            barTitle = new String[1];
            barTitle[0] = "Bar Chart";
        } else {
            barTitle = new String[2];
            barTitle[0] = "Bar Chart";
            barTitle[1] = "Small";
        }
        if (chartMode.equals(singleMode)) {
            int bottomY = 500;
            graphics.setColor(Color.CYAN);
            graphics.fillRect(112, bottomY - 200, 75, 200);
            graphics.fillRect(187, bottomY - 400, 75, 400);
            graphics.fillRect(262, bottomY - 300, 75, 300);
            graphics.fillRect(337, bottomY - 250, 75, 250);
            graphics.fillRect(412, bottomY - 340, 75, 340);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 55));
            graphics.drawString(barTitle[0], 130, 400);
        } else {
            graphics.setColor(Color.CYAN);
            int bottomY = 300;
            graphics.fillRect(100, bottomY - 100, 40, 100);
            graphics.fillRect(140, bottomY - 200, 40, 200);
            graphics.fillRect(180, bottomY - 150, 40, 150);
            graphics.fillRect(220, bottomY - 125, 40, 125);
            graphics.fillRect(260, bottomY - 170, 40, 170);
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Arial Black", Font.BOLD, 25));
            graphics.drawString(barTitle[0], 130, 250);
            graphics.drawString(barTitle[1], 130, 270);
        }
    }
}
