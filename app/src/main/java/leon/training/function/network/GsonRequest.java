package leon.training.function.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maxiaolong on 2017/6/5.
 */

public interface GsonRequest {
    @GET("https://api.github.com/")
    Call<GsonBean> getGson();
}
