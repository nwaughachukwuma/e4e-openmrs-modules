/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.smartacarecustomapp3;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleActivator;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.smartacarecustomapp3.activator.Initializer;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class SmartaCareCustomAppActivator implements ModuleActivator {
	
	protected Log log = LogFactory.getLog(getClass());
	
	
	// adopted from lfhcforms module
	public List<Initializer> getInitializers() {
//		List<Initializer> l = new ArrayList<Initializer>();
//		l.add(new HtmlFormsInitializer());
//		return l;
		return null;
	}
		
	/**
	 * @see ModuleActivator#willRefreshContext()
	 */
	public void willRefreshContext() {
		log.info("Refreshing SmartaCare Custom App Module");
	}
	
	/**
	 * @see ModuleActivator#contextRefreshed()
	 */
	public void contextRefreshed() {
		log.info("SmartaCare Custom App Module refreshed");
	}
	
	/**
	 * @see ModuleActivator#willStart()
	 */
	public void willStart() {
		log.info("Starting SmartaCare Custom App Module");
	}
	
	/**
	 * @see ModuleActivator#started()
	 */
	public void started() {
		log.info("SmartaCare Custom App Module started.\nSetting custom admin configuration for SmartaCare Custom App");
		
		try{
			// Disabling the default Patient Registration app (page).
			AppFrameworkService service = Context.getService(AppFrameworkService.class);
			service.disableApp("referenceapplication.registrationapp.registerPatient");
			
		}catch(Exception e){
			Module mod = ModuleFactory.getModuleById(SmartaCareCustomApp.MODULE_ID);
            ModuleFactory.stopModule(mod);
            throw new RuntimeException("failed to setup the required modules", e);
		}
		// iterate over activators
		for (Initializer initializer : getInitializers()) {
			initializer.started();
		}
	}
	
	/**
	 * @see ModuleActivator#willStop()
	 */
	public void willStop() {
		log.info("Stopping SmartaCare Custom App Module");
	}
	
	/**
	 * @see ModuleActivator#stopped()
	 */
	public void stopped() {
		log.info("SmartaCare Custom App Module stopped.\nUnsetting custom admin configuration for SmartaCare Custom App");
		AppFrameworkService service = Context.getService(AppFrameworkService.class);
		service.enableApp("referenceapplication.registrationapp.registerPatient");
		
		for (int i = getInitializers().size() - 1; i >= 0; i--) {
			getInitializers().get(i).stopped();
		}
	}
		
}
