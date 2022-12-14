package my.lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validate(lotto);

        this.lotto = lotto;
    }

    private static void validate(List<Integer> lotto) {
        validateSize(lotto);
        validateRange(lotto);
        validateDuplication(lotto);
    }

    private static void validateSize(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateRange(List<Integer> lotto) {
        for (int number : lotto) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자이어야 합니다.");
            }
        }
    }

    private static void validateDuplication(List<Integer> lotto) {
        Set<Integer> set = new HashSet<>(lotto);
        if (set.size() != lotto.size()) {
            throw new IllegalArgumentException("[ERROR] 같은 로또 번호가 있으면 안됩니다.");
        }
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
