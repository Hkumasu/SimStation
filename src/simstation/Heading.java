package simstation;

import java.util.Random;

public enum Heading {

    NORTH,

    EAST,

    WEST,

    SOUTH;
    
    public static Heading random() {
        Random random = new Random();
        int x = random.nextInt(3);
        if(x == 0)
            return NORTH;
        else if(x == 1)
            return EAST;
        else if(x == 2)
            return WEST;
        return SOUTH;
    }
}
