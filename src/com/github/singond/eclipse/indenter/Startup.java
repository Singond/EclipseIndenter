package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IStartup;

/**
 * Enables the Indenter plugin to start automatically.
 *
 * @author Singon
 */
public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		Log.debug("Starting Indenter plugin");
		new AutoRunner().start();
	}

}
