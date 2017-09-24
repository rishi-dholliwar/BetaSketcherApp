package com.teambeta.sketcherapp.model;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * The LineTool class implements the drawing behavior for when the Pen tool has been selected
 */
public class PenTool extends DrawingTool {

    private int currentY;
    private int currentX;
    private int lastX;
    private int lastY;
    private int sizeInPixels;
    private Color color;

    public PenTool() {
        color = Color.black;
        sizeInPixels = 1;
        lastX = 0;
        lastY = 0;
        currentX = 0;
        currentY = 0;
    }

    @Override
    public void onDrag(Graphics2D graphics, MouseEvent e, int startX, int startY, int endX, int endY) {
        //when the line tool is released draw the line
        if (graphics != null) {
            currentX = e.getX();
            currentY = e.getY();
            // draw line if graphics context not null
            graphics.drawLine(startX, startY, endX, endY);
            lastX = currentX;
            lastY = currentY;
        }

    }

    @Override
    public void onRelease(Graphics2D graphics, MouseEvent e, int startX, int startY, int endX, int endY) {
    }

    @Override
    public void onClick(Graphics2D graphics, MouseEvent e, int startX, int startY, int endX, int endY) {
        currentX = e.getX();
        currentY = e.getY();
        graphics.drawLine(currentX, currentY, currentX, currentY);
        lastX = currentX;
        lastY = currentY;
    }

    @Override
    public void onPress(Graphics2D graphics, MouseEvent e, int startX, int startY, int endX, int endY) {
//        lastX = currentX;
//        lastY = currentY;
        currentX = e.getX();
        currentY = e.getY();
    }

    @Override
    public Color getColor() {
        return color;
    }
}
