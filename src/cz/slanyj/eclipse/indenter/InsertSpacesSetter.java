package cz.slanyj.eclipse.indenter;

/**
 * Interface for classes which change the spaces substitution setting.
 * @author Singon
 *
 */
public interface InsertSpacesSetter {
	
	/**
	 * Sets whether typing tab in the editor should substitute the tab
	 * character with a string of space characters. The number of spaces
	 * inserted is controlled by the tab width setting.
	 * @param substitute True if tabs should be substituted with spaces.
	 */
	public void setInsertSpaces(boolean substitute);
}
