package com.github.singond.eclipse.indenter;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public final class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "Activator"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/** Main object specific to this plug-in instance. */
	private final Indenter instance;
	
	/**
	 * Constructs a new Activator of this plug-in.
	 */
	public Activator() {
		this.instance = new Indenter();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the main object for this plug-in instance.
	 *
	 * @return the instance of {@code Indenter}
	 */
	public Indenter getIndenterInstance() {
		return instance;
	}
}
