package com.unionOfMiners.android.union.bottomsheetconverter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.unionOfMiners.android.union.KZTRates.Rss;
import com.unionOfMiners.android.union.R;
import com.unionOfMiners.android.union.USDRates.RatesUSD;
import com.unionOfMiners.android.union.coinModel.CoinsFromApi;

import java.util.List;


public class BottomSheetConverter extends BottomSheetDialogFragment {
    List<CoinsFromApi> list;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    EditText etFrom;
    EditText etTo;
    String[] CURRENCY_From;
    String[] CURRENCY_to;

    double d;

    double btcToDol;
    double btcToEur;
    double btcToGbp;
    double btcToRub;
    double btcToKz;
    double btcToEth;
    double btcToBtcCash;
    double btcToRipple;
    double btcToLtc;

    double ethToDol;
    double ethToEur;
    double ethToGbp;
    double ethToRub;
    double ethToKz;
    double ethToBtc;
    double ethToRipple;
    double ethToBtcCash;
    double ethToLtc;

    double rippleToDol;
    double rippleToEur;
    double rippleToGbp;
    double rippleToRub;
    double rippleToKz;
    double rippleToBtc;
    double rippleToEth;
    double rippleToBtcCash;
    double rippleToLtc;

    double btcCashToDol;
    double btcCashToEur;
    double btcCashToGbp;
    double btcCashToRub;
    double btcCashToKz;
    double btcCashToBtc;
    double btcCashToEth;
    double btcCashToRipple;
    double btcCashToLtc;


    double ltcToDol;
    double ltcToEur;
    double ltcToGbp;
    double ltcToRub;
    double ltcToKz;
    double ltcToBtc;
    double ltcToEth;
    double ltcToRipple;
    double ltcToBtcCash;

    String currency1 = "btc";
    String currency2 = "usd";


    public void setList(List<CoinsFromApi> list) {
        this.list = list;
    }

//    public static BottomSheetConverter newInstance(List<CoinsFromApi> coinList){
//        Bundle args = new Bundle();
//        Serializable smth=(Serializable) coinList;
//        args.putSerializable(Constants.KEY_TO_BOTTOM_COIN, smth);
//       // args.putString("coin", "con");
//        BottomSheetConverter bottom = new BottomSheetConverter();
//        bottom.setArguments(args);
//        Log.d("bundle", String.valueOf(args.getSerializable(Constants.KEY_TO_BOTTOM_COIN)));
//        return bottom;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.converter_fragment, container);

        etFrom = (EditText) v.findViewById(R.id.et_exchangeOne);
        etTo = (EditText) v.findViewById(R.id.et_exchangeTwo);

        calculate();
        spinnerInit(v);
        return v;

    }

    private void calculate() {
        setupConverterValue();
        etFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty())
                    try {
                        d = Double.parseDouble(s.toString());
                    }catch (Exception e){

                    }

                if (currency1.equals("btc") && currency2.equals("usd")) {
                    if ((d * btcToDol) < 1)
                        etTo.setText(String.format("%1$,.4f", (d * btcToDol)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToDol)));
                } else if (currency1.equals("btc") && currency2.equals("eur")) {
                    if ((d * btcToEur) < 1)
                        etTo.setText(String.format("%1$,.4f", (d * btcToEur)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToEur)));
                } else if (currency1.equals("btc") && currency2.equals("gbp")) {
                    if ((d * btcToGbp) < 1)
                        etTo.setText(String.format("%1$,.4f", (d * btcToGbp)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToGbp)));
                } else if (currency1.equals("btc") && currency2.equals("rub")) {
                    if ((d * btcToRub) < 1)
                        etTo.setText(String.format("%1$,.4f", (d * btcToRub)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToRub)));
                } else if (currency1.equals("btc") && currency2.equals("kz")) {
                    if ((d * btcToKz) < 1)
                        etTo.setText(String.format("%1$,.4f", (d * btcToKz)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToKz)));
                } else if (currency1.equals("btc") && currency2.equals("btc")) {
                    etTo.setText(String.format("%1$,.1f", d));
                } else if (currency1.equals("btc") && currency2.equals("eth")) {
                    if((d * btcToEth)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcToEth)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToEth)));
                } else if (currency1.equals("btc") && currency2.equals("btcC")) {
                    if((d * btcToBtcCash)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcToBtcCash)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToBtcCash)));
                } else if (currency1.equals("btc") && currency2.equals("rpl")) {
                    if ((d * btcToRipple)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcToRipple)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToRipple)));
                } else if (currency1.equals("btc") && currency2.equals("ltc")) {
                    if ((d * btcToLtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcToLtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcToLtc)));
                } else if (currency1.equals("eth") && currency2.equals("usd")) {
                    if ((d * ethToDol)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToDol)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToDol)));
                } else if (currency1.equals("eth") && currency2.equals("eur")) {
                    if((d * ethToEur)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToEur)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToEur)));
                } else if (currency1.equals("eth") && currency2.equals("gbp")) {
                    if((d * ethToGbp)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToGbp)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToGbp)));
                } else if (currency1.equals("eth") && currency2.equals("rub")) {
                    if ((d * ethToRub)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToRub)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToRub)));
                } else if (currency1.equals("eth") && currency2.equals("kz")) {
                    if ((d * ethToKz)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToKz)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToKz)));
                } else if (currency1.equals("eth") && currency2.equals("btc")) {
                    if((d * ethToBtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToBtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToBtc)));
                } else if (currency1.equals("eth") && currency2.equals("btcC")) {
                    if((d * ethToBtcCash)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToBtcCash)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToBtcCash)));
                } else if (currency1.equals("eth") && currency2.equals("rpl")) {
                    if((d * ethToRipple)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToRipple)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToRipple)));
                } else if (currency1.equals("eth") && currency2.equals("ltc")) {
                    if((d * ethToLtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ethToLtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * ethToLtc)));
                } else if (currency1.equals("rpl") && currency2.equals("usd")) {
                    if ((d * rippleToDol)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToDol)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToDol)));
                } else if (currency1.equals("rpl") && currency2.equals("eur")) {
                    if ((d * rippleToEur)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToEur)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToEur)));
                } else if (currency1.equals("rpl") && currency2.equals("gbp")) {
                    if ((d * rippleToGbp)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToGbp)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToGbp)));
                } else if (currency1.equals("rpl") && currency2.equals("rub")) {
                    if((d * rippleToRub)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToRub)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToRub)));
                } else if (currency1.equals("rpl") && currency2.equals("kz")) {
                    if ((d * rippleToKz)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToKz)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToKz)));
                } else if (currency1.equals("rpl") && currency2.equals("btc")) {
                    if((d * rippleToBtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToBtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToBtc)));
                } else if (currency1.equals("rpl") && currency2.equals("eth")) {
                    if ((d * rippleToEth)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToEth)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToEth)));
                } else if (currency1.equals("rpl") && currency2.equals("btcC")) {
                    if((d * rippleToBtcCash)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToBtcCash)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToBtcCash)));
                } else if (currency1.equals("rpl") && currency2.equals("ltc")) {
                    if ((d * rippleToLtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * rippleToLtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * rippleToLtc)));
                } else if (currency1.equals("btcC") && currency2.equals("usd")) {
                    if ((d * btcCashToDol)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToDol)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToDol)));
                } else if (currency1.equals("btcC") && currency2.equals("eur")) {
                    if ((d * btcCashToEur)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToEur)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToEur)));
                } else if (currency1.equals("btcC") && currency2.equals("gbp")) {
                    if ((d * btcCashToGbp)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToGbp)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToGbp)));
                } else if (currency1.equals("btcC") && currency2.equals("rub")) {
                    if((d * btcCashToRub)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToRub)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToRub)));
                } else if (currency1.equals("btcC") && currency2.equals("kz")) {
                    if ((d * btcCashToKz)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToKz)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToKz)));
                } else if (currency1.equals("btcC") && currency2.equals("btc")) {
                    if((d * btcCashToBtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToBtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToBtc)));
                } else if (currency1.equals("btcC") && currency2.equals("eth")) {
                    if ((d * btcCashToEth)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToEth)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToEth)));
                } else if (currency1.equals("btcC") && currency2.equals("rpl")) {
                    if ((d * btcCashToRipple)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToRipple)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToRipple)));
                } else if (currency1.equals("btcC") && currency2.equals("ltc")) {
                    if ((d * btcCashToLtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * btcCashToLtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * btcCashToLtc)));
                } else if (currency1.equals("ltc") && currency2.equals("usd")) {
                    if ((d * ltcToDol)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToDol)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToDol)));
                } else if (currency1.equals("ltc") && currency2.equals("eur")) {
                    if ((d * ltcToEur)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToEur)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToEur)));
                } else if (currency1.equals("ltc") && currency2.equals("gbp")) {
                    if ((d * ltcToGbp)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToGbp)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToGbp)));
                } else if (currency1.equals("ltc") && currency2.equals("rub")) {
                    if ((d * ltcToRub)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToRub)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToRub)));
                } else if (currency1.equals("ltc") && currency2.equals("kz")) {
                    if((d * ltcToKz)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToKz)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToKz)));
                } else if (currency1.equals("ltc") && currency2.equals("btc")) {
                    if ((d * ltcToBtc)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToBtc)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToBtc)));
                } else if (currency1.equals("ltc") && currency2.equals("eth")) {
                    if ((d * ltcToEth)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToEth)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToEth)));
                } else if (currency1.equals("ltc") && currency2.equals("btcC")) {
                    if ((d * ltcToBtcCash)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToBtcCash)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToBtcCash)));
                } else if (currency1.equals("ltc") && currency2.equals("rpl")) {
                    if((d * ltcToRipple)<1)
                    etTo.setText(String.format("%1$,.4f", (d * ltcToRipple)));
                    else etTo.setText(String.format("%1$,.1f", (d * ltcToRipple)));
                } else if (currency1.equals("usd") && currency2.equals("btc")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcToDol)));
                } else if (currency1.equals("usd") && currency2.equals("eth")) {
                    etTo.setText(String.format("%1$,.4f", (d / ethToDol)));
                } else if (currency1.equals("usd") && currency2.equals("btcC")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcCashToDol)));
                } else if (currency1.equals("usd") && currency2.equals("rpl")) {
                    etTo.setText(String.format("%1$,.4f", (d / rippleToDol)));
                } else if (currency1.equals("usd") && currency2.equals("ltc")) {
                    etTo.setText(String.format("%1$,.4f", (d / ltcToDol)));
                } else if (currency1.equals("usd") && currency2.equals("usd")) {
                    etTo.setText(String.format("%1$,.1f", d));
                } else if (currency1.equals("usd") && currency2.equals("eur")) {
                    etTo.setText(String.format("%1$,.4f", (d * RatesUSD.rates.getEUR())));
                } else if (currency1.equals("usd") && currency2.equals("gbp")) {
                    etTo.setText(String.format("%1$,.4f", (d * RatesUSD.rates.getGBP())));
                } else if (currency1.equals("usd") && currency2.equals("rub")) {
                    etTo.setText(String.format("%1$,.4f", (d * RatesUSD.rates.getRUB())));
                } else if (currency1.equals("usd") && currency2.equals("kz")) {
                    etTo.setText(String.format("%1$,.4f", (d * Rss.items.get(4).getDescription())));
                } else if (currency1.equals("eur") && currency2.equals("btc")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcToEur)));
                } else if (currency1.equals("eur") && currency2.equals("eth")) {
                    etTo.setText(String.format("%1$,.4f", (d / ethToEur)));
                } else if (currency1.equals("eur") && currency2.equals("btcC")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcToEur)));
                } else if (currency1.equals("eur") && currency2.equals("rpl")) {
                    etTo.setText(String.format("%1$,.4f", (d / rippleToEur)));
                } else if (currency1.equals("eur") && currency2.equals("ltc")) {
                    etTo.setText(String.format("%1$,.4f", (d / ltcToEur)));
                } else if (currency1.equals("gbp") && currency2.equals("btc")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcToGbp)));
                } else if (currency1.equals("gbp") && currency2.equals("eth")) {
                    etTo.setText(String.format("%1$,.4f", (d / ethToGbp)));
                } else if (currency1.equals("gbp") && currency2.equals("btcC")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcCashToGbp)));
                } else if (currency1.equals("gbp") && currency2.equals("rpl")) {
                    etTo.setText(String.format("%1$,.4f", (d / rippleToGbp)));
                } else if (currency1.equals("gbp") && currency2.equals("ltc")) {
                    etTo.setText(String.format("%1$,.4f", (d / ltcToGbp)));
                } else if (currency1.equals("rub") && currency2.equals("btc")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcToRub)));
                } else if (currency1.equals("rub") && currency2.equals("eth")) {
                    etTo.setText(String.format("%1$,.4f", (d / ethToRub)));
                } else if (currency1.equals("rub") && currency2.equals("btcC")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcCashToRub)));
                } else if (currency1.equals("rub") && currency2.equals("rpl")) {
                    etTo.setText(String.format("%1$,.4f", (d / rippleToRub)));
                } else if (currency1.equals("rub") && currency2.equals("ltc")) {
                    etTo.setText(String.format("%1$,.4f", (d / ltcToRub)));
                } else if (currency1.equals("kz") && currency2.equals("btc")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcToKz)));
                } else if (currency1.equals("kz") && currency2.equals("eth")) {
                    etTo.setText(String.format("%1$,.4f", (d / ethToKz)));
                } else if (currency1.equals("kz") && currency2.equals("btcC")) {
                    etTo.setText(String.format("%1$,.4f", (d / btcCashToKz)));
                } else if (currency1.equals("kz") && currency2.equals("rpl")) {
                    etTo.setText(String.format("%1$,.4f", (d / rippleToKz)));
                } else if (currency1.equals("kz") && currency2.equals("ltc")) {
                    etTo.setText(String.format("%1$,.4f", (d / ltcToKz)));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private BottomSheetBehavior.BottomSheetCallback mCallback =
            new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) dismiss();
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                }
            };

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.converter_fragment, null);
        dialog.setContentView(contentView);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if (behavior != null & behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mCallback);
        }
    }

    private void spinnerInit(View v) {
        CURRENCY_From = new String[]{"Bitcoin", "Ethereum", "Ripple", "Bitcoin Cash", "LiteCoin", "US Dollar", "Euro", "British Pound", "Russian Rubble", "Kazakh Tenge"};
        CURRENCY_to = new String[]{"US Dollar", "Euro", "British Pound", "Russian Rubble", "Kazakh Tenge", "Bitcoin", "Ethereum", "Ripple", "Bitcoin Cash", "LiteCoin"};
        ArrayAdapter<String> adapterFrom = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, CURRENCY_From);
        ArrayAdapter<String> adapterTo = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, CURRENCY_to);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom = (Spinner) v.findViewById(R.id.spinner_from);
        spinnerFrom.setAdapter(adapterFrom);
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        currency1 = "btc";
                        break;
                    case 1:
                        currency1 = "eth";
                        break;
                    case 2:
                        currency1 = "rpl";
                        break;
                    case 3:
                        currency1 = "btcC";
                        break;
                    case 4:
                        currency1 = "ltc";
                        break;
                    case 5:
                        currency1 = "usd";
                        break;
                    case 6:
                        currency1 = "eur";
                        break;
                    case 7:
                        currency1 = "gbp";
                        break;
                    case 8:
                        currency1 = "rub";
                        break;
                    case 9:
                        currency1 = "kz";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo = (Spinner) v.findViewById(R.id.spinner_to);
        spinnerTo.setAdapter(adapterTo);
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        currency2 = "usd";
                        break;
                    case 1:
                        currency2 = "eur";
                        break;
                    case 2:
                        currency2 = "gbp";
                        break;
                    case 3:
                        currency2 = "rub";
                        break;
                    case 4:
                        currency2 = "kz";
                        break;
                    case 5:
                        currency2 = "btc";
                        break;
                    case 6:
                        currency2 = "eth";
                        break;
                    case 7:
                        currency2 = "rpl";
                        break;
                    case 8:
                        currency2 = "btcC";
                        break;
                    case 9:
                        currency2 = "ltc";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupConverterValue() {

        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i).getLong()) {
                case "Bitcoin":
                    btcToDol = list.get(i).getPrice();
                    btcToEur = list.get(i).getEur();
                    btcToGbp = list.get(i).getGbp();
                    btcToRub = list.get(i).getRub();
                    btcToKz = list.get(i).getKzt();
                    break;
                case "Ethereum":
                    ethToDol = list.get(i).getPrice();
                    ethToEur = list.get(i).getEur();
                    ethToGbp = list.get(i).getGbp();
                    ethToRub = list.get(i).getRub();
                    ethToKz = list.get(i).getKzt();
                    break;
                case "Bitcoin Cash":
                    btcCashToDol = list.get(i).getPrice();
                    btcCashToEur = list.get(i).getEur();
                    btcCashToGbp = list.get(i).getGbp();
                    btcCashToRub = list.get(i).getRub();
                    btcCashToKz = list.get(i).getKzt();
                    break;
                case "Ripple":
                    rippleToDol = list.get(i).getPrice();
                    rippleToEur = list.get(i).getEur();
                    rippleToGbp = list.get(i).getGbp();
                    rippleToRub = list.get(i).getRub();
                    rippleToKz = list.get(i).getKzt();
                    break;
                case "Litecoin":
                    ltcToDol = list.get(i).getPrice();
                    ltcToEur = list.get(i).getEur();
                    ltcToGbp = list.get(i).getGbp();
                    ltcToRub = list.get(i).getRub();
                    ltcToKz = list.get(i).getKzt();
                    break;
            }
        }
        btcToEth = btcToDol / ethToDol;
        btcToBtcCash = btcToDol / btcCashToDol;
        btcToRipple = btcToDol / rippleToDol;
        btcToLtc = btcToDol / ltcToDol;

        ethToBtc = ethToDol / btcToDol;
        ethToBtcCash = ethToDol / btcCashToDol;
        ethToRipple = ethToDol / rippleToDol;
        ethToLtc = ethToDol / ltcToDol;

        btcCashToBtc = btcCashToDol / btcToDol;
        btcCashToEth = btcCashToDol / ethToDol;
        btcCashToRipple = btcCashToDol / rippleToDol;
        btcCashToLtc = btcCashToDol / ltcToDol;

        rippleToBtc = rippleToDol / btcToDol;
        rippleToEth = rippleToDol / ethToDol;
        rippleToBtcCash = rippleToDol / btcCashToDol;
        rippleToLtc = rippleToDol / ltcToDol;

        ltcToBtc = ltcToDol / btcToDol;
        ltcToEth = ltcToDol / ethToDol;
        ltcToBtcCash = ltcToDol / btcCashToDol;
        ltcToRipple = ltcToDol / rippleToDol;
    }
}
