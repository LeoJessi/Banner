package top.jessi.banner.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import top.jessi.banner.adapter.ImageAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.ActivityVp2FragmentRecyclerviewBinding;
import top.jessi.banner.util.TabLayoutMediator;
import top.jessi.banner.indicator.CircleIndicator;

public class Vp2FragmentRecyclerviewActivity extends AppCompatActivity {

    private ActivityVp2FragmentRecyclerviewBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityVp2FragmentRecyclerviewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.vp2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position == 0) {
                    return BannerListFragment.newInstance(position);
                } else if (position == 1) {
                    return BlankFragment.newInstance();
                } else {
                    return BannerFragment.newInstance();
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });

        new TabLayoutMediator(mBinding.tabLayout, mBinding.vp2, (tab, position) -> {
            tab.setText("页面" + position);
        }).attach();


        mBinding.banner.addBannerLifecycleObserver(this)
               .setAdapter(new ImageAdapter(DataBean.getTestData()))
               .setIntercept(false)
               .setIndicator(new CircleIndicator(this));
    }
}
