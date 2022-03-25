package Screens;

import Charts.InitialBottles;
import Charts.InitialGoal;
import Charts.InitialChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Home extends JFrame {
    private JPanel myPanel;
    private JButton homeToBottle;
    private JButton homeToGoal;
    private JPanel barChartHourPanel;
    private JPanel lineChartPanel;
    private JButton refreshButton;
    private JPanel barChartDayPanel;
    private JPanel bottlesPanel;
    private JLabel todayGoalLabel;
    private JLabel alreadyDrankLabel;
    private JLabel amountLabel;
    private JPanel pieChartPanel;

    public Home(String title) {
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
            }

        });

        homeToGoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Home.super.dispose();
                JFrame goals = new Goals("Personal Goals");
                goals.setVisible(true);
                goals.pack();
            }

        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitialChart.setDataset();
                InitialBottles.setBottles();
                InitialGoal.setDataset();
                Home.super.dispose();
                JFrame home = new Home("D2 project V1.0_0311");
                home.setVisible(true);
                home.pack();
            }
        });

        alreadyDrankLabel.setText("Already drank:" + InitialGoal.getTodayFinished());
        amountLabel.setText("You need " + (int) Math.ceil(InitialChart.getEachDayGoal()/ InitialGoal.getCapacity()) + " bottles");
        todayGoalLabel.setText("Goal today: " + InitialChart.getEachDayGoal());
    }

    private void createUIComponents() {
        barChartHourPanel = new ChartPanel(creatEachHourChart());
        barChartHourPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        barChartDayPanel = new ChartPanel(createEachDayChart());
        barChartDayPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        bottlesPanel = new ChartPanel(creatBottlesChart());
        bottlesPanel.setPreferredSize(new java.awt.Dimension(1400, 500));
    }

    private JFreeChart creatEachHourChart(){
        JFreeChart barChartHour = ChartFactory.createBarChart(
                "Each hour in past 24",
                null,
                "Weight",
                InitialChart.getBarChartDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        return barChartHour;
    }

    private JFreeChart createEachDayChart() {
        JFreeChart barChartDay = ChartFactory.createBarChart(
                "Each day in past 7",
                null,
                "Weight",
                InitialChart.getBarChartDayDataset(),
                PlotOrientation.VERTICAL,
                false, false, false);
        CategoryPlot categoryPlot = (CategoryPlot) barChartDay.getPlot();
        categoryPlot.setDataset(1, InitialChart.getLineBase());
        //BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
        //barRenderer.setMaximumBarWidth(0.5f);
        //categoryPlot.mapDatasetToRangeAxes(1,1);
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        lineAndShapeRenderer.setShapesVisible(false);
        lineAndShapeRenderer.setLinesVisible(true);
        lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{30F, 12F}, 0.0F));
        lineAndShapeRenderer.setSeriesShape(0, new Ellipse2D.Double(-2D, -2D, 4D, 4D));
        categoryPlot.setRenderer(1, lineAndShapeRenderer);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        return barChartDay;
    }

    private JFreeChart creatBottlesChart() {
        JFreeChart bottlesChart = ChartFactory.createStackedBarChart(
                "",
                "",
                "Score",
                InitialGoal.getDataset(),
                PlotOrientation.VERTICAL,
                false, false, false);
        bottlesChart.setBackgroundPaint(Color.DARK_GRAY);
        CategoryPlot bottlesPlot = bottlesChart.getCategoryPlot();
        BarRenderer categoryItemRenderer = (BarRenderer) bottlesPlot.getRenderer();
        categoryItemRenderer.setShadowVisible(true);
        categoryItemRenderer.setBarPainter(new StandardBarPainter());
        bottlesPlot.getRenderer().setSeriesPaint(0, new Color(239, 70, 55));
        bottlesPlot.getRenderer().setSeriesPaint(1, new Color(0, 172, 178));
        bottlesPlot.setRangeGridlinesVisible(false);
        bottlesPlot.setBackgroundPaint(Color.DARK_GRAY);
        bottlesPlot.setOutlineVisible(false);
        bottlesPlot.getDomainAxis().setVisible(false);
        bottlesPlot.getRangeAxis().setVisible(false);
        bottlesPlot.getRangeAxis().setAutoRange(false);
        return bottlesChart;
    }
}