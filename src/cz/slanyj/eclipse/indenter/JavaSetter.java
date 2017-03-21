package cz.slanyj.eclipse.indenter;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class JavaSetter implements TabWidthSetter, InsertSpacesSetter {

	/**
	 * Only toggles the value between TAB and SPACE.
	 * The Java editor also supports MIXED option, but setting that is not
	 * implemented in this class.
	 */
	@Override
	public void setInsertSpaces(boolean substitute) {
		String indentChar = substitute ? "space" : "tab";
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.jdt.core");
		ps.setValue("org.eclipse.jdt.core.formatter.tabulation.char", indentChar);
	}

	@Override
	public void setTabWidth(int tabWidth) {
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.jdt.core");
		ps.setValue("org.eclipse.jdt.core.formatter.tabulation.size", tabWidth);
		ps.setValue("org.eclipse.jdt.core.formatter.indentation.size", tabWidth);
	}

}
