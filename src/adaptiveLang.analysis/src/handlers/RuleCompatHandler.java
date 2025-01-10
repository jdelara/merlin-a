package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import analysis.RuleCompatAnalyser;
import merlin.common.utils.FileUtils;

public class RuleCompatHandler extends AnalysisHandler {
	private static final String MERLIN_ADAPTIVE_MARKER_RULEPROBLEM = "merlin.adaptive.marker.ruleproblem";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[merlin] Analysing rule compatibility");
		IFile adapterFile = this.getSelectedFile(event);
		
		RuleCompatAnalyser rca = new RuleCompatAnalyser(adapterFile);
		System.out.println(rca);
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		if (!rca.getErrors().isEmpty()) 
			 MessageDialog.openError      (window.getShell(), "Merlin", adapterFile.getName() + " has errors.");
		else MessageDialog.openInformation(window.getShell(), "Merlin", adapterFile.getName() + " validated successfully!");
		
		FileUtils.updateStringMarkers(adapterFile, rca.getErrors(), MERLIN_ADAPTIVE_MARKER_RULEPROBLEM);
		
		return Status.OK;
	}

}
