package leon.training.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import leon.trainingproject.BR;

/**
 * Created by maxiaolong on 2017/5/19.
 */
public class Person extends BaseObservable {
    private String firstName;
    private String lastName;
    private int age;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Override
    public String toString() {
        String content = "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
        notifyChange();
        return content;
    }
}
