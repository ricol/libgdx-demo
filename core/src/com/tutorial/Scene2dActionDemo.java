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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;

public class Scene2dActionDemo implements ApplicationListener
{

    public class MyActor extends Actor
    {

        Texture texture = new Texture(Gdx.files.internal("tutorial/sprite/jet.png"));
        public boolean started = false;

        public MyActor()
        {
            setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
        }

//        @Override
//        public void act(float delta)
//        {
//            for (Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();)
//            {
//                iter.next().act(delta);
//            }
//        }

        @Override
        public void draw(Batch batch, float alpha)
        {
//            batch.draw(texture, this.getX(), getY());

            batch.draw(texture, this.getX(), getY(), this.getOriginX(), this.getOriginY(), this.getWidth(),
                this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0,
                texture.getWidth(), texture.getHeight(), false, false);
        }
    }
    private Stage stage;

    @Override
    public void create()
    {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        MyActor myActor = new MyActor();

//        MoveToAction moveAction = new MoveToAction();
//        moveAction.setPosition(300f, 0f);
//        moveAction.setDuration(10f);
//        myActor.addAction(moveAction);
        MoveToAction moveAction = new MoveToAction();
        RotateToAction rotateAction = new RotateToAction();
        ScaleToAction scaleAction = new ScaleToAction();

        moveAction.setPosition(300f, 0f);
        moveAction.setDuration(5f);
        rotateAction.setRotation(90f);
        rotateAction.setDuration(5f);
        scaleAction.setScale(0.5f);
        scaleAction.setDuration(5f);

        myActor.addAction(moveAction);
        myActor.addAction(rotateAction);
        myActor.addAction(scaleAction);

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
