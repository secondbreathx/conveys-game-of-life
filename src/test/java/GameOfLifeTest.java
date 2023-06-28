import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLifeTest {

  private GameOfLife game;
  int rows = 5;
  int cols = 5;
  int firstBoardRow = 2;
  int firstBoardCol = 3;

  int secondBoardRow = 2;
  int secondBoardCol = 2;

  int fourthBoardRow = 4;
  int fourthBoardCol = 4;

  @BeforeEach
  public void setup() {
    game = new GameOfLife(rows, cols);
    game.setCell(2, 3, 1);
    game.setCell(2, 2, 1);
    game.setCell(3, 3, 1);
  }

  @Test
  public void setCellTest() {
    Assert.assertEquals(game.board[firstBoardRow][firstBoardCol], 1);
    Assert.assertEquals(game.board[secondBoardRow][secondBoardCol], 1);
    Assert.assertEquals(game.board[3][3], 1);
  }

  @Test
  public void itShouldBeSameCountAliveNeighbours() {
    int count = game.countAliveNeighbours(4, 4);
    Assert.assertEquals(count, 1);
  }
}
