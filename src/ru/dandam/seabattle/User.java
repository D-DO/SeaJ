package ru.dandam.seabattle;

public class User {
    String name;
    Field field = new Field();
    String message;

    public boolean isShoot(String message) {
        if (message.length() < 2) {
            return true;
        }
        char charX;
        char charY;
        char charY1;
        this.message = message.toUpperCase();
        charX = message.charAt(0);
        charY = message.charAt(1);

        int k = 0;

        if (message.length() == 2) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    if ((field.cells[i][j].getAlphabeticX() == charX) &&
                            (field.cells[i][j].getAlphabeticY() == charY)) {
                        field.cells[i][j].yesShoot();
                        k++;
                    }
                }
            }
        }

        if (message.length() > 2) {
            charY1 = message.charAt(2);
            for (int i = 0; i < 10; i++) {
                if ((field.cells[i][9].getAlphabeticX() == charX) &&
                        (charY == '1') && (charY1 == '0')) {
                    field.cells[i][9].yesShoot();
                    k++;
                }
            }
        }

        if (k > 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
