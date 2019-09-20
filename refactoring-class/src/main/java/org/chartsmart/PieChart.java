package org.chartsmart;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PieChart implements Chart {
    private String chartMode;

    public PieChart(String chartMode) {
        this.chartMode = chartMode;
    }

    public void renderChart(Graphics graphics) {
        String[] pieTitle = new String[0];
        List<String> pieTitle2 = new ArrayList<>();
        if (chartMode.equals(Chart.SINGLE_MODE)) {
            pieTitle2.add("Pie Chart");
        } else {
            pieTitle = new String[2];
            pieTitle[1] = "Small";
            pieTitle[0] = "Pie Chart";
        }
        if (chartMode.equals(Chart.SINGLE_MODE)) {
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

    public void renderChartBackground(Graphics graphics, int width, int height) {
        if (chartMode.equals(Chart.SINGLE_MODE)) {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 450, height - 150);
        } else {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 225, 225);
        }
    }

    public String getTitle() {
        String title;
        if (chartMode.equals(Chart.SINGLE_MODE)) {
            title = "Pie Chart - Single Mode";
        } else {
            title = "Pie Chart - Compare Mode";
        }
        return title;
    }
}
