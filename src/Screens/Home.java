package Screens;

import ChartTable.Chart;
import ChartTable.InitialChart;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Home extends JFrame{
    private JPanel myPanel;
    private JButton homeToBottle;
    private JButton homeToGoal;
    private JPanel barChartPanel;
    private JPanel lineChartPanel;
    private JButton refreshButton;
    private JPanel barChartDayPanel;
    private JPanel pieChartPanel;

    public Home(String title){
        super(title);
        setContentPane(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homeToBottle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Home.super.dispose();
                JFrame bottles = new Bottles("Bottles");
                bottles.setVisible(true);
                bottles.pack();
            };
        });

        homeToGoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Home.super.dispose();
                JFrame goals = new Goals("Personal Goals");
                goals.setVisible(true);
                goals.pack();
            };
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitialChart.setDataset();
                Home.super.dispose();
                JFrame home = new Home("D2 project V1.0_0311");
                home.setVisible(true);
                home.pack();
            }
        });
    }

    private void createUIComponents() {
        Chart newBarChart = new Chart("Amount each hour in past 24h");
        JFreeChart barChart = ChartFactory.createBarChart(
                newBarChart.getChartTitle(),
                null,
                "Weight",
                InitialChart.getBarChartDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        barChartPanel = new ChartPanel(barChart);
        barChartPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        Chart newLineChart = new Chart("Cumulative amount in past 24h");
        JFreeChart lineChart = ChartFactory.createLineChart(
                newLineChart.getChartTitle(),
                null,
                "Weight",
                InitialChart.getLineChartDataset(),
                PlotOrientation.VERTICAL,
                false,true,false);
        lineChartPanel = new ChartPanel(lineChart);
        lineChartPanel.setPreferredSize( new java.awt.Dimension(700, 500));

        Chart newBarChartDay = new Chart("Amount each day in past 7");
        /*JFreeChart barChartDay = ChartFactory.createBarChart(
                newBarChartDay.getChartTitle(),
                null,
                "Weight",
                InitialChart.getBarChartDayDataset(),
                PlotOrientation.VERTICAL,
                false, true, false){

        }*/
        //barChartDayPanel = new ChartPanel(barChartDay);
        barChartDayPanel = new ChartPanel(createChart(newBarChartDay));
        barChartDayPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        Chart newPieChart = new Chart("Each Day Goal");
        JFreeChart pieChart = ChartFactory.createPieChart(
                newPieChart.getChartTitle(),
                InitialChart.getPieChartDataset(),
                true, true, false);
        pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new java.awt.Dimension(700, 500));

    }

    private JFreeChart createChart(Chart x){
        JFreeChart barChartDay = ChartFactory.createBarChart(
                x.getChartTitle(),
                null,
                "Weight",
                InitialChart.getBarChartDayDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        CategoryPlot categoryPlot = (CategoryPlot) barChartDay.getPlot();
        categoryPlot.setDataset(1,InitialChart.getLineBase());
        //BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
        //barRenderer.setMaximumBarWidth(0.5f);
                //categoryPlot.mapDatasetToRangeAxes(1,1);
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        lineAndShapeRenderer.setShapesVisible(false);
        lineAndShapeRenderer.setLinesVisible(true);
        lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {30F, 12F}, 0.0F));
        lineAndShapeRenderer.setSeriesShape(0, new Ellipse2D.Double(-2D,-2D,4D,4D));
        categoryPlot.setRenderer(1,lineAndShapeRenderer);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        return barChartDay;
    }
}
