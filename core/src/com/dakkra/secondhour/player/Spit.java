package com.dakkra.secondhour.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dakkra.secondhour.projectile.Projectile;

public class Spit extends Projectile {

    public Spit(int x, int y, float degrees) {
        this.degrees = degrees;
        this.x = x;
        this.y = y;
        this.speed = 10f;
        sprite = new Sprite(new Texture(Gdx.files.internal("sprites/projectiles/spit.png")));
        sprite.setPosition(x, y);
        sprite.setRotation(degrees);
    }

}
