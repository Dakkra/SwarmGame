package com.dakkra.secondhour.projectile;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dakkra.secondhour.VectorUtil;

public abstract class Projectile {

    protected float degrees, x, y;
    protected Sprite sprite;
    protected float speed = 4.5f;

    public void drawSelf(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void updatePosition() {
        Vector2 rot = VectorUtil.degreeToVector(degrees);
        sprite.translate(rot.x * speed, rot.y * speed);
    }

}
