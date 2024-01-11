package top.jessi.banner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import top.jessi.banner.adapter.ImageNetAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.databinding.BannerBinding;
import top.jessi.banner.youth.indicator.RectangleIndicator;
import top.jessi.banner.youth.util.BannerUtils;

public class BannerFragment extends Fragment {

    private BannerBinding mBinding;

    public static Fragment newInstance() {
        return new BannerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = BannerBinding.inflate(getLayoutInflater());;
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.banner.setAdapter(new ImageNetAdapter(DataBean.getTestData3()));
        mBinding.banner.setIndicator(new RectangleIndicator(getActivity()));
        mBinding.banner.setIndicatorSpace((int) BannerUtils.dp2px(4));
        mBinding.banner.setIndicatorRadius(0);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBinding.banner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBinding.banner.stop();
    }
}
