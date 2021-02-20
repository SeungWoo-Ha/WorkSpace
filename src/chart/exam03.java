package chart;

import javafx.application.Application;
import sun.misc.CharacterEncoder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.BasicStroke;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.category.BarRenderer;
public class exam03 {

    public exam03() {}
  
    // getChart() 메서드. Chart 를 만들어서 리턴함
    public JFreeChart getChart() {
    	
        JFreeChart chart = ChartFactory.createBarChart("The RainFall Distribution on Seoul in 2016", 
                                "Month", "Rainfall(ml)", getDataSet(), PlotOrientation.VERTICAL, 
                                true, true, false); 
        chart.setBackgroundPaint(Color.WHITE);
        chart.setBorderVisible(true);
        chart.setBorderPaint(Color.BLACK);
        chart.setBorderStroke(new BasicStroke(2));
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);   
        plot.setRangeGridlinePaint(Color.YELLOW);     
        plot.setDomainGridlinesVisible(false);     
        CategoryAxis axis = plot.getDomainAxis(); 
        axis.setLowerMargin(0.03);
        axis.setUpperMargin(0.03); 
        axis.setCategoryLabelPositions
        (CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.YELLOW,   0.0f, 0.0f, new Color(210, 210, 100));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(100, 255, 100));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        return chart;
    }

    // getDataSet() 메서드. dataset 을 만들어서 리턴함 - getChart() 내에서 사용
    private DefaultCategoryDataset getDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        String ml = "Rainfall Volume(ml)";
        String day = "Rainy Days(day)";
        String mon1 = "Jan";
        String mon2 = "Feb";
        String mon3 = "Mar";
        String mon4 = "Apr";
        String mon5 = "May";
        String mon6 = "Jun";
        String mon7 = "Jul";
        String mon8 = "Aug";
        String mon9 = "Sep";
        String mon10 = "Oct";
        String mon11 = "Nov";
        String mon12 = "Dec";
      
        // addValue() 메서드를 이용해서 값을 추가함
        dataSet.addValue(1, ml, mon1);
        dataSet.addValue(47.6, ml, mon2);
        dataSet.addValue(40.5, ml, mon3);
        dataSet.addValue(76.8, ml, mon4);
        dataSet.addValue(160.5, ml, mon5);
        dataSet.addValue(54.4, ml, mon6);
        dataSet.addValue(358.2, ml, mon7);
        dataSet.addValue(67.1, ml, mon8);
        dataSet.addValue(33, ml, mon9);
        dataSet.addValue(74.8, ml, mon10);
        dataSet.addValue(16.7, ml, mon11);
        dataSet.addValue(61.1, ml, mon12);
        // addValue() 메서드를 이용해서 값을 추가함
        dataSet.addValue(4, day, mon1);
        dataSet.addValue(8, day, mon2);
        dataSet.addValue(5, day, mon3);
        dataSet.addValue(10, day, mon4);
        dataSet.addValue(9, day, mon5);
        dataSet.addValue(8, day, mon6);
        dataSet.addValue(17, day, mon7);
        dataSet.addValue(11, day, mon8);
        dataSet.addValue(7, day, mon9);
        dataSet.addValue(9, day, mon10);
        dataSet.addValue(11, day, mon11);
        dataSet.addValue(10, day, mon12);
        return dataSet;
    }  
  
    // 메인 메서드. 챠트 프레임을 보여줌
    public static void main(String[] args) {
        JFreeChart chart = new exam03().getChart();
        ChartFrame cf = new ChartFrame("[미래웨더]날씨 통계 데이터 시각화 프로그램 - RainFall visualizer", chart);
        cf.setSize(400, 400);
        cf.setVisible(true);
    }
}
