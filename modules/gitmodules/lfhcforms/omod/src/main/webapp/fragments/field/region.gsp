<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="LFHC:2106">SW</option>
        <option value ="LFHC:2107">SE</option>
        <option value ="LFHC:2108">SS</option>
        <option value ="LFHC:2109">NW</option>
        <option value ="LFHC:2110">NE</option>
        <option value ="LFHC:2111">NC</option>
        <option value ="LFHC:911">Foreigner</option>
    </select>
    <span class="field-error"></span>
</p>