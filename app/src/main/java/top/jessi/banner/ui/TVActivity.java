package top.jessi.banner.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import top.jessi.banner.R;
import top.jessi.banner.adapter.ImageAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityTVBinding;
import top.jessi.banner.indicator.CircleIndicator;
import top.jessi.banner.listener.OnBannerListener;
import top.jessi.banner.transformer.AlphaPageTransformer;

public class TVActivity extends AppCompatActivity {

    private ActivityTVBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityTVBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.banner.setAdapter(new ImageAdapter(DataBean.getTestData()));
        mBinding.banner.setIndicator(new CircleIndicator(this));
        mBinding.banner.addPageTransformer(new AlphaPageTransformer());
                // .addPageTransformer(new RotateUpPageTransformer());
        mBinding.banner.isAutoLoop(true);
        mBinding.banner.setOnBannerListener(new OnBannerListener<DataBean>() {
            @Override
            public void OnBannerClick(DataBean data, int position) {
            }
        });
    }
}
