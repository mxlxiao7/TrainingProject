package leon.training.thread.phaser;

import java.util.concurrent.Phaser;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/1/16.
 */

public class PhaserUtil {

    /**
     * 开启3个线程，分别打印字母a,b,c各10次，然后进入下一阶段打印后面的字母d,e,f各10次，然后再进入下一阶段.......以此类推，直到整个字母表全部打印完毕。
     */
    public static void doAction() {
        Phaser phaser = new Phaser(3) {// 共有3个工作线程，因此在构造函数中赋值为3
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                Utils.msg("\n=========华丽的分割线=============");
                return registeredParties == 0;
            }
        };

        Utils.msg("程序开始执行");
        char a = 'a';
        for (int i = 0; i < 3; i++) { // 创建并启动3个线程
            new PrintThread((char) (a + i), phaser).start();
        }

        while (!phaser.isTerminated()) {// 只要phaser不终结，主线程就循环等待
            Thread.yield();
        }
        Utils.msg("程序结束");
    }
}
