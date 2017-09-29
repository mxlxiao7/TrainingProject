// IServieInterface.aidl
package leon.training.function.aidl;

// Declare any non-default types here with import statements

import leon.training.function.aidl.Info;
import leon.training.function.aidl.Controler;


interface IServieInterface {

    String getServiceName();

    Info getInfo();

    void registControler(Controler c);

    void unRegistControler(Controler c);

    void doTask();
}
