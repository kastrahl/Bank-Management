package com.codeforinterview;

import javax.swing.*;
        import java.awt.event.*;
        import java.util.Stack;

public class FrameManager {
    private Stack<JFrame> frameStack;

    public FrameManager() {
        frameStack = new Stack<>();
    }

    public void openFrame(JFrame frame) {
        if (!frameStack.isEmpty()) {
            JFrame previousFrame = frameStack.peek();
            previousFrame.setVisible(false);
        }
        frameStack.push(frame);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void goBack() {
        if (!frameStack.isEmpty()) {
            JFrame currentFrame = frameStack.pop();
            currentFrame.setVisible(false);
            if (!frameStack.isEmpty()) {
                JFrame previousFrame = frameStack.peek();
                previousFrame.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        FrameManager frameManager = new FrameManager();

        JFrame frame1 = new JFrame("Frame 1");
        JButton openNextFrameButton = new JButton("Open Next Frame");
        openNextFrameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Frame 2");
                JButton backButton = new JButton("Go Back");
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frameManager.goBack();
                    }
                });
                frame2.add(backButton);
                frame2.setSize(300, 200);
                frame2.setLocationRelativeTo(null);
                frameManager.openFrame(frame2);
            }
        });
        frame1.add(openNextFrameButton);
        frame1.setSize(300, 200);
        frame1.setLocationRelativeTo(null);
        frameManager.openFrame(frame1);
    }
}
