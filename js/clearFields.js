function clearFields(field)
{

	if (field == 'qc-legalAidRef')
	{
		document.getElementById('qc_legalAidRef').value= '';

		$('#laf-receipt').hide();
	}

	if (field == 'qd_no')
	{
		document.getElementById('qd_name1').value = '';
		document.getElementById('qd_relationship1').value = '';
		document.getElementById('qd_prn1').value = '';
		document.getElementById('qd_name2').value = '';
		document.getElementById('qd_relationship2').value = '';
		document.getElementById('qd_prn2').value = '';
		document.getElementById('qd_name3').value = '';
		document.getElementById('qd_relationship3').value = '';
		document.getElementById('qd_prn3').value = '';
		document.getElementById('qd_name4').value = '';
		document.getElementById('qd_relationship4').value = '';
		document.getElementById('qd_prn4').value = '';

		$('#multiple-application').hide();
	}

	if (field == 's1j_interpreter')
	{
		document.getElementById('s1j_who').value= '';
		document.getElementById('s1j_language').value= '';
		document.getElementById('s1j_dialect').value= '';

		$('#s1j_interpreter').hide();
	}

	if (field == 'removal_date')
	{
		document.getElementById('s1m_hour').value = '0';
		document.getElementById('s1m_minutes').value = '0';
		document.getElementById('s1m_ampm').value = '0';

		document.getElementById('s1n_day').value = '0';
		document.getElementById('s1n_month').value = '0';
		document.getElementById('s1n_year').value = '0';

		$('#removal_date').hide();
	}

	if (field == 'current_sentence')
	{
		document.getElementById('s1p_day').value = '0';
		document.getElementById('s1p_month').value = '0';
		document.getElementById('s1p_year').value = '0';

		document.getElementById('s1q_a').checked = false;
		document.getElementById('s1q_b').checked = false;
		document.getElementById('s1q_c').checked = false;
		document.getElementById('s1q_d').checked = false;

		$('#current_sentence').hide();
	}
	
	if (field == 'your_other_appeal')
	{
		document.getElementById('s3e_day1').value = '0';
		document.getElementById('s3e_month1').value = '0';
		document.getElementById('s3e_year1').value = '0';
		document.getElementById('s3e_appealNo1').value = '';

		document.getElementById('s3e_day2').value = '0';
		document.getElementById('s3e_month2').value = '0';
		document.getElementById('s3e_year2').value = '0';
		document.getElementById('s3e_appealNo2').value = '';

		document.getElementById('s3e_day3').value = '0';
		document.getElementById('s3e_month3').value = '0';
		document.getElementById('s3e_year3').value = '0';
		document.getElementById('s3e_appealNo3').value = '';

		$('#your_other_appeal').hide();
	}

	if (field == 's4')
	{
		document.getElementById('s4_decalaration').checked = false;
		$('#s4').hide();
	}
}