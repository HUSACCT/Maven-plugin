package husacct.maven.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import husacct.ServiceProvider;
import husacct.analyse.IAnalyseService;
import husacct.control.ControlServiceImpl;
import husacct.control.task.MainController;
import husacct.control.task.WorkspaceController;
import husacct.validate.IValidateService;

import java.io.File;
import java.util.HashMap;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Checks an existing Maven project using the HUSACCT library 
 * @goal husacct
 * @requiresProject false
 */
public class HusacctMojo extends AbstractMojo {

	/**
	 * Workspace location.
	 * @parameter expression="${husacct.workspace}" default-value="workspace.hu"
	 */
	private String workspaceLocation;
	
	/**
	 * Output format
	 * @parameter expression="${husacct.outputformat}" default-value="pdf"
	 */	
	private String outputFormat;
	
	/**
	 * Output location
	 * @parameter expression="${husacct.outputlocation}" default-value="./export.pdf"
	 */	
	private String outputLocation;
	
	private MainController mainController;
	private WorkspaceController workspaceController;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info(String.format("Running HUSACCT using workspace %s, violations report stored as %s at %s", workspaceLocation, outputFormat, outputLocation));
		setControllers();
		loadWorkspace(workspaceLocation);
		analyseApplication();
		checkConformance();
		exportViolations(outputLocation, outputFormat);
	}
	
	private void setControllers(){
		ControlServiceImpl controlService = (ControlServiceImpl) ServiceProvider.getInstance().getControlService();
		mainController = controlService.getMainController();
		workspaceController = mainController.getWorkspaceController();
	}
	
	private void loadWorkspace(String location) throws MojoFailureException {
		getLog().info(String.format("Loading workspace %s", location));
		File file = new File(location);
		if(file.exists()){
			HashMap<String, Object> dataValues = new HashMap<String, Object>();
			dataValues.put("file", file);
			workspaceController.loadWorkspace("Husacct", dataValues);
			if(workspaceController.isOpenWorkspace()){
				getLog().info(String.format("Workspace %s loaded", location));
			} else {
				throw new MojoFailureException(String.format("Unable to open workspace %s", file.getAbsoluteFile()));
			}
		} else {
			throw new MojoFailureException(String.format("Unable to locate %s", file.getAbsoluteFile()));
		}
	}
	
	private void analyseApplication() throws MojoFailureException {
		IAnalyseService analyseService = ServiceProvider.getInstance().getAnalyseService();
		analyseService.analyseApplication();
		if(analyseService.isAnalysed()){
			getLog().info("Application analysed");
		} else {
			throw new MojoFailureException("Unable to analyse application");
		}
	}
	
	private void checkConformance() throws MojoFailureException {
		IValidateService validateService = ServiceProvider.getInstance().getValidateService();
		validateService.checkConformance();
		if(validateService.isValidated()){
			getLog().info("Application validated");
		} else {
			throw new MojoFailureException("Unable to validate application");
		}
	}
	
	private void exportViolations(String location, String extension) {
		IValidateService validateService = ServiceProvider.getInstance().getValidateService();
		File file = new File(location);
		getLog().debug(String.format("Export violations to %s", file.getAbsolutePath()));
		validateService.exportViolations(new File(location), extension);
	}
}
