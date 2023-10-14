package edu.square.utils.UIUtils;


import java.awt.*;
import java.awt.event.ComponentListener;
import java.util.HashSet;

public class JComponentsCollectionUtil {
    private final HashSet<Frame> frames;

    public JComponentsCollectionUtil() {
        frames = new HashSet<>();
    }

    public void addComponent(Frame frame) {
        frames.add(frame);
    }


    /**
     * resize all frames
     *
     * @param percent percentage of previous size, the value should be in (0, 2)
     */
    public void resizeAllFrames(double percent) {
        assert percent > 0 && percent < 2;
        for (Frame frame : frames) {
            resizeFrame(frame, percent);
        }
    }

    private void resizeFrame(Frame frame, double percent) {
        frame.setSize((int) (frame.getWidth() * percent), (int) (frame.getHeight() * percent));
        frame.setVisible(true); //TODO: test if it's necessary
    }


}
