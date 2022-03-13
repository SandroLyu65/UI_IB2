package Screens;

import ChartTable.Chart;
import ChartTable.InitialChart;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

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
        JFreeChart barChartDay = ChartFactory.createBarChart(
                newBarChartDay.getChartTitle(),
                null,
                "Weight",
                InitialChart.getBarChartDayDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        barChartDayPanel = new ChartPanel(barChartDay);
        barChartDayPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        Chart newPieChart = new Chart("Each Day Goal");
        JFreeChart pieChart = ChartFactory.createPieChart(
                newPieChart.getChartTitle(),
                InitialChart.getPieChartDataset(),
                true, true, false);
        pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new java.awt.Dimension(700, 500));

    }
}
