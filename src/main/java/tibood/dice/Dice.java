package tibood.dice;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Dice {

    public int roll(){
        Random random=new Random();
        return random.nextInt(6)+1;
    }
}
