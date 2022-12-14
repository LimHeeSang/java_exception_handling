package map.subway.service;

import map.subway.Repository.LottoRepository;
import map.subway.exception.IllegalStateLottoCountException;
import map.subway.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void buyLotto(List<Integer> numbers) {
        if (lottoRepository.size() >= 2) {
            throw new IllegalStateLottoCountException();
        }

        Lotto lotto = new Lotto(numbers);
        lottoRepository.save(lotto);
    }

    public List<List<Integer>> getLotto() {
        List<Lotto> lottos = lottoRepository.findAll();
        return lottos.stream()
                .map(Lotto::getLotto)
                .collect(Collectors.toList());
    }

    public void deleteLotto(int number) {
        lottoRepository.remove(number);
    }
}
