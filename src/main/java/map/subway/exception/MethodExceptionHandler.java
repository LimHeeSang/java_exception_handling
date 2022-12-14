package map.subway.exception;

import map.subway.controller.LottoControllable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodExceptionHandler implements InvocationHandler {

    private final LottoControllable target;

    public MethodExceptionHandler(LottoControllable lottoControllable) {
        this.target = lottoControllable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            System.out.println(targetException.getMessage());

            if (targetException instanceof IllegalStateLottoCountException) {
                Class<?> aClass = Class.forName("map.subway.controller.LottoControllable");
                Method deleteLottoMethod = aClass.getMethod("deleteLotto");
                deleteLottoMethod.invoke(target, args);
            }

            return invoke(proxy, method, args);
        }
    }
}
