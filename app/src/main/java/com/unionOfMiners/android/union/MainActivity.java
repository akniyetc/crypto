package com.unionOfMiners.android.union;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

import com.crashlytics.android.Crashlytics;
import com.unionOfMiners.android.union.KZTRates.Rss;
import com.unionOfMiners.android.union.USDRates.RatesUSD;
import com.unionOfMiners.android.union.adapters.CurrencyAdapter;
import com.unionOfMiners.android.union.fragment.AuthFragment;
import com.unionOfMiners.android.union.fragment.AuthNotFragment;
import com.unionOfMiners.android.union.fragment.GaugeViewFragment;
import com.unionOfMiners.android.union.fragment.ListFragment;
import com.unionOfMiners.android.union.fragment.SettingsFragment;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    private RatesUSD usdRates;
    private Rss rssKZ;
    private RecyclerView mRecyclerView;
    private ProgressDialog mProgressDialog;
    private Menu menu;
    private CurrencyAdapter adapter;
    private LayoutAnimationController animation;
    private FrameLayout lin;

    private BottomNavigationView bottomNavigationView;

    GaugeViewFragment gauge;
    ListFragment mListFragment;
    AuthNotFragment authNot;
    AuthFragment auth;
    SettingsFragment mSettingsFragment;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        mListFragment = new ListFragment();
        gauge = new GaugeViewFragment();
        authNot = new AuthNotFragment();
        auth = new AuthFragment();
        mSettingsFragment = new SettingsFragment();


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
       changeFragment(mListFragment, R.id.fragmentContainer);





        setBottomNavigation();



//        EventBus.getDefault().register(this);
//
//
//        mProgressDialog = new ProgressDialog(this, ProgressDialog.THEME_HOLO_DARK);
//        mProgressDialog.setMessage("Please, wait..");
//        mProgressDialog.setCancelable(false);
//        mRecyclerView = (RecyclerView) findViewById(R.id.rv_currency);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        lin = (FrameLayout) findViewById(R.id.linlayout);
//
//        animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_animation_fall_down);
//
//        Prefs.putString("test", "");
//
//        mProgressDialog.show();
//
//        getRequireApi();

    }

    private void setBottomNavigation(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_profile:
                        changeFragment(authNot, R.id.fragmentContainer);
                        return true;
                    case R.id.action_catalog:
                        changeFragment(mListFragment, R.id.fragmentContainer);
                        return true;
                    case R.id.action_stat:
                        changeFragment(gauge, R.id.fragmentContainer);
                        return true;
                    case R.id.action_settings:
                        changeFragment(mSettingsFragment, R.id.fragmentContainer);
                        return true;

                }

                return true;
            }
        });
    }

    public void changeFragment(Fragment fragment, @IdRes int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commitNow();
    }

//    @Override
//    public void onClick(CoinsFromApi currency, String type) {
//        Intent intent = new Intent(this, DetailActivity.class);
//        intent.putExtra(Constants.KEY_TO_DETAIL, currency);
//        intent.putExtra(Constants.KEY_TYPE, type);
//        startActivity(intent);
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        this.menu = menu;
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.search_coin);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (adapter != null)
//                    adapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.item_converter:
//                if (adapter != null) {
//                    BottomSheetConverter bottomSheetConverter = new BottomSheetConverter();
//                    bottomSheetConverter.setList(adapter.getmCryptoCurrencyList());
//
//                    bottomSheetConverter.show(getSupportFragmentManager(), bottomSheetConverter.getTag());
//                }
//                break;
//
//            case R.id.item_usd_default:
//                final View menuItemView = findViewById(R.id.item_usd_default);
//                final PopupMenu popup = new PopupMenu(this, menuItemView);
//                if (adapter != null) {
//                    popup.inflate(R.menu.menu_other_cur);
//                    popup.show();
//                    popup.getMenu().findItem(R.id.item_usd).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            menu.findItem(R.id.item_usd_default).setTitle(R.string.usd_short);
//                            adapter.setData(adapter.getmCryptoCurrencyList());
//                            adapter.setType("USD");
//                            mRecyclerView.setLayoutAnimation(animation);
//                            adapter.notifyDataSetChanged();
//                            return true;
//                        }
//                    });
//                    popup.getMenu().findItem(R.id.item_EUR).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            menu.findItem(R.id.item_usd_default).setTitle(R.string.eur_short);
//                            adapter.setType("EUR");
//                            adapter.setData(adapter.getmCryptoCurrencyList());
//                            mRecyclerView.setLayoutAnimation(animation);
//                            adapter.notifyDataSetChanged();
//                            return true;
//                        }
//                    });
//                    popup.getMenu().findItem(R.id.item_rub).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            menu.findItem(R.id.item_usd_default).setTitle(R.string.rub_short);
//                            adapter.setData(adapter.getmCryptoCurrencyList());
//                            mRecyclerView.setLayoutAnimation(animation);
//                            adapter.setType("RUB");
//                            adapter.notifyDataSetChanged();
//                            return true;
//                        }
//                    });
//                    popup.getMenu().findItem(R.id.item_gbp).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            menu.findItem(R.id.item_usd_default).setTitle(R.string.gbp_short);
//                            adapter.setData(adapter.getmCryptoCurrencyList());
//                            mRecyclerView.setLayoutAnimation(animation);
//                            adapter.setType("GBP");
//                            adapter.notifyDataSetChanged();
//                            return true;
//                        }
//                    });
//                    popup.getMenu().findItem(R.id.item_kzt).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                        @Override
//                        public boolean onMenuItemClick(MenuItem item) {
//                            menu.findItem(R.id.item_usd_default).setTitle(R.string.kzt_short);
//                            adapter.setData(adapter.getmCryptoCurrencyList());
//                            mRecyclerView.setLayoutAnimation(animation);
//                            adapter.setType("KZT");
//                            adapter.notifyDataSetChanged();
//                            return true;
//                        }
//                    });
//                }
//                break;
//        }
//
//
//        return true;
//    }

//    @Override
//    protected void onDestroy() {
//        EventBus.getDefault().unregister(this);
//        super.onDestroy();
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(final CoinsFromSocket coinsFromSocket) {
//        Log.d("SocketCoins", String.valueOf(coinsFromSocket.getMessage().getMsg().getPrice()));
//        adapter.updateData(coinsFromSocket);
//        EventBus.getDefault().post(coinsFromSocket.getMessage());
//    }
//
//
//    public void refreshDialog() {
//        mProgressDialog.hide();
//        Snackbar snack = Snackbar.make(lin, R.string.errot_title, Snackbar.LENGTH_INDEFINITE)
//                .setAction(R.string.refresh, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mProgressDialog.show();
//                        getRequireApi();
//                    }
//                });
//        snack.getView().setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorRed));
//        Button sbButton = (Button) snack.getView().findViewById(android.support.design.R.id.snackbar_action);
//        sbButton.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
//        snack.show();
//    }
//
//    private void getRequireApi() {
//
//        PrefsApplication.get().getApi().getCryptoCurrency().enqueue(new Callback<List<CoinsFromApi>>() {
//            @Override
//            public void onResponse(Call<List<CoinsFromApi>> call, Response<List<CoinsFromApi>> response) {
//                mProgressDialog.dismiss();
//                if (response.body() != null) {
//                    adapter = new CurrencyAdapter(response.body(), MainActivity.this, getApplicationContext());
//                    mRecyclerView.setAdapter(adapter);
//                    mRecyclerView.setLayoutAnimation(animation);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CoinsFromApi>> call, Throwable t) {
//
//                Log.d("test", String.valueOf(t));
//                refreshDialog();
//            }
//        });
//
//        PrefsApplication.get().getCurrencyApi().getSimpleCurrency().enqueue(new Callback<Rss>() {
//            @Override
//            public void onResponse(Call<Rss> call, Response<Rss> response) {
//                //Log.d("testy", String.valueOf(response.body().getItems().get(0).getDescription()));
//                rssKZ = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<Rss> call, Throwable t) {
//                Log.d("testy", t.toString());
//                refreshDialog();
//                //Toast.makeText(MainActivity.this, "KZT Rate Error", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        PrefsApplication.get().getUSD().getUSDRates("USD")
//                .enqueue(new Callback<RatesUSD>() {
//                    @Override
//                    public void onResponse(Call<RatesUSD> call, Response<RatesUSD> response) {
//                        Log.d("USDRates", String.valueOf(response.body().getRates().getEUR()));
//                        usdRates = response.body();
//                    }
//
//                    @Override
//                    public void onFailure(Call<RatesUSD> call, Throwable t) {
//                        //Toast.makeText(MainActivity.this, "USD Rate Error", Toast.LENGTH_SHORT).show();
//                        refreshDialog();
//                    }
//                });
//    }
//
//    public RatesUSD getUsdRates() {
//        return usdRates;
//    }
//
//    public Rss getRssKZ() {
//        return rssKZ;
//    }
}
