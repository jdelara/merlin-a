package views;


import org.eclipse.jface.resource.ImageDescriptor;

import handlers.Activator;

public class Images {
	public static final ImageDescriptor run;
	public static final ImageDescriptor reachability;
	
	static {
		run = Activator.getImageDescriptor("icons/run.png");
		reachability = Activator.getImageDescriptor("icons/reachability.png");
	}
}
