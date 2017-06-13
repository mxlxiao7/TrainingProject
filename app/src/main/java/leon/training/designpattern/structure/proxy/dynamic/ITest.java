package leon.training.designpattern.structure.proxy.dynamic;

import retrofit2.http.GET;

/**
 * Created by maxiaolong on 2017/6/5.
 */

public interface ITest {
    @GET("/user")
    public void add(int a, int b);
}
