package com.dakkra.secondhour.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dakkra.secondhour.Character;
import com.dakkra.secondhour.SecondHour;
import com.dakkra.secondhour.projectile.Projectile;

public class Spit extends Projectile {

    public Spit(int x, int y, float degrees, Character parent, SecondHour game) {
        super(x, y, degrees, parent, game);
        this.speed = 10f;
        sprite = new Sprite(new Texture(Gdx.files.internal("sprites/projectiles/spit.png")));
        sprite.setPosition(x, y);
        sprite.setRotation(degrees);
    }

}
