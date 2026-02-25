package Classes;

import GUI.ScreenSaver;
import java.awt.*;

public abstract class Shape extends Rectangle{
    //    Attributes:
    private Color shapeColor1;
    private Color shapeColor2;
    private int shapeHeight;
    private int shapeWidth;
    private int xPosition;
    private int yPosition;
    private int xSpeed;
    private int ySpeed;
    private boolean colorChanged = false;

    //    Getters & Setters:
    public Color getShapeColor1() {
        return shapeColor1;
    }

    public void setShapeColor1(Color shapeColor) {
        this.shapeColor1 = shapeColor;
    }

    public Color getShapeColor2() {
        return shapeColor2;
    }

    public void setShapeColor2(Color shapeColor) {
        this.shapeColor2 = shapeColor;
    }

    public int getShapeHeight() {
        return shapeHeight;
    }

    public void setShapeHeight(int shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    public int getShapeWidth() {
        return shapeWidth;
    }

    public void setShapeWidth(int shapeWidth) {
        this.shapeWidth = shapeWidth;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public boolean isColorChanged() {
        return colorChanged;
    }

    public void setColorChanged(boolean colorChanged) {
        this.colorChanged = colorChanged;
    }

    //    Methods:
    public abstract void drawShape(Graphics g);

    public abstract void moveShape(ScreenSaver ss);

    public abstract void invertSpeed();
}
