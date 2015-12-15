package com.dakkra.secondhour;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SecondHour extends ApplicationAdapter {
	SpriteBatch batch;

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		System.out.println(width + ", " + height);
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.2f,0.2f,0.6f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//Draw imaged here
		batch.end();
	}
}
