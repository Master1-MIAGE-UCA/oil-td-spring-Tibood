package tibood.dice;

import org.springframework.stereotype.Service;

import tibood.dice.DiceRollLog.DiceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

@Service
public class DiceService {
    private DiceRepository diceRepository;

    public DiceService(DiceRepository diceRepository) {
        this.diceRepository = diceRepository;
    }

    public List<Integer> rollDice(int numberOfDice) {
        List<Integer> results = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfDice; i++) {
            int result = random.nextInt(6) + 1;
            results.add(result);
        }

        DiceRollLog history = new DiceRollLog();
        history.setDiceCount(numberOfDice);
        history.setResults(results);
        history.setTimestamp(new Date());
        diceRepository.save(history);

        return results;
    }
}
