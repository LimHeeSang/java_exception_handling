package map.subway.repository;

import map.subway.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottos;

    public LottoRepository() {
        this.lottos = new ArrayList<>();
    }

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAll() {
        return Collections.unmodifiableList(lottos);
    }

    public void remove(int number) {
        lottos.remove(number - 1);
    }

    public int size() {
        return lottos.size();
    }
}
