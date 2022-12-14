package my.lotto.controller;

import java.util.Arrays;

public enum MainFeature {

    LOTTO("1", "로또 구입 기능"),
    BOOK("2", "도서 구입 기능"),
    QUIT("Q", "종료");

    private final String number;
    private final String name;

    MainFeature(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public static MainFeature from(String number) {
        return Arrays.stream(MainFeature.values())
                .filter(mainFeature -> mainFeature.isEqual(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 1, 2, Q 중에서 입력가능합니다."));
    }

    private boolean isEqual(String number) {
        return this.number.equals(number);
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
