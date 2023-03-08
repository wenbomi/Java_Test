package proxy;

/**
 * @ClassName Apple
 * @Author Xiao Mi
 * @Date 2023/1/6 10:25
 * 简介：真实类
 */
public class Apple implements saleComputer{
    @Override
    public String sale(double money) {
        System.out.println("消费了" + money + "买了一台MacBook Air M1。。。");
        return "Mac Computer";
    }

    @Override
    public void show() {
        System.out.println("展示电脑... ");
    }
}
