package com.github.singond.eclipse.indenter;

import org.eclipse.ui.IEditorPart;

public class AutoRunner extends EditorChangeListener {

	@Override
	public void editorChanged(IEditorPart editor) {
		Log.debug("Opened editor " + editor);
	}

}
