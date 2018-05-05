package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * Container for the running plugin.
 *
 * @author Singon
 */
public class Indenter {
	
	private final InsertSpacesHandler insertSpacesHandler;
	private final TabWidthHandler tabWidthHandler;
	private final EditorSettings settings;
	
	public Indenter() {
		this.insertSpacesHandler = new InsertSpacesHandler();
		this.tabWidthHandler = new TabWidthHandler();
		this.settings = new EditorSettings();
	}

	/**
	 * Obtains the active {@code Indenter} instance from the activator.
	 */
	public static Indenter instance() {
		return Activator.getDefault().getIndenterInstance();
	}
	
	public EditorSettings getEditorSettings() {
		return settings;
	}

	public InsertSpacesHandler getInsertSpacesHandler() {
		return insertSpacesHandler;
	}

	public TabWidthHandler getTabWidthHandler() {
		return tabWidthHandler;
	}
	
	public static IEditorPart getActiveEditor() {
		return PlatformUI.getWorkbench()
		                 .getActiveWorkbenchWindow()
		                 .getActivePage()
		                 .getActiveEditor();
	}
}
