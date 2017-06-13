package leon.training.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leon.training.BaseActivity;
import leon.trainingproject.BR;
import leon.trainingproject.R;
import leon.trainingproject.databinding.ActivityDatabindingBinding;

/**
 * Created by maxiaolong on 2017/5/19.
 * http://blog.csdn.net/qq_33689414/article/details/52205724
 * http://www.jianshu.com/p/de4d50b88437
 */

public class DataBindingActivity extends BaseActivity implements EventCallback {

    private ActivityDatabindingBinding binding;
    private int i = 0;
    private int j = 0;
    private Person mPerson;
    private Animal mAnimal;
    private ObservableArrayList<String> mAnimalList;
    private ObservableArrayMap<String, String> mAnimalMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(DataBindingActivity.this, R.layout.activity_databinding);
        binding.tagTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DataBindingActivity.this, binding.tagTV.getText(), 0).show();
            }
        });
        binding.setDemoClick(this);
        initData(i);

        //别名
        User user = new User();
        user.firstName = "关";
        user.lastName = "羽";
        user.age = 22;
        user.phone = "18710221905";
        binding.setTagContent("猛将");
        binding.setTagClick(true);
        binding.setUser(user);
        binding.setUser2(user);

        //自动更新
        mPerson = new Person();
        binding.setPerson(mPerson);

        //Observable数据改变自动更新
        mAnimal = new Animal();
        mAnimal.field.set("cat");
        mAnimal.age.set(2);
        binding.setAnimal(mAnimal);

        mAnimalList = new ObservableArrayList<>();
        mAnimalList.add("dog");
        mAnimalList.add("mouse");
        binding.setAnimalList(mAnimalList);

        mAnimalMap = new ObservableArrayMap<>();
        mAnimalMap.put("name", "Tom");
        mAnimalMap.put("age", "4");
        binding.setAnimalMap(mAnimalMap);
    }

    /**
     * binding设置数据有2中方式:
     * 1.binding.setUser(user)
     * 2.binding.setVariable(BR.user,user)–采用BR指定
     *
     * @param j
     */
    private void initData(int j) {
        User user = new User();
        switch (j) {
            case 0:
                user.firstName = "赵";
                user.lastName = "云";
                user.age = 22;
                user.phone = "18710221905";
                binding.setTagContent("猛将");
                binding.setTagClick(true);
                binding.setUser(user);
                break;
            case 1:
                user.firstName = "诸葛";
                user.lastName = "亮";
                user.age = 25;
                user.phone = "18710221905";
                binding.setTagContent("儒将");
                binding.setTagClick(true);
                binding.setVariable(BR.user, user);
                break;
        }
        binding.setUser(user);
        i++;
    }


    public void change(View view) {
        int index = i % 2;
        initData(index);
    }

    @Override
    public void click(View v) {
        Toast.makeText(DataBindingActivity.this, "点击", 0).show();
    }

    /**
     * model变量改变自动更新数据
     *
     * @param v
     */
    @Override
    public void click2(View v) {
        switch (j % 2) {
            case 0:
                mPerson.setFirstName("马");
                mPerson.setLastName("超");
                mPerson.setAge(25);
                mPerson.toString();
                break;
            case 1:
                mPerson.setFirstName("黄");
                mPerson.setLastName("钟");
                mPerson.setAge(44);
                mPerson.toString();
                break;
        }
        j++;
    }

    /**
     * 集合数据绑定
     *
     * @param v
     */
    @Override
    public void click3(View v) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        binding.setList(list);

        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "40");
        binding.setMap(map);

        String[] arrays = {"lisi", "laowang"};
        binding.setStrArrays(arrays);
    }


    /**
     * 集合数据自动更新
     *
     * @param v
     */
    @Override
    public void click4(View v) {
        switch (j % 2) {
            case 0:
                mAnimal.field.set("cat");
                mAnimal.age.set(2);
                mAnimalList.set(0, "dog");
                mAnimalList.set(1, "mouse");
                mAnimalMap.put("name", "Tom");
                mAnimalMap.put("age", "4");
                break;
            case 1:
                mAnimal.field.set("dog");
                mAnimal.age.set(4);
                mAnimalList.set(0, "cat");
                mAnimalList.set(1, "dog");
                mAnimalMap.put("name", "Sam");
                mAnimalMap.put("age", "5");
                break;
        }
        j++;
    }

    /**
     * @param v
     */
    @Override
    public void click5(View v) {
        startActivity(new Intent(DataBindingActivity.this, DataBindingListActivity.class));
    }
}
