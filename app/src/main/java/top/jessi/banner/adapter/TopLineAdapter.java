package top.jessi.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.jessi.banner.R;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.util.BannerUtils;

/**
 * 自定义布局，实现类似1号店、淘宝头条的滚动效果
 */
public class TopLineAdapter extends BannerAdapter<DataBean, TopLineAdapter.TopLineHolder> {

    public TopLineAdapter(List<DataBean> mDatas) {
        super(mDatas);
    }

    @Override
    public TopLineHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new TopLineHolder(BannerUtils.getView(parent, R.layout.top_line_item2));
    }

    @Override
    public void onBindView(TopLineHolder holder, DataBean data, int position, int size) {
        holder.message.setText(data.title);
        if (data.viewType==1) {
            holder.source.setText("1号店");
        }else if (data.viewType==2) {
            holder.source.setText("淘宝头条");
        }else if (data.viewType==3) {
            holder.source.setText("京东快报");
        }
    }

    class TopLineHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public TextView source;

        public TopLineHolder(@NonNull View view) {
            super(view);
            message=view.findViewById(R.id.message);
            source=view.findViewById(R.id.source);
        }
    }
}
