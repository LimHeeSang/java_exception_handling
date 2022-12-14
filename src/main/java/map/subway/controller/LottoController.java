package map.subway.controller;

import map.subway.service.LottoService;
import map.subway.view.LottoInputView;
import map.subway.view.LottoOutputView;
import map.subway.view.LottoViewable;

import java.util.List;

public class LottoController implements LottoControllable {

    private final LottoService lottoService;
    private final LottoViewable lottoViewable;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
        this.lottoViewable = LottoInputView.getInstance();
    }

    @Override
    public void run() {
        LottoFeature lottoFeature;
        do {
            LottoOutputView.printLottoFeature();
            lottoFeature = lottoViewable.inputLottoFeature();

            lottoFeature.process(this);
        } while (!lottoFeature.isBack());
    }

    public void lottoBuy() {
        List<Integer> lottoNumbers = lottoViewable.inputBuyLottoNumbers();
        lottoService.buyLotto(lottoNumbers);
        LottoOutputView.printLottoBuy();
    }

    public void getBuyLottos() {
        List<List<Integer>> lottos = lottoService.getLotto();
        LottoOutputView.printLottos(lottos);
    }

    public void deleteLotto() {
        int number = lottoViewable.inputDeleteLottoNumber();
        lottoService.deleteLotto(number);
        LottoOutputView.printDeleteLotto();
    }
}
