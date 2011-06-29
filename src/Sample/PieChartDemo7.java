package Sample;

//package org.jfree.chart.demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;



/**
 * A demo showing four pie charts.
 */
public class PieChartDemo7 extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     * 
     * @param title  the frame title.
     */
    public PieChartDemo7(String title) {

        super(title);
        JPanel panel = new JPanel(new GridLayout(2, 4));
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Section 1", 20  );
        dataset.setValue("Section 2", 20);
        dataset.setValue("Section 3", 20);
        dataset.setValue("Section 4", 20);
        dataset.setValue("Section 5",20);
        //dataset.setValue("Section 6",20);
        //dataset.setValue("Section 8",20);
        
        
        JFreeChart chart1 = ChartFactory.createPieChart("Chart 1", dataset, false, false, false);
        JFreeChart chart2 = ChartFactory.createPieChart("Chart 2", dataset, false, false, false);
        PiePlot plot2 = (PiePlot) chart2.getPlot();
        plot2.setCircular(false);
        JFreeChart chart3 = ChartFactory.createPieChart3D("Chart 3", dataset, false, false, false);
        PiePlot3D plot3 = (PiePlot3D) chart3.getPlot();
        plot3.setForegroundAlpha(0.6f);
        plot3.setCircular(true);
        JFreeChart chart4 = ChartFactory.createPieChart3D("Chart 4", dataset, true, true, true);
        PiePlot3D plot4 = (PiePlot3D) chart4.getPlot();
        plot4.setForegroundAlpha(0.9f);
        
        //JFreeChart chart5=ChartFactory.createPieChart3D("Chart 5",dataset,true,true,true);
        //PiePlot3D plot5=(PiePlot3D) chart5.getPlot();
        //plot5.setForegroundAlpha(0.6f);
        
        panel.add(new ChartPanel(chart1));
        panel.add(new ChartPanel(chart2));
        panel.add(new ChartPanel(chart3));
        panel.add(new ChartPanel(chart4));
        panel.setBackground(Color.BLUE);

        panel.setPreferredSize(new Dimension(800, 600));
        setContentPane(panel);

    }

    /**
     * The starting point for the demo.
     * 
     * @param args  ignored.
     */
    public static void main(String[] args) {
        PieChartDemo7 demo = new PieChartDemo7("Pie Chart Demo 7");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
