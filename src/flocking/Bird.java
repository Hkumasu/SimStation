/*
4/13/23 - Hazuki Sugahara: Created the file
4/14/23 - Hazuki Sugahara: Modified the file
*/

package flocking;

import mvc.*;
import simstation.*;

class Bird extends Agent {

   int speed;

    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public int getSpeed() { return speed; }
    
    public void update() {
        Bird neighbor = (Bird) simulation.getneightbor(this, 5);
        if (neighbor != null) {
            heading = neighbor.getHeading();
            speed = neighbor.speed;
        }
        move(speed);
    }
}
