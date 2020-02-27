/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author ricolwang
 */
public class AnimationDemo implements ApplicationListener, InputProcessor
{

    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private Animation<AtlasRegion> rotateUpAnimation;
    private Animation<AtlasRegion> rotateDownAnimation;
    private Animation<AtlasRegion> current;
    private float elapsedTime = 0;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("tutorial/animation/spritesheet.atlas"));
        TextureRegion[] rotateUpFrames = new TextureRegion[10];

        // Rotate Up AnimationDemo
        // Create an array of TextureRegions
        rotateUpFrames[0] = (textureAtlas.findRegion("0001"));
        rotateUpFrames[1] = (textureAtlas.findRegion("0002"));
        rotateUpFrames[2] = (textureAtlas.findRegion("0003"));
        rotateUpFrames[3] = (textureAtlas.findRegion("0004"));
        rotateUpFrames[4] = (textureAtlas.findRegion("0005"));
        rotateUpFrames[5] = (textureAtlas.findRegion("0006"));
        rotateUpFrames[6] = (textureAtlas.findRegion("0007"));
        rotateUpFrames[7] = (textureAtlas.findRegion("0008"));
        rotateUpFrames[8] = (textureAtlas.findRegion("0009"));
        rotateUpFrames[9] = (textureAtlas.findRegion("0010"));

        rotateUpAnimation = new Animation(0.05f, rotateUpFrames);

        // Rotate Down AnimationDemo
        // Or you can just pass in all of the regions to the AnimationDemo constructor
        rotateDownAnimation = new Animation(0.05f,
            (textureAtlas.findRegion("0020")),
            (textureAtlas.findRegion("0019")),
            (textureAtlas.findRegion("0018")),
            (textureAtlas.findRegion("0017")),
            (textureAtlas.findRegion("0016")),
            (textureAtlas.findRegion("0015")),
            (textureAtlas.findRegion("0014")),
            (textureAtlas.findRegion("0013")),
            (textureAtlas.findRegion("0012")),
            (textureAtlas.findRegion("0011")));

        Gdx.input.setInputProcessor((InputProcessor) this);
        
        current = rotateDownAnimation;
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        textureAtlas.dispose();
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        if (current != null)
        {
            //sprite.draw(batch);
            elapsedTime += Gdx.graphics.getDeltaTime();
            current.getKeyFrame(elapsedTime, true);
            batch.draw(current.getKeyFrame(elapsedTime, true), 0, 0);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Keys.UP:
                current = rotateUpAnimation;
                break;
            case Keys.DOWN:
                current = rotateDownAnimation;
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

}
