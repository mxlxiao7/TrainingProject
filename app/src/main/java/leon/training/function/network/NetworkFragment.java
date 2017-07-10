package leon.training.function.network;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import leon.training.BaseFragment;
import leon.training.algorithm.Utils;
import leon.trainingproject.R;
import leon.trainingproject.databinding.FragmentNetworkLayoutBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class NetworkFragment extends BaseFragment {
    private static final String TAG = NetworkFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView mTextView;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;
    private FragmentNetworkLayoutBinding mBinding;

    public NetworkFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NetworkFragment newInstance() {
        NetworkFragment fragment = new NetworkFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_network_layout, container, false);

        mMsg = mBinding.tvMsg;
        mClearBtn = mBinding.clear;
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
            }
        });

        mBtn = mBinding.btn;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.baidu.com/";
                Utils.msg("开始请求" + url + " \n");
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        Utils.msg(response.body().string());
                    }
                });

                url = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1070393332,3426120788&fm=80&w=179&h=119&img.JPEG";
                request = new Request.Builder()
                        .url(url)
                        .build();
                call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        byte[] bytes = response.body().bytes();
                        final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        FragmentActivity activity = NetworkFragment.this.getActivity();
                        if (activity == null) {
                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mBinding.img.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                });
            }
        });

        mBtn1 = mBinding.btn1;
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Retrofit的Url组合规则
                    BaseUrl	                            和URL有关的注解中提供的值        	         最后结果
                    http://localhost:4567/path/to/other/	/post	                    http://localhost:4567/post
                    http://localhost:4567/path/to/other/	post	                    http://localhost:4567/path/to/other/post
                    http://localhost:4567/path/to/other/	https://github.com/ikidou	https://github.com/ikidou
                 */

                String url = "https://www.baidu.com/";
                Utils.msg("开始请求" + url + " \n");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                TRequest request = retrofit.create(TRequest.class);
                retrofit2.Call<ResponseBody> call = request.getMsg();
                call.enqueue(new retrofit2.Callback<ResponseBody>() {
                    @Override
                    public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        try {
                            Utils.msg(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });

        mBtn2 = mBinding.btn2;
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Retrofit的Url组合规则
                 BaseUrl	                            和URL有关的注解中提供的值        	         最后结果
                 http://localhost:4567/path/to/other/	/post	                    http://localhost:4567/post
                 http://localhost:4567/path/to/other/	post	                    http://localhost:4567/path/to/other/post
                 http://localhost:4567/path/to/other/	https://github.com/ikidou	https://github.com/ikidou
                 */
                Utils.msg("开始请求");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.baidu.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GsonRequest request = retrofit.create(GsonRequest.class);
                retrofit2.Call<GsonBean> call = request.getGson();
                call.enqueue(new retrofit2.Callback<GsonBean>() {
                    @Override
                    public void onResponse(retrofit2.Call<GsonBean> call, retrofit2.Response<GsonBean> response) {
                        try {
                            Utils.msg(response.body().toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<GsonBean> call, Throwable t) {

                    }
                });
            }
        });


        return mBinding.getRoot();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        s.append(message).append("\n");
        mMsg.setText(s.toString());
    }
}
