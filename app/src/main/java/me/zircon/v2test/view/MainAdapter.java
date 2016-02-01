package me.zircon.v2test.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.zircon.v2test.BR;
import me.zircon.v2test.R;
import me.zircon.v2test.data.model.Topic;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/29 <br>
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BaseBindingViewHolder> {

    public static final int FOOTER = 2;

    private List<Topic> topics = new ArrayList<>();
    private LayoutInflater inflater;

    public MainAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void addRows(List<Topic> topics) {
        if (this.topics.size() > 0) {
            this.topics.clear();
        }
        if (topics != null && topics.size() > 0) {
            this.topics.addAll(topics);
            Topic footer = new Topic();
            footer.setEof("~EOF~");
            this.topics.add(footer);
        }
        notifyDataSetChanged();
    }

    @Override
    public BaseBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = null;
        switch (viewType) {
            case FOOTER:
                viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.footer_item, parent, false);
                break;
            default:
                viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.main_item, parent, false);
                break;
        }
        return new BaseBindingViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(BaseBindingViewHolder holder, int position) {
        Log.d("yeww", "pos = " + position);
        final Topic topic = topics.get(position);
        holder.getBinding().setVariable(BR.mainItem, topic);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == this.topics.size() - 1) {
            return FOOTER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.topics.size();
    }

    static class BaseBindingViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding viewDataBinding;

        public BaseBindingViewHolder(ViewDataBinding itemBinding) {
            super(itemBinding.getRoot());
            this.viewDataBinding = itemBinding;
        }

        public ViewDataBinding getBinding() {
            return this.viewDataBinding;
        }
    }


}
