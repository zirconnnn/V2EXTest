package me.zircon.v2test.data.api;

import android.support.annotation.NonNull;

import java.util.List;

import me.zircon.v2test.data.model.Member;
import me.zircon.v2test.data.model.Topic;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/28 <br>
 */
public interface Api {

    @GET("topics/hot.json")
    Observable<List<Topic>> queryHot();

    @GET("members/show.json")
    Observable<Member> queryMember(@Query("username") @NonNull String username);

}
