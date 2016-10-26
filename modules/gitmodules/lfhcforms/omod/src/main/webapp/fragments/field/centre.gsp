<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="LFHC:2113">Public</option>
        <option value ="LFHC:2114">Private</option>
    </select>
    <span class="field-error"></span>
</p>