package leon.training.designpattern.structure.facade;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/4/24.
 */

public class CPU {
    public void start() {
        Utils.msg("\nCpu is start...");
    }

    public void shutDown() {
        Utils.msg("\nCPU is shutDown...");
    }

}
