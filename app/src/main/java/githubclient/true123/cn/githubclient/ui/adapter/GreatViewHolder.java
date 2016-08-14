package githubclient.true123.cn.githubclient.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;

import butterknife.Bind;
import githubclient.true123.cn.githubclient.R;
import githubclient.true123.cn.githubclient.bean.Repository;

/**
 * Created by junbo on 14/8/2016.
 */
@AutoFactory(implementing = ViewHolderFactory.class)
public class GreatViewHolder extends BaseViewHolder {
    @Bind(R.id.repository_name)
    TextView repName;
    @Bind(R.id.fork)
    TextView fork;
    @Bind(R.id.star)
    TextView star;

    public GreatViewHolder(View itemView) {
        super(LayoutInflater.from(itemView.getContext())
                .inflate(R.layout.recycler_item_great, (ViewGroup) itemView, false));
    }

    @Override
    void bind(Repository repository) {
        repName.setText(repository.getName());
        fork.setText(repository.getStargazers_count());
        star.setText(repository.getForks_count());
    }
}
