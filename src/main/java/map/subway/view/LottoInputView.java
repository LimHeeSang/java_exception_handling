package map.subway.view;

import map.subway.controller.LottoFeature;
import map.subway.controller.MainFeature;
import map.subway.exception.InputExceptionHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView implements LottoViewable {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LottoInputView lottoInputView = new LottoInputView();

    private LottoInputView() {
    }

    public static LottoViewable getInstance() {
        return createProxy(new InputExceptionHandler(lottoInputView));
    }

    public static LottoViewable createProxy(InvocationHandler handler) {
        return (LottoViewable) Proxy.newProxyInstance(
                LottoViewable.class.getClassLoader(),
                new Class[]{LottoViewable.class},
                handler);
    }

    @Override
    public MainFeature inputMainFeature() {
        System.out.println("원하는 기능을 입력하세요: ");
        return MainFeature.from(scanner.nextLine());
    }

    @Override
    public LottoFeature inputLottoFeature() {
        System.out.println("원하는 로또 기능을 입력하세요");
        return LottoFeature.from(scanner.nextLine());
    }

    @Override
    public List<Integer> inputBuyLottoNumbers() {
        System.out.println("구입할 로또 번호를 입력하세요.");
        String s = scanner.nextLine();
        String[] split = s.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public int inputDeleteLottoNumber() {
        System.out.println("조회목록의 삭제할 로또 번호를 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
