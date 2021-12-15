package endalos.fun.misc;

import endalos.fun.model.Orientation;

public enum Config {
    instance;
    public int width = 1000;
    public int height = 1000;
    public int scale = 2;
    public int targetFps = 900; // 0 = max possible
    public Orientation[] orientationFlow = {Orientation.up, Orientation.right, Orientation.down, Orientation.left};
}
