package githubclient.true123.cn.githubclient.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;

import butterknife.Bind;
import butterknife.ButterKnife;
import githubclient.true123.cn.githubclient.R;
import githubclient.true123.cn.githubclient.bean.Repository;

/**
 * Created by junbo on 14/8/2016.
 */
@AutoFactory(implementing = ViewHolderFactory.class)
public class NormalViewHolder extends BaseViewHolder {
    @Bind(R.id.repository_name)
    TextView repName;

    public NormalViewHolder(View parent) {

        super(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_normal, (ViewGroup) parent, false));
       // ButterKnife.bind(this,itemView);

    }

    @Override
    void bind(Repository repository) {
        repName.setText(repository.getName());
    }
}
