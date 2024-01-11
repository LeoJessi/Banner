package top.jessi.banner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import top.jessi.banner.adapter.MyRecyclerViewAdapter;
import top.jessi.banner.databinding.ActivityRecyclerviewBannerBinding;


public class BannerListFragment extends Fragment {
    private static int index;
    private ActivityRecyclerviewBannerBinding mBinding;

    public static Fragment newInstance(int i) {
        index = i;
        return new BannerListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ActivityRecyclerviewBannerBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.text.setText("当前页:"+index);
        mBinding.netRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.netRv.setAdapter(new MyRecyclerViewAdapter(getActivity()));
    }

}
