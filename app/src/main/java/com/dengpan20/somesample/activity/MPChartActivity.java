package com.dengpan20.somesample.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.base.BaseActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MPChartActivity extends BaseActivity {

    private final String[] section =new String[]{
            "SC\n160","SC\n165","SC\n170","SC\n175","SC\n180",
    };

    CombinedChart chart1,chart3;
    BarChart chart2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpchart);
        chart1 = findViewById(R.id.chart1);
        chart2 = findViewById(R.id.chart2);
        chart3 = findViewById(R.id.chart3);

        initChart1();
        initChart2();
        initChart3();
    }

    private void initChart1() {
        chart1.getDescription().setEnabled(false);
        chart1.setBackgroundColor(Color.WHITE);
        chart1.setDragEnabled(false);
        chart1.setHighlightFullBarEnabled(false);
        chart1.setDrawGridBackground(false);
        chart1.setScaleEnabled(false);


        YAxis rightAxis = chart1.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        rightAxis.setLabelCount(5);
        rightAxis.setAxisMaximum(100);
        rightAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return (int)value+"";
            }
        });

        YAxis leftAxis = chart1.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        leftAxis.setAxisMaximum(250f);


        XAxis xAxis = chart1.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
//        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {

//                LogUtil.logI("value = ",value+"");
                if(value == 0 ||value==12){
                    return "";
                }
                if(value%2==0){
                    return section[((int) (value/2)-1)];
                }else {
                    return "";
                }
//                return section[(int) value % section.length];
            }
        });
        xAxis.setLabelCount(12);
        xAxis.setAxisMaximum(12f);
        xAxis.setAxisMinimum(0f);



        CombinedData data = new CombinedData();
        data.setData(getChart1LineData());
        data.setData(getChart1BarData());
        chart1.setData(data);
        chart1.invalidate();
    }

    private BarData getChart3BarData() {
        BarDataSet set;
        set = new BarDataSet(barEntries,"数量");
        set.setColor(Color.BLUE);
        BarData barData = new BarData();
        barData.setBarWidth(0.5f);
        barData.addDataSet(set);
        return barData;
    }

    private List<BarEntry> barEntries = new ArrayList<>();
    private LineData getChart3LineData() {
        List<Entry> entries = new ArrayList<>();
        for (int i=1;i<31;i++){
            float num = (float) Math.random()*100;
            Entry entity = new Entry(i,(float)num);
            BarEntry barEntry = new BarEntry(i,num);
            entries.add(entity);
            barEntries.add(barEntry);
        }
//        chart3.getXAxis().setLabelCount(30,false);
//        chart3.getXAxis().setAxisMaximum(31f);
        LineDataSet set = new LineDataSet(entries,"");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));
        LineData lineData = new LineData();
        lineData.addDataSet(set);
        return lineData;
    }

    private LineData getChart1LineData() {
        LineData lineData = new LineData();
        ArrayList<Entry> entries = new ArrayList<>();
        Entry entity = new Entry(2f,(float) 60);
        Entry entity1 = new Entry(4f,(float) 50);
        Entry entity2= new Entry(6f,(float) 90);
        Entry entity3 = new Entry(8f,(float) 50);
        Entry entity4 = new Entry(10f,(float) 20);
        entries.add(entity);
        entries.add(entity1);
        entries.add(entity2);
        entries.add(entity3);
        entries.add(entity4);


        LineDataSet set= new LineDataSet(entries,"正确率");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.RIGHT);
        lineData.addDataSet(set);
        return lineData;
    }

    private BarData getChart1BarData() {
        List<BarEntry> barEntries = new ArrayList<>();
        BarEntry entry1 = new BarEntry(2f,(float) 60);
        BarEntry entry2 = new BarEntry(4f,(float) 160);
        BarEntry entry3 = new BarEntry(6f,(float) 250);
        BarEntry entry4 = new BarEntry(8f,(float) 100);
        BarEntry entry5 = new BarEntry(10f,(float) 200);
        barEntries.add(entry1);
        barEntries.add(entry2);
        barEntries.add(entry3);
        barEntries.add(entry4);
        barEntries.add(entry5);
        BarDataSet set;
        set = new BarDataSet(barEntries,"数量");
        set.setColors(Color.BLUE);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        dataSets.add(set);
        BarData barData = new BarData(dataSets);
        barData.setBarWidth(1f);
        CombinedData data = new CombinedData();
        data.setHighlightEnabled(false);
        data.setData(barData);
        return barData;
    }

    private void initChart2() {

        chart2.getDescription().setEnabled(false);
        chart2.setDragEnabled(true);
        chart2.setScaleEnabled(false);
        chart2.getLegend().setEnabled(false);

        chart2.setDrawGridBackground(false);
        XAxis xAxis = chart2.getXAxis();
        xAxis.setAxisMinimum(0);
        chart2.getXAxis().setDrawGridLines(false);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceMin(0.2f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
//                String valueStr = value+"";
//                String[] split = valueStr.split(".");
//                if(split == null || split.length ==0) return "";
//                if(split[1].equals("0")){
//                    return valueStr;
//                }else {
//                    return "";
//                }
                return (int)value+"";
            }
        });
        xAxis.setDrawGridLines(false);

        YAxis axisRight = chart2.getAxisRight();

        axisRight.setEnabled(false);
        axisRight.setDrawGridLines(false);

        YAxis axisLeft = chart2.getAxisLeft();
        axisLeft.setAxisMinimum(100);
        axisLeft.setAxisMinimum(0);
        axisLeft.setLabelCount(5);
        xAxis.setDrawGridLines(false);


        chart2.getViewPortHandler().getMatrixTouch().postScale(2f, 1f);
        chart2.setData(getChart2Data());
        chart2.invalidate();

    }

    private BarData getChart2Data() {
        BarData barData = new BarData();
        List<BarEntry> entries  = new ArrayList<>();

        for (int i =0 ;i<15;i++){
            float num = (float) (Math.random()*100f);
            BarEntry entry = new BarEntry((i+1),new float[]{num,100-num});
            entries.add(entry);
        }
//        chart2.getXAxis().setLabelCount(16);
        BarDataSet barDataSet;
        barDataSet = new BarDataSet(entries,null);
        barDataSet.setDrawIcons(false);
        barDataSet.setColors(new int[]{Color.BLUE,Color.GRAY});
        barData.setBarWidth(0.5f);
//        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
//        dataSets.add(barDataSet);
        barData.addDataSet(barDataSet);

        return barData;
    }

    private void initChart3() {
        chart3.getDescription().setEnabled(false);
        chart3.setBackgroundColor(Color.WHITE);
        chart3.setDragEnabled(true);
        chart3.setHighlightFullBarEnabled(false);
        chart3.setDrawGridBackground(false);
        chart3.setScaleEnabled(false);

        YAxis rightAxis = chart3.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setEnabled(false);
        YAxis axisLeft = chart3.getAxisLeft();
        axisLeft.setAxisMaximum(100);
        axisLeft.setAxisMinimum(0);
        axisLeft.setLabelCount(5);
        XAxis xAxis = chart3.getXAxis();
        xAxis.setAxisMinimum(0);
        xAxis.setSpaceMin(0.2f);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                String valueStr = value+"";
                String[] split = valueStr.split(".");
//                if(split == null || split.length ==0) return ".";
//                if(split[1].equals("0")){
//                    return valueStr;
//                }else {
//                    return "";
//                }
                boolean isNum = (value % 1f > 0);


                if(!isNum){
                    Log.d("===x=",value+" int value = "+(int)value+"");

                    return valueStr;
                }else {
                    return "";
                }
//                return value+"";
//                LogUtil.logI("value = ",value+"");
//                if(value == 0 ||value==12){
//                    return "";
//                }
//                if(value%2==0){
//                    return section[((int) (value/2)-1)];
//                }else {
//                    return "";
//                }
//                return section[(int) value % section.length];
            }
        });

        CombinedData data = new CombinedData();
        data.setData(getChart3LineData());
        data.setData(getChart3BarData());
        chart3.getViewPortHandler().getMatrixTouch().postScale(4f, 1f);

        chart3.setData(data);
        chart3.invalidate();

    }
    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }

    public boolean isNum(String num){
        return  Pattern.matches("-?[0-9]*(\\.?)[0-9]*",num);
    }
}
