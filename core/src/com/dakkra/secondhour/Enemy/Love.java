package com.dakkra.secondhour.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dakkra.secondhour.Character;
import com.dakkra.secondhour.SecondHour;
import com.dakkra.secondhour.projectile.Projectile;

public class Love extends Projectile {
    public Love(int x, int y, float degrees, Character parent, SecondHour game) {
        super(x, y, degrees, parent, game);
        this.damage = 1f;
        this.speed = 2.5f;
        this.sprite = new Sprite(new Texture(Gdx.files.internal("sprites/projectiles/enemyspit.png")));
        sprite.setPosition(x, y);
        sprite.setRotation(degrees);
    }
}
