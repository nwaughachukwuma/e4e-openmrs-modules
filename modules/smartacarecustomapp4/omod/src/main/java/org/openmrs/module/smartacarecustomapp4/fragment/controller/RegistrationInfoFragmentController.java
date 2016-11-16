package org.openmrs.module.smartacarecustomapp4.fragment.controller;

import java.util.Map;
import java.util.Map.Entry;

import org.openmrs.Patient;
import org.openmrs.PersonAttribute;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomApp;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Fields and actions to provide registrationInfo view.
 * 
 * @author Romain Buisson
 */
public class RegistrationInfoFragmentController {

	private String fatherNameUuid= SmartaCareCustomApp.FATHER_NAME_UUID;		
	private String motherNameUuid= SmartaCareCustomApp.MOTHER_NAME_UUID;	
	
	public void controller(	FragmentModel model, @RequestParam("patientId") Patient patient,
			UiUtils ui
			)
	{
		model.addAttribute("fatherName", null);
		model.addAttribute("motherName", null);
		model.addAttribute("village", null);

		Map<String, PersonAttribute> attributes = patient.getPerson().getAttributeMap();
		for ( Entry<String, PersonAttribute> attr : attributes.entrySet() ) {
			if (attr.getValue().getAttributeType().getUuid().equals(fatherNameUuid)) {
				model.addAttribute("fatherName", attr.getValue());
			}			
			if (attr.getValue().getAttributeType().getUuid().equals(motherNameUuid)) {
				model.addAttribute("motherName", attr.getValue());
			}
		}		
		String village = patient.getPersonAddress().getCityVillage();
		model.addAttribute("village", village);
	}
}




