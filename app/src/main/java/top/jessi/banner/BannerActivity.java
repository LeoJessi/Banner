package top.jessi.banner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import top.jessi.banner.adapter.ImageAdapter;
import top.jessi.banner.adapter.ImageTitleAdapter;
import top.jessi.banner.adapter.ImageTitleNumAdapter;
import top.jessi.banner.adapter.MultipleTypesAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityBannerBinding;
import top.jessi.banner.ui.ConstraintLayoutBannerActivity;
import top.jessi.banner.ui.GalleryActivity;
import top.jessi.banner.ui.RecyclerViewBannerActivity;
import top.jessi.banner.ui.TVActivity;
import top.jessi.banner.ui.TouTiaoActivity;
import top.jessi.banner.ui.VideoActivity;
import top.jessi.banner.ui.Vp2FragmentRecyclerviewActivity;
import top.jessi.banner.adapter.BannerImageAdapter;
import top.jessi.banner.config.BannerConfig;
import top.jessi.banner.config.IndicatorConfig;
import top.jessi.banner.holder.BannerImageHolder;
import top.jessi.banner.indicator.CircleIndicator;
import top.jessi.banner.indicator.RoundLinesIndicator;
import top.jessi.banner.util.BannerUtils;
import top.jessi.ilog.ILog;
import top.jessi.twinking.RefreshListenerAdapter;
import top.jessi.twinking.TwinklingRefreshLayout;

public class BannerActivity extends AppCompatActivity {
    private ActivityBannerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBannerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //自定义的图片适配器，也可以使用默认的BannerImageAdapter
        ImageAdapter adapter = new ImageAdapter(DataBean.getTestData2());

        mBinding.banner.setAdapter(adapter)
//              .setCurrentItem(0,false)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))//设置指示器
                .setOnBannerListener((data, position) -> {
                    Snackbar.make(mBinding.banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
                    ILog.d("position：" + position);
                });

        //添加item之间切换时的间距(如果使用了画廊效果就不要添加间距了，因为内部已经添加过了)
//        banner.addPageTransformer(new MarginPageTransformer( BannerUtils.dp2px(10)));

        //和下拉刷新配套使用
        mBinding.swipeRefresh.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                //模拟网络请求需要3秒，请求完成，设置finishRefreshing
                new Handler().postDelayed(() -> {
                    mBinding.swipeRefresh.finishRefreshing();
                    //给banner重新设置数据
                    mBinding.banner.setDatas(DataBean.getTestData());

                    //对setDatas()方法不满意？你可以自己在adapter控制数据，参考setDatas()的实现修改
//                adapter.updateData(DataBean.getTestData());
//                banner.setCurrentItem(banner.getStartPosition(), false);
//                banner.setIndicatorPageChange();

                }, 3000);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                //模拟网络请求需要3秒，请求完成，设置finishLoadmore
                new Handler().postDelayed(() -> {
                    mBinding.swipeRefresh.finishLoadmore();
                    //给banner重新设置数据
                    mBinding.banner.setDatas(DataBean.getTestData());

                    //对setDatas()方法不满意？你可以自己在adapter控制数据，参考setDatas()的实现修改
//                adapter.updateData(DataBean.getTestData());
//                banner.setCurrentItem(banner.getStartPosition(), false);
//                banner.setIndicatorPageChange();

                }, 3000);
            }

        });


        initClick();
    }

    private void initClick() {
        mBinding.indicator.setVisibility(View.GONE);
        mBinding.styleImage.setOnClickListener(v -> {
            mBinding.swipeRefresh.setEnabled(true);
            mBinding.banner.setAdapter(new ImageAdapter(DataBean.getTestData()));
            mBinding.banner.setIndicator(new CircleIndicator(this));
            mBinding.banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
        });
        mBinding.styleImageTitle.setOnClickListener(v->{
            mBinding.swipeRefresh.setEnabled(true);
            mBinding.banner.setAdapter(new ImageTitleAdapter(DataBean.getTestData()));
            mBinding.banner.setIndicator(new CircleIndicator(this));
            mBinding.banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
            mBinding.banner.setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                    BannerConfig.INDICATOR_MARGIN, BannerUtils.dp2px(12)));
        });
        mBinding.styleImageTitleNum.setOnClickListener(v->{
            mBinding.swipeRefresh.setEnabled(true);
            //这里是将数字指示器和title都放在adapter中的，如果不想这样你也可以直接设置自定义的数字指示器
            mBinding.banner.setAdapter(new ImageTitleNumAdapter(DataBean.getTestData()));
            mBinding.banner.removeIndicator();
        });
        mBinding.styleMultiple.setOnClickListener(v->{
            mBinding.swipeRefresh.setEnabled(true);
            mBinding.banner.setIndicator(new CircleIndicator(this));
            mBinding.banner.setAdapter(new MultipleTypesAdapter(this, DataBean.getTestData()));
        });
        mBinding.styleNetImage.setOnClickListener(v->{
            mBinding.swipeRefresh.setEnabled(false);
            //方法一：使用自定义图片适配器
//                banner.setAdapter(new ImageNetAdapter(DataBean.getTestData3()));

            //方法二：使用自带的图片适配器
            mBinding.banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
                @Override
                public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                    //图片加载自己实现
                    // TODO GSY
                    // Glide.with(holder.itemView.getContext())
                    //         .load(data.imageUrl)
                    //         // .thumbnail(Glide.with(holder.itemView.getContext()).load(R.drawable.loading))
                    //         // .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    //         .into(holder.imageView);
                }
            });
            mBinding.banner.setIndicator(new RoundLinesIndicator(this));
            mBinding.banner.setIndicatorSelectedWidth(BannerUtils.dp2px(15));
        });
        mBinding.changeIndicator.setOnClickListener(v->{
            mBinding.indicator.setVisibility(View.VISIBLE);
            //在布局文件中使用指示器，这样更灵活
            mBinding.banner.setIndicator(mBinding.indicator, false);
            mBinding.banner.setIndicatorSelectedWidth(BannerUtils.dp2px(15));
        });
        mBinding.gallery.setOnClickListener(v->{
            startActivity(new Intent(this, GalleryActivity.class));
        });
        mBinding.rvBanner.setOnClickListener(v -> {
            startActivity(new Intent(this, RecyclerViewBannerActivity.class));
        });
        mBinding.clBanner.setOnClickListener(v->{
            startActivity(new Intent(this, ConstraintLayoutBannerActivity.class));
        });
        mBinding.vpBanner.setOnClickListener(v -> {
            startActivity(new Intent(this, Vp2FragmentRecyclerviewActivity.class));
        });
        mBinding.bannerVideo.setOnClickListener(v->{
            startActivity(new Intent(this, VideoActivity.class));
        });
        mBinding.bannerTv.setOnClickListener(v -> {
            startActivity(new Intent(this, TVActivity.class));
        });
        mBinding.topLine.setOnClickListener(v->{
            startActivity(new Intent(this, TouTiaoActivity.class));
        });
    }
}
