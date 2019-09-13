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

    private void renderChart(Graphics graphics) {
        if (chartType == BAR_CHART) {
            renderBarChart(graphics);
        } else {
            renderPieChart(graphics);
        }
    }

    private void renderChartBackground(Graphics graphics) {
        if (chartType == BAR_CHART) {
            renderBarChartBackground(graphics);
        } else {
            renderPieChartBackground(graphics);
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

    private void renderBarChart(Graphics graphics) {
        String[] barTitle;
        if (chartMode.equals(SINGLE_MODE)) {
            barTitle = new String[1];
            barTitle[0] = "Bar Chart";
        } else {
            barTitle = new String[2];
            barTitle[0] = "Bar Chart";
            barTitle[1] = "Small";
        }
        if (chartMode.equals(SHARED_DISPLAY)) {
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
        } else {
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
