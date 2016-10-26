<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <p name="${config.formFieldName}">
	    Weight<br/><input type="number" min="1" name ="LFHC:2120" /><br/>
	    Height<br/>
	    <input type="number" min="1" name ="LFHC:2121" /><br/>
	    BMI<br/>
	    <input type="number" min="1" name ="LFHC:2122" /><br/>
	    Waist Circumference<br/>
	    <input type="number" min="1" name ="LFHC:2123" /><br/>
	    Hip Circumference<br/>
	    <input type="number" min="1" name ="LFHC:2124" /><br/>
	    Waist-Hip ratio<br/>
	    <input type="number" min="1" name ="LFHC:2125" />
	    <span class="field-error"></span>
    </p>
</p>