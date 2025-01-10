package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import adapters.Adapter;
import adapters.AdapterModel;
import analysis.CoverageAnalyser;
import merlin.adaptive.adapters.ConfigDiff;
import merlin.adaptive.adapters.Diffs;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import handlers.utils.AdaptersUtil;

import org.eclipse.core.resources.IFile;

import merlin.common.features.DefaultFeatureProvider;
import merlin.common.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;

public class CoverageHandler extends AnalysisHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[merlin] Analysing adapters coverage");
		//List<IFile> allFiles = FileUtils.getAllIFiles("adapters");
		IFile selectedFile = this.getSelectedFile(event);
		CoverageAnalyser cva = new CoverageAnalyser(selectedFile);
		System.out.println(cva.getCoverage());		
		return Status.OK;
	}
}
