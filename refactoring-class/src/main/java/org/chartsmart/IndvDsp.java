package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IndvDsp extends JPanel {

    private final int BAR_CHART = 406;
    private final String SINGLE_MODE = "rpfll";
    private String chartMode;
    private String title;
    private int chartType;

    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
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
        DrawChart(g);
    }

    private void DrawChart(Graphics g) {
        // Render chart background
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                Color bgc = Color.RED;
                g.setColor(bgc);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                Color color;
                color = Color.BLUE;
                g.setColor(color);
                g.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                g.setColor(Color.BLUE);
                g.fillOval(100, 100, 225, 225);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] pieTitle = new String[0];
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i++] = "Small";
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                specialData.add("Pie Chart");
            } else {
                pieTitle = new String[2];
                pieTitle[1] = "Small";
                pieTitle[0] = "Pie" + " Chart";
            }
        }
        Font font;
        if (chartType == BAR_CHART) {
            if (chartMode.equals("shareddisplay")) {
                if (data != null) {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, 40, 100);
                    g.fillRect(140, bottomY - 200, 40, 200);
                    g.fillRect(180, bottomY - 150, 40, 150);
                    g.fillRect(220, bottomY - 125, 40, 125);
                    g.fillRect(260, bottomY - 170, 40, 170);
                    g.setColor(Color.RED);
                    g.setFont(font);
                    g.drawString(data[0], 130, 250);
                    g.drawString(data[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                g.setColor(Color.CYAN);
                g.fillRect(112, bottomY - 200, 75, 200);
                g.fillRect(187, bottomY - 400, 75, 400);
                g.fillRect(262, bottomY - 300, 75, 300);
                g.fillRect(337, bottomY - 250, 75, 250);
                g.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString(data[0], 130, 400);
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                g.setFont(font);
                g.setColor(Color.WHITE);
                g.drawString(pieTitle[0], 145, 205);
                g.drawString(pieTitle[1], 170, 235);
            }
        }
    }
}
