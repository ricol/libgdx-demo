package au.com.deepspace.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogicgames.superjumper.SuperJumper;

public class DesktopLauncher
{
	public static void main(String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new LwjglApplication(new MyGdxGameUI(), config);
//		new LwjglApplication(new MyGdxGameSwitch(), config);
//		new LwjglApplication(new MyGdxGameShader(), config);
//		new LwjglApplication(new MyGdxGameBox2dLight(), config);
//		new LwjglApplication(new MyGdxGameBox2d(), config);
//		new LwjglApplication(new MyGdxGameParallax(), config);
//		new LwjglApplication(new MyGdxGameCamera(), config);
//		new LwjglApplication(new MyGdxGameParticles(), config);
		new LwjglApplication(new SuperJumper(), config);
//		new LwjglApplication(new Metagun(), config);
	}
}
