package cz.slanyj.eclipse.indenter;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class GeneralSetter implements TabWidthSetter, InsertSpacesSetter {

	@Override
	public void setTabWidth(int tabWidth) {
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.ui.editors");
		ps.setValue("tabWidth", (int)tabWidth);
	}

	@Override
	public void setInsertSpaces(boolean substitute) {
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.ui.editors");
		ps.setValue("spacesForTabs", substitute);
	}

}
