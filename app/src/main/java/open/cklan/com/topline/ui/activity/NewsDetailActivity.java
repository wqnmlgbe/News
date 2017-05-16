package open.cklan.com.topline.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import open.cklan.com.library.model.NewsContentEntity;
import open.cklan.com.library.model.NewsContentParserEntity;
import open.cklan.com.library.model.base.BaseMultiItem;
import open.cklan.com.library.utils.HtmlParserUtil;
import open.cklan.com.library.utils.LogUtil;
import open.cklan.com.topline.R;
import open.cklan.com.topline.adapter.NewsDetailAdapter;
import open.cklan.com.topline.component.activity.DaggerNewsDetailActivityComponent;
import open.cklan.com.topline.component.activity.NewsDetailActivityComponent;
import open.cklan.com.topline.contract.NewsDetailContract;
import open.cklan.com.topline.module.presenter.NewsDetailPresenterModule;
import open.cklan.com.topline.presenter.NewsDetailPresenter;
import open.cklan.com.topline.ui.activity.base.BaseActivity;

/**
 * AUTHOR：lanchuanke on 17/5/5 10:00
 */
public class NewsDetailActivity extends BaseActivity implements NewsDetailContract.View {
    public static final String ARG_DOC_ID = "doc_id";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private String doc_id;
    NewsDetailAdapter adapter;
    List<BaseMultiItem> data;
    @Inject
    NewsDetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        setupToolbar();
        initURL();
        presenter.loadNewsContent(doc_id);
    }

    private void setupToolbar() {
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white);
    }


    private void initURL() {
        Intent intent = getIntent();
        if (intent == null) {
            throw new RuntimeException("no listUrl");
        } else {
            doc_id = intent.getStringExtra(ARG_DOC_ID);
        }
    }

    @Override
    protected void initInject() {
        NewsDetailActivityComponent component = DaggerNewsDetailActivityComponent.builder()
                .activityComponent(getActivityComponent())
                .newsDetailPresenterModule(new NewsDetailPresenterModule(this))
                .build();
        component.inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void showContent(NewsContentEntity contentEntity) {
        if(data==null)data=new ArrayList<>();
        try {
            data.addAll(HtmlParserUtil.parseHtml(contentEntity));
            adapter=new NewsDetailAdapter(this,data);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showCommentList() {

    }
}
