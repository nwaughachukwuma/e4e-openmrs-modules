<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="LFHC:913">Igbo</option>
        <option value ="LFHC:914">Hausa</option>
        <option value ="LFHC:915">Yoruba</option>
        <option value ="LFHC:916">Ibibio</option>
        <option value ="LFHC:917">English</option>
        <option value ="LFHC:918">French</option>
        <option value ="LFHC:919">Other</option>
    </select>
    <span class="field-error"></span>
</p>