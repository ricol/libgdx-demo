package com.mygdx.game.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.particles.MyGdxGameParticles;

/**
 * Created by julienvillegas on 31/01/2017.
 */

public class MusicalNote extends Image
{

	ParticleEffect effect;

	public MusicalNote()
	{
		super(new Texture("particles/note.png"));
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("particles/bubleNote.p"), MyGdxGameParticles.textureAtlas);
		effect.start();
		effect.setPosition(this.getWidth() / 2 + this.getX(), this.getHeight() / 2 + this.getY());
	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		super.draw(batch, parentAlpha);
		effect.draw(batch);
	}

	@Override
	public void act(float delta)
	{
		super.act(delta);
		effect.setPosition(this.getWidth() / 2 + this.getX(), this.getHeight() / 2 + this.getY());
		effect.update(delta);

	}
}
