package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchWindow;

public class WindowListener implements IWindowListener {

	public static final WindowListener INSTANCE;
	
	static {
		INSTANCE = new WindowListener();
	}
	
	public WindowListener() {
		Log.debug("Creating new WindowListener");
	}
	
	@Override
	public void windowActivated(IWorkbenchWindow win) {
		// TODO Auto-generated method stub
		Log.debug("Window activated: " + win);
		win.addPageListener(PageListener.INSTANCE);
		win.getActivePage().addPartListener(new AutoSwitcher());
	}

	@Override
	public void windowClosed(IWorkbenchWindow win) {
		// TODO Auto-generated method stub
		Log.debug("Window closed: " + win);
		
	}

	@Override
	public void windowDeactivated(IWorkbenchWindow win) {
		// TODO Auto-generated method stub
		Log.debug("Window deactivated: " + win);
		
	}

	@Override
	public void windowOpened(IWorkbenchWindow win) {
		Log.debug("Window opened: " + win);
//		win.addPageListener(PageListener.INSTANCE);
	}

}
