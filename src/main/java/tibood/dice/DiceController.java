package tibood.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import tibood.dice.DiceRepository;

@RestController
public class DiceController {

    private DiceRepository diceRepository;

    @GetMapping("/rollDice")
    public int rollDice(){
        return new Dice().roll();
    }

    @GetMapping("/rollDices/{X}")
    public int rollDiceXtime(int X){
        int result = 0;
        for (int i = 0; i < X; i++) {
            DiceRollLog diceRollLog = new DiceRollLog();
            result += new Dice().roll();
        }
        return result;
    }

    @GetMapping("/diceLogs")
    public Iterable<DiceRollLog> diceLogs(){
        return diceRepository.findAll();
    }
    

}
