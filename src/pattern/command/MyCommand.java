package pattern.command;

/**
 * @author MaZhuli
 * @description 命令实现
 * @date 2019/6/27
 */
public class MyCommand implements Command{
    //持有接受者
    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
