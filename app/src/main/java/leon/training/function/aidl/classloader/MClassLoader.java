package leon.training.function.aidl.classloader;

/**
 * @author maxiaolong3
 * @version V1.0
 * @description:
 * @date 2018/3/21 下午8:26
 */
public class MClassLoader extends ClassLoader {

    /**
     *
     * 首先会执行loadclass，一般不会复写此方法，防止破坏双亲委派
     *
     *
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        //加上锁，同步处理，因为可能是多线程在加载类
        synchronized (name) {
            //检查，是否该类已经加载过了，如果加载过了，就不加载了
            Class c = findLoadedClass(name);

            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                //如果parent加载类失败，就调用自己的findClass方法进行类加载
                c = findClass(name);
            }

            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    /**
     *
     *  在使用时一般复写此方法
     *  当loadclass调用后委托父加载器加载不到东西时，会调用本加载器的findClass方法
     *  在此方法中加载类数据，然后使用defineClass()生成类返回
     *
     * @param name
     * @return
     */
    protected Class findClass(String name) {
        return null;
    }
}
