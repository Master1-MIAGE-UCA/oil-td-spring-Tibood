package tibood.dice;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DiceController {

    private DiceRepository diceRepository;

    @GetMapping("/rollDice")
    public int rollDice(){
        return new Dice().roll();
    }

    @GetMapping("/rollDices/{X}")
    public int[] rollDiceXtime(@PathVariable int X){
        int result = 0;
        DiceRollLog diceRollLog = new DiceRollLog();
        diceRollLog.setDiceCount(X);
        for (int i = 0; i < X; i++) {
            result += new Dice().roll();
            diceRollLog.setResults(i, result);
            diceRollLog.setTimestamp(new Date());
        }
        return diceRollLog.getResults();
    }

    @GetMapping("/diceLogs")
    public Iterable<DiceRollLog> diceLogs(){
        return diceRepository.findAll();
    }
    

}
