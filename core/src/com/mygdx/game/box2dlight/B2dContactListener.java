package com.mygdx.game.box2dlight;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Created by julienvillegas on 07/12/2017.
 */

public class B2dContactListener implements ContactListener
{
	@Override
	public void beginContact(Contact contact)
	{
		String classA = contact.getFixtureA().getBody().getUserData().getClass().getName();
		String classB = contact.getFixtureB().getBody().getUserData().getClass().getName();

		// Gdx.app.debug("begin Contact","between: "+classA+" and "+ classB);
		if (classA.equalsIgnoreCase("com.mygdx.game.WindowsFrame") && classB.equalsIgnoreCase("com.mygdx.game.Ball"))
		{
			Ball ball = (Ball) (contact.getFixtureB().getBody().getUserData());
			BallGenerator.getInstance().explode(ball);

		} else if (classB.equalsIgnoreCase("com.mygdx.game.WindowsFrame")
				&& classA.equalsIgnoreCase("com.mygdx.game.Ball"))
		{
			Ball ball = (Ball) (contact.getFixtureA().getBody().getUserData());
			BallGenerator.getInstance().explode(ball);
		}

	}

	@Override
	public void endContact(Contact contact)
	{

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold)
	{

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse)
	{

	}
}
