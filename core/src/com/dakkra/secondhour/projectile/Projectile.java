package com.dakkra.secondhour.projectile;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dakkra.secondhour.Character;
import com.dakkra.secondhour.Enemy.Enemy;
import com.dakkra.secondhour.SecondHour;
import com.dakkra.secondhour.VectorUtil;

public abstract class Projectile {

    protected SecondHour game;
    protected float degrees, x, y;
    protected Sprite sprite;
    protected float speed = 4.5f;
    protected float damage = 5f;
    protected boolean isUsed = false;
    protected Character parent;

    public Projectile(int x, int y, float degrees, Character parent, SecondHour game) {
        this.game = game;
        this.parent = parent;
        this.degrees = degrees;
        this.x = x;
        this.y = y;
    }

    public void drawSelf(SpriteBatch batch) {
        if (!isUsed) {
            sprite.draw(batch);
        }
    }

    public void updatePosition() {
        if (!isUsed) {
            Vector2 rot = VectorUtil.degreeToVector(degrees);
            sprite.translate(rot.x * speed, rot.y * speed);
            for (Enemy e : game.enemies) {
                collidesWithCharacter(e);
            }
            collidesWithCharacter(game.player);
        }
    }

    public Rectangle getBox() {
        return sprite.getBoundingRectangle();
    }

    public float getDamage() {
        return damage;
    }

    public boolean collidesWithCharacter(Character character) {
        if (character == parent) {
            return false;
        }
        Rectangle characterBox = character.getBox();
        Vector2 charBoxCenter = new Vector2(0, 0);
        if (characterBox.contains(sprite.getBoundingRectangle().getCenter(charBoxCenter))) {
            character.takeDamage(damage);
            isUsed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isUsed() {
        return isUsed;
    }

}
