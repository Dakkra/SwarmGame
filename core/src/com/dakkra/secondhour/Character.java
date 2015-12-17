package com.dakkra.secondhour;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


public abstract class Character {

    protected boolean isAlive = true;
    protected float health = 10f;
    protected Sprite sprite;

    public void takeDamage(float damage) {
        if (isAlive) {
            health -= damage;
        }
        if (health <= 0) {
            isAlive = false;
        }
    }

    public Rectangle getBox() {
        return sprite.getBoundingRectangle();
    }

}
