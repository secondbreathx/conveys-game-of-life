public class MainClass {

  public static void main(String[] args) {
    int rows = 5;
    int cols = 5;

    GameOfLife gameOfLife = new GameOfLife(rows,cols);
    // 1 means that live cell
    // 0 means that dead cell
    gameOfLife.setCell(2,3,1);
    gameOfLife.setCell(2,2,1);
    gameOfLife.setCell(3,3,1);

    // initial Board
    System.out.println("This is initial board ");
    gameOfLife.printBoard(gameOfLife.board);

    // Applying Iteration
    gameOfLife.simulate(6);

    // Final Board
    System.out.println();
    System.out.println("This is last board ");
    gameOfLife.printBoard(gameOfLife.nextGeneration);
  }
}
