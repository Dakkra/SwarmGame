package com.dakkra.secondhour.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private final float PLAYER_SPEED = 3f;
    private Sprite sprite;

    public Player() {
        sprite = new Sprite();
        sprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
        sprite.setPosition(Math.round((Gdx.graphics.getWidth() / 2) - sprite.getTexture().getWidth() / 2), Math.round((Gdx.graphics.getHeight() / 2) - sprite.getTexture().getHeight() / 2));
        sprite.setRotation(90);
    }

    public void movePlayer() {
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

    public void drawPlayer(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
