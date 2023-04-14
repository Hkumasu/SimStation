/*
4/13/2023 - Hazuki Sugahara: Created the file
*/

package flocking;

import mvc.*;
import simstation;
class Bird extends Agent {

//    int speed;

    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public void update() {
        Agent neighbor = simulation.getneightbor(this, 10);
        if (neighbor != null) {
            heading = neighbor.getHeading();
            speed = neighbor.getSpeed();
        }
        move(speed);
    }
}
