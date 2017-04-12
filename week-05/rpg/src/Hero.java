import java.awt.*;

public class Hero {
  int heroPosX;
  int heroPosY;
  String direction;
  int moveCounter;
  int level;
  int HP;
  int DP;
  int SP;
  boolean hasKey;
  boolean canMove;

  Hero() {
    heroPosX = 0;
    heroPosY = 0;
    direction = "down";
    moveCounter = 0;
    level = 1;
    HP = 20 + 3 * (int) (Math.random() * 6 + 1);
    DP = 2 * (int) (Math.random() * 6 + 1);
    SP = 5 + (int) (Math.random() * 6 + 1);
    hasKey = false;
    canMove = true;
  }

  public void drawHero(Graphics g) {
    if (direction == "right") {
      PositionedImage image = new PositionedImage("hero-right.png", heroPosX, heroPosY);
      image.draw(g);
    } else if (direction == "left") {
      PositionedImage image = new PositionedImage("hero-left.png", heroPosX, heroPosY);
      image.draw(g);
    } else if (direction == "up") {
      PositionedImage image = new PositionedImage("hero-up.png", heroPosX, heroPosY);
      image.draw(g);
    } else {
      PositionedImage image = new PositionedImage("hero-down.png", heroPosX, heroPosY);
      image.draw(g);
    }
  }

  public void heroMovementY(int i, int[][] matrix) {
    if (canMove) {
      if (i < 0) {
        if (heroPosY >= 72 && matrix[heroPosX / 72][heroPosY / 72 - 1] != 1) {
          heroPosY += i;
        }
        direction = "up";
        moveCounter++;
      } else {
        if (heroPosY < 648 && matrix[heroPosX / 72][heroPosY / 72 + 1] != 1) {
          heroPosY += i;
        }
        direction = "down";
        moveCounter++;
      }
    }
  }

  public void heroMovementX(int i, int[][] matrix) {
    if (canMove) {
      if (i < 0) {
        if (heroPosX >= 72 && matrix[heroPosX / 72 - 1][heroPosY / 72] != 1) {
          heroPosX += i;
        }
        direction = "left";
        moveCounter++;
      } else {
        if (heroPosX < 648 && matrix[heroPosX / 72 + 1][heroPosY / 72] != 1) {
          heroPosX += i;
        }
        direction = "right";
        moveCounter++;
      }
    }
  }
}
