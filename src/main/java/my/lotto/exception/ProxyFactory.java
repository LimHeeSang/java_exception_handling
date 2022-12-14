package my.lotto.exception;

import my.lotto.controller.LottoControllable;
import my.lotto.view.LottoViewable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static LottoViewable createProxy(InvocationHandler handler) {
        return (LottoViewable) Proxy.newProxyInstance(
                LottoViewable.class.getClassLoader(),
                new Class[]{LottoViewable.class},
                handler);
    }

    public static LottoControllable createProxy2(InvocationHandler handler) {
        return (LottoControllable) Proxy.newProxyInstance(
                LottoControllable.class.getClassLoader(),
                new Class[]{LottoControllable.class},
                handler);
    }
}
