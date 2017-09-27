package com.unionOfMiners.android.union.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.FrameLayout;

import com.pixplicity.easyprefs.library.Prefs;
import com.unionOfMiners.android.union.Constants;
import com.unionOfMiners.android.union.DetailActivity;
import com.unionOfMiners.android.union.KZTRates.Rss;
import com.unionOfMiners.android.union.PrefsApplication;
import com.unionOfMiners.android.union.R;
import com.unionOfMiners.android.union.USDRates.RatesUSD;
import com.unionOfMiners.android.union.adapters.CurrencyAdapter;
import com.unionOfMiners.android.union.bottomsheetconverter.BottomSheetConverter;
import com.unionOfMiners.android.union.coinModel.CoinsFromApi;
import com.unionOfMiners.android.union.coinModel.CoinsFromSocket;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HP on 12.09.2017.
 */

public class ListFragment extends Fragment implements CurrencyAdapter.ClickListener{
    private RatesUSD usdRates;
    private Rss rssKZ;
    private RecyclerView mRecyclerView;
    private ProgressDialog mProgressDialog;
    private Menu menu;
    private CurrencyAdapter adapter;
    private LayoutAnimationController animation;
    private FrameLayout lin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_currency, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        EventBus.getDefault().register(this);




        mProgressDialog = new ProgressDialog(getContext(), ProgressDialog.THEME_HOLO_DARK);
        mProgressDialog.setMessage("Please, wait..");
        mProgressDialog.setCancelable(false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_currency);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        lin = (FrameLayout) view.findViewById(R.id.linlayout);

        animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_fall_down);

        Prefs.putString("test", "");

        mProgressDialog.show();

        getRequireApi();
    }

    @Override
    public void onClick(CoinsFromApi currency, String type) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(Constants.KEY_TO_DETAIL, currency);
        intent.putExtra(Constants.KEY_TYPE, type);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(final CoinsFromSocket coinsFromSocket) {
        Log.d("SocketCoins", String.valueOf(coinsFromSocket.getMessage().getMsg().getPrice()));
        adapter.updateData(coinsFromSocket);
        EventBus.getDefault().post(coinsFromSocket.getMessage());
    }

    public void refreshDialog() {
        mProgressDialog.hide();
        Snackbar snack = Snackbar.make(lin, R.string.errot_title, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.refresh, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mProgressDialog.show();
                        getRequireApi();
                    }
                });
        snack.getView().setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorRed));
        Button sbButton = (Button) snack.getView().findViewById(android.support.design.R.id.snackbar_action);
        sbButton.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
        snack.show();
    }

    private void getRequireApi() {

        PrefsApplication.get().getApi().getCryptoCurrency().enqueue(new Callback<List<CoinsFromApi>>() {
            @Override
            public void onResponse(Call<List<CoinsFromApi>> call, Response<List<CoinsFromApi>> response) {
                mProgressDialog.dismiss();
                if (response.body() != null) {
                    adapter = new CurrencyAdapter(response.body(), ListFragment.this, getContext());
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.setLayoutAnimation(animation);
                }
            }

            @Override
            public void onFailure(Call<List<CoinsFromApi>> call, Throwable t) {

                Log.d("test", String.valueOf(t));
                refreshDialog();
            }
        });

        PrefsApplication.get().getCurrencyApi().getSimpleCurrency().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                //Log.d("testy", String.valueOf(response.body().getItems().get(0).getDescription()));
                rssKZ = response.body();
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.d("testy", t.toString());
                refreshDialog();
                //Toast.makeText(MainActivity.this, "KZT Rate Error", Toast.LENGTH_SHORT).show();
            }
        });

        PrefsApplication.get().getUSD().getUSDRates("USD")
                .enqueue(new Callback<RatesUSD>() {
                    @Override
                    public void onResponse(Call<RatesUSD> call, Response<RatesUSD> response) {
                        Log.d("USDRates", String.valueOf(response.body().getRates().getEUR()));
                        usdRates = response.body();
                    }

                    @Override
                    public void onFailure(Call<RatesUSD> call, Throwable t) {
                        //Toast.makeText(MainActivity.this, "USD Rate Error", Toast.LENGTH_SHORT).show();
                        refreshDialog();
                    }
                });
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.menu = menu;
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.search_coin);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (adapter != null)
                    adapter.getFilter().filter(newText);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_converter:
                if (adapter != null) {
                    BottomSheetConverter bottomSheetConverter = new BottomSheetConverter();
                    bottomSheetConverter.setList(adapter.getmCryptoCurrencyList());

                    bottomSheetConverter.show(getFragmentManager(), bottomSheetConverter.getTag());
                }
                break;

            case R.id.item_usd_default:
                final View menuItemView = getActivity().findViewById(R.id.item_usd_default);
                final PopupMenu popup = new PopupMenu(getContext(), menuItemView);
                if (adapter != null) {
                    popup.inflate(R.menu.menu_other_cur);
                    popup.show();
                    popup.getMenu().findItem(R.id.item_usd).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            menu.findItem(R.id.item_usd_default).setTitle(R.string.usd_short);
                            adapter.setData(adapter.getmCryptoCurrencyList());
                            adapter.setType("USD");
                            mRecyclerView.setLayoutAnimation(animation);
                            adapter.notifyDataSetChanged();
                            return true;
                        }
                    });
                    popup.getMenu().findItem(R.id.item_EUR).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            menu.findItem(R.id.item_usd_default).setTitle(R.string.eur_short);
                            adapter.setType("EUR");
                            adapter.setData(adapter.getmCryptoCurrencyList());
                            mRecyclerView.setLayoutAnimation(animation);
                            adapter.notifyDataSetChanged();
                            return true;
                        }
                    });
                    popup.getMenu().findItem(R.id.item_rub).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            menu.findItem(R.id.item_usd_default).setTitle(R.string.rub_short);
                            adapter.setData(adapter.getmCryptoCurrencyList());
                            mRecyclerView.setLayoutAnimation(animation);
                            adapter.setType("RUB");
                            adapter.notifyDataSetChanged();
                            return true;
                        }
                    });
                    popup.getMenu().findItem(R.id.item_gbp).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            menu.findItem(R.id.item_usd_default).setTitle(R.string.gbp_short);
                            adapter.setData(adapter.getmCryptoCurrencyList());
                            mRecyclerView.setLayoutAnimation(animation);
                            adapter.setType("GBP");
                            adapter.notifyDataSetChanged();
                            return true;
                        }
                    });
                    popup.getMenu().findItem(R.id.item_kzt).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            menu.findItem(R.id.item_usd_default).setTitle(R.string.kzt_short);
                            adapter.setData(adapter.getmCryptoCurrencyList());
                            mRecyclerView.setLayoutAnimation(animation);
                            adapter.setType("KZT");
                            adapter.notifyDataSetChanged();
                            return true;
                        }
                    });
                }
                break;
        }


        return true;
    }
}
