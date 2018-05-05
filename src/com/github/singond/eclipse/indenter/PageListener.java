package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IWorkbenchPage;

public class PageListener implements IPageListener {

	public static final PageListener INSTANCE;
	
	static {
		INSTANCE = new PageListener();
	}
	
	public PageListener() {
		Log.debug("Creating new PageListener");
	}
	
	@Override
	public void pageActivated(IWorkbenchPage page) {
//		page.addPartListener(new AutoSwitcher());
		Log.debug("Page activated: " + page);
		page.addPartListener(new AutoSwitcher());
	}

	@Override
	public void pageClosed(IWorkbenchPage page) {
		// TODO Auto-generated method stub
		Log.debug("Page closed: " + page);
	}

	@Override
	public void pageOpened(IWorkbenchPage page) {
		Log.debug("Page opened: " + page);
		Log.debug("Opening new workbench page, attaching page listener");
		page.addPartListener(new AutoSwitcher());
	}

}
