package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IEditorPart;

public class AutoRunner extends EditorChangeListener {
	
	@Override
	public void editorChanged(IEditorPart editor) {
		Log.debug("Opened editor " + editor);
		EditorSettings settings = Indenter.instance().getEditorSettings();
		
		if (settings.hasTabWidth(editor)) {
			short w = settings.getTabWidth(editor);
			Log.debug("Found tab width for this editor: " + w);
			Indenter.instance().getTabWidthHandler().setTabWidth(w);
		}
		
		if (settings.hasInsertSpaces(editor)) {
			boolean i = settings.getInsertSpaces(editor);
			Log.debug("Found insert spaces for this editor: " + i);
			Indenter.instance().getInsertSpacesHandler().setInsertSpaces(i);
		}
	}
}
