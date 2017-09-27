package com.unionOfMiners.android.union;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.unionOfMiners.android.union.KZTRates.Rss;
import com.unionOfMiners.android.union.USDRates.RatesUSD;
import com.unionOfMiners.android.union.chart.ChartData;
import com.unionOfMiners.android.union.coinModel.CoinsFromApi;
import com.unionOfMiners.android.union.coinModel.Message;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailActivity extends AppCompatActivity {

    private String type;
    private CoinsFromApi mCryptoCurrency;
    private TextView tvPrice, tvPerc, tvMarketCap, tvVolume24, tvSupply;
    private TextView tvToday, tv1w, tv1m, tv3m, tv6m, tv1y, tvAll;
    private TextView dataNull, errorMessage;
    private LineChart lineChart;
    private ProgressBar mProgressBar;
    private List<TextView> tvList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dataNull = (TextView) findViewById(R.id.tv_history_no);
        dataNull.setVisibility(View.INVISIBLE);
        errorMessage = (TextView) findViewById(R.id.tv_error_mess);
        errorMessage.setVisibility(View.INVISIBLE);

        mCryptoCurrency = (CoinsFromApi) getIntent().getSerializableExtra(Constants.KEY_TO_DETAIL);
        type = getIntent().getStringExtra(Constants.KEY_TYPE);
        DetailActivity.this.setTitle(mCryptoCurrency.getLong());

        mProgressBar = (ProgressBar) findViewById(R.id.pb_chart);

        lineChart = (LineChart) findViewById(R.id.lc_line_chart);
        lineChart.setVisibility(View.INVISIBLE);

        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvPerc = (TextView) findViewById(R.id.tv_perc);
        tvMarketCap = (TextView) findViewById(R.id.tv_value_market_cap);
        tvVolume24 = (TextView) findViewById(R.id.tv_volume24);
        tvSupply = (TextView) findViewById(R.id.tv_supply_value);

        tvToday = (TextView) findViewById(R.id.tv_today);
        tv1w = (TextView) findViewById(R.id.tv_1w);
        tv1m = (TextView) findViewById(R.id.tv_1m);
        tv3m = (TextView) findViewById(R.id.tv_3m);
        tv6m = (TextView) findViewById(R.id.tv_6m);
        tv1y = (TextView) findViewById(R.id.tv_1y);
        tvAll = (TextView) findViewById(R.id.tv_all);

        tvList.add(tvToday);
        tvList.add(tv1w);
        tvList.add(tv1m);
        tvList.add(tv3m);
        tvList.add(tv6m);
        tvList.add(tv1y);
        tvList.add(tvAll);


        updateData();
        getChartData();
        textViewListener();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Message message) {
        if (message.getCoin().equals(mCryptoCurrency.getShort())) {
            mCryptoCurrency.setPrice(message.getMsg().getPrice());
            mCryptoCurrency.setPerc(message.getMsg().getPerc());
            mCryptoCurrency.setVolume(message.getMsg().getVolume());
            mCryptoCurrency.setMktcap(message.getMsg().getMktcap());
            updateData();
        }
    }

    public void updateData() {
        tvSupply.setText(String.format("%1$,.2f", mCryptoCurrency.getSupply()));
        tvPerc.setText(String.valueOf(mCryptoCurrency.getPerc() + "%"));
        switch (type) {
            case "USD":
                if (mCryptoCurrency.getPrice() < 0.01)
                    tvPrice.setText(String.format("%1$,.6f", mCryptoCurrency.getPrice()));
                else
                    tvPrice.setText(String.format("%1$,.2f", mCryptoCurrency.getPrice()));

                tvMarketCap.setText(String.format("%1$,.2f", mCryptoCurrency.getMktcap()));
                tvVolume24.setText(String.format("%1$,.2f", mCryptoCurrency.getVolume()));
                break;
            case "EUR":
                if (mCryptoCurrency.getEur() < 0.01)
                    tvPrice.setText(String.format("%1$,.6f", mCryptoCurrency.getEur()));
                else
                    tvPrice.setText(String.format("%1$,.2f", mCryptoCurrency.getEur()));

                tvMarketCap.setText(String.format("%1$,.2f", mCryptoCurrency.getEURCap()));
                tvVolume24.setText(String.format("%1$,.2f", mCryptoCurrency.getEURVolume()));
                break;
            case "GBP":
                if (mCryptoCurrency.getGbp() < 0.01)
                    tvPrice.setText(String.format("%1$,.6f", mCryptoCurrency.getGbp()));
                else
                    tvPrice.setText(String.format("%1$,.2f", mCryptoCurrency.getGbp()));
                tvMarketCap.setText(String.format("%1$,.2f", mCryptoCurrency.getGBPCap()));
                tvVolume24.setText(String.format("%1$,.2f", mCryptoCurrency.getGBPVolume()));
                break;
            case "RUB":
                if (mCryptoCurrency.getRub() < 0.01)
                    tvPrice.setText(String.format("%1$,.6f", mCryptoCurrency.getRub()));
                else
                    tvPrice.setText(String.format("%1$,.2f", mCryptoCurrency.getRub()));

                tvMarketCap.setText(String.format("%1$,.2f", mCryptoCurrency.getRUBCap()));
                tvVolume24.setText(String.format("%1$,.2f", mCryptoCurrency.getRUBVolume()));
                break;
            case "KZT":
                if (mCryptoCurrency.getKzt() < 0.01)
                    tvPrice.setText(String.format("%1$,.6f", mCryptoCurrency.getKzt()));
                else
                    tvPrice.setText(String.format("%1$,.2f", mCryptoCurrency.getKzt()));
                tvMarketCap.setText(String.format("%1$,.2f", mCryptoCurrency.getKZTCap()));
                tvVolume24.setText(String.format("%1$,.2f", mCryptoCurrency.getKZTVolume()));
                break;
        }
    }

    public void getChartData() {
        tvToday.setTextColor(ContextCompat.getColor(this, R.color.colorBlue));
        getChartDataFromApi(Constants.DAY_1, tvToday);
    }

    private void dataSet(LineDataSet dataSet) {
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

    private void drawChart() {
        lineChart.setViewPortOffsets(0, 20, 0, 0);
        lineChart.setBackgroundColor(Color.rgb(66, 66, 66));

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

    private void textViewListener() {
        tvToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChartData();
            }
        });
        tv1w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChartDataFromApi(Constants.WEEK_1, tv1w);
            }
        });

        tv1m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChartDataFromApi(Constants.MONTH_1, tv1m);
            }
        });

        tv3m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChartDataFromApi(Constants.MONTH_3, tv3m);
            }
        });

        tv6m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChartDataFromApi(Constants.MONTH_6, tv6m);
            }
        });

        tv1y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChartDataFromApi(Constants.YEAR_1, tv1y);
            }
        });

        tvAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                lineChart.setVisibility(View.INVISIBLE);

                for (TextView tv : tvList) {
                    tv.setTextColor(Color.WHITE);
                }
                tvAll.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBlue));
                PrefsApplication.get().getChartInterface().getChartDataAll(mCryptoCurrency.getShort())
                        .enqueue(new Callback<ChartData>() {
                            @Override
                            public void onResponse(Call<ChartData> call, Response<ChartData> response) {
                                mProgressBar.setVisibility(View.INVISIBLE);
                                getChart(response.body());
                            }

                            @Override
                            public void onFailure(Call<ChartData> call, Throwable t) {
                                mProgressBar.setVisibility(View.INVISIBLE);
                                errorMessage.setVisibility(View.VISIBLE);
                            }
                        });
            }
        });
    }

    private void getChart(ChartData data) {
        if (data != null) {
            List<Float> yValstoEntry = new ArrayList<>();
            List<Float> xValsToEntry = new ArrayList<>();
            List<Entry> yVals = new ArrayList<Entry>();

            switch (type) {
                case "USD":
                    for (int i = 0; i < data.getPrice().size(); i++) {
                        yValstoEntry.add(data.getPrice().get(i).get(1));
                        xValsToEntry.add(data.getPrice().get(i).get(0));
                    }
                    break;
                case "EUR":
                    for (int i = 0; i < data.getPrice().size(); i++) {
                        yValstoEntry.add((float) (data.getPrice().get(i).get(1) * RatesUSD.rates.getEUR()));
                        xValsToEntry.add(data.getPrice().get(i).get(0));
                    }
                    break;
                case "GBP":
                    for (int i = 0; i < data.getPrice().size(); i++) {
                        yValstoEntry.add((float) (data.getPrice().get(i).get(1) * RatesUSD.rates.getGBP()));
                        xValsToEntry.add(data.getPrice().get(i).get(0));
                    }
                    break;
                case "RUB":
                    for (int i = 0; i < data.getPrice().size(); i++) {
                        yValstoEntry.add((float) (data.getPrice().get(i).get(1) * RatesUSD.rates.getRUB()));
                        xValsToEntry.add(data.getPrice().get(i).get(0));
                    }
                    break;
                case "KZT":
                    for (int i = 0; i < data.getPrice().size(); i++) {
                        yValstoEntry.add((float) (data.getPrice().get(i).get(1) * Rss.items.get(4).getDescription()));
                        xValsToEntry.add(data.getPrice().get(i).get(0));
                    }
                    break;
            }


            for (int i = 0; i < yValstoEntry.size(); i++) {
                yVals.add(new Entry(xValsToEntry.get(i), yValstoEntry.get(i)));
            }

            LineDataSet dataSet = new LineDataSet(yVals, "time");
            dataSet(dataSet);
            drawChart();
        } else {
            dataNull.setVisibility(View.VISIBLE);
            tvAll.setEnabled(false);
            tvToday.setEnabled(false);
            tv1w.setEnabled(false);
            tv1m.setEnabled(false);
            tv3m.setEnabled(false);
            tv6m.setEnabled(false);
            tv1y.setEnabled(false);
        }
    }

    private void getChartDataFromApi(String period, TextView textView) {
        for (TextView tv : tvList) {
            tv.setTextColor(Color.WHITE);
        }
        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBlue));
        mProgressBar.setVisibility(View.VISIBLE);
        lineChart.setVisibility(View.INVISIBLE);
        PrefsApplication.get().getChartInterface().getChartData(period, mCryptoCurrency.getShort())
                .enqueue(new Callback<ChartData>() {
                    @Override
                    public void onResponse(Call<ChartData> call, Response<ChartData> response) {
                        mProgressBar.setVisibility(View.INVISIBLE);
                        getChart(response.body());
                    }

                    @Override
                    public void onFailure(Call<ChartData> call, Throwable t) {
                        mProgressBar.setVisibility(View.INVISIBLE);
                        errorMessage.setVisibility(View.VISIBLE);
                    }
                });
    }

}
