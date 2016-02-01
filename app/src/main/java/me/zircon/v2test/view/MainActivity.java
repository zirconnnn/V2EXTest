package me.zircon.v2test.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import me.zircon.v2test.R;
import me.zircon.v2test.data.model.Topic;
import me.zircon.v2test.databinding.MainListBinding;
import me.zircon.v2test.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainListBinding mainListBinding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainListBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new MainActivityViewModel();
        mainListBinding.setViewModel(mainActivityViewModel);

        initView();
        mainActivityViewModel.queryHotCommand();
    }

    private void initView() {

        setSupportActionBar(mainListBinding.toolbar);
        mainListBinding.listHot.setLayoutManager(new LinearLayoutManager(this));
        mainListBinding.listHot.addItemDecoration(new SpaceItemDecoration(this));
        mainListBinding.listHot.setAdapter(new MainAdapter(this));
        mainListBinding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainActivityViewModel.queryHotCommand();
            }
        });
//        mainListBinding.refreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mainListBinding.refreshLayout.setRefreshing(true);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                mainActivityViewModel.queryHotCommand();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @BindingAdapter("bind:contentList")
    public static void setContentList(RecyclerView view, List<Topic> list) {
        MainAdapter adapter = (MainAdapter) view.getAdapter();
        adapter.addRows(list);
    }


}
