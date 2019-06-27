package pattern.command;

/**
 * @author MaZhuli
 * @description 命令下达者
 * @date 2019/6/27
 */
public class Invoker {
    //持有命令
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.exe();
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
