import java.awt.*;

public class Carnivore extends Animal {

    public Carnivore(int id, Point location)
    {
        super(location, 40, 'C');
    }
    protected void minusEnergyEachMove() {
        this.energy -= 15;
    }
    public boolean canEat(Organism organism) {
        return organism instanceof Herbivore;
    }
}
