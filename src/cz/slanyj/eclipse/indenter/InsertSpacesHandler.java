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
		Command cmd = event.getCommand();
		// The old value
		/*boolean old = HandlerUtil.toggleCommandState(cmd);
		boolean insertSpaces = !old;*/
		
		ICommandService cs = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		Command cmd2 = cs.getCommand("cz.slanyj.eclipse.indenter.commands.insertSpaces");
		State state = cmd2.getState("cz.slanyj.eclipse.indenter.state.insertSpaces");
		((PersistentState) state).setShouldPersist(true);
		boolean insertSpaces = (Boolean) state.getValue();
		state.setValue(!insertSpaces);
		insertSpaces = (Boolean) state.getValue();
		
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.ui.editors");
		ps.setValue("spacesForTabs", insertSpaces);
		
		// Display the selected option
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Setting Space Substitution",
				"Inserting spaces for tabs is turned " + (insertSpaces ? "on" : "off"));
		
		return null;
	}
}
