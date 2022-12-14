package my.lotto.view;

import my.lotto.controller.LottoFeature;
import my.lotto.controller.MainFeature;

import java.util.List;

public interface LottoViewable {

    MainFeature inputMainFeature();

    LottoFeature inputLottoFeature();

    List<Integer> inputBuyLottoNumbers();

    int inputDeleteLottoNumber();
}
