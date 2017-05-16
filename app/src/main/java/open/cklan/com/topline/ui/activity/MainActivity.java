package open.cklan.com.topline.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import open.cklan.com.library.model.CategoryEntity;
import open.cklan.com.library.widget.SearchView;
import open.cklan.com.topline.adapter.MainFragmentAdapter;
import open.cklan.com.topline.component.activity.DaggerMainActivityComponent;
import open.cklan.com.topline.contract.MainContract;
import open.cklan.com.topline.module.presenter.MainPresenterModule;
import open.cklan.com.topline.presenter.MainActivityPresenter;
import open.cklan.com.topline.ui.activity.base.BaseActivity;
import open.cklan.com.topline.R;
import open.cklan.com.topline.ui.fragment.news_list.NewsListFragment;
import open.cklan.com.videoplayer.JCVideoPlayer;

public class MainActivity extends BaseActivity implements MainContract.View{
    @Inject
    MainActivityPresenter presenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.search_view)
    SearchView searchView;
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    List<CategoryEntity> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupSearchView();
        presenter.loadCategories();
    }

    @Override
    protected void initInject() {
        DaggerMainActivityComponent.builder()
                .activityComponent(getActivityComponent())
                .mainPresenterModule(new MainPresenterModule(this))
                .build().inject(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        //解决searchView显示时获取searchBar宽高为0的bug
        searchView.setSearchBarSize(toolbar.getWidth(),toolbar.getHeight());
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    private void setupSearchView(){
        searchView.setVoiceSearch(true);
        searchView.setCursorDrawable(R.drawable.search_view_cursor);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Snackbar.make(findViewById(R.id.root), "Query: " + query, Snackbar.LENGTH_LONG)
                        .show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new SearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

    }

    private void setupViewPager(){
        List<Fragment> list=new ArrayList<>();
        for (CategoryEntity category:categoryList) {
            NewsListFragment fragment=new NewsListFragment();
            fragment.setTitleAndType(category);
            list.add(fragment);
        }
        MainFragmentAdapter adapter=new MainFragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void showCategories(List<CategoryEntity> categoryList) {
        this.categoryList=categoryList;
        setupViewPager();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
