package leon.training.databinding;

import android.text.TextUtils;

/**
 * Created by maxiaolong on 2017/5/18.
 */

public class User {
    public String firstName = "赵";
    public String lastName = "云";
    public String phone = "18710221905";
    public int age = 24;
    public boolean isShowTag = true;

    /**
     * 获取全名
     *
     * @param firstName
     * @param lastName
     * @return
     */
    public String getFullName(String firstName, String lastName) {
        StringBuilder sb = new StringBuilder();
        sb.append("全名：");
        if (!TextUtils.isEmpty(firstName)) {
            sb.append(firstName);
        }
        if (!TextUtils.isEmpty(lastName)) {
            sb.append("." + lastName);
        }
        return sb.toString();
    }



}
