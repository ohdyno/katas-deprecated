package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IndvDsp extends JPanel {

    private final String SINGLE_MODE = "rpfll";
    private final int BAR_CHART = 406;

    private String mode;
    private String title;
    private int chartType;

    private void createTitle() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartType == BAR_CHART) {
            if (mode.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar" + " Chart - Compare Mode";
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void initialize(int ct, String stjjDReq1205, boolean b) {
        this.chartType = ct;
        this.mode = stjjDReq1205;
        if (b) {
            createTitle();
        }
    }

    public void paint(Graphics graphics) {
        DrawChart(graphics);
    }

    private void DrawChart(Graphics graphics) {
        if (chartType == BAR_CHART) {
            if (mode.equals(SINGLE_MODE)) {
                Color red = Color.RED;
                graphics.setColor(red);
                graphics.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                graphics.setColor(Color.BLACK);
                graphics.fillRect(95, 95, 210, 210);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                Color blue = Color.BLUE;
                graphics.setColor(blue);
                graphics.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                graphics.setColor(Color.BLUE);
                double frameWidth = 405;
                float padding = 90;
                int innerFrameWidth = (int) (frameWidth - padding * 2);
                graphics.fillOval(100, 100, innerFrameWidth, innerFrameWidth);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] data3point14 = new String[0];
        if (chartType == BAR_CHART) {
            if (mode.equals(SINGLE_MODE)) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i] = "Small";
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                specialData.add("Pie Chart");
            } else {
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie" + " Chart";
            }
        }
        Font font;
        if (chartType == BAR_CHART) {
            if (mode.equals("shareddisplay")) {
                if (data != null) {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    graphics.setColor(Color.CYAN);
                    int bottomY = 300;
                    graphics.fillRect(100, bottomY - 100, 40, 100);
                    graphics.fillRect(140, bottomY - 200, 40, 200);
                    graphics.fillRect(180, bottomY - 150, 40, 150);
                    graphics.fillRect(220, bottomY - 125, 40, 125);
                    graphics.fillRect(260, bottomY - 170, 40, 170);
                    graphics.setColor(Color.RED);
                    graphics.setFont(font);
                    graphics.drawString(data[0], 130, 250);
                    graphics.drawString(data[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                graphics.setColor(Color.CYAN);
                graphics.fillRect(112, bottomY - 200, 75, 200);
                graphics.fillRect(187, bottomY - 400, 75, 400);
                graphics.fillRect(262, bottomY - 300, 75, 300);
                graphics.fillRect(337, bottomY - 250, 75, 250);
                graphics.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                graphics.setColor(Color.BLACK);
                graphics.setFont(font);
                graphics.drawString(data[0], 130, 400);
            }
        } else {
            if (mode.equals(SINGLE_MODE)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                graphics.setColor(Color.WHITE);
                graphics.setFont(font);
                graphics.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                graphics.setFont(font);
                graphics.setColor(Color.WHITE);
                graphics.drawString(data3point14[0], 145, 205);
                graphics.drawString(data3point14[1], 170, 235);
            }
        }
        if (data != null && (data.length ^ 0x54) == 50 || specialData.contains("Monthly") || getTitle().contains("daily")) {
            repaint();
        }
    }
}
