package leon.training.ndk.hotfix;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Native层修复
 */
public class NativePatch {

    private static final String CLASSES = "Classes";
    private static final String PATCH_CLASSES = "Patch-Classes";

    private Context mContext;
    private File mFile;
    private HashMap mClassMap;

    public NativePatch(Context context, File file) {
        this.mContext = context;
        this.mFile = file;
    }

    public void init() {
        mClassMap = new HashMap();
        JarFile jarFile = null;
        InputStream in = null;
        List<String> list = new ArrayList<String>();

        try {
            //同dom解析相似
            jarFile = new JarFile(mFile);
            //getJarEntry(file) file：传入路径
            JarEntry jarEntry = jarFile.getJarEntry("META-INF/PATCH.MF");
            in = jarFile.getInputStream(jarEntry);

            //解析
            Manifest manifest = new Manifest(in);
            //通过manifest 拿到MF文件里面的key-value
            Attributes attributes = manifest.getMainAttributes();

            for (Object key : attributes.keySet()) {
                String keyStr = (String) key;
                if (keyStr.endsWith(CLASSES)) {
                    String value = attributes.getValue(keyStr);
                    list = Arrays.asList(value.split(","));
                    if (keyStr.equalsIgnoreCase(PATCH_CLASSES)) {
                        mClassMap.put(keyStr, list);
                    } else {
                        mClassMap.put(keyStr.trim().substring(0, keyStr.length() - 8), list);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (jarFile != null) {
                try {
                    jarFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
