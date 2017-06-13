package leon.training.designpattern.behavior.chain;

/**
 * Created by maxiaolong on 2017/5/25.
 */

public interface IHandler {

    /**
     * 处理请求
     */
    public String handleRequest(String user, double fee);

    public IHandler getSuccessor();

    public void setSuccessor(IHandler successor);
}
