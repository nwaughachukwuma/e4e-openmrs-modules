<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="163161">SW</option>
        <option value ="163162">SE</option>
        <option value ="163163">SS</option>
        <option value ="163164">NW</option>
        <option value ="163165">NE</option>
        <option value ="163166">NC</option>
        <option value ="163147">Foreigner</option>
    </select>
    <span class="field-error"></span>
</p>