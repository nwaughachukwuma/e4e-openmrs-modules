<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="163168">Public</option>
        <option value ="163169">Private</option>
    </select>
    <span class="field-error"></span>
</p>