package GUI;

import Classes.*;
import Classes.Shape;
import static GUI.MainWindow.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class ScreenSaver extends JPanel {
    private Timer timer = new Timer(getUpdateInterval(), new TimerAction());
    private ArrayList<Shape> shapes;
    private Random random = new Random();

    public ScreenSaver() {
        shapes = new ArrayList<Shape>();

//        Adds an event listener to the mouse click so it runs
//        createNewShape() and starts the timer when clicked
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createNewShape();
                timer.start();
            }
        });
    }

    //    This uses random integers to create new random shapes of different colors and sizes
    public void createNewShape() {
        String shapesArr[] = {"Circle", "Line", "Diamond", "Square", "Triangle"};
        Color colorsArr[] = {Color.RED, Color.GREEN, Color.BLUE, Color.WHITE,
                Color.ORANGE, Color.MAGENTA, Color.GRAY, Color.YELLOW};

        int randShape = random.nextInt(shapesArr.length);
        int randColor1 = random.nextInt(colorsArr.length);
        int randColor2 = random.nextInt(colorsArr.length);
        int randHeight = random.nextInt(100 - 30 + 1) + 30;
        int randWidth = random.nextInt(100 - 30 + 1) + 30;
        int randXPos = random.nextInt(650 - 50 + 1) + 50;
        int randYPos = random.nextInt(650 - 50 + 1) + 50;
        int randXSpeed = (int) (Math.random() * 10 + 1);
        int randYSpeed = (int) (Math.random() * 10 + 1);
        int xForTriangle[] = {randXPos, randXPos + (randWidth / 2), randXPos};
        int yForTriangle[] = {randYPos - (randWidth / 2), randYPos, randYPos + (randWidth / 2)};
        int xForDiamond[] = {randXPos, randXPos + (randWidth / 2), randXPos, randXPos - (randWidth / 2)};
        int yForDiamond[] = {randYPos - (randWidth / 2), randYPos, randYPos + (randWidth / 2), randYPos};

        switch (shapesArr[randShape]) {
            case "Circle":
                shapes.add(new Circle(colorsArr[randColor1], colorsArr[randColor2], randWidth, randXPos, randYPos, randXSpeed, randYSpeed));
                break;
            case "Line":
                shapes.add(new Line(colorsArr[randColor1], colorsArr[randColor2], randHeight, randWidth, randXPos, randYPos, randXSpeed, randYSpeed));
                break;
            case "Diamond":
                shapes.add(new Diamond(colorsArr[randColor1], colorsArr[randColor2], xForDiamond, yForDiamond, randXSpeed, randYSpeed));
                break;
            case "Square":
                shapes.add(new Square(colorsArr[randColor1], colorsArr[randColor2], randWidth, randXPos, randYPos, randXSpeed, randYSpeed));
                break;
            case "Triangle":
                shapes.add(new Triangle(colorsArr[randColor1], colorsArr[randColor2], xForTriangle, yForTriangle, randXSpeed, randYSpeed));
                break;
        }
    }

    //    This is the function that runs every 50 milliseconds as per the Timer initialized at the top of this file
//    It move all shapes in the shapes ArrayList and also checks for collisions between the shapes.
    private class TimerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Shape shape : shapes) {
                shape.moveShape(ScreenSaver.this);
            }

            checkCollision();
            ScreenSaver.this.repaint();
        }
    }

    //    This function draws all shapes in the ArrayList using a forEach loop.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        for (Shape shape : shapes) {
            shape.drawShape(g);
        }
    }

    //    This is used to compare all shapes in the ArrayList and change their movement direction
//    if collision was detected.
    public void checkCollision() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape shapeA = shapes.get(i);
            for (int j = i + 1; j < shapes.size(); j++) {
                Shape shapeB = shapes.get(j);

                if (isColliding(shapeA, shapeB)) {
                    shapeA.invertSpeed();
                    shapeB.invertSpeed();
                }
            }
        }
    }

    //    This function was provided by external AI (Gemini) consultation. It uses the intersects() method
//    inherited by the Shape's parent class, Rectangle, so it can detect collision easier not relying
//    too much on math.
    public boolean isColliding(Rectangle shapeA, Rectangle shapeB) {
        return shapeA.intersects(shapeB);

    }
}