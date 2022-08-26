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
 * The Interface QueryBuilder1Properties.
 */
public interface QueryBuilder7Properties {
	
	/** The sql_save1_1. */
	public String sql_save1_1 = "Insert into IAFT7(hearing_type,qa_sponsor,qa_rep,qa_witness,qb_lsc,qb_LAR,family_member,qc_name1,qc_relationship1,qc_prn1,qc_name2,qc_relationship2,qc_prn2,qc_name3,qc_relationship3,qc_prn3,qc_name4,qc_relationship4,qc_prn4,date_added,securitytoken) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	/** The sql_update1_1. */
	public String sql_update1_1 = "update IAFT7 set hearing_type=?,qa_sponsor=?,qa_rep=?,qa_witness=?,qb_lsc=?,qb_LAR=?,family_member=?,qc_name1=?,qc_relationship1=?,qc_prn1=?,qc_name2=?,qc_relationship2=?,qc_prn2=?,qc_name3=?,qc_relationship3=?,qc_prn3=?,qc_name4=?,qc_relationship4=?,qc_prn4=?,date_added=? where securitytoken=?";
	
	/** The sql_save_urn. */
	public String sql_save_urn = "Insert into formsdata(securitytoken,submissionURN,paymentURN,AggregatedURN,formname,amount,formtitle) values (?,?,?,?,?,?,?)";
	
	/** The sql_update_urn. */
	public String sql_update_urn = "update formsdata set submissionURN=?,paymentURN=?,AggregatedURN=? where securitytoken=?";
	/** The sql_update_urn. */
	public String sql_update_suburn = "update formsdata set submissionURN=?,paymentURN=? where securitytoken=?";
	
	/** The sql_update1_urn. */
	public String sql_update1_urn = "update formsdata set submissionURN=?,paymentURN=?,AggregatedURN=?,amount=?,formtitle=? where securitytoken=?";
	
	/** The sql_update3_urn. */
	public String sql_update3_urn = "update formsdata set submissionURN=?,paymentURN=?,amount=? where securitytoken=?";

	/** The sql_retrieve1_1. */
	public String sql_retrieve1_1 = "select * from IAFT7 where securitytoken=?";
	
	/** The sql_save1_2. */
	public String sql_save1_2 = "update IAFT7 set s1a=?,s1b=?,s1c=?,s1d=?,s1e=?,s1f_addr1=?,s1f_addr2=?,s1f_addr3=?,s1f_addr4=?,s1f_postcode=?,s1g=?,s1h=?,s1i_yourself=?,s1i_witness=?,s1i_representative=?,s1j=?,s1j_who=?,s1j_language=?,s1j_dialect=?,s1k=?,s1l=?,s1m=?,s1n=?,s1o=?,s1p=?,s1q=?,s1f_email=? where securitytoken=?";
	
	/** The sql_retrieve1_2. */
	public String sql_retrieve1_2 = "select s3d_2 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_33. */
	public String sql_retrieve1_33 = "select s3d_3 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_4. */
	public String sql_retrieve1_4 = "select s3d_4 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_5. */
	public String sql_retrieve1_5 = "select s3d_5 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_6. */
	public String sql_retrieve1_6 = "select s3d_6 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_7. */
	public String sql_retrieve1_7 = "select s3d_7 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_8. */
	public String sql_retrieve1_8 = "select s3d_8 from IAFT7 where securitytoken=?";
	
	/** The sql_retrieve1_9. */
	public String sql_retrieve1_9 = "select s3d_additional from IAFT7 where securitytoken=?";

	/** The sql_save1_3. */
	public String sql_save1_3 = "update IAFT7 set s2a=?,s2b=?,s2c=?,s2d_post=?,s2d_other=?,s2e=?,s2f=?,s2i=?,s2HOAN=?,s2j=?,s2k=? where securitytoken=?";
	
	/** The sql_retrieve1_3. */
	public String sql_retrieve1_3 = "select s1a,s1b,s1c,s1d,s1e,s1f_addr1,s1f_addr2,s1f_addr3,s1f_addr4,s1f_postcode,s1g,s1h,s1i_yourself,s1i_witness,s1i_representative,s1j,s1j_who,s1j_language,s1j_dialect,s1k,s1l,s1m,s1n,s1o,s1p,s1q from IAFT7 where securitytoken=?";
	
	/** The sql_save1_4. */
	public String sql_save1_4 = "update IAFT7 set s3a=?,s3b=?,s3c=? where securitytoken=?";
	
	/** The sql_save1_5_1. */
	public String sql_save1_5_1 = "update IAFT7 set s3d_1=? where securitytoken=?";
	
	/** The sql_save1_5_2. */
	public String sql_save1_5_2 = "update IAFT7 set s3d_2=? where securitytoken=?";
	
	/** The sql_save1_5_3. */
	public String sql_save1_5_3 = "update IAFT7 set s3d_3=? where securitytoken=?";
	
	/** The sql_save1_5_4. */
	public String sql_save1_5_4 = "update IAFT7 set s3d_4=? where securitytoken=?";
	
	/** The sql_save1_5_5. */
	public String sql_save1_5_5 = "update IAFT7 set s3d_5=? where securitytoken=?";
	
	/** The sql_save1_5_6. */
	public String sql_save1_5_6 = "update IAFT7 set s3d_6=? where securitytoken=?";
	
	/** The sql_save1_5_7. */
	public String sql_save1_5_7 = "update IAFT7 set s3d_7=? where securitytoken=?";
	
	/** The sql_save1_5_8. */
	public String sql_save1_5_8 = "update IAFT7 set s3d_8=? where securitytoken=?";
	
	/** The sql_save1_5_9. */
	public String sql_save1_5_9 = "update IAFT7 set s3d_additional=? where securitytoken=?";

	/** The sql_urn_update. */
	public String sql_urn_update = "update URN set Id=?";
	
	/** The sql_urn_get. */
	public String sql_urn_get = "select * from URN";
	
	/** The sql_save1_8. */
	public String sql_save1_8 = "update IAFT7 set s3e=?,s3e_date1=?,s3e_appealno1=?,s3e_date2=?,s3e_appealno2=?,s3e_date3=?,s3e_appealno3=?,s3g=? where securitytoken=?";
	
	/** The sql_save1_9. */
	public String sql_save1_9 = "update IAFT7 set s4_signature=?,s4_date=?,s4_declaration=? where securitytoken=?";
	
	/** The sql_save1_10. */
	public String sql_save1_10 = "update IAFT7 set s5a=?,s5b=?,s5c_addr1=?,s5c_addr2=?,s5c_addr3=?,s5c_addr4=?,s5c_postcode=?,s5d=?,s5e=?,s5f=?,s5g=?,s5h=?,s5i=?,s5j=?,s5b_other=?,rep_sign=?,s4_declaration=? where securitytoken=?";
	
	/** The sql_retrieve_urn. */
	public String sql_retrieve_urn = "select * from formsdata where securitytoken=?";
	
	/** The sql_retrieve_aggrurn. */
	public String sql_retrieve_aggrurn = "select * from formsdata where AggregatedURN=?  order by Id";
	
	public String sql_retrieve_aggrurn1 = "select * from formsdata where AggregatedURN=? or paymentURN=? order by Id";
	/** The sql_retrieve. */
	public String sql_retrieve = "select * from formsdata where paymentURN=? or AggregatedURN=? ";
	

	public String sql_retrieve_both="select * from formsdata where AggregatedURN=? or securitytoken=? or paymentURN=?";
	
	
	public String sql_delete_token = "update formsdata set status=? where securitytoken=?";
}
