package pattern.chain_of_responsibility;

/**
 * @author MaZhuli
 * @description 处理器
 * @date 2019/6/27
 */
//责任链模式，有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求。
public interface Handler {
    public void operator();
}
