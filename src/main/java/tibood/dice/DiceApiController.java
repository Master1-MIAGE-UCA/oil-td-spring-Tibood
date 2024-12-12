package tibood.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceApiController {

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
        return DiceRollLog();
    }
    

}
