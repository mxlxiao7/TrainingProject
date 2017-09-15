package leon.training.databinding;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by maxiaolong on 2017/5/22.
 */

public class Animal {
    public final ObservableField<String> field = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
