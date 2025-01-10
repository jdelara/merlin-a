package merlin.adaptive.utils;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class HandlerUtils {
		// it returns the file selected in the workspace
		public static IFile getSelectedFile (ExecutionEvent event) {
			IFile      file      = null;
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if (selection instanceof IStructuredSelection) {
				Object first = ((IStructuredSelection)selection).getFirstElement();
				if (first==null) 
					return null;
				IAdapterManager man = Platform.getAdapterManager();
				if (man==null) return null;
				file = man.getAdapter(first, IFile.class);
				if (file == null) 
					if (first instanceof IAdaptable)
						file = (IFile)((IAdaptable)first).getAdapter(IFile.class);
			}
			return file;
		}
}
