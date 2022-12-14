package map.subway.view;

import java.util.List;

public class LottoOutputView {

    private LottoOutputView() {
    }

    public static void printMainFeature() {
        System.out.println("1. 로또 구입 기능\n" +
                "2. 도서 구입 기능\n" +
                "Q. 종료");
        printBlank();
    }

    private static void printBlank() {
        System.out.println();
    }

    public static void printLottoFeature() {
        System.out.println("1. 로또 구입\n" +
                "2. 구입한 로또 조회\n" +
                "3. 로또 삭제\n" +
                "B. 돌아가기");
        printBlank();
    }

    public static void printLottos(List<List<Integer>> lottos) {
        if (lottos.size() == 0) {
            System.out.println("구입한 로또가 없습니다.");
            return;
        }

        int number = 1;
        for (List<Integer> lotto : lottos) {
            System.out.printf("%d. %s%n", number++, lotto);
        }
        printBlank();
    }

    public static void printLottoBuy() {
        System.out.println("로또를 구입했습니다.");
        printBlank();
    }

    public static void printDeleteLotto() {
        System.out.println("로또를 삭제했습니다.");
        printBlank();
    }

    public static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
