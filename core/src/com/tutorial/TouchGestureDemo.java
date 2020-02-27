/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class TouchGestureDemo implements ApplicationListener, GestureListener
{

    private SpriteBatch batch;
    private BitmapFont font;
    private String message = "No gesture performed yet";
    private int w, h;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("data/arial-15.fnt"), false);
        font.setColor(Color.RED);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        GestureDetector gd = new GestureDetector(this);
        Gdx.input.setInputProcessor(gd);
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        font.draw(batch, message, 100, 100);

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
    public boolean touchDown(float x, float y, int pointer, int button)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button)
    {
        message = "Tap performed, finger" + Integer.toString(button);
        return true;
    }

    @Override
    public boolean longPress(float x, float y)
    {
        message = "Long press performed";
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button)
    {
        message = "Fling performed, velocity:" + Float.toString(velocityX)
            + "," + Float.toString(velocityY);
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY)
    {
        message = "Pan performed, delta:" + Float.toString(deltaX)
            + "," + Float.toString(deltaY);
        return true;
    }

    @Override
    public boolean zoom(float initialDistance, float distance)
    {
        message = "Zoom performed, initial Distance:" + Float.toString(initialDistance)
            + " Distance: " + Float.toString(distance);
        return true;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
        Vector2 pointer1, Vector2 pointer2)
    {
        message = "Pinch performed";
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button)
    {
        return true;
    }

    @Override
    public void pinchStop()
    {
    }

}
