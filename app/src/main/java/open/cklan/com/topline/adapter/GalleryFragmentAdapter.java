package open.cklan.com.topline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import open.cklan.com.topline.ui.fragment.base.BaseNewsListFragment;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:25
 */
public class GalleryFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public GalleryFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.size();
    }

}
