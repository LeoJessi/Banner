package top.jessi.banner.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.jessi.banner.R;
import top.jessi.banner.bean.DataBean;
import top.jessi.banner.viewholder.ImageHolder;
import top.jessi.banner.viewholder.TitleHolder;
import top.jessi.banner.viewholder.VideoHolder;
import top.jessi.banner.util.BannerUtils;


/**
 * 自定义布局,多个不同UI切换
 */
public class MultipleTypesAdapter extends BannerAdapter<DataBean, RecyclerView.ViewHolder> {
    private Context context;
    private SparseArray<RecyclerView.ViewHolder> mVHMap = new SparseArray<>();

    public MultipleTypesAdapter(Context context, List<DataBean> mDatas) {
        super(mDatas);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new ImageHolder(BannerUtils.getView(parent, R.layout.banner_image));
            case 2:
                return new VideoHolder(BannerUtils.getView(parent, R.layout.banner_video));
            case 3:
                return new TitleHolder(BannerUtils.getView(parent, R.layout.banner_title));
        }
        return new ImageHolder(BannerUtils.getView(parent, R.layout.banner_image));
    }

    @Override
    public int getItemViewType(int position) {
        //先取得真实的position,在获取实体
//        return getData(getRealPosition(position)).viewType;
        //直接获取真实的实体
        return getRealData(position).viewType;
        //或者自己直接去操作集合
//        return mDatas.get(getRealPosition(position)).viewType;
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, DataBean data, int position, int size) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case 1:
                ImageHolder imageHolder = (ImageHolder) holder;
                mVHMap.append(position,imageHolder);
                imageHolder.imageView.setImageResource(data.imageRes);
                break;
            case 2:
                VideoHolder videoHolder = (VideoHolder) holder;
                mVHMap.append(position,videoHolder);
                // TODO GSY
                // videoHolder.player.setUp(data.imageUrl, true, null);
                // videoHolder.player.getBackButton().setVisibility(View.GONE);
                //增加封面
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(R.drawable.image4);
                // TODO GSY
                // videoHolder.player.setThumbImageView(imageView);
                break;
            case 3:
                TitleHolder titleHolder = (TitleHolder) holder;
                mVHMap.append(position,titleHolder);
                titleHolder.title.setText(data.title);
                titleHolder.title.setBackgroundColor(Color.parseColor(DataBean.getRandColor()));
                break;
        }
    }

    public SparseArray<RecyclerView.ViewHolder> getVHMap() {
        return mVHMap;
    }


}
