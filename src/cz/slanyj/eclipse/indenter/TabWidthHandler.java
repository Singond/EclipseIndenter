package cz.slanyj.eclipse.indenter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class TabWidthHandler extends AbstractHandler {

	public TabWidthHandler() {}

	/**
	 * The command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String optString = event.getParameter("cz.slanyj.eclipse.indenter.params.tabWidth");
		short tabWidth = Short.valueOf(optString);
		
		// Display the selected option
		/*IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Setting Tab Width",
				"Selected tab width is "+tabWidth);*/
		
		// Works for the general setting, but is overriden in Java editors
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.ui.editors");
		ps.setValue("tabWidth", (int)tabWidth);
		
		// Works with Java editors
		/*IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.jdt.core");
		ps.setValue("org.eclipse.jdt.core.formatter.tabulation.size", (int)tabWidth);
		ps.setValue("org.eclipse.jdt.core.formatter.indentation.size", (int)tabWidth);*/
		
		return null;
	}
}