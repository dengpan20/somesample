package com.dengpan20.somesample.activity;

import android.graphics.Color;
import android.os.Bundle;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.base.BaseActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.formatter.ValueFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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


        YAxis rightAxis = chart1.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = chart1.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = chart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return section[(int) value % section.length];
            }
        });



        CombinedData data = new CombinedData();
        data.setData(getChart1LineData());
        data.setData(getChart1BarData());
        chart1.setData(data);
        chart1.invalidate();
    }

    private LineData getChart1LineData() {
        LineData lineData = new LineData();
        ArrayList<Entry> entries = new ArrayList<>();
        Entry entity = new Entry(1f,70f);
        Entry entity1 = new Entry(2f,60f);
        Entry entity2= new Entry(3f,50f);
        Entry entity3 = new Entry(4f,40f);
        Entry entity4 = new Entry(5f,30f);
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

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineData.addDataSet(set);
        return lineData;
    }

    private BarData getChart1BarData() {
        BarData barData = new BarData();
        ArrayList<BarEntry> entries = new ArrayList<>();
        BarEntry entity = new BarEntry(1f,70f);
        BarEntry entity1 = new BarEntry(2f,60f);
        BarEntry entity2= new BarEntry(3f,50f);
        BarEntry entity3 = new BarEntry(4f,40f);
        BarEntry entity4 = new BarEntry(5f,30f);
        entries.add(entity);
        entries.add(entity1);
        entries.add(entity2);
        entries.add(entity3);
        entries.add(entity4);


        BarDataSet set= new BarDataSet(entries,"正确率");
        set.setColor(Color.rgb(240, 238, 70));
        //设置lengen
//        set2.setStackLabels(new String[]{"Stack 1", "Stack 2"});
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        barData.addDataSet(set);
        barData.setBarWidth(1f);
        return barData;
    }

    private void initChart2() {

    }
    private void initChart3() {

    }
    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }
}
