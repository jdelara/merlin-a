package merlin.adaptive.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MigrationConfigDialog extends Dialog {
	private Text src, tar;
	private String srcFile, tarFile;
	private IProject project;	
	
	public MigrationConfigDialog (Shell parentShell, IProject project) {
		super(parentShell);
		this.project = project;
	}
	
	@Override
    protected Control createDialogArea(Composite parent) {
		Composite  container = (Composite) super.createDialogArea(parent);
		GridLayout layout    = new GridLayout(2, false);
        layout.marginRight   = 5;
        layout.marginLeft   = 10;
        container.setLayout(layout);
        
        // property
        Label src_label = new Label(container, SWT.LEFT); 
        src_label.setText("Source configuration file:");
        src = new Text (container, SWT.WRAP | SWT.BORDER);
        src.setLayoutData(new GridData(200, 25));
        src.setText("configs/src.xml");
        
        Label tar_label = new Label(container, SWT.LEFT); 
        tar_label.setText("Target configuration file:");
        tar = new Text (container, SWT.WRAP | SWT.BORDER);
        tar.setLayoutData(new GridData(200, 25));
        tar.setText("configs/tar.xml");
        
		return container;
		
	}
	
	public String getSrcFile() {
		return this.srcFile;
	}
	
	public String getTarFile() {
		return this.tarFile;
	}
	
	 @Override
     protected void okPressed() {
	  	this.srcFile = src.getText();
	    this.tarFile = tar.getText();
	    if (this.checkFileExists(this.srcFile) && this.checkFileExists(this.tarFile))
	    	super.okPressed();
	 }

	private boolean checkFileExists(String fileName) {
		IFile src = this.project.getFile(fileName);
		if (!src.exists()) { 
			MessageDialog.openError(this.getShell(), "Merlin", "The file "+fileName+" does not exist");
			return false;
		}
		return true;
	}
}
