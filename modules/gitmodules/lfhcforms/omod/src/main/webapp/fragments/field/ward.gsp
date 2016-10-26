<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="LFHC:2116">Medical</option>
        <option value ="LFHC:2117">Surgical</option>
        <option value ="LFHC:2118">Obstetrics</option>
    </select>
    <span class="field-error"></span>
</p>