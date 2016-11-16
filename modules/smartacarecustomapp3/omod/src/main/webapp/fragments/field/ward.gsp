<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="163171">Medical</option>
        <option value ="163172">Surgical</option>
        <option value ="163173">Obstetrics</option>
    </select>
    <span class="field-error"></span>
</p>