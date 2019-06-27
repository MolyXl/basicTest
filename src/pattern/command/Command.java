package pattern.command;

/**
 * @author MaZhuli
 * @description 命令接口
 * @date 2019/6/27
 */
//命令模式的目的就是达到命令的发出者和执行者之间解耦
public interface Command {
    public void exe();
}
