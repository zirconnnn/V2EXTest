package me.zircon.v2test.data.api;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import me.zircon.v2test.data.model.Member;
import me.zircon.v2test.data.model.Topic;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/29 <br>
 */
public class RestDataSource {

    private final Api api;
    private static final String BASE_URL = "https://www.v2ex.com/api/";
    private static RestDataSource instance;

    public static RestDataSource getInstance() {
        if (instance == null) {
            instance = new RestDataSource();
        }
        return instance;
    }

    private RestDataSource() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        api = new Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(FastJsonConvertFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(Api.class);

    }

    public Observable<List<Topic>> queryHot() {
        return api.queryHot().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Member> queryMember(String username) {
        return api.queryMember(username).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    static class FastJsonConvertFactory extends Converter.Factory {

        public static FastJsonConvertFactory create() {
            return new FastJsonConvertFactory();
        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

            return new FastJsonResponseBodyConverter<>(type);
        }

        static class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

            private Type type;

            public FastJsonResponseBodyConverter(Type type) {
                this.type = type;
            }

            @Override
            public T convert(ResponseBody value) throws IOException {
                return JSON.parseObject(new String(value.bytes()), type);
            }
        }
    }




}
