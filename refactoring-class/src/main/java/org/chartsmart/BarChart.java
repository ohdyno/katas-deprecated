package org.chartsmart;

public class BarChart {
    String title(boolean isSingleMode) {
        if (isSingleMode) {
            return "Bar Chart - Single Mode";
        } else {
            return "Bar Chart - Compare Mode";
        }
    }
}
