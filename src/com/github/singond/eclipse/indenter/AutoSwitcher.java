package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Enables switching the settings automatically.
 *
 * @author Singon
 */
public class AutoSwitcher implements IPartListener {

	private IEditorPart getActiveEditor() {
		return PlatformUI.getWorkbench()
		                .getActiveWorkbenchWindow()
		                .getActivePage()
		                .getActiveEditor();
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		Log.debug("Part activated: " + part);
		if (part instanceof IEditorPart) {
			IEditorPart editor = (IEditorPart) part;
			Log.debug("Opened editor " + editor);
		}
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		Log.debug("Part brought to top: " + part);
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		Log.debug("Part closed: " + part);
		
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
		Log.debug("Part deactivated: " + part);
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		Log.debug("Part opened: " + part);
		
	}
}
