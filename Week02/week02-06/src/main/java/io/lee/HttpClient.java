package io.lee;

import okhttp3.*;

import java.io.IOException;

/**
 * @author lizhe
 */
public class HttpClient {

    public static void main(String[] args) {
        call();
    }

    private static void call() {
        String url = "http://localhost:8801";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).get().build();
        final Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.code() + " " + response.message());
                System.out.println(response.body().string());
            }
        });
    }
}
