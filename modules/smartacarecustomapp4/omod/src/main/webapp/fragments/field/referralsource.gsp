<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="163155">Clinic</option>
        <option value ="163156">Emergency</option>
        <option value ="163157">In-hospital</option>
        <option value ="163158">External</option>
    </select>
    <span class="field-error"></span>
</p>