import java.awt.*;

public class Plant extends Organism
{
    public Plant(int id, Point location)
    {
        super(location, 20, 'P');
    }
    public void daily_movement(Board board) {
        this.energy += 10;
    }

}
