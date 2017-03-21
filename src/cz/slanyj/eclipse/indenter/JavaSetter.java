package cz.slanyj.eclipse.indenter;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class JavaSetter implements TabWidthSetter, InsertSpacesSetter {

	@Override
	public void setInsertSpaces(boolean substitute) {
		Log.warn("Setting spacesForTabs is not implemented yet in JavaSetter");
	}

	@Override
	public void setTabWidth(int tabWidth) {
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.jdt.core");
		ps.setValue("org.eclipse.jdt.core.formatter.tabulation.size", tabWidth);
		ps.setValue("org.eclipse.jdt.core.formatter.indentation.size", tabWidth);
	}

}
