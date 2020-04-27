package demo14;


@FunctionalInterface
public interface MessageBuilder {

    // 拼接消息的抽象方法
    public abstract String buildMessage();
}
