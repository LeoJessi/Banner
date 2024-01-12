package top.jessi.banner.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import top.jessi.banner.adapter.MultipleTypesAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityVideoBinding;
import top.jessi.banner.indicator.NumIndicator;
import top.jessi.banner.config.IndicatorConfig;
import top.jessi.banner.listener.OnPageChangeListener;

/**
 * 仿淘宝商品详情，banner第一个放视频,然后首尾不能自己滑动，加上自定义数字指示器
 */
public class VideoActivity extends AppCompatActivity {
    private ActivityVideoBinding mBinding;
    // VlcVideoView player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityVideoBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.banner.addBannerLifecycleObserver(this)
                .setAdapter(new MultipleTypesAdapter(this, DataBean.getTestDataVideo()))
                .setIndicator(new NumIndicator(this))
                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                .addOnPageChangeListener(new OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        stopVideo(position);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        Log.e("--","position:"+position);
                        stopVideo(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
    }

    private void stopVideo(int position) {
        // if (player == null) {
        //     RecyclerView.ViewHolder viewHolder = mBinding.banner.getAdapter().getViewHolder();
        //     if (viewHolder instanceof VideoHolder) {
        //         VideoHolder holder = (VideoHolder) viewHolder;
        //         player = holder.player;
        //         if (position != 0) {
        //             // player.onVideoPause();
        //             // player.pause();
        //         }
        //     }
        // }else {
        //     if (position != 0) {
        //         // player.onVideoPause();
        //         // player.pause();
        //     }
        // }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // if (player != null) player.pause();
        // if (player != null)
        //     player.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // if (player != null) player.startPlay();
    //    if (player != null)
        //             player.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // if (player != null) player.onDestroy();
        // GSYVideoManager.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        //释放所有
        // if (player != null)
        //     player.setVideoAllCallBack(null);

        // if (player != null) player.onDestroy();
        super.onBackPressed();
    }

}
