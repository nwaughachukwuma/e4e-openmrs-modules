<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <p name="${config.formFieldName}">
	    Weight<br/><input type="number" min="1" name="163175" /><br/>
	    Height(m)<br/>
	    <input type="number" min="1" step="0.01" name="163176" /><br/>
	    BMI<br/>
	    <input type="number" min="1" name="163177" /><br/>
	    Waist Circumference<br/>
	    <input type="number" id="waist_circ" min="1" name="163178" /><br/>
	    Hip Circumference<br/>
	    <input type="number" id="hip_circ" min="1" name="163179" onblur="calculateBMI()" onkeyup="calculateBMI()" /><br/>
	    Waist-Hip ratio<br/>
	    <input type="text" id="bmi"  name="163180" disabled="true" />
	    <span class="field-error"></span>
    </p>
    
    
    <script>
    	// custom function written to calculate the BMI.
    	function calculateBMI(){
		  	var waist_circ = document.getElementById("waist_circ").value;
		    var hip_circ = document.getElementById("hip_circ").value;
			if (waist_circ !== "" && hip_circ !== ""){
				var bmi = waist_circ/hip_circ;
				document.getElementById("bmi").value = bmi;
			}
			else {
				//ui.message("enter waist circumference");
				document.getElementById("waist_circ").blur(function(){
					var waist_circ = document.getElementById("waist_circ").value;
					var hip_circ = document.getElementById("hip_circ").value;
					var bmi = waist_circ/hip_circ;
					document.getElementById("bmi").value = bmi;
				});
				document.getElementById("waist_circ").onkeyup = function(){
					var waist_circ = document.getElementById("waist_circ").value;
					var hip_circ = document.getElementById("hip_circ").value;
					var bmi = waist_circ/hip_circ;
					document.getElementById("bmi").value = bmi;
				};
			}
		};    
    </script>
</p>