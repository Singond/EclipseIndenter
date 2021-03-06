package com.github.singond.eclipse.indenter;

import java.util.ArrayList;
import java.util.List;

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
 * Handles changing the setting for substituting tabs with spaces.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class InsertSpacesHandler extends AbstractHandler {
	
	private final List<InsertSpacesSetter> setters = new ArrayList<InsertSpacesSetter>();

	public InsertSpacesHandler() {
		setters.add(new GeneralSetter());
		setters.add(new JavaSetter());
		setters.add(new XmlSetter());
		setters.add(new HtmlSetter());
	}

	/**
	 * Sets the spaces substitution setting using all registered setters.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		boolean insertSpaces = insertSpacesEnabled();
		for (InsertSpacesSetter s : setters) {
			s.setInsertSpaces(!insertSpaces);
		}
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
