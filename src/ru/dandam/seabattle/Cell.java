package ru.dandam.seabattle;

public class Cell {
    private int positionHoriz;
    private int positionVert;
    private String showingCell;
    private char alphabeticX;
    private char alphabeticY;
    private boolean isShoot;
    Sheep sheep;
    private boolean nearSheep;
    private boolean isVisible;


    private char getCellCharX(int p) {
        char s = 'А';
        for (int i = 0; i < p; i++) {
            s++;
        }
        return s;
    }

    private char getCellCharY(int p) {
        char s = '1';
        for (int i = 0; i < p; i++) {
            s++;
        }
        return s;
    }

    public Cell(int x, int y) {
        positionHoriz = x;
        positionVert = y;
        alphabeticX = getCellCharX(x);
        alphabeticY = getCellCharY(y);
        isShoot = false;
        sheep = null;
        showingCell = showCell();
        isVisible = true;
    }


    public String showCell() {


        if (isVisible) {
            if (isShoot) {
                if (sheep == null) {
                    return " + ";
                } else {
                    return " X ";
                }


            } else {
                if (sheep == null) {
                    return " ~ ";
                } else {
                    return " O ";
                }

            }
        } else {
            if (isShoot) {
                if (sheep == null) {
                    return " + ";
                } else {
                    return " X ";
                }


            } else {
                if (sheep == null) {
                    return " ~ ";
                } else {
                    return " ~ ";
                }

            }

        }

    }


    public int getPositionHoriz() {
        return positionHoriz;
    }

    public void setPositionHoriz(int positionHoriz) {
        this.positionHoriz = positionHoriz;
    }

    public int getPositionVert() {
        return positionVert;
    }

    public void setPositionVert(int positionVert) {
        this.positionVert = positionVert;
    }

    public String getShowingCell() {
        return showingCell;
    }

    public void setShowingCell(String showingCell) {
        this.showingCell = showingCell;
    }

    public char getAlphabeticX() {
        return alphabeticX;
    }

    public void setAlphabeticX(char alphabeticX) {
        this.alphabeticX = alphabeticX;
    }

    public char getAlphabeticY() {
        return alphabeticY;
    }

    public void setAlphabeticY(char alphabeticY) {
        this.alphabeticY = alphabeticY;
    }

    public boolean isShoot() {
        return isShoot;
    }

    public void setShoot(boolean shoot) {
        isShoot = shoot;
        if (shoot) {
            if (sheep != null) {
                sheep.incSoots();
            }

        }
        showingCell = showCell();
    }

    public void yesShoot() {
        isShoot = true;
        if (sheep != null) {
            sheep.incSoots();
        }

        showingCell = showCell();
    }

    public Sheep getSheep() {
        return sheep;
    }

    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
        showingCell = showCell();
    }

    public boolean isNearSheep() {
        return nearSheep;
    }

    public void setNearSheep(boolean nearSheep) {
        this.nearSheep = nearSheep;
        showingCell = showCell();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
