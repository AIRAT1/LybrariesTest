package de.android.lybrariestest.di.module;


import com.squareup.okhttp.OkHttpClient;

import org.joda.time.convert.Converter;

import java.util.concurrent.Executor;

import dagger.Module;
import de.android.lybrariestest.BuildConfig;

@Module
public class ApiModule {
    // 50 Mb cache size
    private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024;
    // request timeout
    private static final int TIMEOUT = 10;
    // base request url
    private String url;

    public ApiModule(String url) {
        this.url = url;
    }

    RestAdapter provideRestAdapter(Converter converter,
                                   Endpoint endpoint,
                                   Executor executor,
                                   OkHttpClient client) {
        return new RestAdapter.Builder()
                .setLogLevel(BuildConfig.DEBUG
                ? ReatAdapter.LogLevel.FULL
                : ReatAdapter.LogLevel.NONE)
                .setClient(new OkClient(client))
                .setConverter(converter)
                .setEndpoint(endpoint)
                .setExecutors(executor, executor)
                .build();
    }
}
