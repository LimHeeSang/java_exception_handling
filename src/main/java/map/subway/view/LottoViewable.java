package map.subway.view;

import map.subway.controller.LottoFeature;
import map.subway.controller.MainFeature;

import java.util.List;

public interface LottoViewable {

    MainFeature inputMainFeature();

    LottoFeature inputLottoFeature();

    List<Integer> inputBuyLottoNumbers();

    int inputDeleteLottoNumber();
}
