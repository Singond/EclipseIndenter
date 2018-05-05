package com.github.singond.eclipse.indenter;

/**
 * Container for the running plugin.
 *
 * @author Singon
 */
public class Indenter {

	/**
	 * Obtains the active {@code Indenter} instance from the activator.
	 */
	public static Indenter instance() {
		return Activator.getDefault().getIndenterInstance();
	}
}
