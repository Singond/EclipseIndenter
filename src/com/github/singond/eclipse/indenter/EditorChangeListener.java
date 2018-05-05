package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Enables switching the settings automatically.
 *
 * @author Singon
 */
public abstract class EditorChangeListener {
	
	private final WindowListener winLsnr;
	private final PageListener pageLsnr;
	private final PartListener partLsnr;
	
	public EditorChangeListener() {
		winLsnr = new WindowListener();
		pageLsnr = new PageListener();
		partLsnr = new PartListener();
	}

	public void start() {
		PlatformUI.getWorkbench().addWindowListener(winLsnr);
	}
	
	/**
	 * Called when an editor is activated.
	 *
	 * @param editor the editor which is now active
	 */
	public abstract void editorChanged(IEditorPart editor);
	
	private class WindowListener implements IWindowListener {
		
		@Override
		public void windowActivated(IWorkbenchWindow win) {
			Log.debug("Window activated: " + win);
			win.addPageListener(pageLsnr);
			win.getActivePage().addPartListener(partLsnr);
		}

		@Override
		public void windowClosed(IWorkbenchWindow win) {
			Log.debug("Window closed: " + win);
			
		}

		@Override
		public void windowDeactivated(IWorkbenchWindow win) {
			Log.debug("Window deactivated: " + win);
		}

		@Override
		public void windowOpened(IWorkbenchWindow win) {
			Log.debug("Window opened: " + win);
		}
	}
	
	private class PageListener implements IPageListener {
		
		@Override
		public void pageActivated(IWorkbenchPage page) {
			Log.debug("Page activated: " + page);
			page.addPartListener(partLsnr);
		}

		@Override
		public void pageClosed(IWorkbenchPage page) {
			Log.debug("Page closed: " + page);
		}

		@Override
		public void pageOpened(IWorkbenchPage page) {
			Log.debug("Page opened: " + page);
			Log.debug("Opening new workbench page, attaching page listener");
			page.addPartListener(partLsnr);
		}

	}
	
	private class PartListener implements IPartListener {

		@Override
		public void partActivated(IWorkbenchPart part) {
			Log.debug("Part activated: " + part);
			if (part instanceof IEditorPart) {
				IEditorPart editor = (IEditorPart) part;
				editorChanged(editor);
			}
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
			Log.debug("Part brought to top: " + part);
		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			Log.debug("Part closed: " + part);
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
			Log.debug("Part deactivated: " + part);
		}

		@Override
		public void partOpened(IWorkbenchPart part) {
			Log.debug("Part opened: " + part);
		}
	}
}
