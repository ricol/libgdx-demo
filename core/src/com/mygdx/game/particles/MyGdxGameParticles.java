
package com.mygdx.game.particles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyGdxGameParticles extends Game
{
	static public Skin skin;
	static public TextureAtlas textureAtlas;

	@Override
	public void create()
	{
		skin = new Skin(Gdx.files.internal("particles/skin/glassy-ui.json"));
		textureAtlas = new TextureAtlas();
		textureAtlas.addRegion("note", new TextureRegion(new Texture("particles/note.png")));
		this.setScreen(new TitleScreen(this));

	}

	@Override
	public void render()
	{
		super.render();

	}

	public void dispose()
	{
		skin.dispose();

	}

}
