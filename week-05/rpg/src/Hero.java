import java.awt.*;
import java.lang.*;

public class Hero extends Character {
  int maxHP;
  String direction;
  int moveCounter;
  boolean hasKey;

  Hero() {
    posX = 0;
    posY = 0;
    direction = "down";
    moveCounter = 0;
    level = 1;
    maxHP = 10 + 1 * (int) (Math.random() * 6 + 1);
    HP = maxHP;
    DP = 1 + (int) (Math.random() * 6 + 1);
    SP = 1 + (int) (Math.random() * 6 + 1);
    hasKey = false;
    canMove = true;
  }

  public void drawHero(Graphics g) {
    if (direction == "right") {
      PositionedImage image = new PositionedImage("hero-right.png", posX, posY);
      image.draw(g);
    } else if (direction == "left") {
      PositionedImage image = new PositionedImage("hero-left.png", posX, posY);
      image.draw(g);
    } else if (direction == "up") {
      PositionedImage image = new PositionedImage("hero-up.png", posX, posY);
      image.draw(g);
    } else {
      PositionedImage image = new PositionedImage("hero-down.png", posX, posY);
      image.draw(g);
    }
  }

  public void heroMovementY(int i, int[][] matrix) {
    if (canMove) {
      if (i < 0) {
        if (posY >= 72 && matrix[posX / 72][posY / 72 - 1] != 1) {
          posY += i;
        }
        direction = "up";
        moveCounter++;
      } else {
        if (posY < 648 && matrix[posX / 72][posY / 72 + 1] != 1) {
          posY += i;
        }
        direction = "down";
        moveCounter++;
      }
    }
  }

  public void heroMovementX(int i, int[][] matrix) {
    if (canMove) {
      if (i < 0) {
        if (posX >= 72 && matrix[posX / 72 - 1][posY / 72] != 1) {
          posX += i;
        }
        direction = "left";
        moveCounter++;
      } else {
        if (posX < 648 && matrix[posX / 72 + 1][posY / 72] != 1) {
          posX += i;
        }
        direction = "right";
        moveCounter++;
      }
    }
  }
}
