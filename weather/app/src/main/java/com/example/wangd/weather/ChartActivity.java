package com.example.wangd.weather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    public LineChart chart;
    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //设置表格
        chart = findViewById(R.id.chart1);
        chart.getDescription().setEnabled(false);
        chart.setDrawGridBackground(false);

        // enable touch gestures
        chart.setTouchEnabled(true);

        chart.setDrawBorders(false);
        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.animateX(1500);
        //设置字体大小
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTextSize(12f);
        YAxis rightAxis =chart.getAxisRight();
        rightAxis.setTextSize(12f);

        XAxis xAxis1 = chart.getXAxis();
        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis1.setTextSize(10f);

        final String[] quarters = new String[] { "Q1", "Q2", "Q3", "Q4","Q5","Q6","Q7" };
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            float val = (float) (Math.random() * 100) + 3;
            values.add(new Entry(i, val));
        }
        LineDataSet set1 = new LineDataSet(values, "气温变化");
        set1.setLineWidth(1.25f);
        set1.setCircleRadius(3f);
        set1.setCircleHoleRadius(2.5f);
        set1.setColor(Color.BLUE);
        set1.setCircleColor(Color.BLUE);
        set1.setHighLightColor(Color.RED);
        set1.setValueTextSize(12f); //设置文字的大小
        chart.setData(new LineData(set1));
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-exitTime<=2000){
            super.onBackPressed();
        }else{
            exitTime=System.currentTimeMillis();
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
        }
    }
}
