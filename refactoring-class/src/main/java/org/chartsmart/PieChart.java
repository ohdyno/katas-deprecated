package org.chartsmart;

public class PieChart {
    String setPieChartTitle(boolean isSingleMode) {
        if (isSingleMode) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }
}
