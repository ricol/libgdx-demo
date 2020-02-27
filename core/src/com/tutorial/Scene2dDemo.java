/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Scene2dDemo implements ApplicationListener
{

    public class MyActor extends Actor
    {

        Texture texture = new Texture(Gdx.files.internal("tutorial/sprite/jet.png"));
        float actorX = 0, actorY = 0;
        public boolean started = false;

        public MyActor()
        {
            setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
            addListener(new InputListener()
            {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
                {
                    ((MyActor) event.getTarget()).started = true;
                    return true;
                }
            });
        }

        @Override
        public void draw(Batch batch, float alpha)
        {
            batch.draw(texture, actorX, actorY);
        }

        @Override
        public void act(float delta)
        {
            if (started)
            {
                actorX += 5;
            }
        }
    }

    private Stage stage;

    @Override
    public void create()
    {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        MyActor myActor = new MyActor();
        myActor.setTouchable(Touchable.enabled);
        stage.addActor(myActor);
    }

    @Override
    public void dispose()
    {
    }

    @Override
    public void render()
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
}
