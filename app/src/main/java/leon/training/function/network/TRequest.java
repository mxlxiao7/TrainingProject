package leon.training.function.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maxiaolong on 2017/6/1.
 */

public interface TRequest {
    @GET("search/error.html")
    Call<ResponseBody> getMsg();
}
