package com.xinlan.puzzlegame.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.xinlan.puzzlegame.PuzzleApp;

/**
 * Created by pany on 2017/1/19.
 */

public class GameScreen implements Screen {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 480;

    public OrthographicCamera gameCamera;
    public SpriteBatch batch;

    public Puzzle mPuzzle;

    public GameScreen(PuzzleApp game) {
    }

    @Override
    public void show() {
        gameCamera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        gameCamera.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);
        batch = new SpriteBatch();

        init();
    }

    protected void init(){
        mPuzzle = new Puzzle("demo.jpg");

        mPuzzle.initPuzzles(7,5);
    }

    @Override
    public void render(float delta) {
        delta = Math.min(0.06f, delta);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(gameCamera.combined);
        gameCamera.update();



        batch.begin();
        mPuzzle.render(delta,batch);
        batch.end();
    }

    @Override
    public void resize(int w, int h) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        mPuzzle.free();
    }
}//end class
