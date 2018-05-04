package com.github.singond.eclipse.indenter;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class XmlSetter implements TabWidthSetter, InsertSpacesSetter {

	/**
	 * When setting indentation character to space,
	 * sets the indentation size to the tabWidth in general editor settings.
	 * If the indentation character is tab, sets the indentation size to 1.
	 */
	@Override
	public void setInsertSpaces(boolean substitute) {
		String indentChar = substitute ? "space" : "tab";
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.wst.xml.core");
		ps.setValue("indentationChar", indentChar);
		/*
		 * XML Editors have their own property for indentation size,
		 * but its meaning is different from displayed tab width.
		 * It is the number of repetitions of the indentation character
		 * (be it tab or space) for a single level of indentation.
		 * This means setting indentationChar=tab and indentationSize=4
		 * will indent every level with four tabs.
		 * In order to correct this, set indentationSize to 1 when using tabs.
		 */
		if (substitute) {
			IPreferenceStore psGeneral = new ScopedPreferenceStore(
					InstanceScope.INSTANCE, "org.eclipse.ui.editors");
			int tabWidth = psGeneral.getInt("tabWidth");
			ps.setValue("indentationSize", tabWidth);
		} else {
			ps.setValue("indentationSize", 1);
		}
	}

	@Override
	public void setTabWidth(int tabWidth) {
		IPreferenceStore ps = new ScopedPreferenceStore(InstanceScope.INSTANCE,
				"org.eclipse.wst.xml.core");
		String indentChar = ps.getString("indentationChar");
		switch (indentChar) {
			case "space":
				ps.setValue("indentationSize", tabWidth);
				break;
			case "tab":
				ps.setValue("indentationSize", 1);
				break;
			default:
				throw new IllegalArgumentException("Unknown value of indentationChar setting: "+indentChar);
		}
	}

}
