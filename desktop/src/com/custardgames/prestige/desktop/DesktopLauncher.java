package com.custardgames.prestige.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.custardgames.prestige.Prestige;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Prestige";
		config.width = Prestige.WIDTH;
		config.height = Prestige.HEIGHT;
		config.resizable = true;
		config.backgroundFPS = 0;
		config.foregroundFPS = 0;
		config.vSyncEnabled = true;
		config.fullscreen = false;
		
		new LwjglApplication(new Prestige(), config);
	}
}
