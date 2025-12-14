package Demo4;

// 接口策略
public interface PaymentStrategy {
    void pay(int amount);
}
// 具体策略：AliPay
class AliPay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("支付宝支付：" + amount + "元");
    }
}
// 具体策略：WeChat
class WeChatPay implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("微信支付：" + amount + "元");
    }
}
// 上下文：购物车
class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int money) {
        strategy.pay(money);
    }
}
//客户端
class Client {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 用户选支付宝
        cart.setPaymentStrategy(new AliPay());
        cart.checkout((100));

        // 用户突然改主意选微信
        cart.setPaymentStrategy(new WeChatPay());
        cart.checkout(100);
    }
}