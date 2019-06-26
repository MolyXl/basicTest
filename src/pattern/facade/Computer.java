package pattern.facade;

/**
 * @author MaZhuli
 * @description 电脑
 * @date 2019/6/26
 */
//外观模式是为了解决类与类之家的依赖关系的，降低类之间的耦合度
public class Computer {
    private Cpu cpu;
    private Memory memory;
    private Thread thread;

    public Computer(Cpu cpu, Memory memory, Thread thread) {
        this.cpu = cpu;
        this.memory = memory;
        this.thread = thread;

    }

    public void startUp() {
        this.cpu.startUp();
        this.memory.startUp();
        this.thread.startUp();
    }

    public void shutDown() {
        this.cpu.shutDown();
        this.memory.shutDown();
        this.thread.shutDown();
    }
}
