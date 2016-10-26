<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="LFHC:2101">Clinic</option>
        <option value ="LFHC:2102">Emergency</option>
        <option value ="LFHC:2103">In-hospital</option>
        <option value ="LFHC:2104">External</option>
    </select>
    <span class="field-error"></span>
</p>