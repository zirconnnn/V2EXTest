package me.zircon.v2test.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import java.util.List;

import me.zircon.v2test.data.api.RestDataSource;
import me.zircon.v2test.data.model.Topic;
import rx.Subscriber;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/29 <br>
 */
public class MainActivityViewModel {

    public final ObservableBoolean isRefresh = new ObservableBoolean(true);
    public final ObservableBoolean isShowContent = new ObservableBoolean(false);
    public final ObservableArrayList<Topic> contentList = new ObservableArrayList<>();


    private RestDataSource restDataSource;

    public MainActivityViewModel() {
        restDataSource = RestDataSource.getInstance();
    }

    public void queryHotCommand() {
        isRefresh.set(true);
        contentList.clear();

        restDataSource.queryHot().subscribe(new Subscriber<List<Topic>>() {
            @Override
            public void onCompleted() {
                isRefresh.set(false);
            }

            @Override
            public void onError(Throwable e) {
                isRefresh.set(false);
                isShowContent.set(false);
                e.printStackTrace();
            }

            @Override
            public void onNext(List<Topic> topics) {
                if (topics != null && topics.size() > 0) {
                    isShowContent.set(true);
                    contentList.addAll(topics);
                } else {
                    isShowContent.set(false);
                }
            }
        });
    }




}
