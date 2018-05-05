package com.github.singond.eclipse.indenter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;

/**
 * Handles changing the setting for tab width.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class TabWidthHandler extends AbstractHandler {

	private final List<TabWidthSetter> setters = new ArrayList<TabWidthSetter>();
	
	public TabWidthHandler() {
		setters.add(new GeneralSetter());
		setters.add(new JavaSetter());
		setters.add(new XmlSetter());
		setters.add(new HtmlSetter());
	}
	
	/**
	 * Sets the tab width setting to the given value using all
	 * registered setters.
	 *
	 * @param tabWidth the width of tab in spaces
	 */
	public void setTabWidth(short tabWidth) {
		for (TabWidthSetter s : setters) {
			s.setTabWidth(tabWidth);
		}
	}

	/**
	 * Sets the tab width setting using all registered setters.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String optString = event.getParameter("com.github.singond.eclipse.indenter.params.tabWidth");
		short tabWidth = Short.valueOf(optString);
		setTabWidth(tabWidth);
		IEditorPart editor = Indenter.getActiveEditor();
		EditorSettings settings = Indenter.instance().getEditorSettings();
		settings.storeTabWidth(editor, tabWidth);
		return null;
	}
}
