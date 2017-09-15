package leon.training.designpattern.structure.facade;

import leon.training.utils.Utils;

/**
 * Disk子系统类
 *
 * @author Administrator
 */
public class Disk {

    public void start() {
        Utils.msg("\nDisk is start...");
    }

    public void shutDown() {
        Utils.msg("\nDisk is shutDown...");
    }
}
