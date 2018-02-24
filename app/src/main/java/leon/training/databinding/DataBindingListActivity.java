package leon.training.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import leon.training.BaseActivity;
import leon.trainingproject.BR;
import leon.trainingproject.R;
import leon.trainingproject.databinding.ActivityRvDatabindingBinding;
import leon.trainingproject.databinding.ActivityRvDatabindingItemBinding;

/**
 * Created by maxiaolong on 2017/5/22.
 */

public class DataBindingListActivity extends BaseActivity {


    private ActivityRvDatabindingBinding binding;
    private MyAdapter mAdapter;

    private int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(DataBindingListActivity.this, R.layout.activity_rv_databinding);
        binding.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = 20;
                mAdapter.datas = new String[size];
                for (int j = 0; j < size; j++) {
                    if (i % 2 == 0) {
                        mAdapter.datas[j] = "Command " + j;
                    } else {
                        mAdapter.datas[j] = "Other Command " + j;
                    }
                }
                i++;
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(DataBindingListActivity.this);
        binding.recycler.setLayoutManager(manager);
        binding.recycler.setHasFixedSize(true);
        mAdapter = new MyAdapter(getApplicationContext());
        binding.recycler.setAdapter(mAdapter);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private Context mContext;
        String[] datas;

        public MyAdapter(Context context) {
            mContext = context;
            datas = context.getResources().getStringArray(R.array.item_list);
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ActivityRvDatabindingItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.activity_rv_databinding_item, parent, false);
            return new MyViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
            String name = datas[position];
            holder.getBinding().setStr(name);

            //executePendingBindings()方法说明
            // When a variable or observable changes, the binding will be scheduled to change before the next frame.
            // There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            holder.getBinding().executePendingBindings();//此方法必须执行在UI线程，当绑定的数据修改时更新视图（不知道翻译的准不准）
        }

        @Override
        public int getItemCount() {
            return datas.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private ActivityRvDatabindingItemBinding binding;

            public MyViewHolder(ViewDataBinding binding) {
                super(binding.getRoot());
                this.binding = (ActivityRvDatabindingItemBinding) binding;
            }

            public ActivityRvDatabindingItemBinding getBinding() {
                return binding;
            }

            public void setBinding(ActivityRvDatabindingItemBinding binding) {
                this.binding = binding;
            }
        }
    }

}
