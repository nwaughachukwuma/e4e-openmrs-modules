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
package org.openmrs.module.smartacarecustomapp4;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class SmartaCareCustomApp extends BaseOpenmrsObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	// custom provided by reference application module.
	public static final String MODULE_ID = "smartacarecustomapp3";	
	public static final String FATHER_NAME_UUID = "51c5e4f4-7e13-11e5-8bcf-feff819cdc9f";	
	public static final String MOTHER_NAME_UUID = "8d871d18-c2cc-11de-8d13-0010c6dffd0f";	
	
	private Integer id;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
}