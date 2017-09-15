package leon.training.function.memory;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import leon.training.BaseFragment;
import leon.training.utils.Utils;
import leon.trainingproject.R;
import leon.trainingproject.databinding.FragmentMemoryLayoutBinding;

/**
 * Author:maxiaolong
 * Date:2016/10/12
 * Time:17:00
 * Email:mxlxiao7@sina.com
 */
public class MemoryFragment extends BaseFragment {
    private static final String TAG = MemoryFragment.class.getSimpleName();
    private StringBuilder s = new StringBuilder();
    private Button mClearBtn;
    private TextView mTextView;
    private TextView mMsg;
    private Button mBtn;
    private Button mBtn1;
    private FragmentMemoryLayoutBinding mBinding;
    private List<Bitmap> mCache = new ArrayList<Bitmap>();

    public MemoryFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MemoryFragment newInstance() {
        MemoryFragment fragment = new MemoryFragment();
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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_memory_layout, container, false);
        mMsg = mBinding.tvMsg;
        mClearBtn = mBinding.clear;
        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.setLength(0);
                helloEventBus("");
                while (mBinding.container.getChildCount() > 1) {
                    mBinding.container.removeViewAt(mBinding.container.getChildCount() - 1);
                }
                for (Bitmap bitmap : mCache) {
                    bitmap.recycle();
                }
                mCache.clear();
            }
        });

        mBtn = mBinding.btn;
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder msg = new StringBuilder();

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ALPHA_8;
                options.inDensity = 160;
                options.inTargetDensity = 160;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);
                int byteCount = bitmap.getByteCount();
                msg.append("ALPHA_8 = " + byteCount + "   [" + bitmap.getWidth() + "," + bitmap.getHeight() + "]" + "\n");

                BitmapFactory.Options options1 = new BitmapFactory.Options();
                options1.inPreferredConfig = Bitmap.Config.RGB_565;
                options1.inDensity = 160;
                options1.inTargetDensity = 160;
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options1);
                int byteCount1 = bitmap1.getByteCount();
                msg.append("RGB_565 = " + byteCount1 + "   [" + bitmap1.getWidth() + "," + bitmap1.getHeight() + "]" + "\n");

                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inPreferredConfig = Bitmap.Config.ARGB_4444;
                options2.inDensity = 160;
                options2.inTargetDensity = 160;
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options2);
                int byteCount2 = bitmap2.getByteCount();
                msg.append("ARGB_4444 = " + byteCount2 + "   [" + bitmap2.getWidth() + "," + bitmap2.getHeight() + "]" + "\n");

                BitmapFactory.Options options3 = new BitmapFactory.Options();
                options3.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options3.inDensity = 160;
                options3.inTargetDensity = 160;
                Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options3);
                int byteCount3 = bitmap3.getByteCount();
                msg.append("ARGB_8888 = " + byteCount3 + "   [" + bitmap3.getWidth() + "," + bitmap3.getHeight() + "]" + "\n");

                Utils.msg(msg.toString());

                ImageView imageView = new ImageView(getActivity());
                imageView.setImageBitmap(bitmap);
                mBinding.container.addView(imageView);

                ImageView imageView1 = new ImageView(getActivity());
                imageView1.setImageBitmap(bitmap1);
                mBinding.container.addView(imageView1);

                ImageView imageView2 = new ImageView(getActivity());
                imageView2.setImageBitmap(bitmap2);
                mBinding.container.addView(imageView2);

                ImageView imageView3 = new ImageView(getActivity());
                imageView3.setImageBitmap(bitmap3);
                mBinding.container.addView(imageView3);
            }
        });

        mBtn1 = mBinding.btn1;
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder msg = new StringBuilder();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_img, options);
                int byteCount = bitmap.getByteCount();
                msg.append("ARGB_8888 = " + byteCount + "\n");
                Utils.msg(msg.toString());
                mCache.add(bitmap);
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
