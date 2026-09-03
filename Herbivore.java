import java.awt.*;

public class Herbivore extends Animal
{
    public Herbivore(int id, Point location)
    {
        super(location, 60, 'H');
    }
    protected void minusEnergyEachMove() {
        this.energy -= 10;
    }
    protected boolean canEat(Organism organism) {
        return organism instanceof Plant;
    }
}
