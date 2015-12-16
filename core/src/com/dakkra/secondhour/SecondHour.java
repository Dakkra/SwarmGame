package com.dakkra.secondhour;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.viewport.*;
import com.dakkra.secondhour.player.Player;

public class SecondHour extends ApplicationAdapter {

    public SpriteBatch spriteBatch;
    private OrthographicCamera mainCamera;
    private Viewport mainViewport;
    private Player player;

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        mainViewport.update(width, height);
    }

    @Override
    public void create() {
        Gdx.graphics.setVSync(true);
        player = new Player();
        spriteBatch = new SpriteBatch();
        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false);
        mainViewport = new FitViewport(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, mainCamera);
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
    }

    private void runBatch() {
        spriteBatch.setProjectionMatrix(mainCamera.combined);
        spriteBatch.begin();
        player.drawPlayer(spriteBatch);
        spriteBatch.end();
    }
}
