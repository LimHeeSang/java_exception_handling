package my.lotto.controller;

import my.lotto.exception.ExceptionHandler;

import java.util.Arrays;
import java.util.function.Consumer;

public enum LottoFeature {

    LOTTO_BUY("1", "로또 구입", LottoController::lottoBuy),
    LOTTO_GET("2", "구입한 로또 조회", LottoController::getBuyLottos),
    LOTTO_DELETE("3", "로또 삭제", LottoController::deleteLotto),
    BACK("B", "돌아가기", lottoController -> {});

    private final String number;
    private final String name;
    private final Consumer<LottoController> consumer;

    LottoFeature(String number, String name, Consumer<LottoController> consumer) {
        this.number = number;
        this.name = name;
        this.consumer = consumer;
    }

    public static LottoFeature from(String number) {
        return Arrays.stream(LottoFeature.values())
                .filter(lottoFeature -> lottoFeature.isEqual(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 1, 2, 3, B 중에서 입력가능합니다."));
    }

    private boolean isEqual(String number) {
        return this.number.equals(number);
    }

    public void process(LottoController lottoController) {
        ExceptionHandler.process(consumer, lottoController);
    }

    public boolean isBack() {
        return this == BACK;
    }
}
