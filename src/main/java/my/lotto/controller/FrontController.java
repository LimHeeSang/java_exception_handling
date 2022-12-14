package my.lotto.controller;

import my.lotto.view.LottoInputView;
import my.lotto.view.LottoOutputView;
import my.lotto.view.LottoViewable;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

    private final Map<MainFeature, LottoControllable> controllers;
    private final LottoViewable lottoViewable;

    public FrontController(LottoControllable lottoControllable) {
        this.controllers = new HashMap<>();
        controllers.put(MainFeature.LOTTO, lottoControllable);
        this.lottoViewable = LottoInputView.getInstance();
    }

    public void run() {
        MainFeature mainFeature;
        do {
            LottoOutputView.printMainFeature();
            mainFeature = lottoViewable.inputMainFeature();

            LottoControllable lottoControllable = controllers.get(mainFeature);
            lottoControllable.run();
        } while (!mainFeature.isQuit());
    }

}
