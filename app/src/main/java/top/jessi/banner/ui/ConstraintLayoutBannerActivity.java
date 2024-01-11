package top.jessi.banner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import top.jessi.banner.R;
import top.jessi.banner.adapter.ImageTitleAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityConstraintLayoutBannerBinding;
import top.jessi.banner.youth.config.BannerConfig;
import top.jessi.banner.youth.config.IndicatorConfig;
import top.jessi.banner.youth.indicator.CircleIndicator;
import top.jessi.banner.youth.util.BannerUtils;


public class ConstraintLayoutBannerActivity extends AppCompatActivity {
    private static final String TAG = "banner_log";
    private ActivityConstraintLayoutBannerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityConstraintLayoutBannerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.banner.setAdapter(new ImageTitleAdapter(DataBean.getTestData()));
        mBinding.banner.setIndicator(new CircleIndicator(this));
        mBinding.banner.setIndicatorSelectedColorRes(R.color.main_color);
        mBinding.banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        mBinding.banner.setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                BannerConfig.INDICATOR_MARGIN, (int) BannerUtils.dp2px(12)));
        mBinding.banner.addBannerLifecycleObserver(this);
    }

}
