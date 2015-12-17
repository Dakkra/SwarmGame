package com.dakkra.secondhour.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.dakkra.secondhour.Character;
import com.dakkra.secondhour.Enemy.Enemy;
import com.dakkra.secondhour.SecondHour;
import com.dakkra.secondhour.VectorUtil;

public class Player extends Character {

    final float PLAYER_SPEED = 3f;
    private Array<Spit> spits = new Array<Spit>();
    private SecondHour game;

    public Player(SecondHour game) {
        this.game = game;
        this.health = 30f;
        sprite = new Sprite();
        sprite = new Sprite(new Texture(Gdx.files.internal("sprites/player.png")));
        sprite.setPosition(Math.round((Gdx.graphics.getWidth() / 2) - sprite.getTexture().getWidth() / 2), Math.round((Gdx.graphics.getHeight() / 2) - sprite.getTexture().getHeight() / 2));
        sprite.setRotation(90);
    }

    public void updatePlayer() {
        if (!isAlive) {
            //End game
            System.exit(0);
        }
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
            Vector2 vec = VectorUtil.degreeToVector(sprite.getRotation());
            sprite.translate(mag * vec.x * PLAYER_SPEED, mag * vec.y * PLAYER_SPEED);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            fireBullet();
        }

        for (int i = 0; i < spits.size; i++) {
            if (spits.get(i).isUsed()) {
                spits.removeIndex(i);
            }
        }

        for (int i = 0; i < game.enemies.size; i++) {
            Vector2 enemyPos = new Vector2(0, 0);
            if (sprite.getBoundingRectangle().contains(game.enemies.get(i).getBox().getCenter(enemyPos))) {
                takeDamage(5);
                game.enemies.get(i).takeDamage(10);
            }
        }

    }

    private void fireBullet() {
        spits.add(new Spit((int) sprite.getX(), (int) sprite.getY(), sprite.getRotation(), this, game));
    }

    public void drawPlayer(SpriteBatch batch) {
        sprite.draw(batch);
        for (Spit i : spits) {
            i.updatePosition();
            i.drawSelf(batch);
        }
    }

    public Rectangle getBounds() {
        return sprite.getBoundingRectangle();
    }

}
