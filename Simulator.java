import java.awt.Point;

public class Simulator {
    private Board simBoard;

    public Simulator(int boardX, int boardY, int numOfCarnivores, int numOfHerbivores, int numOfPlants) {
        simBoard = new Board(boardX, boardY);
        simBoard.placeOrganisms(numOfCarnivores, numOfHerbivores, numOfPlants);
        System.out.println("Starting board state:");
        simBoard.printBoard();
    }

    public void run(int numOfDays) {
        // implement this function for simulating numOfDays
        for (int day = 1; day <= numOfDays; day++) {
            System.out.println("Day " + day + ":");

            boolean[][] been_to = new boolean[simBoard.getRows()][simBoard.getCols()];
            for (int row = 0; row < simBoard.getRows(); row++) {
                for (int col = 0; col < simBoard.getCols(); col++) {
                    if (!been_to[row][col]) {
                        Organism org = simBoard.getOrganism(new Point(row, col));
                        if (org != null) {
                            org.daily_movement(simBoard);
                            Point next = org.getLocation();
                            if (simBoard.isValidLocation(next)) {
                                been_to[next.x][next.y] = true;
                            }
                        }
                    }
                }
            }
            simBoard.printBoard();
            System.out.println();
        }
    }
}