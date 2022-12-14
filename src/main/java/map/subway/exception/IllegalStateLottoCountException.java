package map.subway.exception;

public class IllegalStateLottoCountException extends RuntimeException {

    public IllegalStateLottoCountException() {
        super("[ERROR] 로또는 최대 2개까지 구매할 수 있습니다.");
    }
}
