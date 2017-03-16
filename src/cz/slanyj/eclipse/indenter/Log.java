package cz.slanyj.eclipse.indenter;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Status;

public class Log {

	static void debug(String msg) {
		log(msg, Status.INFO);
	}
	
	static void info(String msg) {
		log(msg, Status.INFO);
	}
	
	static void warn(String msg) {
		log(msg, Status.WARNING);
	}
	
	static void error(String msg) {
		log(msg, Status.ERROR);
	}
	
	private static void log(String msg, int level) {
		ILog l = Activator.getDefault().getLog();
		l.log(new Status(level, Activator.PLUGIN_ID, Status.OK, msg, null));
	}
}
