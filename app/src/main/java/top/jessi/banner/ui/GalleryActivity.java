package top.jessi.banner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import top.jessi.banner.adapter.ImageAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityGalleryBinding;
import top.jessi.banner.youth.indicator.CircleIndicator;


public class GalleryActivity extends AppCompatActivity {
    private ActivityGalleryBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        /**
         * 画廊效果
         */
        mBinding.banner1.setAdapter(new ImageAdapter(DataBean.getTestData2()));
        mBinding.banner1.setIndicator(new CircleIndicator(this));
        //添加画廊效果
        mBinding.banner1.setBannerGalleryEffect(50, 10);
        //(可以和其他PageTransformer组合使用，比如AlphaPageTransformer，注意但和其他带有缩放的PageTransformer会显示冲突)
        //添加透明效果(画廊配合透明效果更棒)
        //mBanner1.addPageTransformer(new AlphaPageTransformer());


        /**
         * 魅族效果
         */
        mBinding.banner2.setAdapter(new ImageAdapter(DataBean.getTestData()));
        mBinding.banner2.setIndicator(mBinding.indicator,false);
        //添加魅族效果
        mBinding.banner2.setBannerGalleryMZ(20);

    }
}