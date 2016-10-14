package reflect;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class Client {

  public static void main(String[] args) throws Throwable {
    RealSubject rs = new RealSubject(); // 在这里指定被代理类
    InvocationHandler ds = new DynamicSubject(rs);
    @SuppressWarnings("rawtypes")
    Class cls = rs.getClass();

    // 以下是一次性生成代理
    Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
    subject.request();
  }
}
