package Screens;

import Initial.InitialBottles;
import Initial.InitialChart;
import Initial.InitialGoal;
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
    private JButton refreshButton;
    private JPanel barChartHourPanel;
    private JPanel lineChartPanel;
    private JButton homeToGoal;
    private JPanel barChartDayPanel;
    private JPanel bottlesPanel;
    private JLabel todayGoalLabel;
    private JLabel alreadyDrankLabel;
    private JLabel amountLabel;
    private JPanel pieChartPanel;
    private static final Font uiFont = new Font("Segoe UI",Font.BOLD,16);
    private static final Font x = new Font("Monospaced",1,16);
    public Home(String title) {
        super(title);
        setContentPane(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        amountLabel.setFont(x);
        todayGoalLabel.setFont(x);
        alreadyDrankLabel.setFont(x);
        homeToBottle.setFont(uiFont);
        homeToGoal.setFont(uiFont);
        refreshButton.setFont(uiFont);

        homeToBottle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Home.super.dispose();
                JFrame bottles = new Bottles("Bottles");
                String src = "./files/window.png";
                bottles.setIconImage(new ImageIcon(src).getImage());
                bottles.setVisible(true);
                bottles.pack();
                bottles.setLocationRelativeTo(null);
            }

        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InitialChart.setDataset();
                InitialBottles.setBottles();
                InitialGoal.setDataset();
                Home.super.dispose();
                JFrame home = new Home("D2 project V1.0_0311");
                home.setVisible(true);
                home.pack();
                home.setLocationRelativeTo(null);
                //home.setExtendedState(home.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }
        });

        homeToGoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.super.dispose();
                JFrame goals = new Goals("Personal Goals");
                String src = "./files/window.png";
                goals.setIconImage(new ImageIcon(src).getImage());
                goals.setVisible(true);
                goals.pack();
                goals.setLocationRelativeTo(null);
            }
        });

        alreadyDrankLabel.setText("Already drank:" + InitialGoal.getTodayFinished()+" L");
        amountLabel.setText("You need " + (int) Math.ceil(InitialChart.getEachDayGoal()/ InitialGoal.getCapacity()) + " bottles today");
        todayGoalLabel.setText("Goal today: " + InitialChart.getEachDayGoal()+" L");
    }

    private void createUIComponents() {
        barChartHourPanel = new ChartPanel(creatEachHourChart());
        barChartHourPanel.setPreferredSize(new java.awt.Dimension(350, 250));

        barChartDayPanel = new ChartPanel(createEachDayChart());
        barChartDayPanel.setPreferredSize(new java.awt.Dimension(350, 250));

        bottlesPanel = new ChartPanel(creatBottlesChart());
        bottlesPanel.setPreferredSize(new java.awt.Dimension(700, 350));
    }

    private JFreeChart creatEachHourChart(){
        JFreeChart barChartHour = ChartFactory.createBarChart(
                "Each hour in past 24",
                null,
                "Weight",
                InitialChart.getBarChartDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        barChartHour.setBackgroundPaint(new Color(237,238,237));

        CategoryPlot bottlesPlot = barChartHour.getCategoryPlot();

        BarRenderer barRenderer = (BarRenderer) bottlesPlot.getRenderer();
        barRenderer.setShadowVisible(true);
        barRenderer.setBarPainter(new StandardBarPainter());
        barRenderer.setMaximumBarWidth(0.5f);
        barRenderer.setSeriesPaint(0, new Color(239, 70, 55));
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
        barChartDay.setBackgroundPaint(new Color(237,238,237));

        CategoryPlot categoryPlot = (CategoryPlot) barChartDay.getPlot();
        categoryPlot.setDataset(1, InitialChart.getLineBase());

        BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
        barRenderer.setShadowVisible(true);
        barRenderer.setBarPainter(new StandardBarPainter());
        barRenderer.setMaximumBarWidth(0.5f);
        barRenderer.setSeriesPaint(0, new Color(239, 70, 55));

        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        lineAndShapeRenderer.setShapesVisible(false);
        lineAndShapeRenderer.setLinesVisible(true);
        lineAndShapeRenderer.setSeriesPaint(0, new Color(0, 172, 178));
        lineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[]{30F, 12F}, 0.0F));
        lineAndShapeRenderer.setSeriesShape(0, new Ellipse2D.Double(-2D, -2D, 4D, 4D));
        categoryPlot.setRenderer(1, lineAndShapeRenderer);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        return barChartDay;
    }

    private JFreeChart creatBottlesChart() {
        JFreeChart bottlesChart = ChartFactory.createStackedBarChart(
                "Compliance of Goal",
                "",
                "",
                InitialGoal.getDataset(),
                PlotOrientation.VERTICAL,
                false, false, false);
        bottlesChart.setBackgroundPaint(new Color(237,238,237));

        CategoryPlot bottlesPlot = bottlesChart.getCategoryPlot();

        BarRenderer barRenderer = (BarRenderer) bottlesPlot.getRenderer();
        barRenderer.setShadowVisible(true);
        barRenderer.setBarPainter(new StandardBarPainter());
        bottlesPlot.getRenderer().setSeriesPaint(0, new Color(239, 70, 55));
        bottlesPlot.getRenderer().setSeriesPaint(1, new Color(0, 172, 178));
        bottlesPlot.setRangeGridlinesVisible(false);
        bottlesPlot.setOutlineVisible(false);
        bottlesPlot.getDomainAxis().setVisible(false);
        bottlesPlot.getRangeAxis().setVisible(false);
        bottlesPlot.getRangeAxis().setAutoRange(false);
        return bottlesChart;
    }
}