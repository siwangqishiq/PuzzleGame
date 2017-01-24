package com.xinlan.puzzlegame.core;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by panyi on 2017/1/22.
 */

public class Benchmark {
    float left;
    float top;

    Puzzle puzzle;

    ShapeRenderer shapeRenderer;

    public Benchmark(float left, float top, Puzzle puzzle) {
        this.puzzle = puzzle;
        this.left = left;
        this.top = top;

        shapeRenderer = new ShapeRenderer();
    }

    public void render(Camera camera) {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1f);
        float x = left;
        float y = top;
        for (int i = 0; i < puzzle.y_num; i++) {
            for (int j = 0; j < puzzle.x_num; j++) {
                shapeRenderer.rect(x, y, puzzle.cube_width, puzzle.cube_height);
                x += puzzle.cube_width;
            }//end for j
            x = left;
            y -= puzzle.cube_height;
        }//end for i
        shapeRenderer.end();
    }

}//end class
