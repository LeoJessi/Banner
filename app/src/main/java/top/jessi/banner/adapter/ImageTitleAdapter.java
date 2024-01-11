package top.jessi.banner.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import top.jessi.banner.R;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.viewholder.ImageTitleHolder;
import top.jessi.banner.youth.adapter.BannerAdapter;


/**
 * 自定义布局，图片+标题
 */

public class ImageTitleAdapter extends BannerAdapter<DataBean, ImageTitleHolder> {

    public ImageTitleAdapter(List<DataBean> mDatas) {
        super(mDatas);
    }

    @Override
    public ImageTitleHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new ImageTitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image_title, parent, false));
    }

    @Override
    public void onBindView(ImageTitleHolder holder, DataBean data, int position, int size) {
        holder.imageView.setImageResource(data.imageRes);
        holder.title.setText(data.title);
    }

}
