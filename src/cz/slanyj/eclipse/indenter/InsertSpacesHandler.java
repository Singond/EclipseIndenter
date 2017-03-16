package cz.slanyj.eclipse.indenter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.State;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.jface.commands.PersistentState;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class InsertSpacesHandler extends AbstractHandler {

	public InsertSpacesHandler() {}

	/**
	 * The command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		boolean insertSpaces = insertSpacesEnabled();
		
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.ui.editors");
		ps.setValue("spacesForTabs", !insertSpaces);
		return null;
	}
	
	/**
	 * Decides whether substituting spaces for tabs is enabled.
	 * Currently checks only the global setting in org.eclipse.ui.editors. 
	 * @return True if tabs are being substituted by spaces.
	 */
	private boolean insertSpacesEnabled() {
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.ui.editors");
		boolean enabled = ps.getBoolean("spacesForTabs");
		Log.debug(enabled ? "SpacesForTabs was enabled" : "SpacesForTabs was not enabled");
		return enabled;
	}
}
