package map.subway;

import map.subway.Repository.LottoRepository;
import map.subway.controller.FrontController;
import map.subway.controller.LottoControllable;
import map.subway.controller.LottoController;
import map.subway.exception.MethodExceptionHandler;
import map.subway.service.LottoService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Application {

    public static void main(String[] args) {
        FrontController frontController = getFrontController();
        frontController.run();
    }

    private static FrontController getFrontController() {
        return new FrontController(getLottoController());
    }

    private static LottoControllable getLottoController() {
        return createControllerProxy(new MethodExceptionHandler(new LottoController(lottoService())));
    }

    public static LottoControllable createControllerProxy(InvocationHandler handler) {
        return (LottoControllable) Proxy.newProxyInstance(
                LottoControllable.class.getClassLoader(),
                new Class[]{LottoControllable.class},
                handler);
    }

    private static LottoService lottoService() {
        return new LottoService(lottoRepository());
    }

    private static LottoRepository lottoRepository() {
        return new LottoRepository();
    }
}