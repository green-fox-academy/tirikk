import java.util.ArrayList;

public class Character {
  int posX;
  int posY;
  String image;
  int level;
  int maxHp;
  int hp;
  int dp;
  int sp;
  boolean canMove;
  String direction;
  boolean hasKey;

  String generateDirection() {
    int i = (int) (Math.random() * 4);
    if (i == 0) {
      direction = "left";
    } else if (i == 1) {
      direction = "up";
    } else if (i == 2) {
      direction = "right";
    } else {
      direction = "down";
    }
    return direction;
  }

  void moveRandom() {
    ArrayList<String> directionsTried = new ArrayList<>();
    if ((int) (Math.random() * 4) == 0) {
      generateDirection();
    }
    boolean moved = false;
    while (!moved) {
      if (direction.equals("left")) {
        if (moveLeft()) {
          moved = true;
        } else {
          generateDirection();
          directionsTried.add("left");
        }
      } else if (direction.equals("right")) {
        if (moveRight()) {
          moved = true;
        } else {
          generateDirection();
          directionsTried.add("right");
        }
      } else if (direction.equals("up")) {
        if (moveUp()) {
          moved = true;
        } else {
          generateDirection();
          directionsTried.add("up");
        }
      } else {
        if (moveDown()) {
          moved = true;
        } else {
          generateDirection();
          directionsTried.add("down");
        }
      }
      if (directionsTried.contains("left") && directionsTried.contains("right") && directionsTried.contains("up")
              && directionsTried.contains("down")) {
        moved = true;
      }
    }
  }

  boolean moveLeft() {
    if (posX >= 72 && Map.isFloor(posX / 72 - 1, posY / 72) && !Map.isOccupied(posX / 72 - 1,
            posY / 72)) {
      Map.setOccupied(posX / 72 - 1, posY / 72);
      Map.setUnoccupied(posX / 72, posY / 72);
      posX -= 72;
      return true;
    } else {
      return false;
    }
  }

  boolean moveRight() {
    if (posX < 648 && Map.isFloor(posX / 72 + 1, posY / 72) && !Map.isOccupied(posX / 72 + 1,
            posY / 72)) {
      Map.setOccupied(posX / 72 + 1, posY / 72);
      Map.setUnoccupied(posX / 72, posY / 72);
      posX += 72;
      return true;
    } else {
      return false;
    }
  }

  boolean moveUp() {
    if (posY >= 72 && Map.isFloor(posX / 72, posY / 72 - 1) && !Map.isOccupied(posX / 72,
            posY / 72 - 1)) {
      Map.setOccupied(posX / 72, posY / 72 - 1);
      Map.setUnoccupied(posX / 72, posY / 72);
      this.posY -= 72;
      return true;
    } else {
      return false;
    }
  }

  boolean moveDown() {
    if (posY < 648 && Map.isFloor(posX / 72, posY / 72 + 1) && !Map.isOccupied(posX / 72,
            posY / 72 + 1)) {
      Map.setOccupied(posX / 72, posY / 72 + 1);
      Map.setUnoccupied(posX / 72, posY / 72);
      posY += 72;
      return true;
    } else {
      return false;
    }
  }
}
