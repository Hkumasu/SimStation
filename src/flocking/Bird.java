/*
4/13/2023 - Hazuki Sugahara: Created the file
*/

package flocking;

import mvc.*;
import simstation.*;
import simstation.Agent;
import simstation.Heading;

class Bird extends Agent {

//    int speed;

    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(10) + 1;
    }

    public void update() {
        Agent neighbor = simulation.getNeighbor(this, 5);
        if (neighbor != null) {
            heading = neighbor.getHeading();
            speed = neighbor.getSpeed();
        }
        move(speed);
    }
}
