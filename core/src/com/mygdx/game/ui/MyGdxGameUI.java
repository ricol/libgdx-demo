package com.mygdx.game.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyGdxGameUI extends Game
{

    static public Skin skin;

    @Override
    public void create()
    {
        skin = new Skin(Gdx.files.internal("ui/skin/glassy-ui.json"));
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
