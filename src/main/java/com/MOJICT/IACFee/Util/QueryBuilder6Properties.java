/************************************************************
 * An MoJ WebTeam Product
 * IAC Fees CPI
 * 06-Dec-2011
 * Warning this software is not licensed for re-use outside
 * the MoJ estate.
 * Copyright 2011 - 2011
 ************************************************************/
package com.MOJICT.IACFee.Util;

// TODO: Auto-generated Javadoc
/**
 * The Interface QueryBuilder2Properties.
 */
public interface QueryBuilder6Properties {
	
	/** The sql_save2_1. */
	public String sql_save6_1="Insert into IAFT6(hearing_type,qa_sponsor,qa_rep,qa_witness,qb_lsc,qb_LAR,family_member,qc_name1,qc_relationship1,qc_prn1,qc_name2,qc_relationship2,qc_prn2,qc_name3,qc_relationship3,qc_prn3,qc_name4,qc_relationship4,qc_prn4,date_added,securitytoken) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	/** The sql_update2_1. */
	public String sql_update6_1="update IAFT6 set hearing_type=?,qa_sponsor=?,qa_rep=?,qa_witness=?,qb_lsc=?,qb_LAR=?,family_member=?,qc_name1=?,qc_relationship1=?,qc_prn1=?,qc_name2=?,qc_relationship2=?,qc_prn2=?,qc_name3=?,qc_relationship3=?,qc_prn3=?,qc_name4=?,qc_relationship4=?,qc_prn4=?,date_added=? where securitytoken=?";
	
	/** The sql_save_urn. */
	public String sql_save_urn="Insert into formsdata(securitytoken,submissionURN,paymentURN,AggregatedURN,formname,amount,formtitle) values (?,?,?,?,?,?,?)";
	
	/** The sql_update3_2urn. */
	public String sql_update6_2urn="update formsdata set SubmissionURN=?,paymentURN=?,amount=? where securitytoken=?";
	
	/** The sql_update1_urn. */
	public String sql_update1_urn="update formsdata set submissionURN=?,paymentURN=?,AggregatedURN=?,amount=?,formtitle=? where securitytoken=?";
	
	/** The sql_retrieve2_1. */
	public String sql_retrieve6_1="select * from IAFT6 where securitytoken=?";
	
	/** The sql_save2_2. */
	public String sql_save6_2="update IAFT6 set s1a=?,s1b=?,s1c=?,s1d=?,s1e=?,s1f_addr1=?,s1f_addr2=?,s1f_addr3=?,s1f_addr4=?,s1f_postcode=?,s1g=?,s1f_email=? where securitytoken=?";
	
	/** The sql_retrieve2_2. */
	public String sql_retrieve6_2="select s3d_2 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_33. */
	public String sql_retrieve6_33="select s3d_3 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_4. */
	public String sql_retrieve6_4="select s3d_4 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_5. */
	public String sql_retrieve6_5="select s3d_5 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_6. */
	public String sql_retrieve6_6="select s3d_6 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_7. */
	public String sql_retrieve6_7="select s3d_7 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_8. */
	public String sql_retrieve6_8="select s3d_8 from IAFT6 where securitytoken=?";
	
	/** The sql_retrieve2_9. */
	public String sql_retrieve6_9="select s3d_additional from IAFT6 where securitytoken=?";
	
	/** The sql_save2_3. */
	public String sql_save6_3="update IAFT6 set s2a=?,s2b=?,s2c=?,s2d_post=?,s2d_other=?,s2e=?,s2f=?,s2i=? where securitytoken=?";
	
	/** The sql_retrieve2_3. */
	public String sql_retrieve6_3="select s1a,s1b,s1c,s1d,s1e,s1f_addr1,s1f_addr2,s1f_addr3,s1f_addr4,s1f_postcode,s1g,s1h,s1i_yourself,s1i_witness,s1i_representative,s1j,s1j_who,s1j_language,s1j_dialect,s1k,s1l,s1m,s1n,s1o,s1p,s1q from IAFT6 where securitytoken=?";
	
	/** The sql_save2_4. */
	public String sql_save6_4="update IAFT6 set s3a=?,s3b=?,s3c=? where securitytoken=?";
	
	/** The sql_save2_5_1. */
	public String sql_save6_5_1="update IAFT6 set s3d_1=? where securitytoken=?";
	
	/** The sql_save2_5_2. */
	public String sql_save6_5_2="update IAFT6 set s3d_2=? where securitytoken=?";
	
	/** The sql_save2_5_3. */
	public String sql_save6_5_3="update IAFT6 set s3d_3=? where securitytoken=?";
	
	/** The sql_save2_5_4. */
	public String sql_save6_5_4="update IAFT6 set s3d_4=? where securitytoken=?";
	
	/** The sql_save2_5_5. */
	public String sql_save6_5_5="update IAFT6 set s3d_5=? where securitytoken=?";
	
	/** The sql_save2_5_6. */
	public String sql_save6_5_6="update IAFT6 set s3d_6=? where securitytoken=?";
	
	/** The sql_save2_5_7. */
	public String sql_save6_5_7="update IAFT6 set s3d_7=? where securitytoken=?";
	
	/** The sql_save2_5_8. */
	public String sql_save6_5_8="update IAFT6 set s3d_8=? where securitytoken=?";
	
	/** The sql_save2_5_9. */
	public String sql_save6_5_9="update IAFT6 set s3d_additional=? where securitytoken=?";
	
	/** The sql_urn_update. */
	public String sql_urn_update="update URN set Id=?";
	
	/** The sql_urn_get. */
	public String sql_urn_get="select * from URN";
	//public String sql_save2_6="update IAFT6 set s3d_4=?,s3d_5=?,s3d_6=?,s3d_7=? where securitytoken=?";
	/** The sql_save2_77. */
	public String sql_save6_77="update IAFT6 set s3d_8=?,s3d_additional=? where securitytoken=?";
	
	/** The sql_save2_6. */
	public String sql_save6_6="update IAFT6 set s1j_who=?,s1j_language=?,s1j_dialect=?,s1k=?,s3d_1=?,s3e=?,s3e_date1=?,s3e_appealno1=?,s3e_date2=?,s3e_appealno2=?,s3e_date3=?,s3e_appealno3=?,s3f=? where securitytoken=?";
	
	/** The sql_save2_8. */
	public String sql_save6_8="update IAFT6 set s6a=?,s6b=?,s6c=?,s6d_addr1=?,s6d_addr2=?,s6d_addr3=?,s6d_addr4=?,s6d_postcode=?,s6e=?,s6f=?,s6_auth=? where securitytoken=?";
	
	/** The sql_save2_9. */
	public String sql_save6_9="update IAFT6 set s4_signature=?,s4_date=? where securitytoken=?";
	
	/** The sql_save2_rep. */
	public String sql_save6_rep="update IAFT6 set have_rep=?,have_sponsor=?,s4_declaration=? where securitytoken=?";
	
	/** The sql_save2_7. */
	public String sql_save6_7="update IAFT6 set s5a=?,s5b=?,s5c_addr1=?,s5c_addr2=?,s5c_addr3=?,s5c_addr4=?,s5c_postcode=?,s5d=?,s5e=?,s5f=?,s5g=?,s5h=?,s5i=?,s5j=?,s5b_other=?,rep_sign=?,s4_declaration=? where securitytoken=?";
	
	/** The sql_retrieve_urn. */
	public String sql_retrieve_urn="select * from formsdata where securitytoken=?";
}
