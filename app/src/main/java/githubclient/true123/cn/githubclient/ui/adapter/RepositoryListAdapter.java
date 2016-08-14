package githubclient.true123.cn.githubclient.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import githubclient.true123.cn.githubclient.bean.Repository;
import githubclient.true123.cn.githubclient.ui.views.RepositoryListView;

/**
 * Created by junbo on 14/8/2016.
 */
public class RepositoryListAdapter extends RecyclerView.Adapter {
    public static final int VIEW_TYPE_NORMAL = 1;
    public static final int VIEW_TYPE_GREAT = 2;
    private List<Repository> data = new ArrayList<>();
    private Map<Integer, ViewHolderFactory> factoryMap = new HashMap<>();
    private RepositoryListView repositoryListView;

    public RepositoryListAdapter(RepositoryListView repositoryListView, Map<Integer, ViewHolderFactory> factoryMap) {
        this.factoryMap = factoryMap;
        this.repositoryListView = repositoryListView;
    }

    public void update(List data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Repository repository = data.get(position);
        if (repository.getStargazers_count() > 100) {
            return VIEW_TYPE_GREAT;
        }
        return VIEW_TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final BaseViewHolder viewHolder = factoryMap.get(viewType).createViewHolder(parent);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repositoryListView.onItemClick(data.get(viewHolder.getAdapterPosition()));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder) holder).bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
