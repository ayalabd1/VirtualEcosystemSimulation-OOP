import java.awt.*;

abstract class Animal extends Organism implements I_AnimalAction {
    private int previous_move;

    public Animal(Point location, int energy, char name) {
        super(location, energy, name);
        this.previous_move = 0; // the previous move will be defined as ”Down”
    }
    public void move(Board board) {
        Point curr = this.location;
        int[] Dorder = {0,1,2,3};
        int Dprev = this.previous_move;
        int Dnew = Dprev;

        Point next_move = getNextMove(curr, Dnew);
        if (isValiddir(board, next_move)) {
            canMove(board, curr, next_move);
            return;
        }
        int attempts = 0;
        int idx = 0;

        while (attempts < 3 && idx < 4) {
            Dnew = Dorder[idx];
            idx++;
            if (Dnew == Dprev)
                continue;
            attempts++;
            next_move = getNextMove(curr, Dnew);
            if (isValiddir(board, next_move)) {
                canMove(board, curr, next_move);
                this.previous_move = Dnew;
                return;
            }
        }
    }
    protected abstract void minusEnergyEachMove();

    private Point getNextMove(Point curr, int dir) {
        switch (dir) {
            case 0: return new Point(curr.x+1, curr.y);
            case 1: return new Point(curr.x, curr.y-1);
            case 2: return new Point(curr.x-1, curr.y);
            case 3: return new Point(curr.x, curr.y+1);
            default: return new Point(curr.x, curr.y);
        }
    }
    private boolean isValiddir(Board board, Point p) {
        return board.isValidLocation(p) && board.isEmpty(p);
    }
    private void canMove(Board board, Point cur, Point to) {
        board.removeOrganism(cur);
        this.setLocation(to);
        board.putOrganism(to, this);
        minusEnergyEachMove();
    }


    public void eat(Board board) {
            Point curr = this.location;
            for (int dir = 0; dir < 4; dir++) {
                Point target = getNextMove(curr, dir);
                if (board.isValidLocation(target)) {
                    Organism meal = board.getOrganism(target);
                    if (canEat(meal)) {
                        this.energy += meal.getEnergy();
                        board.removeOrganism(target);
                        return;
                    }
                }
            }
    }
    protected abstract boolean canEat(Organism organism);

    public void daily_movement(Board board) {
        if (this.energy <= 0) {
            board.removeOrganism(this.location);
            return;
        }
        this.eat(board);
        this.move(board);
    }
}
