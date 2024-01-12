package top.jessi.banner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import top.jessi.banner.adapter.TopLineAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityTouTiaoBinding;
import top.jessi.banner.Banner;
import top.jessi.banner.transformer.ZoomOutPageTransformer;

public class TouTiaoActivity extends AppCompatActivity {
    private ActivityTouTiaoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityTouTiaoBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //实现1号店和淘宝头条类似的效果
        mBinding.banner.setAdapter(new TopLineAdapter(DataBean.getTestData2()))
               .setOrientation(Banner.VERTICAL)
               .setPageTransformer(new ZoomOutPageTransformer())
               .setOnBannerListener((data, position) -> {
                   Snackbar.make(mBinding.banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
               });

    }
}