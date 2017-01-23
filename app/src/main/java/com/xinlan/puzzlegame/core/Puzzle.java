package com.xinlan.puzzlegame.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by py on 2017/1/19.
 */

public class Puzzle {
    public static final int VIEW_WIDTH = (int) (0.8f * GameScreen.SCREEN_WIDTH);
    public static final int VIEW_HEIGHT = (int) (0.8f * GameScreen.SCREEN_HEIGHT);

    String originFile;

    int x_num;
    int y_num;

    Texture srcTexture;

    List<PuzzleItem> itemList;

    boolean isTouch = false;

    public Puzzle(String orignFile) {
        this.originFile = orignFile;
    }

    public void initPuzzles(int x_num, int y_num) {
        this.x_num = x_num;
        this.y_num = y_num;

        loadPuzzles();
    }

    private void loadPuzzles() {
        srcTexture = new Texture(Gdx.files.internal(originFile));

        int src_width = srcTexture.getWidth();
        int src_height = srcTexture.getHeight();

        //System.out.println("srcWidth = "+srcWidth+"   srcHeight = "+srcHeight);
        //int total_items_num = x_num * y_num;

        itemList = new LinkedList<>();
        int item_width = src_width / x_num;
        int item_height = src_height / y_num;

        int view_width = VIEW_WIDTH / x_num;
        int view_height = VIEW_HEIGHT / y_num;

        int index = 0;
        float padding = 0;
        for (int j = 0; j < y_num; j++) {
            for (int i = 0; i < x_num; i++) {
                PuzzleItem item = new PuzzleItem();
                item.width = view_width;
                item.height = view_height;
                item.texture = new TextureRegion(srcTexture, i * item_width, j * item_height, item_width, item_height);
                item.index = index;

                item.x = padding + i * (view_width + padding);
                item.y = VIEW_HEIGHT - j * (view_height + padding);

                itemList.add(item);
                index++;
            }//end for j
        }//end for i
    }

    float angle = 0;
    float wait = 0;

    public void render(float delta, SpriteBatch batch) {
        if (isTouch) {
            angle += 4;
        }

        for (int i = 0; i < itemList.size(); i++) {
            PuzzleItem item = itemList.get(i);
            batch.draw(item.texture, item.x, item.y, 0,
                    0, item.width, item.height, 1, 1, angle);
        }

        if (angle >= 360) {
            angle = 0;
            isTouch = false;
        }

    }


    public void free() {

        if (srcTexture != null) {
            srcTexture.dispose();
        }
    }
}//end class
