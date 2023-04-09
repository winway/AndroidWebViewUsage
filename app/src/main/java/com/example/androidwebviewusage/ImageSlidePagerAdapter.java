package com.example.androidwebviewusage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @PackageName: com.example.androidwebviewusage
 * @ClassName: ImageSlidePagerAdapter
 * @Author: winwa
 * @Date: 2023/4/9 20:25
 * @Description:
 **/
public class ImageSlidePagerAdapter extends PagerAdapter {
    private List<ImageView> mData;

    public ImageSlidePagerAdapter(List<ImageView> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mData.get(position));
        return mData.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mData.get(position));
    }
}
