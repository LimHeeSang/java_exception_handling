package map.subway.view;

import map.subway.controller.LottoFeature;
import map.subway.controller.MainFeature;
import map.subway.exception.ExceptionHandler;

import java.util.List;

public class ProxyLottoInputView implements LottoViewable {

    private final LottoViewable lottoViewable;

    public ProxyLottoInputView(LottoViewable lottoViewable) {
        this.lottoViewable = lottoViewable;
    }

    @Override
    public MainFeature inputMainFeature() {
        return ExceptionHandler.input(lottoViewable::inputMainFeature);
    }

    @Override
    public LottoFeature inputLottoFeature() {
        return ExceptionHandler.input(lottoViewable::inputLottoFeature);
    }

    @Override
    public List<Integer> inputBuyLottoNumbers() {
        return ExceptionHandler.input(lottoViewable::inputBuyLottoNumbers);
    }

    @Override
    public int inputDeleteLottoNumber() {
        return ExceptionHandler.input(lottoViewable::inputDeleteLottoNumber);
    }
}
