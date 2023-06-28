public class GameOfLife {
  int rows;
  int cols;
  int board[][];
  int nextGeneration[][];

  public GameOfLife(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.board = new int[rows][cols];
    this.nextGeneration = new int[rows][cols];
  }

  public void setCell(int row, int col, int value) {
    board[row][col] = value;
  }

  public void simulate(int cycles) {
    for (int i = 0; i < cycles; i++) {
      generateNextGeneration();
      board = nextGeneration;
    }
  }

  public void generateNextGeneration() {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int countAlive = countAliveNeighbours(row, col);
        if (board[row][col] == 1) {
          if (countAlive < 2 || countAlive > 3) {
            nextGeneration[row][col] = 0;
          } else {
            nextGeneration[row][col] = 1;
          }
        } else {

          if (countAlive == 3) {
            nextGeneration[row][col] = 1;
          } else {
            nextGeneration[row][col] = 0;
          }
        }
      }
    }
  }



  public int countAliveNeighbours(int row, int col) {
    int count = 0;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {

        if (i == 0 && j == 0) {
          continue;
        }
        int newAliveRow = row + i;
        int newAliveCol = col + j;
        if (isValid(newAliveRow, newAliveCol) && board[newAliveRow][newAliveCol] == 1) {
          count++;
        }
      }
    }
    return count;
  }


  public boolean isValid(int row, int col) {
    return (row >= 0 && row < rows) && col >= 0 && col < cols;
  }

  public void printBoard(int matrix[][]) {



    StringBuilder builder = null;

    for (int row = 0; row < rows; row++) {
      builder = new StringBuilder();

      for (int col = 0; col < cols; col++) {

        if (matrix[row][col] == 1) {
          builder.append(" 1 ");
        } else {
          builder.append(" . ");
        }
      }
      System.out.println(builder);
      System.out.println();
    }
  }
}
