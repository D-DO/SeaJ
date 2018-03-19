package ru.dandam.seabattle;

public class Cell {
    private int positionHoriz;
    private int positionVert;
    private String showingCell;
    private char alphabeticDes;
    private boolean isShoot;
    Sheep sheep;
    private boolean nearSheep;



    private char getCellChar(int p) {
        char s = 'А';
        for (int i = 0; i < p; i++) {
            s++;
        }
        return s;
    }

    public Cell(int x, int y) {
        positionHoriz = x;
        positionVert = y;
        alphabeticDes = getCellChar(x);
        isShoot = false;
        sheep = null;

        showingCell = showCell();
    }

    public String showCell() {
        if (isShoot) {
            if (sheep == null) {
                return " * ";
            } else {
                return " X ";
            }
        } else {
            if (sheep == null) {
                return " _ ";
            } else {
                return " O ";
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

    public char getAlphabeticDes() {
        return alphabeticDes;
    }

    public void setAlphabeticDes(char alphabeticDes) {
        this.alphabeticDes = alphabeticDes;
    }

    public boolean isShoot() {
        return isShoot;
    }

    public void setShoot(boolean shoot) {
        isShoot = shoot;
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
    }
}
