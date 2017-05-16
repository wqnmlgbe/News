package open.cklan.com.topline.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import open.cklan.com.topline.R;
import open.cklan.com.topline.ui.fragment.base.BaseFragment;

/**
 * AUTHOR：lanchuanke on 17/5/16 12:17
 */
public class GalleryFragment extends BaseFragment {
    public static final String ARG_URL="url";
    PhotoView photoView;
    String url;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        url=arguments.getString(ARG_URL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gallery,null);
        photoView= (PhotoView) view.findViewById(R.id.photoView);
        Glide.with(getContext()).load(url).into(photoView);
        return view;
    }

}
