package com.dakkra.secondhour;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.viewport.*;

public class SecondHour extends ApplicationAdapter {

    private final float PLAYER_SPEED = 3f;
    private SpriteBatch spriteBatch;
    private OrthographicCamera mainCamera;
    private Viewport mainViewport;
    private Sprite sprite;

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        mainViewport.update(width, height);
    }

    @Override
    public void create() {
        Gdx.graphics.setVSync(true);
        spriteBatch = new SpriteBatch();
        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false);
        mainViewport = new FitViewport(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, mainCamera);
        sprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
        sprite.setPosition(Math.round((Gdx.graphics.getWidth() / 2) - sprite.getTexture().getWidth() / 2), Math.round((Gdx.graphics.getHeight() / 2) - sprite.getTexture().getHeight() / 2));
        sprite.setRotation(90);
    }

    @Override
    public void render() {
        movePlayer();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(mainCamera.combined);
        spriteBatch.begin();
        //Draw here
        sprite.draw(spriteBatch);
        spriteBatch.end();
        mainCamera.update();
    }

    private void movePlayer() {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            up = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            down = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            left = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            right = 1;
        }

        int mag = up - down;
        int dir = left - right;

        if (dir != 0) {
            sprite.rotate(dir * 5);
        }

        if (mag != 0) {
            Vector2 vec = degreeToVector(sprite.getRotation());
            sprite.translate(mag * vec.x * PLAYER_SPEED, mag * vec.y * PLAYER_SPEED);
        }

    }

    private Vector2 degreeToVector(float degree) {
        float rad = (float) (degree * (Math.PI / 180));
        return new Vector2((float) Math.cos(rad), (float) Math.sin(rad));
    }


}
