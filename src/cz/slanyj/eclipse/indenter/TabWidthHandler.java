package cz.slanyj.eclipse.indenter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

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
	 * Sets the tab width setting using all registered setters.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String optString = event.getParameter("cz.slanyj.eclipse.indenter.params.tabWidth");
		short tabWidth = Short.valueOf(optString);
		for (TabWidthSetter s : setters) {
			s.setTabWidth(tabWidth);
		}
		return null;
	}
}
