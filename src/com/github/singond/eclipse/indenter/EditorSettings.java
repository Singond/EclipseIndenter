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
	 * Gets the most recent space substitution setting applied
	 * to the given editor.
	 *
	 * @param editor the editor
	 * @return the most recent space substitution setting applied
	 *         to {@code editor}
	 * @throws IllegalStateException if no value has been applied to
	 *         {@code editor} yet
	 */
	public boolean getInsertSpaces(IEditorPart editor) {
		Boolean value = insertSpacesSettings.get(editor);
		if (value != null) {
			return value.booleanValue();
		} else {
			throw new IllegalStateException("No value has been set for "
			                                + editor + " yet");
		}
	}
	
	/**
	 * Gets the preferred spaces substitution setting for the given
	 * editor or null, if no value has been set.
	 *
	 * @param editor the editor
	 * @return the last tab width setting applied to {@code editor}
	 */
	public void storeInsertSpaces(IEditorPart editor, boolean value) {
		Log.debug("Storing spaces setting for " + editor + ": " + value);
		if (editor == null) {
			throw new NullPointerException("Editor cannot be null");
		}
		insertSpacesSettings.put(editor, value);
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
	 * Gets the most recent tab width setting applied to the given editor.
	 *
	 * @param editor the editor
	 * @return the most recent tab width setting applied to {@code editor}
	 * @throws IllegalStateException if no value has been applied to
	 *         {@code editor} yet
	 */
	public short getTabWidth(IEditorPart editor) {
		Short w = tabWidthSettings.get(editor);
		if (w != null) {
			return w.shortValue();
		} else {
			throw new IllegalStateException("No value has been set for "
			                                + editor + " yet");
		}
	}
	
	/**
	 * Stores the preferred tab width for the given editor.
	 *
	 * @param editor the editor
	 * @param width the tab width
	 */
	public void storeTabWidth(IEditorPart editor, short width) {
		Log.debug("Storing tab width setting for " + editor + ": " + width);
		if (editor == null) {
			throw new NullPointerException("Editor cannot be null");
		}
		if (width < 0) {
			throw new IllegalArgumentException("Tab width must not be negative");
		}
		tabWidthSettings.put(editor, width);
	}
}
