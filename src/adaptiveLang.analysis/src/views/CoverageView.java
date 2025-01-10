package views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;

import analysis.ConfigReachabilityAnalyser;
import analysis.CoverageAnalyser;
import analysis.FeatureMetric;
import merlin.adaptive.adapters.Diffs;
import merlin.adaptive.handlers.MigrationConfigDialog;
import merlin.common.utils.FileUtils;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;


/**

 */

public class CoverageView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "views.CoverageView";

	@Inject IWorkbench workbench;
	
	private TableViewer viewer;
	private Action calculateCoverage;
	private Action doubleClickAction;
	private Action reachabilityAnalysis;
	private ConfigReachabilityAnalyser cra;
	 
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		this.createColumns(parent);
		final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		//viewer.setLabelProvider(new ViewLabelProvider());
		List<IFile> allFiles = FileUtils.getAllIFiles("adapters");
		if (allFiles.size()>0) {
			CoverageAnalyser cva = new CoverageAnalyser(allFiles.get(0));
			this.cra = new ConfigReachabilityAnalyser(allFiles.get(0));
			viewer.setInput(cva.getFeatures());
		}

		// Create the help context id for the viewer's control
		workbench.getHelpSystem().setHelp(viewer.getControl(), "adaptiveLang.analysis.viewer");
		getSite().setSelectionProvider(viewer);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void createColumns(Composite parent) {
		String[] titles = { "Feature", "+-", "-+", "++", "--" };
        int[] bounds = { 100, 200, 200, 200, 200 };
        
        TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], SWT.NONE, 0);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                FeatureMetric p = (FeatureMetric) element;
                return p.getName();
            }
            
            @Override
            public Color getBackground(Object element) {
            	return new Color(new RGB(200,200,200)); 
            }
        });
        
        int i = 1;
        for (Diffs df: Diffs.values()) {
	        col = createTableViewerColumn(titles[i], bounds[i], SWT.CENTER, i);
	        i++;
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	FeatureMetric p = (FeatureMetric) element;
	                return p.getAdapterAsString(df);
	            }
	            @Override
	            public Color getBackground(Object element) {
	            	if (this.getText(element).equals(""))
	            		return new Color(new RGB(155, 0, 0));
	            	else return new Color(new RGB(0,155,0)); 
	            }
	        });       
        }
	}
	
	private TableViewerColumn createTableViewerColumn(String title, int bound, int align, final int colNumber) {
        final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,align);
        final TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;
    }

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				CoverageView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(calculateCoverage);
		manager.add(reachabilityAnalysis);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(calculateCoverage);
		manager.add(reachabilityAnalysis);
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(calculateCoverage);
		manager.add(reachabilityAnalysis);
	}

	private void makeActions() {
		calculateCoverage = new Action() {
			public void run() {
				List<IFile> allFiles = FileUtils.getAllIFiles("adapters");
				if (allFiles.size()>0) {
					CoverageAnalyser cva = new CoverageAnalyser(allFiles.get(0));
					List<String> uncovered = cva.getUncoveredFeatures();
					List<String> covered = cva.getCoveredFeatures();
					List<String> allFeatures = cva.allFeatures();
					double coveragePerc = 100*covered.size()/(allFeatures.size()*1.0);
					String strCovPerc = String.format("(%.2f%%)", coveragePerc);
					double unCoveredPerc = 100*uncovered.size()/(allFeatures.size()*1.0);
					String strUnCoveredPerc = String.format("(%.2f%%)", unCoveredPerc);
					
					String displayMessage = 
							"Coverage of "+allFiles.get(0).getName()+" "+strCovPerc+":\n"+
									(covered.size() == allFeatures.size() ? "  All" : "  "+covered)+
							"\nUncovered features "+strUnCoveredPerc+":\n"+
									(uncovered.isEmpty() ? "  None" : "  "+uncovered);
					showMessage(displayMessage);
					viewer.setInput(cva.getFeatures());
				}
				else showMessage("Error: adapters file not found!");
			}
		};
		calculateCoverage.setText("Calculate coverage");
		calculateCoverage.setToolTipText("Calculate coverage of features by adapters");
		/*calculateCoverage.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
						  getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));*/
		calculateCoverage.setImageDescriptor(Images.run);
		
		doubleClickAction = new Action() {
			public void run() {
				IStructuredSelection selection = viewer.getStructuredSelection();
				Object obj = selection.getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
		
		this.reachabilityAnalysis = new Action() {
			public void run() {
				cra.doAnalysis();
				MigrationConfigDialog mcf = new MigrationConfigDialog(null, cra.getFile().getProject());
				mcf.create();
				if (mcf.open()==Window.OK) {
					showMessage("Reachable: "+cra.isReachable(mcf.getSrcFile(), mcf.getTarFile()));
				}
				else {
					showMessage("Cancel!");
				}
			}
		};
		this.reachabilityAnalysis.setImageDescriptor(Images.reachability);
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Coverage view",
			message);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
