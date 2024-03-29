CREATE SCHEMA dbo;
CREATE TABLE dbo.Fees(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	startdate TIMESTAMP(0) NULL,
	fees_paper varchar(50) NULL,
	fees_oral varchar(50) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE dbo.formsdata(
  ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	securitytoken varchar(50) NULL,
	submissionURN varchar(50) NULL,
	paymentURN varchar(50) NULL,
	AggregatedURN varchar(50) NULL,
	formname varchar(50) NULL,
	amount int NULL,
	formtitle varchar(50) NULL,
	transactionstatus varchar(50) DEFAULT 'Not Known' NULL,
	count int DEFAULT 0 NULL,
	status varchar(50) DEFAULT 'In Progress' NULL,
	PRIMARY KEY (ID)
  );

CREATE TABLE dbo.IAFT1(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	hearing_type varchar(50) NULL,
	qa_sponsor varchar(50) NULL,
	qa_rep varchar(50) NULL,
	qa_witness varchar(50) NULL,
	qb_lsc varchar(50) NULL,
	qb_LAR varchar(50) NULL,
	family_member varchar(50) NULL,
	qc_name1 varchar(70) NULL,
	qc_relationship1 varchar(50) NULL,
	qc_prn1 varchar(50) NULL,
	qc_name2 varchar(70) NULL,
	qc_relationship2 varchar(50) NULL,
	qc_prn2 varchar(50) NULL,
	qc_name3 varchar(70) NULL,
	qc_relationship3 varchar(50) NULL,
	qc_prn3 varchar(50) NULL,
	qc_name4 varchar(70) NULL,
	qc_relationship4 varchar(50) NULL,
	qc_prn4 varchar(50) NULL,
	s1a varchar(50) NULL,
	s1b varchar(50) NULL,
	s1c varchar(50) NULL,
	s1d TIMESTAMP(3) NULL,
	s1e varchar(50) NULL,
	s1f_addr1 varchar(50) NULL,
	s1f_addr2 varchar(50) NULL,
	s1f_addr3 varchar(50) NULL,
	s1f_addr4 varchar(50) NULL,
	s1f_postcode varchar(50) NULL,
	s1g varchar(50) NULL,
	s1h varchar(50) NULL,
	s1i_yourself varchar(50) NULL,
	s1i_witness varchar(50) NULL,
	s1i_representative varchar(50) NULL,
	s1j varchar(50) NULL,
	s1j_who varchar(70) NULL,
	s1j_language varchar(50) NULL,
	s1j_dialect varchar(50) NULL,
	s1k varchar(1000) NULL,
	s1l varchar(50) NULL,
	s1m varchar(50) NULL,
	s1n TIMESTAMP(3) NULL,
	s1o varchar(50) NULL,
	s1p TIMESTAMP(3) NULL,
	s1q varchar(50) NULL,
	s2a varchar(50) NULL,
	s2b varchar(50) NULL,
	s2c varchar(50) NULL,
	s2d_post varchar(50) NULL,
	s2d_fax varchar(50) NULL,
	s2d_courier varchar(50) NULL,
	s2d_other varchar(50) NULL,
	s2e TIMESTAMP(3) NULL,
	s2f varchar(50) NULL,
	s3a varchar(8000) NULL,
	s3b varchar(8000) NULL,
	s3c varchar(8000) NULL,
	s3d_1 varchar(8000) NULL,
	s3d_2 varchar(8000) NULL,
	s3d_3 varchar(8000) NULL,
	s3d_4 varchar(8000) NULL,
	s3d_5 varchar(8000) NULL,
	s3d_6 varchar(8000) NULL,
	s3d_7 varchar(8000) NULL,
	s3d_8 varchar(8000) NULL,
	s3d_additional varchar(8000) NULL,
	s3e varchar(8000) NULL,
	s3e_date1 TIMESTAMP(3) NULL,
	s3e_appealno1 varchar(50) NULL,
	s3e_date2 TIMESTAMP(3) NULL,
	s3e_appealno2 varchar(50) NULL,
	s3e_date3 TIMESTAMP(3) NULL,
	s3e_appealno3 varchar(50) NULL,
	s3f varchar(50) NULL,
	s4_signature varchar(50) NULL,
	s4_date TIMESTAMP(3) NULL,
	s5a varchar(500) NULL,
	s5b varchar(500) NULL,
	s5c_addr1 varchar(50) NULL,
	s5c_addr2 varchar(50) NULL,
	s5c_addr3 varchar(50) NULL,
	s5c_addr4 varchar(50) NULL,
	s5c_postcode varchar(50) NULL,
	s5d varchar(50) NULL,
	s5e varchar(50) NULL,
	s5f varchar(50) NULL,
	s5g varchar(50) NULL,
	s5h varchar(50) NULL,
	s5i varchar(50) NULL,
	s5j varchar(50) NULL,
	securitytoken varchar(50) NULL,
	s5b_other varchar(50) NULL,
	rep_sign varchar(50) NULL,
	date_added TIMESTAMP(0) NULL,
	s4_declaration varchar(50) NULL,
	s2i TIMESTAMP(3) NULL,
	s1f_email varchar(250) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE dbo.IAFT2(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	hearing_type varchar(50) NULL,
	qa_sponsor varchar(50) NULL,
	qa_rep varchar(50) NULL,
	qa_witness varchar(50) NULL,
	qb_lsc varchar(50) NULL,
	qb_LAR varchar(50) NULL,
	family_member varchar(50) NULL,
	qc_name1 varchar(70) NULL,
	qc_relationship1 varchar(50) NULL,
	qc_prn1 varchar(50) NULL,
	qc_name2 varchar(70) NULL,
	qc_relationship2 varchar(50) NULL,
	qc_prn2 varchar(50) NULL,
	qc_name3 varchar(70) NULL,
	qc_relationship3 varchar(50) NULL,
	qc_prn3 varchar(50) NULL,
	qc_name4 varchar(70) NULL,
	qc_relationship4 varchar(50) NULL,
	qc_prn4 varchar(50) NULL,
	s1a varchar(35) NULL,
	s1b varchar(35) NULL,
	s1c varchar(50) NULL,
	s1d TIMESTAMP(3) NULL,
	s1e varchar(50) NULL,
	s1f_addr1 varchar(50) NULL,
	s1f_addr2 varchar(50) NULL,
	s1f_addr3 varchar(50) NULL,
	s1f_addr4 varchar(50) NULL,
	s1f_postcode varchar(50) NULL,
	s1g varchar(50) NULL,
	s1h varchar(50) NULL,
	s1i_yourself varchar(50) NULL,
	s1i_witness varchar(50) NULL,
	s1i_representative varchar(50) NULL,
	s1j varchar(50) NULL,
	s1j_who varchar(70) NULL,
	s1j_language varchar(50) NULL,
	s1j_dialect varchar(50) NULL,
	s1k varchar(1000) NULL,
	s1l varchar(50) NULL,
	s1m varchar(50) NULL,
	s1n TIMESTAMP(3) NULL,
	s1o varchar(50) NULL,
	s1p TIMESTAMP(3) NULL,
	s1q varchar(50) NULL,
	s2a varchar(50) NULL,
	s2b varchar(50) NULL,
	s2c varchar(50) NULL,
	s2d_post varchar(50) NULL,
	s2d_fax varchar(50) NULL,
	s2d_courier varchar(50) NULL,
	s2d_other varchar(50) NULL,
	s2e TIMESTAMP(3) NULL,
	s2f varchar(50) NULL,
	s3a varchar(8000) NULL,
	s3b varchar(8000) NULL,
	s3c varchar(8000) NULL,
	s3d_1 varchar(8000) NULL,
	s3d_2 varchar(8000) NULL,
	s3d_3 varchar(8000) NULL,
	s3d_4 varchar(8000) NULL,
	s3d_5 varchar(8000) NULL,
	s3d_6 varchar(8000) NULL,
	s3d_7 varchar(8000) NULL,
	s3d_8 varchar(8000) NULL,
	s3d_additional varchar(8000) NULL,
	s3e varchar(8000) NULL,
	s3e_date1 TIMESTAMP(3) NULL,
	s3e_appealno1 varchar(50) NULL,
	s3e_date2 TIMESTAMP(3) NULL,
	s3e_appealno2 varchar(50) NULL,
	s3e_date3 TIMESTAMP(3) NULL,
	s3e_appealno3 varchar(50) NULL,
	s3f varchar(50) NULL,
	s4_signature varchar(50) NULL,
	s4_date TIMESTAMP(3) NULL,
	s5a varchar(500) NULL,
	s5b varchar(500) NULL,
	s5c_addr1 varchar(50) NULL,
	s5c_addr2 varchar(50) NULL,
	s5c_addr3 varchar(50) NULL,
	s5c_addr4 varchar(50) NULL,
	s5c_postcode varchar(50) NULL,
	s5d varchar(50) NULL,
	s5e varchar(50) NULL,
	s5f varchar(50) NULL,
	s5g varchar(50) NULL,
	s5h varchar(50) NULL,
	s5i varchar(50) NULL,
	s5j varchar(50) NULL,
	securitytoken varchar(50) NULL,
	s5b_other varchar(50) NULL,
	rep_sign varchar(50) NULL,
	s6a varchar(35) NULL,
	s6b varchar(35) NULL,
	s6c varchar(50) NULL,
	s6d_addr1 varchar(50) NULL,
	s6d_addr2 varchar(50) NULL,
	s6d_addr3 varchar(50) NULL,
	s6d_addr4 varchar(50) NULL,
	s6d_postcode varchar(50) NULL,
	s6e varchar(50) NULL,
	s6f varchar(50) NULL,
	s6_auth varchar(50) NULL,
	date_added TIMESTAMP(3) NULL,
	have_rep varchar(50) NULL,
	have_sponsor varchar(50) NULL,
	other_rep varchar(100) NULL,
	s4_declaration varchar(50) NULL,
	s2i TIMESTAMP(3) NULL,
	s1f_email varchar(250) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE dbo.IAFT3(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	hearing_type varchar(50) NULL,
	qa_sponsor varchar(50) NULL,
	qa_rep varchar(50) NULL,
	qa_witness varchar(50) NULL,
	qb_lsc varchar(50) NULL,
	qb_LAR varchar(50) NULL,
	family_member varchar(50) NULL,
	qc_name1 varchar(70) NULL,
	qc_relationship1 varchar(50) NULL,
	qc_prn1 varchar(50) NULL,
	qc_name2 varchar(70) NULL,
	qc_relationship2 varchar(50) NULL,
	qc_prn2 varchar(50) NULL,
	qc_name3 varchar(70) NULL,
	qc_relationship3 varchar(50) NULL,
	qc_prn3 varchar(50) NULL,
	qc_name4 varchar(70) NULL,
	qc_relationship4 varchar(50) NULL,
	qc_prn4 varchar(50) NULL,
	s1a varchar(35) NULL,
	s1b varchar(35) NULL,
	s1c varchar(50) NULL,
	s1d TIMESTAMP(3) NULL,
	s1e varchar(50) NULL,
	s1f_addr1 varchar(50) NULL,
	s1f_addr2 varchar(50) NULL,
	s1f_addr3 varchar(50) NULL,
	s1f_addr4 varchar(50) NULL,
	s1f_postcode varchar(50) NULL,
	s1g varchar(50) NULL,
	s1h varchar(50) NULL,
	s1i_yourself varchar(50) NULL,
	s1i_witness varchar(50) NULL,
	s1i_representative varchar(50) NULL,
	s1j varchar(50) NULL,
	s1j_who varchar(70) NULL,
	s1j_language varchar(50) NULL,
	s1j_dialect varchar(50) NULL,
	s1k varchar(1000) NULL,
	s1l varchar(50) NULL,
	s1m varchar(50) NULL,
	s1n TIMESTAMP(3) NULL,
	s1o varchar(50) NULL,
	s1p TIMESTAMP(3) NULL,
	s1q varchar(50) NULL,
	s2a varchar(50) NULL,
	s2b varchar(50) NULL,
	s2c varchar(50) NULL,
	s2d_post varchar(50) NULL,
	s2d_fax varchar(50) NULL,
	s2d_courier varchar(50) NULL,
	s2d_other varchar(50) NULL,
	s2e TIMESTAMP(3) NULL,
	s2f TIMESTAMP(3) NULL,
	s3a varchar(8000) NULL,
	s3b varchar(8000) NULL,
	s3c varchar(8000) NULL,
	s3d_1 varchar(8000) NULL,
	s3d_2 varchar(8000) NULL,
	s3d_3 varchar(8000) NULL,
	s3d_4 varchar(8000) NULL,
	s3d_5 varchar(8000) NULL,
	s3d_6 varchar(8000) NULL,
	s3d_7 varchar(8000) NULL,
	s3d_8 varchar(8000) NULL,
	s3d_additional varchar(8000) NULL,
	s3e varchar(8000) NULL,
	s3e_date1 TIMESTAMP(3) NULL,
	s3e_appealno1 varchar(50) NULL,
	s3e_date2 TIMESTAMP(3) NULL,
	s3e_appealno2 varchar(50) NULL,
	s3e_date3 TIMESTAMP(3) NULL,
	s3e_appealno3 varchar(50) NULL,
	s3f varchar(50) NULL,
	s4_signature varchar(50) NULL,
	s4_date TIMESTAMP(3) NULL,
	s5a varchar(500) NULL,
	s5b varchar(500) NULL,
	s5c_addr1 varchar(50) NULL,
	s5c_addr2 varchar(50) NULL,
	s5c_addr3 varchar(50) NULL,
	s5c_addr4 varchar(50) NULL,
	s5c_postcode varchar(50) NULL,
	s5d varchar(50) NULL,
	s5e varchar(50) NULL,
	s5f varchar(50) NULL,
	s5g varchar(50) NULL,
	s5h varchar(50) NULL,
	s5i varchar(50) NULL,
	s5j varchar(50) NULL,
	securitytoken varchar(50) NULL,
	s5b_other varchar(50) NULL,
	rep_sign varchar(50) NULL,
	date_added TIMESTAMP(0) NULL,
	s4_declaration varchar(50) NULL,
	s2i TIMESTAMP(3) NULL,
	s1f_email varchar(250) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE dbo.IAFT5(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	hearing_type varchar(50) NULL,
	qa_sponsor varchar(50) NULL,
	qa_rep varchar(50) NULL,
	qa_witness varchar(50) NULL,
	qb_lsc varchar(50) NULL,
	qb_LAR varchar(50) NULL,
	family_member varchar(50) NULL,
	qc_name1 varchar(70) NULL,
	qc_relationship1 varchar(50) NULL,
	qc_prn1 varchar(50) NULL,
	qc_name2 varchar(70) NULL,
	qc_relationship2 varchar(50) NULL,
	qc_prn2 varchar(50) NULL,
	qc_name3 varchar(70) NULL,
	qc_relationship3 varchar(50) NULL,
	qc_prn3 varchar(50) NULL,
	qc_name4 varchar(70) NULL,
	qc_relationship4 varchar(50) NULL,
	qc_prn4 varchar(50) NULL,
	s1a varchar(50) NULL,
	s1b varchar(50) NULL,
	s1c varchar(50) NULL,
	s1d TIMESTAMP(3) NULL,
	s1e varchar(50) NULL,
	s1f_addr1 varchar(50) NULL,
	s1f_addr2 varchar(50) NULL,
	s1f_addr3 varchar(50) NULL,
	s1f_addr4 varchar(50) NULL,
	s1f_postcode varchar(50) NULL,
	s1g varchar(50) NULL,
	s1h varchar(50) NULL,
	s1i_yourself varchar(50) NULL,
	s1i_witness varchar(50) NULL,
	s1i_representative varchar(50) NULL,
	s1j varchar(50) NULL,
	s1j_who varchar(70) NULL,
	s1j_language varchar(50) NULL,
	s1j_dialect varchar(50) NULL,
	s1k varchar(1000) NULL,
	s1l varchar(50) NULL,
	s1m varchar(50) NULL,
	s1n TIMESTAMP(3) NULL,
	s1o varchar(50) NULL,
	s1p TIMESTAMP(3) NULL,
	s1q varchar(50) NULL,
	s2a varchar(50) NULL,
	s2b varchar(50) NULL,
	s2c varchar(50) NULL,
	s2d_post varchar(50) NULL,
	s2d_fax varchar(50) NULL,
	s2d_courier varchar(50) NULL,
	s2d_other varchar(50) NULL,
	s2e TIMESTAMP(3) NULL,
	s2f varchar(50) NULL,
	s3a varchar(8000) NULL,
	s3b varchar(8000) NULL,
	s3c varchar(8000) NULL,
	s3d_1 varchar(8000) NULL,
	s3d_2 varchar(8000) NULL,
	s3d_3 varchar(8000) NULL,
	s3d_4 varchar(8000) NULL,
	s3d_5 varchar(8000) NULL,
	s3d_6 varchar(8000) NULL,
	s3d_7 varchar(8000) NULL,
	s3d_8 varchar(8000) NULL,
	s3d_additional varchar(8000) NULL,
	s3e varchar(8000) NULL,
	s3e_date1 TIMESTAMP(3) NULL,
	s3e_appealno1 varchar(50) NULL,
	s3e_date2 TIMESTAMP(3) NULL,
	s3e_appealno2 varchar(50) NULL,
	s3e_date3 TIMESTAMP(3) NULL,
	s3e_appealno3 varchar(50) NULL,
	s3f varchar(50) NULL,
	s4_signature varchar(50) NULL,
	s4_date TIMESTAMP(3) NULL,
	s5a varchar(500) NULL,
	s5b varchar(500) NULL,
	s5c_addr1 varchar(50) NULL,
	s5c_addr2 varchar(50) NULL,
	s5c_addr3 varchar(50) NULL,
	s5c_addr4 varchar(50) NULL,
	s5c_postcode varchar(50) NULL,
	s5d varchar(50) NULL,
	s5e varchar(50) NULL,
	s5f varchar(50) NULL,
	s5g varchar(50) NULL,
	s5h varchar(50) NULL,
	s5i varchar(50) NULL,
	s5j varchar(50) NULL,
	securitytoken varchar(50) NULL,
	s5b_other varchar(50) NULL,
	rep_sign varchar(50) NULL,
	date_added TIMESTAMP(0) NULL,
	s4_declaration varchar(50) NULL,
	s2i TIMESTAMP(3) NULL,
	s1f_email varchar(250) NULL,
	s2HOAN varchar(50) NULL,
	s2j TIMESTAMP(3) NULL,
	s2k varchar(50) NULL,
	s3g varchar(3000) NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE dbo.IAFT6(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	hearing_type varchar(50) NULL,
	qa_sponsor varchar(50) NULL,
	qa_rep varchar(50) NULL,
	qa_witness varchar(50) NULL,
	qb_lsc varchar(50) NULL,
	qb_LAR varchar(50) NULL,
	family_member varchar(50) NULL,
	qc_name1 varchar(70) NULL,
	qc_relationship1 varchar(50) NULL,
	qc_prn1 varchar(50) NULL,
	qc_name2 varchar(70) NULL,
	qc_relationship2 varchar(50) NULL,
	qc_prn2 varchar(50) NULL,
	qc_name3 varchar(70) NULL,
	qc_relationship3 varchar(50) NULL,
	qc_prn3 varchar(50) NULL,
	qc_name4 varchar(70) NULL,
	qc_relationship4 varchar(50) NULL,
	qc_prn4 varchar(50) NULL,
	s1a varchar(35) NULL,
	s1b varchar(35) NULL,
	s1c varchar(50) NULL,
	s1d TIMESTAMP(3) NULL,
	s1e varchar(50) NULL,
	s1f_addr1 varchar(50) NULL,
	s1f_addr2 varchar(50) NULL,
	s1f_addr3 varchar(50) NULL,
	s1f_addr4 varchar(50) NULL,
	s1f_postcode varchar(50) NULL,
	s1g varchar(50) NULL,
	s1h varchar(50) NULL,
	s1i_yourself varchar(50) NULL,
	s1i_witness varchar(50) NULL,
	s1i_representative varchar(50) NULL,
	s1j varchar(50) NULL,
	s1j_who varchar(70) NULL,
	s1j_language varchar(50) NULL,
	s1j_dialect varchar(50) NULL,
	s1k varchar(1000) NULL,
	s1l varchar(50) NULL,
	s1m varchar(50) NULL,
	s1n TIMESTAMP(3) NULL,
	s1o varchar(50) NULL,
	s1p TIMESTAMP(3) NULL,
	s1q varchar(50) NULL,
	s2a varchar(50) NULL,
	s2b varchar(50) NULL,
	s2c varchar(50) NULL,
	s2d_post varchar(50) NULL,
	s2d_fax varchar(50) NULL,
	s2d_courier varchar(50) NULL,
	s2d_other varchar(50) NULL,
	s2e TIMESTAMP(3) NULL,
	s2f TIMESTAMP(0) NULL,
	s3a varchar(8000) NULL,
	s3b varchar(8000) NULL,
	s3c varchar(8000) NULL,
	s3d_1 varchar(8000) NULL,
	s3d_2 varchar(8000) NULL,
	s3d_3 varchar(8000) NULL,
	s3d_4 varchar(8000) NULL,
	s3d_5 varchar(8000) NULL,
	s3d_6 varchar(8000) NULL,
	s3d_7 varchar(8000) NULL,
	s3d_8 varchar(8000) NULL,
	s3d_additional varchar(8000) NULL,
	s3e varchar(8000) NULL,
	s3e_date1 TIMESTAMP(3) NULL,
	s3e_appealno1 varchar(50) NULL,
	s3e_date2 TIMESTAMP(3) NULL,
	s3e_appealno2 varchar(50) NULL,
	s3e_date3 TIMESTAMP(3) NULL,
	s3e_appealno3 varchar(50) NULL,
	s3f varchar(50) NULL,
	s4_signature varchar(50) NULL,
	s4_date TIMESTAMP(3) NULL,
	s5a varchar(500) NULL,
	s5b varchar(500) NULL,
	s5c_addr1 varchar(50) NULL,
	s5c_addr2 varchar(50) NULL,
	s5c_addr3 varchar(50) NULL,
	s5c_addr4 varchar(50) NULL,
	s5c_postcode varchar(50) NULL,
	s5d varchar(50) NULL,
	s5e varchar(50) NULL,
	s5f varchar(50) NULL,
	s5g varchar(50) NULL,
	s5h varchar(50) NULL,
	s5i varchar(50) NULL,
	s5j varchar(50) NULL,
	securitytoken varchar(50) NULL,
	s5b_other varchar(50) NULL,
	rep_sign varchar(50) NULL,
	s6a varchar(35) NULL,
	s6b varchar(35) NULL,
	s6c varchar(50) NULL,
	s6d_addr1 varchar(50) NULL,
	s6d_addr2 varchar(50) NULL,
	s6d_addr3 varchar(50) NULL,
	s6d_addr4 varchar(50) NULL,
	s6d_postcode varchar(50) NULL,
	s6e varchar(50) NULL,
	s6f varchar(50) NULL,
	s6_auth varchar(50) NULL,
	date_added TIMESTAMP(3) NULL,
	have_rep varchar(50) NULL,
	have_sponsor varchar(50) NULL,
	other_rep varchar(100) NULL,
	s4_declaration varchar(50) NULL,
	s2i TIMESTAMP(3) NULL,
	s1f_email varchar(250) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE dbo.IAFT7(
	ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
	hearing_type varchar(50) NULL,
	qa_sponsor varchar(50) NULL,
	qa_rep varchar(50) NULL,
	qa_witness varchar(50) NULL,
	qb_lsc varchar(50) NULL,
	qb_LAR varchar(50) NULL,
	family_member varchar(50) NULL,
	qc_name1 varchar(70) NULL,
	qc_relationship1 varchar(50) NULL,
	qc_prn1 varchar(50) NULL,
	qc_name2 varchar(70) NULL,
	qc_relationship2 varchar(50) NULL,
	qc_prn2 varchar(50) NULL,
	qc_name3 varchar(70) NULL,
	qc_relationship3 varchar(50) NULL,
	qc_prn3 varchar(50) NULL,
	qc_name4 varchar(70) NULL,
	qc_relationship4 varchar(50) NULL,
	qc_prn4 varchar(50) NULL,
	s1a varchar(50) NULL,
	s1b varchar(50) NULL,
	s1c varchar(50) NULL,
	s1d TIMESTAMP(3) NULL,
	s1e varchar(50) NULL,
	s1f_addr1 varchar(50) NULL,
	s1f_addr2 varchar(50) NULL,
	s1f_addr3 varchar(50) NULL,
	s1f_addr4 varchar(50) NULL,
	s1f_postcode varchar(50) NULL,
	s1g varchar(50) NULL,
	s1h varchar(50) NULL,
	s1i_yourself varchar(50) NULL,
	s1i_witness varchar(50) NULL,
	s1i_representative varchar(50) NULL,
	s1j varchar(50) NULL,
	s1j_who varchar(70) NULL,
	s1j_language varchar(50) NULL,
	s1j_dialect varchar(50) NULL,
	s1k varchar(1000) NULL,
	s1l varchar(50) NULL,
	s1m varchar(50) NULL,
	s1n TIMESTAMP(3) NULL,
	s1o varchar(50) NULL,
	s1p TIMESTAMP(3) NULL,
	s1q varchar(50) NULL,
	s2a varchar(50) NULL,
	s2b varchar(50) NULL,
	s2c varchar(50) NULL,
	s2d_post varchar(50) NULL,
	s2d_fax varchar(50) NULL,
	s2d_courier varchar(50) NULL,
	s2d_other varchar(50) NULL,
	s2e TIMESTAMP(3) NULL,
	s2f TIMESTAMP(3) NULL,
	s3a varchar(8000) NULL,
	s3b varchar(8000) NULL,
	s3c varchar(8000) NULL,
	s3d_1 varchar(8000) NULL,
	s3d_2 varchar(8000) NULL,
	s3d_3 varchar(8000) NULL,
	s3d_4 varchar(8000) NULL,
	s3d_5 varchar(8000) NULL,
	s3d_6 varchar(8000) NULL,
	s3d_7 varchar(8000) NULL,
	s3d_8 varchar(8000) NULL,
	s3d_additional varchar(8000) NULL,
	s3e varchar(8000) NULL,
	s3e_date1 TIMESTAMP(3) NULL,
	s3e_appealno1 varchar(50) NULL,
	s3e_date2 TIMESTAMP(3) NULL,
	s3e_appealno2 varchar(50) NULL,
	s3e_date3 TIMESTAMP(3) NULL,
	s3e_appealno3 varchar(50) NULL,
	s3f varchar(50) NULL,
	s4_signature varchar(50) NULL,
	s4_date TIMESTAMP(3) NULL,
	s5a varchar(500) NULL,
	s5b varchar(500) NULL,
	s5c_addr1 varchar(50) NULL,
	s5c_addr2 varchar(50) NULL,
	s5c_addr3 varchar(50) NULL,
	s5c_addr4 varchar(50) NULL,
	s5c_postcode varchar(50) NULL,
	s5d varchar(50) NULL,
	s5e varchar(50) NULL,
	s5f varchar(50) NULL,
	s5g varchar(50) NULL,
	s5h varchar(50) NULL,
	s5i varchar(50) NULL,
	s5j varchar(50) NULL,
	securitytoken varchar(50) NULL,
	s5b_other varchar(50) NULL,
	rep_sign varchar(50) NULL,
	date_added TIMESTAMP(0) NULL,
	s4_declaration varchar(50) NULL,
	s2i TIMESTAMP(3) NULL,
	s1f_email varchar(250) NULL,
	s2HOAN varchar(50) NULL,
	s2j TIMESTAMP(3) NULL,
	s2k varchar(50) NULL,
	s3g varchar(3000) NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE dbo.transaction_details(
	Id int GENERATED ALWAYS AS IDENTITY NOT NULL,
	transactionstatus varchar(50) DEFAULT 'Not Known' NULL,
	orderid varchar(50) NULL,
	type varchar(50) NULL,
	referencenumber varchar(50) NULL,
	sub_count int NULL,
	Aggr_URN varchar(50) NULL,
	dateofpayment TIMESTAMP(0) NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE dbo.URN(
	Id varchar(50) NULL
);

INSERT INTO dbo.fees (startdate, fees_paper, fees_oral)
VALUES (current_timestamp, '80', '140');

INSERT INTO dbo.URN (Id)
VALUES ('1');
