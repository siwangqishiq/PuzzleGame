package com.xinlan.puzzlegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.xinlan.puzzlegame.core.GameScreen;

/**
 * Created by panyi on 2017/1/19.
 */

public class PuzzleApp extends Game{
    FPSLogger fps;
    @Override
    public void create() {
        fps = new FPSLogger();
        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
        fps.log();
    }

    @Override
    public void dispose() {
        super.dispose();
        getScreen().dispose();
    }
}//end class
