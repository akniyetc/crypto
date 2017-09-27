package com.unionOfMiners.android.union.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.unionOfMiners.android.union.R;
import com.unionOfMiners.android.union.coinModel.CoinsFromApi;
import com.unionOfMiners.android.union.coinModel.CoinsFromSocket;

import java.util.ArrayList;
import java.util.List;


public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> implements Filterable {

    private List<CoinsFromApi> mCryptoCurrencyList;
    private List<CoinsFromApi> mFilterList;
    private ClickListener mListener;
    private String type = "USD";
    private int count = 1;
    private Context mContext;
    private double usd, eur, gbp, rub, kz;

    public CurrencyAdapter(List<CoinsFromApi> cryptoCurrencyList, ClickListener listener, Context context) {
        mCryptoCurrencyList = cryptoCurrencyList;
        mListener = listener;
        mContext = context;
        mFilterList = cryptoCurrencyList;
    }

    public List<CoinsFromApi> getmCryptoCurrencyList() {
        return mCryptoCurrencyList;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString().toLowerCase();
                if (charString.isEmpty()) {
                    mCryptoCurrencyList = mFilterList;
                } else {
                    List<CoinsFromApi> list = new ArrayList<>();
                    for (CoinsFromApi coin : mCryptoCurrencyList) {
                        if (coin.getLong().toLowerCase().contains(charString)) {
                            list.add(coin);
                        }
                    }
                    mCryptoCurrencyList = list;
                }
                FilterResults results = new FilterResults();
                results.values = mCryptoCurrencyList;
                return results;
            }
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mCryptoCurrencyList = (List<CoinsFromApi>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ClickListener {
        void onClick(CoinsFromApi currency, String type);
    }


    public void setData(List<CoinsFromApi> list) {
        mCryptoCurrencyList = list;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public CurrencyAdapter.CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CurrencyViewHolder(inflater.inflate(R.layout.currency_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CurrencyAdapter.CurrencyViewHolder holder, int position) {
        holder.currencyName.setText(mCryptoCurrencyList.get(position).getLong());
        holder.currencyChanged.setText(String.valueOf(mCryptoCurrencyList.get(position).getPerc() + "%"));

        try {
            usd = mCryptoCurrencyList.get(position).getPrice();
            eur = mCryptoCurrencyList.get(position).getEur();
            gbp = mCryptoCurrencyList.get(position).getGbp();
            rub = mCryptoCurrencyList.get(position).getRub();
            kz = mCryptoCurrencyList.get(position).getKzt();

            switch (type) {
                case "USD": {
                    if (usd < 0.01) {
                        holder.currencyValue.setText(String.format("%.6f", usd));
                    } else if (usd >= 1000) {
                        holder.currencyValue.setText(String.format("%1$,.1f", usd));
                    } else {
                        holder.currencyValue.setText(String.format("%.2f", usd));
                    }
                    break;
                }
                case "EUR": {
                    if (eur < 0.01) {
                        holder.currencyValue.setText(String.format("%.4f", eur));
                    } else if (eur >= 1000) {
                        holder.currencyValue.setText(String.format("%1$,.1f", eur));
                    } else {
                        holder.currencyValue.setText(String.format("%.2f", eur));
                    }
                    break;
                }
                case "GBP": {
                    if (gbp < 0.01) {
                        holder.currencyValue.setText(String.format("%.4f", gbp));
                    } else if (gbp >= 1000) {
                        holder.currencyValue.setText(String.format("%1$,.1f", gbp));
                    } else {
                        holder.currencyValue.setText(String.format("%.2f", gbp));
                    }
                    break;
                }
                case "RUB": {
                    if (rub < 0.01) {
                        holder.currencyValue.setText(String.format("%.4f", rub));
                    } else if (rub >= 1000) {
                        holder.currencyValue.setText(String.format("%1$,.1f", rub));
                    } else {
                        holder.currencyValue.setText(String.format("%.2f", rub));
                    }
                    break;
                }
                case "KZT": {
                    if (kz < 0.01) {
                        holder.currencyValue.setText(String.format("%.4f", kz));
                    } else if (kz >= 1000) {
                        holder.currencyValue.setText(String.format("%1$,.1f", kz));
                    } else {
                        holder.currencyValue.setText(String.format("%.2f", kz));
                    }
                    break;
                }
            }
        } catch (Exception e) {
            Log.d("RatesAdapter", String.valueOf(e));
        }

        if (mCryptoCurrencyList.get(position).getLong().equals("Bitcoin Cash")) {
            Glide.with(mContext).load("http://socket.coincap.io/images/coins/"
                    + "bitcoincash"
                    + ".png")
                    .into(holder.currencyImage);
        } else if (mCryptoCurrencyList.get(position).getLong().equals("Ethereum Classic")) {
            Glide.with(mContext).load("http://socket.coincap.io/images/coins/"
                    + "ethereumclassic"
                    + ".png")
                    .into(holder.currencyImage);
        } else {
            Glide.with(mContext).load("http://socket.coincap.io/images/coins/"
                    + mCryptoCurrencyList.get(position).getLong().toLowerCase()
                    + ".png")
                    .into(holder.currencyImage);
        }
    }

    @Override
    public int getItemCount() {
        switch (count) {
            case 0:
                return 10;
            case 1:
                return mCryptoCurrencyList.size();
            default:
                return mCryptoCurrencyList.size();
        }

    }

    public class CurrencyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView currencyName;
        private TextView currencyValue;
        private TextView currencyChanged;
        private ImageView currencyImage;

        public CurrencyViewHolder(View itemView) {
            super(itemView);
            currencyName = (TextView) itemView.findViewById(R.id.tv_name_currency);
            currencyValue = (TextView) itemView.findViewById(R.id.tv_value_currency);
            currencyChanged = (TextView) itemView.findViewById(R.id.tv_change_currency);
            currencyImage = (ImageView) itemView.findViewById(R.id.iv_coin);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(mCryptoCurrencyList.get(getAdapterPosition()), type);
        }
    }

    public void updateData(CoinsFromSocket coinsFromSocket) {
        for (int i = 0; i < mCryptoCurrencyList.size(); i++) {
            if (coinsFromSocket.getMessage().getCoin().equals(mCryptoCurrencyList.get(i).getShort())) {
                mCryptoCurrencyList.get(i).setPrice(coinsFromSocket.getMessage().getMsg().getPrice());
                mCryptoCurrencyList.get(i).setPerc(coinsFromSocket.getMessage().getMsg().getPerc());
                notifyItemChanged(i);
            }
        }
    }


}
