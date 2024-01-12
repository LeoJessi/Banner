package top.jessi.banner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import top.jessi.banner.R;
import top.jessi.banner.adapter.ImageNetAdapter;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.Banner;
import top.jessi.banner.indicator.CircleIndicator;
import top.jessi.banner.util.BannerUtils;


public class BlankFragment extends Fragment {

    public static Fragment newInstance() {
        return new BlankFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout linearLayout = getView().findViewById(R.id.ll_view);

        //通过new的方式创建banner
        Banner banner = new Banner(getActivity());
        banner.setAdapter(new ImageNetAdapter(DataBean.getTestData3()));
        banner.addBannerLifecycleObserver(this);
        banner.setIndicator(new CircleIndicator(getActivity()));

        //将banner加入到父容器中，实际使用不一定一样
        linearLayout.addView(banner, LinearLayout.LayoutParams.MATCH_PARENT, (int) BannerUtils.dp2px(120));
    }
}
