package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;

/**
 * Enables the Indenter plugin to start automatically.
 *
 * @author Singon
 */
public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		Log.debug("Starting Indenter plugin");
		
//		PlatformUI.getWorkbench()
//		.getActiveWorkbenchWindow()
//		.getActivePage()
//		.addPartListener(new AutoSwitcher());
		PlatformUI.getWorkbench()
		          .addWindowListener(WindowListener.INSTANCE);
	}

}
