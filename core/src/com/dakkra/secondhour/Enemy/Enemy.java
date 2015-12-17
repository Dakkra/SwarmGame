package com.dakkra.secondhour.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dakkra.secondhour.Character;
import com.dakkra.secondhour.VectorUtil;
import com.dakkra.secondhour.player.Player;

import java.util.Random;

public class Enemy extends Character {

    private Player player;
    private float speed;
    private float rotationSpeed;
    private float maxSpeed = 15;
    private float minSpeed = 5;

    public Enemy(Player player) {
        this.player = player;
        sprite = new Sprite(new Texture("sprites/enemy.png"));
        spawn();

    }

    private void spawn() {
        boolean done = false;
        while (!done) {
            double r1 = Math.random() * 2 - 1;
            double r2 = Math.random() * 2 - 1;
            int halfW = Gdx.graphics.getWidth() / 2;
            int halfH = Gdx.graphics.getHeight() / 2;
            int posX = (int) Math.round(Gdx.graphics.getWidth() * r1 / 2) + (halfW / 2);
            int posY = (int) Math.round(Gdx.graphics.getHeight() * r2 / 2) + (halfH / 2);
            Rectangle playerArea = player.getBounds();
            if (!playerArea.contains(posX, posY)) {
                sprite.setPosition(posX, posY);
                done = true;
            }
        }
        System.out.println("Enemy spawn!");
    }

    public void drawAndUpdateSelf(SpriteBatch batch) {

        if (isAlive) {
            Rectangle playerBox = player.getBounds();
            Rectangle selfBox = sprite.getBoundingRectangle();
            Vector2 playerPosition = new Vector2(0, 0);
            Vector2 selfPosition = new Vector2(0, 0);
            playerBox.getCenter(playerPosition);
            selfBox.getCenter(selfPosition);

            Vector2 deltaVec = new Vector2(-(selfPosition.x - playerPosition.x), -(selfPosition.y - playerPosition.y)).nor();
            float rot = VectorUtil.vectorToDegree(deltaVec);
            sprite.setRotation(rot);
            sprite.translate(deltaVec.x * 1, deltaVec.y * 1);
            sprite.draw(batch);
        }
    }

}
