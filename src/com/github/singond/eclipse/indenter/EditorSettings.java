package com.github.singond.eclipse.indenter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.IEditorPart;

/**
 * Indenter settings specific to each open editor instance.
 *
 * @author Singon
 */
public class EditorSettings {

	private final Map<IEditorPart, Boolean> insertSpacesSettings;
	private final Map<IEditorPart, Short> tabWidthSettings;
	
	public EditorSettings() {
		this.insertSpacesSettings = new HashMap<>();
		this.tabWidthSettings = new HashMap<>();
	}
	
	/**
	 * Checks if spaces substitution setting has already been applied
	 * to the given editor.
	 *
	 * @param editor the editor
	 * @return if tab width has been set for the given editor
	 */
	public boolean hasInsertSpaces(IEditorPart editor) {
		return insertSpacesSettings.containsKey(editor);
	}
	
	/**
	 * Gets the preferred spaces substitution setting for the given
	 * editor or null, if no value has been set.
	 *
	 * @param editor the editor
	 * @return the last tab width setting applied to {@code editor}
	 */
	public boolean getInsertSpaces(IEditorPart editor) {
		return insertSpacesSettings.get(editor);
	}
	
	/**
	 * Gets the preferred spaces substitution setting for the given
	 * editor or null, if no value has been set.
	 *
	 * @param editor the editor
	 * @return the last tab width setting applied to {@code editor}
	 */
	public boolean storeInsertSpaces(IEditorPart editor, boolean value) {
		Log.debug("Storing spaces setting for " + editor + ": " + value);
		return insertSpacesSettings.put(editor, value);
	}
	
	/**
	 * Checks if width setting has already been applied to the
	 * given editor.
	 *
	 * @param editor the editor
	 * @return if tab width has been set for the given editor
	 */
	public boolean hasTabWidth(IEditorPart editor) {
		return tabWidthSettings.containsKey(editor);
	}
	
	/**
	 * Gets the preferred tab width for the given editor
	 * or -1, if no value has been set.
	 *
	 * @param editor the editor
	 * @return the last tab width setting applied to {@code editor}
	 */
	public short getTabWidth(IEditorPart editor) {
		return tabWidthSettings.get(editor);
	}
	
	/**
	 * Gets the preferred tab width for the given editor
	 * or -1, if no value has been set.
	 *
	 * @param editor the editor
	 * @return the last tab width setting applied to {@code editor}
	 */
	public short storeTabWidth(IEditorPart editor, short width) {
		Log.debug("Storing tab width setting for " + editor + ": " + width);
		return tabWidthSettings.put(editor, width);
	}
}
