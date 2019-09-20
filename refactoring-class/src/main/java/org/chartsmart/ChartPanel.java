package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPanel extends JPanel {

    private static final String SHARED_DISPLAY = "shareddisplay";
    private static final int BAR_CHART = 406;
    private static final String SINGLE_MODE = "rpfll";
    private String chartMode;
    private String title;
    private int chartType;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        setChartTitle();
    }

    private void setChartTitle() {
        if (chartType == BAR_CHART) {
            setBarChartTitle();
        } else {
            setPieChartTitle();
        }
    }

    String getTitle() {
        return title;
    }

    public void showChart(int chartType, String chartMode, boolean shouldDraw) {
        this.chartType = chartType;
        this.chartMode = chartMode;
        if (shouldDraw) {
            initializeDrawArea();
        }
    }

    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics graphics) {
        renderChartBackground(graphics);
        renderChart(graphics);
    }

    private void renderChartBackground(Graphics graphics) {
        if (chartType == BAR_CHART) {
            renderBarChartBackground(graphics);
        } else {
            renderPieChartBackground(graphics);
        }
    }

    private void renderChart(Graphics graphics) {
        if (chartType == BAR_CHART) {
            new BarChart().renderBarChart(graphics, chartMode, SINGLE_MODE, SHARED_DISPLAY);
        } else {
            renderPieChart(graphics);
        }
    }

    private void setBarChartTitle() {
        if (chartMode.equals(SINGLE_MODE)) {
            title = "Bar Chart - Single Mode";
        } else {
            title = "Bar Chart - Compare Mode";
        }
    }

    private void renderBarChartBackground(Graphics graphics) {
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.RED);
            graphics.fillRect(100, 90, getWidth() - 200, 420);
        } else {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(95, 95, 210, 210);
        }
    }

    private void setPieChartTitle() {
        if (chartMode.equals(SINGLE_MODE)) {
            title = "Pie Chart - Single Mode";
        } else {
            title = "Pie Chart - Compare Mode";
        }
    }

    private void renderPieChartBackground(Graphics graphics) {
        if (chartMode.equals(SINGLE_MODE)) {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 450, getHeight() - 150);
        } else {
            graphics.setColor(Color.BLUE);
            graphics.fillOval(100, 100, 225, 225);
        }
    }

    private void renderPieChart(Graphics graphics) {
        String[] pieTitle = new String[0];
        List<String> pieTitle2 = new ArrayList<>();
        if (chartMode.equals(SINGLE_MODE)) {
            pieTitle2.add("Pie Chart");
        } else {
            pieTitle = new String[2];
            pieTitle[1] = "Small";
            pieTitle[0] = "Pie Chart";
        }
        if (chartMode.equals(SINGLE_MODE)) {
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
