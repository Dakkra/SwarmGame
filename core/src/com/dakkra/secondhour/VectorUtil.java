package com.dakkra.secondhour;


import com.badlogic.gdx.math.Vector2;

public class VectorUtil {

    public static Vector2 degreeToVector(float degree) {
        float rad = (float) (degree * (Math.PI / 180));
        return new Vector2((float) Math.cos(rad), (float) Math.sin(rad));
    }

    public static float vectorToDegree(Vector2 vec) {
        float acos = (float) Math.acos(vec.x) * (float) (180 / Math.PI);
        if (vec.y > 0) {
            acos += 90;
        }
        return acos;
    }

}
