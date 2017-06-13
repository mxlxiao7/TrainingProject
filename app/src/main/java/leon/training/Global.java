package leon.training;


import leon.trainingproject.BuildConfig;

public class Global {

    public static final boolean DEBUG = false;


    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}