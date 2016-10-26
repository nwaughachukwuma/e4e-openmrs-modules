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
package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_11;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.Drug;
import org.openmrs.DrugIngredient;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.annotation.SubResource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

/**
 * {@link Resource} for DrugIngredient, supporting standard CRUD operations
 */
@SubResource(parent = DrugResource1_11.class, path = "ingredient", supportedClass = DrugIngredient.class, supportedOpenmrsVersions = {"1.11.*", "1.12.*", "2.0.*", "2.1.*"})
public class DrugIngredientResource1_11 extends DelegatingSubResource<DrugIngredient, Drug, DrugResource1_11> {
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("ingredient", Representation.REF);
			description.addProperty("strength");
			description.addProperty("units", Representation.REF);
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("ingredient", Representation.REF);
			description.addProperty("strength");
			description.addProperty("units", Representation.REF);
			description.addSelfLink();
			return description;
		}
		return null;
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getCreatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		description.addProperty("ingredient");
		description.addProperty("strength");
		description.addProperty("units");
        return description;
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getUpdatableProperties()
	 */
	@Override
	public DelegatingResourceDescription getUpdatableProperties() {
		return getCreatableProperties();
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#getParent(java.lang.Object)
	 */
	@Override
	public Drug getParent(DrugIngredient instance) {
		return instance.getDrug();
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#setParent(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public void setParent(DrugIngredient instance, Drug drug) {
		instance.setDrug(drug);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.api.SubResource#doGetAll(java.lang.Object,
	 *      org.openmrs.module.webservices.rest.web.RequestContext)
	 */
	@Override
	public NeedsPaging<DrugIngredient> doGetAll(Drug parent, RequestContext context) throws ResponseException {
		List<DrugIngredient> ingredients = new ArrayList<DrugIngredient>();
		if (parent != null) {
			ingredients.addAll(parent.getIngredients());
		}
		return new NeedsPaging<DrugIngredient>(ingredients, context);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#purge(java.lang.Object,
	 *      org.openmrs.module.webservices.rest.web.RequestContext)
	 */
	@Override
	public void purge(DrugIngredient ingredient, RequestContext context) throws ResponseException {
		Drug drug = ingredient.getDrug();
		drug.getIngredients().remove(ingredient);
		ingredient.setDrug(null);
		Context.getConceptService().saveDrug(drug);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceHandler#save(java.lang.Object)
	 */
	@Override
	public DrugIngredient save(DrugIngredient newIngredient) {
		// make sure that the ingredient has actually been added to the drug
		boolean needToAdd = true;
		for (DrugIngredient di : newIngredient.getDrug().getIngredients()) {
			if (di.equals(newIngredient)) {
				needToAdd = false;
				break;
			}
		}
		if (needToAdd) {
			newIngredient.getDrug().getIngredients().add(newIngredient);
		}
		
		Context.getConceptService().saveDrug(newIngredient.getDrug());
		return newIngredient;
	}

	/**
	 * Gets the display string for a concept name.
	 * 
	 * @param conceptName the concept name object.
	 * @return the display string.
	 */
	@PropertyGetter("display")
	public String getDisplayString(DrugIngredient ingredient) {
		return ingredient.getIngredient().getName().getName();
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#newDelegate()
	 */
	@Override
	public DrugIngredient newDelegate() {
		return new DrugIngredient();
	}

	@Override
	public DrugIngredient getByUniqueId(String uniqueId) {
		return Context.getConceptService().getDrugIngredientByUuid(uniqueId);
	}

	@Override
	protected void delete(DrugIngredient delegate, String reason, RequestContext context) throws ResponseException {
		throw new UnsupportedOperationException("Cannot void DrugIngredient. Use purge.");
	}
}