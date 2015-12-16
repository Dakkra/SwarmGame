package com.dakkra.secondhour.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.dakkra.secondhour.player.Player;

public class Enemy {

    private Sprite sprite;
    private Player player;

    public Enemy(Player player) {
        this.player = player;
        sprite = new Sprite(new Texture("sprites/enemy.png"));
        spawn();

    }

    private void spawn() {
        boolean done = false;
        while (!done) {
            double r1 = Math.random();
            double r2 = Math.random();
            int halfW = Gdx.graphics.getWidth()/2;
            int halfH = Gdx.graphics.getHeight()/2;
            int posX = (int) Math.round(Gdx.graphics.getWidth() * r1/2)+(halfW/2);
            int posY = (int) Math.round(Gdx.graphics.getHeight() * r2/2)+(halfH/2);
            Rectangle playerArea = player.getBounds();
            if (!playerArea.contains(posX, posY)) {
                sprite.setPosition(posX, posY);
                done = true;
            }
        }
        System.out.println("Enemy:"+sprite.getX()+","+sprite.getY());
    }

    public void drawSelf(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
