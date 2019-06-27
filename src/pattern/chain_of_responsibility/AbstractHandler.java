package pattern.chain_of_responsibility;

/**
 * @author MaZhuli
 * @description 抽象类
 * @date 2019/6/27
 */
public class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
