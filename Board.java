import java.util.Random;
import java.awt.Point;

public class Board
{
    private Organism[][] board;
    private int rows;
    private int cols;
    Random rand;
    long seed;

    public Board(int rows, int columns)
    {
        board = new Organism[rows][columns];
        this.rows = rows;
        this.cols = columns;

        // reset all board cells to null
        resetBoard();

        seed = System.nanoTime();
        rand = new Random(seed);
    }

    // Set all cells on the board to null.
    // This is the initial state of the board
    // before organisms are placed.
    public void resetBoard()
    {
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                board[i][j] = null;
            }
        }
    }

    public Boolean isEmpty(Point p)
    {
        return board[p.x][p.y] == null;
    }


    // Find a random empty cell on the board
    // returns a Point object if found or Null if not found
    private Point getNextRandomEmptyLocation()
    {
        Point p = new Point();
        long attempts = (long)this.rows * this.cols * 2;
        do
        {
            attempts--;
            p.x = rand.nextInt(this.rows);
            p.y = rand.nextInt(this.cols);
        }
        while(!isEmpty(p) && (attempts > 0));

        return((attempts > 0)? p : null);
    }

    // Place organisms on the board
    // inputs: the number of figures of each type to be placed
    public void placeOrganisms(int numOfCarnivores, int numOfHerbivores, int numOfPlants)
    {
        int count = 0;

        for (int i = 0; i < numOfCarnivores; i++) {
            Point p = getNextRandomEmptyLocation();
            if (p != null) {
                board[p.x][p.y] = new Carnivore(count++, p);
            }
        }
        for (int i = 0; i < numOfHerbivores; i++) {
            Point p = getNextRandomEmptyLocation();
            if (p != null) {
                board[p.x][p.y] = new Herbivore(count++, p);
            }
        }
        for (int i = 0; i < numOfPlants; i++) {
            Point p = getNextRandomEmptyLocation();
            if (p != null) {
                board[p.x][p.y] = new Plant(count++, p);
            }
        }
    }

    public int getCols() {
        return cols;
    }
    public int getRows() {
        return rows;
    }
    public Organism getOrganism(Point p) {
        return board[p.x][p.y];
    }
    public void putOrganism(Point p, Organism o) {
        board[p.x][p.y] = o;
    }
    public void removeOrganism(Point p) {
        board[p.x][p.y] = null;
    }
    public boolean isValidLocation(Point p) {
        return p.x >= 0 && p.x < rows && p.y >= 0 && p.y < cols;
    }

    // print the current board state
    // Organisms are printed by name
    // empty cells are printed as 0
    public void printBoard()
    {
        char printed;
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                printed = (board[i][j] == null) ? '0' : board[i][j].name;
                System.out.print(printed + "" + ' ');
            }

            System.out.println();
        }
    }
}
