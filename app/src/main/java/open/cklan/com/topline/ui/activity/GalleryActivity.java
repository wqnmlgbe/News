package open.cklan.com.topline.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import open.cklan.com.topline.R;
import open.cklan.com.topline.adapter.GalleryFragmentAdapter;
import open.cklan.com.topline.ui.activity.base.BaseActivity;
import open.cklan.com.topline.ui.fragment.GalleryFragment;

/**
 * AUTHOR：lanchuanke on 17/5/16 11:24
 */
public class GalleryActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    public static final String ARG_PIC="pic";
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.tv_num)
    TextView tvNum;
    List<String> pics;
    GalleryFragmentAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        initData();
        initAdapter();
    }

    private void initAdapter() {
        if(pics!=null && pics.size()>0){
            List<Fragment> fragments=new ArrayList<>();
            for(String pic:pics){
                GalleryFragment fragment=new GalleryFragment();
                Bundle bundle=new Bundle();
                bundle.putString(GalleryFragment.ARG_URL,pic);
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
            adapter=new GalleryFragmentAdapter(getSupportFragmentManager(),fragments);
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(this);
        }
    }

    private void initData() {
        pics= (List<String>) getIntent().getSerializableExtra(ARG_PIC);
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tvNum.setText((position+1)+"/"+pics.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
