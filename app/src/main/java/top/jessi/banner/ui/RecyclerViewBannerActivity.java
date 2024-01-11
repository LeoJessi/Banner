package top.jessi.banner.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import top.jessi.banner.adapter.MyRecyclerViewAdapter;


public class RecyclerViewBannerActivity extends AppCompatActivity {
    private top.jessi.banner.databinding.ActivityRecyclerviewBannerBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = top.jessi.banner.databinding.ActivityRecyclerviewBannerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.netRv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.netRv.setAdapter(new MyRecyclerViewAdapter(this));
    }

}
