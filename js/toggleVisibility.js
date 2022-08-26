function initForm(form) {
	/* Function below working ----------------------- */
	if (form === 'iaft1-pg01') {
		var qcLegalAidRef = document.frmIAFT1.qb_LAR.value;

		if (qcLegalAidRef == null  || qcLegalAidRef == '' || qcLegalAidRef == undefined){
			$('#laf-receipt').hide();
		}
		else {
			$('#laf-receipt').show();
		}

		if (document.frmIAFT1.family_member[1].checked){
			$('#multiple_application').show();
		}
		else if(document.frmIAFT1.family_member[0].checked){
			$('#multiple-application').hide();
		}
		else {
			$('#multiple-application').hide();
		}
	}
	
	if (form === 'iaft1-pg02') {
		if (document.frmIAFT1.s1j[1].checked){
			$('#s1j_interpreter').show();
		}
		else if(document.frmIAFT1.s1j[0].checked){
			$('#s1j_interpreter').hide();
		}
		else {
			$('#s1j_interpreter').hide();
		}

		if (document.frmIAFT1.s1l[1].checked){
			$('#removal_date').show();
		}
		else if(document.frmIAFT1.s1l[0].checked){
			$('#removal_date').hide();
		}
		else {
			$('#removal_date').hide();
		}
		
		if (document.frmIAFT1.s1o[1].checked){
			$('#current_sentence').show();
		}
		else if(document.frmIAFT1.s1o[0].checked){
			$('#current_sentence').hide();
		}
		else {
			$('#current_sentence').hide();
		}
	}

	if (form === 'iaft1-pg08') {
		if (document.frmIAFT1.s3e[1].checked){
			$('#your_other_appeal').show();
		}
		else if(document.frmIAFT1.s3e[0].checked){
			$('#your_other_appeal').hide();
		}
		else {
			$('#your_other_appeal').hide();
		}
	}
}

