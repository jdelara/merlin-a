package adaptiveLang.gentree.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GentreeConfigDialog extends Dialog {

	private Text cfolderTxt, afileTxt;
	private String cfolder, afile, projectpath;
	private IProject project;
	
	private final String DEFAULT_LANGUAGE_CONFIGURATIONS_FOLDER = "configs";
	private final String ADAPTERS_FILE_EXTENSION = "adapters";
	
	protected GentreeConfigDialog (Shell parentShell, IProject project) {
		super(parentShell);
		this.project     = project;
		this.projectpath = project.getLocation().toOSString();
	}
	
	@Override
    protected Control createDialogArea(Composite parent) {
		Composite  container = (Composite) super.createDialogArea(parent);
		GridLayout layout    = new GridLayout(3, false);
        layout.marginRight   = 5;
        layout.marginLeft    = 10;
        container.setLayout(layout);
        
        // language configurations folder
        Label cfolderLabel = new Label(container, SWT.LEFT); 
        cfolderLabel.setText("Language configurations folder:");
        cfolderTxt = new Text (container, SWT.WRAP | SWT.BORDER);
        cfolderTxt.setLayoutData(new GridData(200, 25));    
        cfolderTxt.setText(initLanguageConfigurationsFolder(true));
        Button cfolderButton = new Button(container, SWT.PUSH);
        cfolderButton.setText("Open");
        cfolderButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent event) {
        		DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.OPEN);
        		dialog.setFilterPath(projectpath);
        		String directory = dialog.open();
        		if (directory!=null) {
        			if (directory.startsWith(projectpath)) 
        				 cfolderTxt.setText( directory.substring(projectpath.length()+1) );
        			else MessageDialog.openInformation(getShell(), "Merlin", "Select a folder inside the project.");
        		}
        	}
        });
        
        // adapters file
        Label afileLabel = new Label(container, SWT.LEFT); 
        afileLabel.setText("Adapters file:");
        afileTxt = new Text (container, SWT.WRAP | SWT.BORDER);
        afileTxt.setLayoutData(new GridData(200, 25));
        afileTxt.setText(initAdaptersFile(true));
        Button afileButton = new Button(container, SWT.PUSH);
        afileButton.setText("Open");
        afileButton.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent event) {
        		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
        		dialog.setFilterPath(project.getLocation().toOSString());
        		dialog.setFilterExtensions(new String[] { "*."+ADAPTERS_FILE_EXTENSION });
        		String file = dialog.open();
        		if (file!=null) {
        			if (file.startsWith(projectpath)) 
        				 afileTxt.setText( file.substring(projectpath.length()+1) );
        			else MessageDialog.openInformation(getShell(), "Merlin", "Select a file inside the project.");
        		}
        	}
        });
        
		return container;
	}
	
	public String getConfigurationsFolder() {
		return this.cfolder;
	}
	
	public String getAdaptersFile() {
		return this.afile;
	}
	
	@Override
    protected void okPressed() {
		this.afile   = afileTxt.getText();
	    this.cfolder = cfolderTxt.getText();
	    String error = "";
	    
	    if (cfolder.isBlank())    
	    	error += "Please select a language configurations folder.\n";
	    else if (!project.getFolder(cfolder).exists()) 
	    	error += "The folder " + this.cfolder + " does not exist inside the project.\n";
	    
	    if (afile.isBlank())      
	    	error += "Please select an adapters file.\n";
	    else if (!project.getFile(afile).exists())   
	    	error += "The file " + this.afile + " does not exist inside the project.\n";
	    
    	if (error.isEmpty()) 
    		super.okPressed();
    	else MessageDialog.openError(getShell(), "Merlin", error);
	}	

	/**
	 * @return Default value for textfield "language configurations folder".
	 */	
	private String initLanguageConfigurationsFolder (boolean recursive) {		
		try {
			// recursive==false: looks in the root of the project
			if (!recursive) {
				IResource folder = project.findMember(DEFAULT_LANGUAGE_CONFIGURATIONS_FOLDER);
				return folder!=null? folder.getProjectRelativePath().toOSString() : "";
			}		
			// recursive==false: looks in the root of the project, and recursively in its folders
			else {
				IResource folder, resource;
				List<IResource> resources = new ArrayList<IResource>();
				resources.add(project);
				for (int i=0; i<resources.size(); i++) {
					resource = resources.get(i);
					if ((resource.getType() == IResource.FOLDER) || resource.getType() == IResource.PROJECT) {
						folder = ((IContainer)resource).findMember(DEFAULT_LANGUAGE_CONFIGURATIONS_FOLDER);
						if (folder!=null) {
							return folder.getProjectRelativePath().toOSString();
						}
						resources.addAll(Arrays.asList(((IContainer)resource).members()));
					}
				}
			}
		}
		catch (Exception e) {}	
		return "";			
	}

	/**
	 * @return Default value for textfield "adapters file".
	 */
	private String initAdaptersFile (boolean recursive) {
		try {		
			// recursive==false: looks in the root of the project
			if (!recursive) {
				Collection<IResource> members = Arrays.asList(project.members());
				Optional<IResource>   file    = members.stream().filter(member -> ADAPTERS_FILE_EXTENSION.equals(member.getFileExtension())).findAny();
				if (file.isPresent()) 
					return file.get().getProjectRelativePath().toOSString();
			} 
			// recursive==false: looks in the root of the project, and recursively in its folders
			else {
				IResource resource;
				List<IResource> resources = new ArrayList<IResource>();
				resources.add(project);
				for (int i=0; i<resources.size(); i++) {
					resource = resources.get(i);
					if ((resource.getType() == IResource.FOLDER) || resource.getType() == IResource.PROJECT) {
						Collection<IResource> members = Arrays.asList(((IContainer)resource).members());
						Optional<IResource>   file    = members.stream().filter(member -> ADAPTERS_FILE_EXTENSION.equals(member.getFileExtension())).findAny();
						if (file.isPresent()) { 
							return file.get().getProjectRelativePath().toOSString();
						}
						resources.addAll(Arrays.asList(((IContainer)resource).members()));
					}
				}
			}
		}
		catch (CoreException e) {}
		return "";
	}	
}