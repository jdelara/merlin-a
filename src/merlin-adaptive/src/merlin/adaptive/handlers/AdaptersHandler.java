package merlin.adaptive.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;

import merlin.adaptive.utils.HandlerUtils;

public class AdaptersHandler extends AbstractHandler {	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile selectedFile = HandlerUtils.getSelectedFile(event);
		MigrationConfigDialog mcf = new MigrationConfigDialog(null, selectedFile.getProject());
		mcf.create();
		if (mcf.open()==Window.OK) {
			AdaptersFile adaptersFile = new AdaptersFile(selectedFile);
			if (adaptersFile.isValid()) {
				long m1 = System.currentTimeMillis();
				adaptersFile.generateTransformation(mcf.getSrcFile(), mcf.getTarFile());
				long m2 = System.currentTimeMillis();
				System.out.println("Time to generate the migration: "+(m2-m1)+" ms");
				return Status.OK_STATUS;
			}
			else return Status.CANCEL_STATUS;
		}
		else return Status.CANCEL_STATUS;		
	}
}
