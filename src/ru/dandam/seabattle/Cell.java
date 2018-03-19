package ru.dandam.seabattle;

public class Cell {
    private int x;
    private int y;
    private String s;
    private char c;
    private boolean isShoot;

    public char getC() {
        return c;
    }

    private char getCellChar(int p) {
        char s = 'А';
        for (int i = 0; i < p; i++) {
            s++;
        }
        return s;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.s = " - ";
        this.c = getCellChar(x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public boolean isShoot() {
        return isShoot;
    }

    public void setShoot(boolean shoot) {
        isShoot = shoot;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
