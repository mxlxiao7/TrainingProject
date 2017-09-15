package leon.training.designpattern.structure.facade;

import leon.training.utils.Utils;

/**
 * Created by maxiaolong on 2017/4/24.
 */

public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void start() {
        Utils.msg("\nComputer start begin...");
        cpu.start();
        disk.start();
        memory.start();
        Utils.msg("\nComputer start end...");
    }

    public void shutDown() {
        Utils.msg("\nComputer shutDown begin...");
        cpu.shutDown();
        disk.shutDown();
        memory.shutDown();
        Utils.msg("\nComputer shutDown end...");
    }
}