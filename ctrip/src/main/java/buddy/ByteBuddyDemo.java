package buddy;

import java.util.concurrent.Callable;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author xbguo
 * @date 2024/7/25 16:36
 */
public class ByteBuddyDemo {

        public static void main(String[] args) throws Exception {
            // 创建 GreetingServiceImpl 的动态代理类
            GreetingService proxy = new ByteBuddy()
                .subclass(GreetingServiceImpl.class)
                .method(ElementMatchers.named("greet"))
                .intercept(MethodDelegation.to(GreetingInterceptor.class))
                .make()
                .load(ByteBuddyDemo.class.getClassLoader())
                .getLoaded()
                .newInstance();

            // 调用代理类的方法
            String result = proxy.greet("ByteBuddy");
            System.out.println(result);


        }
    public static class GreetingInterceptor {
        @RuntimeType
        public static Object intercept(@SuperCall Callable<?> zuper) throws Exception {
            System.out.println("Before method call");
            try {
                return zuper.call();
            } finally {
                System.out.println("After method call");
            }
        }
    }
}

