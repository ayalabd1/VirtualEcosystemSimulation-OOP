import java.awt.Point;

abstract class Organism
{
    protected Point location;
    private static int count = 0;
    protected int id;
    protected int energy;
    protected char name;

    public Organism() {
        id = count++;
        name = ' ';
    }
    //constructors
    public Organism(Point location, int energy, char name) {
        this();
        this.location = location;
        this.energy = energy;
        this.name = name;
    }
    public Point getLocation() {
        return location;
    }
    public void setLocation(Point location) {
        this.location = location;
    }
    public int getEnergy() {
        return energy;
    }

    public abstract void daily_movement(Board board);
}
