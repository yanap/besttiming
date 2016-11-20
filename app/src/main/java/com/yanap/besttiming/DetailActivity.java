package com.yanap.besttiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static android.R.attr.data;

public class DetailActivity extends AppCompatActivity {

    protected BarChart mChart;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        createBarChart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mToolBar.setTitle("BEST TIMING");

        mToolBar.setNavigationIcon(R.mipmap.ic_back);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }

    private void createBarChart() {

        BarChart barChart = (BarChart) findViewById(R.id.bar_chart);
        barChart.setDescription("ベストタイミング率");

        barChart.getAxisRight().setEnabled(false);
        barChart.getAxisLeft().setEnabled(true);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(false);
        barChart.setEnabled(true);

        barChart.setTouchEnabled(true);
        barChart.setPinchZoom(true);
        barChart.setDoubleTapToZoomEnabled(true);

        barChart.setDrawHighlightArrow(true);

        barChart.setScaleEnabled(true);

        barChart.getLegend().setEnabled(true);

//X軸周り
        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setSpaceBetweenLabels(0);

        ArrayList<IBarDataSet> barDataSets = new ArrayList<IBarDataSet>();

        // X軸
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("1月");
        xValues.add("2月");
        xValues.add("3月");
        xValues.add("4月");
        xValues.add("5月");
        xValues.add("6月");

        // valueA
        ArrayList<BarEntry> valuesA = new ArrayList<>();
        valuesA.add(new BarEntry(100, 0));
        valuesA.add(new BarEntry(200, 1));
        valuesA.add(new BarEntry(300, 2));
        valuesA.add(new BarEntry(400, 3));
        valuesA.add(new BarEntry(500, 4));
        valuesA.add(new BarEntry(600, 5));

        BarDataSet valuesADataSet = new BarDataSet(valuesA, "A");
        valuesADataSet.setColor(ColorTemplate.COLORFUL_COLORS[3]);

        barDataSets.add(valuesADataSet);

        // valueB
        ArrayList<BarEntry> valuesB = new ArrayList<>();
        valuesB.add(new BarEntry(200, 0));
        valuesB.add(new BarEntry(300, 1));
        valuesB.add(new BarEntry(400, 2));
        valuesB.add(new BarEntry(500, 3));
        valuesB.add(new BarEntry(600, 4));
        valuesB.add(new BarEntry(700, 5));

        BarDataSet valuesBDataSet = new BarDataSet(valuesB, "B");
        valuesBDataSet.setColor(ColorTemplate.COLORFUL_COLORS[4]);

        barDataSets.add(valuesBDataSet);

        BarData barData = new BarData(xValues, barDataSets);

        barChart.setData(barData);

        barChart.invalidate();
        // アニメーション
        barChart.animateY(2000, Easing.EasingOption.EaseInBack);

    }

}
