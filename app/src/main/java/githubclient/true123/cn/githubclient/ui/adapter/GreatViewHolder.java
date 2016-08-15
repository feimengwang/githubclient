package githubclient.true123.cn.githubclient.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;

import java.text.MessageFormat;

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
    @Bind(R.id.tv_fork)
    TextView tvFork;
    @Bind(R.id.tv_star)
    TextView tvStar;

    public GreatViewHolder(View parent) {
        super(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_great, (ViewGroup) parent, false));
        // ButterKnife.bind(this,itemView);
    }

    @Override
    void bind(Repository repository) {
        repName.setText(repository.getName());

        tvStar.setText(MessageFormat.format(tvStar.getText().toString(),new Object[]{repository.getStargazers_count()}));
        tvFork.setText(MessageFormat.format(tvFork.getText().toString(),new Object[]{repository.getForks_count()}));
    }
}
