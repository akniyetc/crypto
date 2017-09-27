package com.unionOfMiners.android.union.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.anastr.speedviewlib.AwesomeSpeedometer;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.unionOfMiners.android.union.PrefsApplication;
import com.unionOfMiners.android.union.R;
import com.unionOfMiners.android.union.currentHashRate.CurrentHashRate;
import com.unionOfMiners.android.union.currentHashRate.currentHistory.CurrentHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HP on 13.09.2017.
 */

public class GaugeViewFragment extends Fragment {
    private AwesomeSpeedometer speedometer;
    private LineChart lineChart;
    //ImageSpeedometer iSpeedometer;

    private TextView averHash, unpaid, actWork, validShares, unconfirmed;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gauge_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        iSpeedometer = (ImageSpeedometer) view.findViewById(R.id.speedometer);
//        ImageIndicator indicator = new ImageIndicator(getContext(), R.drawable.indicator);
//        iSpeedometer.setIndicator(indicator);
//        iSpeedometer.speedPercentTo(50);
//        iSpeedometer.speedTo(1500);]

        averHash = (TextView) view.findViewById(R.id.averHashRate);
        unpaid = (TextView) view.findViewById(R.id.unpaid);
        actWork = (TextView) view.findViewById(R.id.actWorkers);
        validShares = (TextView) view.findViewById(R.id.validShares);
        unconfirmed = (TextView) view.findViewById(R.id.unconfirmed);


        speedometer = (AwesomeSpeedometer) view.findViewById(R.id.awsSpedometer);
        lineChart = (LineChart) view.findViewById(R.id.chart_speed);
        getApiData();
        getHistoryDataFromApi();


    }

    public void getApiData() {
        PrefsApplication.get().getHashRateInterface().getCurrentHashRate()
                .enqueue(new Callback<CurrentHashRate>() {
                    @Override
                    public void onResponse(Call<CurrentHashRate> call, Response<CurrentHashRate> response) {
                        Log.d("hashRate", String.valueOf(response.body().getData().getCurrentHashrate()));
                        setSpeedometer(response.body());
                    }

                    @Override
                    public void onFailure(Call<CurrentHashRate> call, Throwable t) {
                        Log.d("errorM", String.valueOf(t));
                    }
                });
    }

    private void setSpeedometer(CurrentHashRate currentHashRate) {
        speedometer.speedTo((float) currentHashRate.getData().getCurrentHashrate());
        averHash.setText(String.format(Locale.getDefault(),"%.2f", currentHashRate.getData().getAverageHashrate()));
        unpaid.setText(String.valueOf(currentHashRate.getData().getUnpaid()));
        actWork.setText(String.valueOf(currentHashRate.getData().getActiveWorkers()));
        validShares.setText(String.valueOf(currentHashRate.getData().getValidShares()));
        unconfirmed.setText(String.valueOf(currentHashRate.getData().getUnconfirmed()));
    }

    private void getHistoryDataFromApi() {
        PrefsApplication.get().getHashRateInterface().getCurrentHistory().enqueue(new Callback<CurrentHistory>() {
            @Override
            public void onResponse(Call<CurrentHistory> call, Response<CurrentHistory> response) {
                Log.d("lololo",String.valueOf(response.body().getData().size()));
                getChart(response.body());
            }

            @Override
            public void onFailure(Call<CurrentHistory> call, Throwable t) {

            }
        });
    }


    public void getChart(CurrentHistory data) {
        if (data != null) {
            List<Float> yValstoEntry = new ArrayList<>();
            List<Float> xValsToEntry = new ArrayList<>();
            List<Entry> yVals = new ArrayList<Entry>();


            for (int i = 0; i < data.getData().size(); i++) {
                yValstoEntry.add((float) data.getData().get(i).getCurrentHashrate());
                xValsToEntry.add((float) data.getData().get(i).getTime());
            }


            for (int i = 0; i < yValstoEntry.size(); i++) {
                yVals.add(new Entry(xValsToEntry.get(i), yValstoEntry.get(i)));
            }

            LineDataSet dataSet = new LineDataSet(yVals, "time");
            dataSet(dataSet);
            drawChart();
        }
    }

    public void dataSet(LineDataSet dataSet) {
        dataSet.setCubicIntensity(0.2f);
        dataSet.setDrawCircles(false);
        dataSet.setLineWidth(1.8f);
        dataSet.setCircleRadius(4f);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setHighLightColor(Color.rgb(244, 117, 117));
        dataSet.setColor(Color.WHITE);
        dataSet.setFillColor(Color.rgb(33, 150, 243));
        dataSet.setFillAlpha(100);
        dataSet.setDrawHorizontalHighlightIndicator(false);
        dataSet.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataSet);
        LineData data = new LineData(dataSets);
        lineChart.setData(data);
    }

    public void drawChart() {
        lineChart.setViewPortOffsets(0, 20, 0, 0);
        lineChart.setBackgroundColor(Color.TRANSPARENT);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setPinchZoom(false);
        lineChart.setDrawGridBackground(false);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setEnabled(false);


        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);

        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.BLACK);


        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);


        YAxis yAxis = lineChart.getAxisLeft();

        yAxis.setLabelCount(12, false);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yAxis.setDrawGridLines(false);
        yAxis.setAxisLineColor(Color.BLACK);

        lineChart.getAxisRight().setEnabled(false);

        lineChart.getLegend().setEnabled(false);
        Description description = new Description();
        description.setText("");
        lineChart.setDescription(description);


        lineChart.animateXY(1000, 1000);


        lineChart.invalidate();
        lineChart.setVisibility(View.VISIBLE);
    }
}
