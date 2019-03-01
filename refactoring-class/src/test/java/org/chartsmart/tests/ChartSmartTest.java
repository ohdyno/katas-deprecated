package org.chartsmart.tests;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.ChartDrawer;
import org.chartsmart.MainWindow;
import org.junit.Test;

@UseReporter(DelayedClipboardReporter.class)
public class ChartSmartTest {
    @Test
    public void testRun() {
        MainWindow chartSmart = new MainWindow();
        Approvals.verify(chartSmart);
    }

    @Test
    public void testBarChart() {
        ChartDrawer cw = new ChartDrawer();
        cw.initializeChart(406, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testBarChartCompare() {
        ChartDrawer cw = new ChartDrawer();
        cw.initializeChart(406, "shareddisplay", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChart() {
        ChartDrawer cw = new ChartDrawer();
        cw.initializeChart(323, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChartCompare() {
        ChartDrawer cw = new ChartDrawer();
        cw.initializeChart(323, "shareddisplay", true);
        Approvals.verify(cw);
    }
}
