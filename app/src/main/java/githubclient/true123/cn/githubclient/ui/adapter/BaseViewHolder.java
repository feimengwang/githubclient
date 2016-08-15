package githubclient.true123.cn.githubclient.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import githubclient.true123.cn.githubclient.bean.Repository;

/**
 * Created by junbo on 14/8/2016.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View parent) {
        super(parent);
        ButterKnife.bind(this,itemView);
    }


    abstract void bind(Repository repository);
}
