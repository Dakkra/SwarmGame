package com.dakkra.secondhour;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.*;
import com.dakkra.secondhour.Enemy.Enemy;
import com.dakkra.secondhour.player.Player;

public class SecondHour extends ApplicationAdapter {

    private SpriteBatch spriteBatch;
    private OrthographicCamera mainCamera;
    private Viewport mainViewport;
    public Player player;
    public Array<Enemy> enemies;

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        mainViewport.update(width, height);
    }

    @Override
    public void create() {

        Vector2 test = new Vector2(4, 5);

        Gdx.graphics.setVSync(true);
        player = new Player(this);
        enemies = new Array<Enemy>();
        spriteBatch = new SpriteBatch();
        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false);
        mainViewport = new FitViewport(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, mainCamera);
//        enemies.add(new Enemy(player));
//        enemies.add(new Enemy(player));
        enemies.add(new Enemy(player));
        enemies.add(new Enemy(player));
        enemies.add(new Enemy(player));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        runUpdates();
        runBatch();
        mainCamera.update();
    }

    private void runUpdates() {
        player.updatePlayer();
        Rectangle playerBox = player.getBounds();
        Vector2 playerCenter = new Vector2(0, 0);
        playerBox.getCenter(playerCenter);
    }

    private void runBatch() {
        spriteBatch.setProjectionMatrix(mainCamera.combined);
        spriteBatch.begin();
        player.drawPlayer(spriteBatch);
        for (int i = 0; i < enemies.size; i++) {
            if (!enemies.get(i).isAlive) {
                enemies.removeIndex(i);
            }
        }
        for (Enemy e : enemies) {
            e.drawAndUpdateSelf(spriteBatch);
        }
        spriteBatch.end();
    }

}
