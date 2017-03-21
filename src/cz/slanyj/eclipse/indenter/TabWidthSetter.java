package cz.slanyj.eclipse.indenter;

/**
 * Interface for classes which change the tab width setting.
 * @author Singon
 *
 */
public interface TabWidthSetter {

	/**
	 * Sets the tab width to be used in display and space substitution.
	 * @param The tab width in characters
	 */
	public void setTabWidth(int tabWidth);
}
