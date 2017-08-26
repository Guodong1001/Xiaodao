package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.HomeIconsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：分类图标的适配器
 * 创建人：yekh
 * 创建时间：17.8.13 19:47
 */
public class HomeIconsAdapter extends RecyclerView.Adapter<HomeIconsAdapter.ViewHolder>{
    private Context mContext;
    private List<HomeIconsBean.ObjectBean.ListBean> mIconsList;

    public HomeIconsAdapter(Context context, List<HomeIconsBean.ObjectBean.ListBean> iconsList) {
        mContext = context;
        mIconsList = iconsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_shouye_class, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mIconsList.get(position).getPicture())
//                .bitmapTransform(new CropCircleTransformation(mContext))
                .into(holder.image);
        holder.mTextView.setText(mIconsList.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return mIconsList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon_image)
        ImageView image;
        @BindView(R.id.icon_title)
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
