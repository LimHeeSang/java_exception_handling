package map.subway.exception;

import map.subway.view.LottoViewable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputExceptionHandler implements InvocationHandler {

    private final LottoViewable target;

    public InputExceptionHandler(LottoViewable lottoViewable) {
        this.target = lottoViewable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException e) {
            printExceptionMessage(e);
            return invoke(proxy, method, args);
        }
    }

    private void printExceptionMessage(InvocationTargetException e) {
        Throwable targetException = e.getTargetException();
        System.out.println(targetException.getMessage());
    }
}
