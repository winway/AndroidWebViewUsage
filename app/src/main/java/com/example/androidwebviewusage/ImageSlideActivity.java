package com.example.androidwebviewusage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageSlideActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private List<ImageView> mPagerAdapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slide);

        mViewPager = findViewById(R.id.image_slide_vp);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        String[] imgs = intent.getStringArrayExtra("imgs");

        mPagerAdapterData = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load(imgs[i]).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            mPagerAdapterData.add(imageView);
        }

        ImageSlidePagerAdapter imageSlidePagerAdapter = new ImageSlidePagerAdapter(mPagerAdapterData);
        mViewPager.setAdapter(imageSlidePagerAdapter);

        mViewPager.setCurrentItem(position);
    }
}