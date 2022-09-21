package com.MOJICT.IACFee.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.MOJICT.IACFee.Beans.*;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.log4j.Logger;
import org.jdom.Namespace;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.MOJICT.IACFee.Beans.*;

/**
 * Make up and write an XML document, using DOM UPDATED FOR JAXP.
 *
 * @author Ian Darwin, http://www.darwinsys.com/
 * @version $Id: DocWriteDOM.java,v 1.6 2004/03/01 03:42:57 ian Exp $
 */
public class DocWriteDOM {
	/**
	 * log4j logging solution
	 */
	static Logger logger = Logger.getLogger(DocWriteDOM.class);

	public String title = "";

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	protected SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

	protected Namespace nm1 = Namespace.getNamespace("http://www.justice.gov.uk/IACFEES");
	protected Namespace nm2 = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

	/**
	 *
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *
	 * @param doc
	 * @param req
	 * @param urn
	 */
	public static void writetofile(Document doc, HttpServletRequest req, String urn) {

		String fileName = urn + ".xml";

		try {
            logger.debug("in writetofile");
			XMLOutputter outputter = new XMLOutputter();
            logger.debug("after XMLOutputer");
			outputter.getFormat().setEncoding("UTF-8"); //Version 1.13
			//outputter.setEncoding("UTF-8"); // Version 1.0
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			outputter.output(doc, baos);

			if (CPIBean.getSTORAGE_METHOD().equals("S3")) {
				try {
					S3Storage S3Storage = new S3Storage();
					S3Storage.uploadToS3(new ByteArrayEntity(baos.toByteArray()), fileName, "upload-pdf-test");
				} catch (Exception ex) {
					logger.error("DocWriteDOM.writetofile - S3 Upload", ex);
				}
			} else {
					LocalFileStorage localFileStorage = new LocalFileStorage();
					localFileStorage.saveXMLToLocalStorage(baos, req, urn);
			}
		} catch (IOException e) {
			logger.error("DocWriteDOM.writetofile", e);
		}

	}

	/**
	 *
	 * @param frm
	 * @param req
	 * @param URN
	 * @return
	 * @throws IOException
	 */
	public static String getxmlnewappeal(IAFT3Bean frm, HttpServletRequest req, String URN) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocNewAppeal(frm);
		DocWriteDOM.writetofile(doc, req, frm.getSubmissionURN());
		return "success";
	}

	public static String getxmlnewappeal(IAFT5Bean frm, HttpServletRequest req, String URN) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocNewAppeal(frm);
		DocWriteDOM.writetofile(doc, req, frm.getSubmissionURN());
		return "success";
	}
	public static String getxmlnewappeal(IAFT6Bean frm, HttpServletRequest req, String URN) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocNewAppeal(frm);
		DocWriteDOM.writetofile(doc, req, frm.getSubmissionURN());
		return "success";
	}
	public static String getxmlnewappeal(IAFT7Bean frm, HttpServletRequest req, String URN) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocNewAppeal(frm);
		DocWriteDOM.writetofile(doc, req, frm.getSubmissionURN());
		return "success";
	}

	/**
	 *
	 * @param frm
	 * @param req
	 * @param URN
	 * @return
	 * @throws IOException
	 */
	public static String getxmlnewappeal(IAFT1Bean frm, HttpServletRequest req, String URN) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocNewAppeal(frm);
		logger.debug("Calling XML method");
		DocWriteDOM.writetofile(doc, req, frm.getSubmissionURN());
		return "success";
	}

	/**
	 *
	 * @param frm
	 * @param req
	 * @param URN
	 * @return
	 * @throws IOException
	 */
	public static String getxmlnewappeal(IAFT2Bean frm, HttpServletRequest req, String URN) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocNewAppeal(frm);
		DocWriteDOM.writetofile(doc, req, frm.getSubmissionURN());
		return "success";
	}

	/**
	 *
	 * @param frm
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public static String getxmlAggregatedpayment(AggregatedBean frm, HttpServletRequest req) throws IOException {
		DocWriteDOM dw = new DocWriteDOM();
		Document doc = dw.makeDocAggregatedpayment(frm);
		logger.debug("The order id is" + frm.getOid());
		if (frm.getAggregatedpaymentURN() != null)
			DocWriteDOM.writetofile(doc, req, frm.getAggregatedpaymentURN());
		else
			DocWriteDOM.writetofile(doc, req, frm.getOid());

		return "success";
	}

	/**
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocNewAppeal(IAFT3Bean frm) {
		Document doc = new Document();
		try {
			Element root = getElementWithDefaultNamespace("NewAppeal");
			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);
			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("NEW APPEAL");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("IAFT-3");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("IAFT-3");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);

			Element naa = getElementWithDefaultNamespace("NewAppealApplications");
			root.addContent(naa);

			Element AAIC = getElementWithDefaultNamespace("AppealAgainstHomeOfficeDecision");
			naa.addContent(AAIC);

			Element ApplicationDetails = getElementWithDefaultNamespace("ApplicationDetails");
			// ApplicationDetails.addContent("1.0");
			AAIC.addContent(ApplicationDetails);

			Attribute AppealType = new Attribute("AppealType", "IAFT-3");
			ApplicationDetails.setAttribute(AppealType);

			Element SubmissionDate = getElementWithDefaultNamespace("SubmissionDate");
			SubmissionDate.addContent(sdf.format(new Date()));
			ApplicationDetails.addContent(SubmissionDate);

			Element SubmissionURN = getElementWithDefaultNamespace("SubmissionURN");
			SubmissionURN.addContent(frm.getSubmissionURN());
			ApplicationDetails.addContent(SubmissionURN);

			Element PaymentRemissionRequested = getElementWithDefaultNamespace("PaymentRemissionRequested");
			PaymentRemissionRequested.addContent("no");
			ApplicationDetails.addContent(PaymentRemissionRequested);

			if (frm.getQb_lsc() != null) {
				if (frm.getQb_lsc().equals("LSC")||frm.getQb_lsc().equals("Yes")) {

					// LegalAId
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Element LegalAidReferenceNumber = getElementWithDefaultNamespace("LegalAidReferenceNumber");
					LegalAidReferenceNumber.addContent(frm.getQb_LAR());
					LegalAid.addContent(LegalAidReferenceNumber);

					Attribute LSF = new Attribute("LegalAid", "yes");

					LegalAid.setAttribute(LSF);

				} else {
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Attribute LSF = new Attribute("LegalAid", "no");

					LegalAid.setAttribute(LSF);

				}
			}
			Element HearingType = getElementWithDefaultNamespace("HearingType");
			if (frm.getAppeal_type().equals("Oral")) {
				HearingType.addContent("oral");
			} else {
				HearingType.addContent("paper");
			}
			ApplicationDetails.addContent(HearingType);

			// Payment details
			if (frm.getAggregatedpaymentURN() != null && frm.getQb_lsc().equals("No") && frm.getPaymentvalue() != 0) {

				Element PaymentDetails = getElementWithDefaultNamespace("PaymentDetails");
				// LegalAid.addContent("No");
				AAIC.addContent(PaymentDetails);

				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				PaymentDetails.addContent(AggregatedPaymentURN);
			}

			/*
			 * <AppellantDetails> <FamilyName>string</FamilyName>
			 * <GivenName>string</GivenName> <Title>string</Title> <Address>
			 * <Line>string</Line> <Country /> <PostCode /> </Address>
			 * </AppellantDetails>
			 */

			// Appellant Details

			Element AppellantDetails = getElementWithDefaultNamespace("AppellantDetails");
			// LegalAid.addContent("No");
			AAIC.addContent(AppellantDetails);

			Element FamilyName = getElementWithDefaultNamespace("FamilyName");
			FamilyName.addContent(frm.getS1a());
			AppellantDetails.addContent(FamilyName);

			Element GivenName = getElementWithDefaultNamespace("GivenName");
			GivenName.addContent(frm.getS1b());
			AppellantDetails.addContent(GivenName);

			Element Title = getElementWithDefaultNamespace("Title");
			Title.addContent(frm.getS1c());
			AppellantDetails.addContent(Title);

			Element Address = getElementWithDefaultNamespace("Address");
			// LegalAid.addContent("No");
			AppellantDetails.addContent(Address);
			try {
				if (!frm.getS1f_addr1().equals("") && frm.getS1f_addr1() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr1());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				if (!frm.getS1f_addr2().equals("") && frm.getS1f_addr2() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr2());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				// logger.debug("???"+frm.getS1f_addr3().trim().equals("")+"??");
				if (!frm.getS1f_addr3().equals("") && frm.getS1f_addr3() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr3());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}

			/*
			 * if(frm.getS1f_addr4()!=" " || frm.getS1f_addr4()!=null) { Element
			 * Line= getElementWithDefaultNamespace("Line");
			 * Line.addContent(frm.getS1f_addr4()); Address.addContent(Line);
			 *
			 * }
			 */
			try {
				if (!frm.getS1f_addr4().equals("") && frm.getS1f_addr4() != null) {
					Element Country = getElementWithDefaultNamespace("Country");
					Country.addContent(Helper.returnIntegerValue(frm.getS1f_addr4()));
					Address.addContent(Country);
				}
			} catch (Exception e) {

			}
			Element PostCode = getElementWithDefaultNamespace("PostCode");
			PostCode.addContent(frm.getS1f_postcode());
			Address.addContent(PostCode);



			if (!frm.getS1f_email().equals("") && frm.getS1f_email() != null) {
			Element email = getElementWithDefaultNamespace("Email");
			// LegalAid.addContent("No");
			email.addContent(frm.getS1f_email());
			AppellantDetails.addContent(email);
			}


			Element DateOfBirth = getElementWithDefaultNamespace("DateOfBirth");
			// logger.debug(">>.............."+sdf.format(sdf.parse(frm.getS1d_dob_year()+"-"+frm.getS1d_dob_month()+"-"+frm.getS1d_dob_day())));
			DateOfBirth.addContent(sdf.format(sdf.parse(frm.getS1d_dob_year() + "-" + frm.getS1d_dob_month() + "-"
					+ frm.getS1d_dob_day())));
			AAIC.addContent(DateOfBirth);

			Element Nationality = getElementWithDefaultNamespace("Nationality");
			Nationality.addContent(Helper.returnIntegerValue(frm.getS1g()));
			AAIC.addContent(Nationality);

			Element Interpreter = getElementWithDefaultNamespace("Interpreter");
			if (frm.getS1j().equals("Yes")) {
				Interpreter.addContent("yes");
			} else {
				Interpreter.addContent("no");

			}
			AAIC.addContent(Interpreter);

			// Element DetainedReferenceNumber = new
			// Element("PrisonReferenceNumber");
			// DetainedReferenceNumber.addContent(frm.getS1g());
			// Detained.addContent(DetainedReferenceNumber);

			// Home Office Details

			/*
			 * <HomeOfficeDecision> <HomeOfficeRefNo>string</HomeOfficeRefNo>
			 * <PortReferenceNo>string</PortReferenceNo>
			 * <COHIDRefNo>string</COHIDRefNo>
			 * <PointsBasedRefusal>no</PointsBasedRefusal>
			 * <DateOfApplicationDecision>2006-12-20</DateOfApplicationDecision>
			 * </HomeOfficeDecision>
			 */

			Element HomeOfficeDecision = getElementWithDefaultNamespace("HomeOfficeDecision");
			// LegalAid.addContent("No");
			AAIC.addContent(HomeOfficeDecision);
			if(frm.getS2a().length()>1)
            {

			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeRefNo");
			HomeOfficeRefNo.addContent(frm.getS2a());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }
			Element PortReferenceNo = getElementWithDefaultNamespace("PortReferenceNo");
			PortReferenceNo.addContent(frm.getS2b());
			HomeOfficeDecision.addContent(PortReferenceNo);
			if(frm.getS2c().length()>1)
            {

			Element COHIDRefNo = getElementWithDefaultNamespace("COHIDRefNo");
			COHIDRefNo.addContent(frm.getS2c());
			HomeOfficeDecision.addContent(COHIDRefNo);
            }
			Element PointsBasedRefusal = getElementWithDefaultNamespace("PointsBasedRefusal");
			PointsBasedRefusal.addContent("no");
			HomeOfficeDecision.addContent(PointsBasedRefusal);

			Element DateOfApplicationDecision = getElementWithDefaultNamespace("DateOfApplicationDecision");
			DateOfApplicationDecision.addContent(sdf.format(sdf.parse(frm.getS2e_service_year() + "-"
					+ frm.getS2e_service_month() + "-" + frm.getS2e_service_day())));
			HomeOfficeDecision.addContent(DateOfApplicationDecision);

			// Appeal

			Element Appeal = getElementWithDefaultNamespace("Appeal");
			// LegalAid.addContent("No");
			AAIC.addContent(Appeal);
	//*********************************Late Appeal Removed.

			/*Element LateAppeal = getElementWithDefaultNamespace("LateAppeal");
			if (frm.getS3a() != null) {
				if (frm.getS3a().length() >= 2) {
					LateAppeal.addContent("yes");
				} else {
					LateAppeal.addContent("no");
				}

			}

			else {
				LateAppeal.addContent("no");
			}

			Appeal.addContent(LateAppeal);
             */

			Element AdditionalDocuments = getElementWithDefaultNamespace("AdditionalDocuments");
			if (frm.getS3b() != null && frm.getS3b().length() >= 2) {
				AdditionalDocuments.addContent("yes");
			} else {
				AdditionalDocuments.addContent("no");

			}
			Appeal.addContent(AdditionalDocuments);

			Element AdditionalDocumentsLater = getElementWithDefaultNamespace("AdditionalDocumentsLater");
			if (frm.getS3c() != null && frm.getS3c().length() >= 2) {
				AdditionalDocumentsLater.addContent("yes");
			} else {
				AdditionalDocumentsLater.addContent("no");

			}

			Appeal.addContent(AdditionalDocumentsLater);

			// Representative details
			/*
			 * <Representative> <RepresentativeName>string</RepresentativeName>
			 * <RepresentativeOrganisation>string</RepresentativeOrganisation> -
			 * <RepresentativeAddress> <Line>string</Line> <Country /> <PostCode
			 * /> </RepresentativeAddress>
			 * <RepresentativeReference>string</RepresentativeReference> -
			 * <RepresentativeContactDetails> <PhoneNumber>string</PhoneNumber>
			 * <MobileNumber>string</MobileNumber> <FaxNumber>string</FaxNumber>
			 * <EmailAddress>string</EmailAddress>
			 * </RepresentativeContactDetails>
			 * <LSCCommission>string</LSCCommission> </Representative>
			 */
			// logger.debug((frm.getS5a()!=null &&
			// !frm.getS5a().trim().equals(""))+">>>>>>>"+(frm.getS5b()!=null &&
			// !frm.getS5b().trim().equals("0")));
			if ((frm.getS5a() != null && !frm.getS5a().trim().equals(""))
					|| (frm.getS5b() != null && !frm.getS5b().trim().equals("0"))) {
				Element Representative = getElementWithDefaultNamespace("Representative");
				// LegalAid.addContent("No");
				AAIC.addContent(Representative);

				if (frm.getS5b().equals("00")&&frm.getS5b_other()!=null &&!frm.getS5b_other().equals("")) {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5b_other());
					Representative.addContent(RepresentativeName);
				}
				else if (!frm.getS5b().equals("0")&&!frm.getS5b().equals("00")) {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(Helper.returnIntegerValue(frm.getS5b()));
					Representative.addContent(RepresentativeName);

				}
				else{

					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5a());
					Representative.addContent(RepresentativeName);
				}

				Element RAddress = getElementWithDefaultNamespace("RepresentativeAddress");
				// LegalAid.addContent("No");
				Representative.addContent(RAddress);
				try {
					if (!frm.getS5c_addr1().trim().equals("") && frm.getS5c_addr1() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr1());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr2().trim().equals("") && frm.getS5c_addr2() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr2());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr3().trim().equals("") && frm.getS5c_addr3() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr3());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS1f_addr4().trim().equals("") && frm.getS1f_addr4() != null) {
						Element Country = getElementWithDefaultNamespace("Country");
						Country.addContent(Helper.returnIntegerValue(frm.getS5c_addr4()));
						RAddress.addContent(Country);
					}
				} catch (Exception e) {

				}

				Element RPostCode = getElementWithDefaultNamespace("PostCode");
				RPostCode.addContent(frm.getS5c_postcode());
				RAddress.addContent(RPostCode);

				Element RepresentativeReference = getElementWithDefaultNamespace("RepresentativeReference");
				RepresentativeReference.addContent(frm.getS5d());
				Representative.addContent(RepresentativeReference);

				Element RContact = getElementWithDefaultNamespace("RepresentativeContactDetails");
				// LegalAid.addContent("No");
				Representative.addContent(RContact);
				if (!frm.getS5e().trim().equals("") && frm.getS5e() != null) {
					Element PhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
					PhoneNumber.addContent(frm.getS5e());
					RContact.addContent(PhoneNumber);
				}
				if (!frm.getS5f().trim().equals("") && frm.getS5f() != null) {
					Element MobileNumber = getElementWithDefaultNamespace("MobileNumber");
					MobileNumber.addContent(frm.getS5f());
					RContact.addContent(MobileNumber);
				}
				if (!frm.getS5g().trim().equals("") && frm.getS5g() != null) {
					Element FaxNumber = getElementWithDefaultNamespace("FaxNumber");
					FaxNumber.addContent(frm.getS5g());
					RContact.addContent(FaxNumber);
				}
				if (!frm.getS5h().trim().equals("") && frm.getS5h() != null) {
					Element Email = getElementWithDefaultNamespace("EmailAddress");
					Email.addContent(frm.getS5h());
					RContact.addContent(Email);
				}
				if (!frm.getS5j().trim().equals("0") && frm.getS5j() != null) {
					Element LSCCommission = getElementWithDefaultNamespace("LSCCommission");
					LSCCommission.addContent(frm.getS5j());
					Representative.addContent(LSCCommission);
				}

			}
			root.addNamespaceDeclaration(nm2);
			doc.setRootElement(root);

			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocNewAppeal", ex);
		}
		return doc;
	}

	/**IAFT6
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocNewAppeal(IAFT6Bean frm) {
		Document doc = new Document();
		try {
			Element root = getElementWithDefaultNamespace("NewAppeal");

			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);
			// root.appendChild(title);
			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("NEW APPEAL");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("IAFT-6");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("IAFT-6");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			// logger.debug(sdf.format(new Date()));
			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);

			Element naa = getElementWithDefaultNamespace("NewAppealApplications");
			root.addContent(naa);

			Element AAIC = getElementWithDefaultNamespace("AppealAgainstEntryClearanceOfficerDecision");
			naa.addContent(AAIC);

			// Childrens Act

			Element ApplicationDetails = getElementWithDefaultNamespace("ApplicationDetails");

			// ApplicationDetails.addContent("1.0");
			AAIC.addContent(ApplicationDetails);
			Attribute AppealType = new Attribute("AppealType", "IAFT-6");
			ApplicationDetails.setAttribute(AppealType);

			Element SubmissionDate = getElementWithDefaultNamespace("SubmissionDate");
			SubmissionDate.addContent(sdf.format(new Date()));
			ApplicationDetails.addContent(SubmissionDate);

			Element SubmissionURN = getElementWithDefaultNamespace("SubmissionURN");
			SubmissionURN.addContent(frm.getSubmissionURN());
			ApplicationDetails.addContent(SubmissionURN);

			Element PaymentRemissionRequested = getElementWithDefaultNamespace("PaymentRemissionRequested");
			PaymentRemissionRequested.addContent("no");
			ApplicationDetails.addContent(PaymentRemissionRequested);

			if (frm.getQb_lsc() != null) {
				if (frm.getQb_lsc().equals("Yes")) {

					// LegalAId
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Element LegalAidReferenceNumber = getElementWithDefaultNamespace("LegalAidReferenceNumber");
					LegalAidReferenceNumber.addContent(frm.getQb_LAR());
					LegalAid.addContent(LegalAidReferenceNumber);

					Attribute LSF = new Attribute("LegalAid", "yes");

					LegalAid.setAttribute(LSF);

					// asylum support

				} else {
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Attribute LSF = new Attribute("LegalAid", "no");

					LegalAid.setAttribute(LSF);

				}
			}
			Element HearingType = getElementWithDefaultNamespace("HearingType");
			if (frm.getAppeal_type().equals("Oral")) {
				HearingType.addContent("oral");
			} else {
				HearingType.addContent("paper");
			}
			ApplicationDetails.addContent(HearingType);

			// Payment details
			if (frm.getAggregatedpaymentURN() != null && !frm.getQb_lsc().equals("Yes") && frm.getPaymentvalue() != 0) {
				Element PaymentDetails = getElementWithDefaultNamespace("PaymentDetails");
				// LegalAid.addContent("No");
				AAIC.addContent(PaymentDetails);

				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				PaymentDetails.addContent(AggregatedPaymentURN);

			}
			/*
			 * <AppellantDetails> <FamilyName>string</FamilyName>
			 * <GivenName>string</GivenName> <Title>string</Title> <Address>
			 * <Line>string</Line> <Country /> <PostCode /> </Address>
			 * </AppellantDetails>
			 */

			// Appellant Details

			Element AppellantDetails = getElementWithDefaultNamespace("AppellantDetails");
			// LegalAid.addContent("No");
			AAIC.addContent(AppellantDetails);

			Element FamilyName = getElementWithDefaultNamespace("FamilyName");
			FamilyName.addContent(frm.getS1a());
			AppellantDetails.addContent(FamilyName);

			Element GivenName = getElementWithDefaultNamespace("GivenName");
			GivenName.addContent(frm.getS1b());
			AppellantDetails.addContent(GivenName);

			Element Title = getElementWithDefaultNamespace("Title");
			Title.addContent(frm.getS1c());
			AppellantDetails.addContent(Title);

			Element Address = getElementWithDefaultNamespace("Address");
			// LegalAid.addContent("No");
			AppellantDetails.addContent(Address);

			if (!frm.getS1f_addr1().equals("") && frm.getS1f_addr1() != null) {
				Element Line = getElementWithDefaultNamespace("Line");
				Line.addContent(frm.getS1f_addr1());
				Address.addContent(Line);

			}

			if (!frm.getS1f_addr2().equals("") && frm.getS1f_addr2() != null) {
				Element Line = getElementWithDefaultNamespace("Line");
				Line.addContent(frm.getS1f_addr2());
				Address.addContent(Line);

			}

			if (!frm.getS1f_addr3().equals("") && frm.getS1f_addr3() != null) {
				Element Line = getElementWithDefaultNamespace("Line");
				Line.addContent(frm.getS1f_addr3());
				Address.addContent(Line);

			}

			if (!frm.getS1f_addr4().equals("") && frm.getS1f_addr4() != null) {
				Element Country = getElementWithDefaultNamespace("Country");
				Country.addContent(Helper.returnIntegerValue(frm.getS1f_addr4()));
				Address.addContent(Country);
			}

			Element PostCode = getElementWithDefaultNamespace("PostCode");
			PostCode.addContent(frm.getS1f_postcode());
			Address.addContent(PostCode);


			if (!frm.getS1f_email().equals("") && frm.getS1f_email() != null) {
			Element email = getElementWithDefaultNamespace("Email");
			// LegalAid.addContent("No");
			email.addContent(frm.getS1f_email());
			AppellantDetails.addContent(email);
			}


			Element DateOfBirth = getElementWithDefaultNamespace("DateOfBirth");
			DateOfBirth.addContent(sdf.format(sdf.parse(frm.getS1d_dob_year() + "-" + frm.getS1d_dob_month() + "-"
					+ frm.getS1d_dob_day())));
			AAIC.addContent(DateOfBirth);

			Element Nationality = getElementWithDefaultNamespace("Nationality");
			Nationality.addContent(Helper.returnIntegerValue(frm.getS1g()));
			AAIC.addContent(Nationality);

			// Element DetainedReferenceNumber = new
			// Element("PrisonReferenceNumber");
			// DetainedReferenceNumber.addContent(frm.getS1g());
			// Detained.addContent(DetainedReferenceNumber);

			// Home Office Details

			/*
			 * <HomeOfficeDecision> <HomeOfficeRefNo>string</HomeOfficeRefNo>
			 * <PortReferenceNo>string</PortReferenceNo>
			 * <COHIDRefNo>string</COHIDRefNo>
			 * <PointsBasedRefusal>no</PointsBasedRefusal>
			 * <DateOfApplicationDecision>2006-12-20</DateOfApplicationDecision>
			 * </HomeOfficeDecision>
			 */

			Element HomeOfficeDecision = getElementWithDefaultNamespace("ECODecision");
			// LegalAid.addContent("No");
			AAIC.addContent(HomeOfficeDecision);

			Element PointsBasedRefusal = getElementWithDefaultNamespace("PointsBasedRefusal");
			if (frm.getS2a().equals("No")) {
				PointsBasedRefusal.addContent("no");
			} else {
				PointsBasedRefusal.addContent("yes");
			}
			HomeOfficeDecision.addContent(PointsBasedRefusal);

			Element PortReferenceNo = getElementWithDefaultNamespace("PostReferenceNo");
			PortReferenceNo.addContent(frm.getS2b());
			HomeOfficeDecision.addContent(PortReferenceNo);

			if(frm.getS2a().length()>1)
            {
			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeANRefNo");
			HomeOfficeRefNo.addContent(frm.getS2a());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }

			Element PostLocation = getElementWithDefaultNamespace("PostLocation");
			PostLocation.addContent(Helper.returnIntegerValue(frm.getS2c()));
			HomeOfficeDecision.addContent(PostLocation);

			Element DateOfApplicationDecision = getElementWithDefaultNamespace("DateOfApplicationDecision");
			DateOfApplicationDecision.addContent(sdf.format(sdf.parse(frm.getS2f_year() + "-" + frm.getS2f_month()
					+ "-" + frm.getS2f_day())));
			HomeOfficeDecision.addContent(DateOfApplicationDecision);
			Element DateApplicationLodged = getElementWithDefaultNamespace("DateApplicationLodged");
			DateApplicationLodged.addContent(sdf.format(sdf.parse(frm.getS2i_year() + "-" + frm.getS2i_month()
					+ "-" + frm.getS2i_day())));
			HomeOfficeDecision.addContent(DateApplicationLodged);

			// Appeal

			Element Appeal = getElementWithDefaultNamespace("Appeal");
			// LegalAid.addContent("No");
			AAIC.addContent(Appeal);
	//*********************************Late Appeal Removed.

			/*Element LateAppeal = getElementWithDefaultNamespace("LateAppeal");
			if (frm.getS3a() != null) {
				if (frm.getS3a().length() >= 2) {
					LateAppeal.addContent("yes");
				} else {
					LateAppeal.addContent("no");
				}

			}

			else {
				LateAppeal.addContent("no");
			}

			Appeal.addContent(LateAppeal);
             */
			Element AdditionalDocuments = getElementWithDefaultNamespace("AdditionalDocuments");
			if (frm.getS3b() != null && frm.getS3b().length() >= 2) {
				AdditionalDocuments.addContent("yes");
			} else {
				AdditionalDocuments.addContent("no");

			}
			Appeal.addContent(AdditionalDocuments);

			Element AdditionalDocumentsLater = getElementWithDefaultNamespace("AdditionalDocumentsLater");
			if (frm.getS3c() != null && frm.getS3c().length() >= 2) {
				AdditionalDocumentsLater.addContent("yes");
			} else {
				AdditionalDocumentsLater.addContent("no");

			}

			Appeal.addContent(AdditionalDocumentsLater);

			// Representative details
			/*
			 * <Representative> <RepresentativeName>string</RepresentativeName>
			 * <RepresentativeOrganisation>string</RepresentativeOrganisation> -
			 * <RepresentativeAddress> <Line>string</Line> <Country /> <PostCode
			 * /> </RepresentativeAddress>
			 * <RepresentativeReference>string</RepresentativeReference> -
			 * <RepresentativeContactDetails> <PhoneNumber>string</PhoneNumber>
			 * <MobileNumber>string</MobileNumber> <FaxNumber>string</FaxNumber>
			 * <EmailAddress>string</EmailAddress>
			 * </RepresentativeContactDetails>
			 * <LSCCommission>string</LSCCommission> </Representative>
			 */
			if ((frm.getS5a() != null && !frm.getS5a().trim().equals(""))
					|| (frm.getS5b() != null && !frm.getS5b().trim().equals("0"))) {
				Element Representative = getElementWithDefaultNamespace("Representative");
				// LegalAid.addContent("No");
				AAIC.addContent(Representative);


				if (frm.getS5b().equals("00")&&frm.getS5b_other()!=null &&!frm.getS5b_other().equals("")) {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5b_other());
					Representative.addContent(RepresentativeName);
				}

				else if (!frm.getS5b().equals("0")&&!frm.getS5b().equals("00")) {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(Helper.returnIntegerValue(frm.getS5b()));
					Representative.addContent(RepresentativeName);
				}
				else {

					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5a());
					Representative.addContent(RepresentativeName);
				}
				Element RAddress = getElementWithDefaultNamespace("RepresentativeAddress");
				// LegalAid.addContent("No");
				Representative.addContent(RAddress);
				if (!frm.getS5c_addr1().trim().equals("") && frm.getS5c_addr1() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS5c_addr1());
					RAddress.addContent(RLine);
				}

				if (!frm.getS5c_addr2().trim().equals("") && frm.getS5c_addr2() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS5c_addr2());
					RAddress.addContent(RLine);
				}

				if (!frm.getS5c_addr3().trim().equals("") && frm.getS5c_addr3() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS5c_addr3());
					RAddress.addContent(RLine);
				}

				if (!frm.getS5c_addr4().trim().equals("") && frm.getS5c_addr4() != null) {
					Element RCountry = getElementWithDefaultNamespace("Country");
					RCountry.addContent(Helper.returnIntegerValue(frm.getS5c_addr4()));
					RAddress.addContent(RCountry);
				}

				Element RPostCode = getElementWithDefaultNamespace("PostCode");
				RPostCode.addContent(frm.getS5c_postcode());
				RAddress.addContent(RPostCode);

				Element RepresentativeReference = getElementWithDefaultNamespace("RepresentativeReference");
				RepresentativeReference.addContent(frm.getS5d());
				Representative.addContent(RepresentativeReference);

				Element RContact = getElementWithDefaultNamespace("RepresentativeContactDetails");
				// LegalAid.addContent("No");
				Representative.addContent(RContact);

				if (!frm.getS5e().trim().equals("") && frm.getS5e() != null) {
					Element PhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
					PhoneNumber.addContent(frm.getS5e());
					RContact.addContent(PhoneNumber);
				}
				if (!frm.getS5f().trim().equals("") && frm.getS5f() != null) {
					Element MobileNumber = getElementWithDefaultNamespace("FaxNumber");
					MobileNumber.addContent(frm.getS5f());
					RContact.addContent(MobileNumber);
				}
				if (!frm.getS5g().trim().equals("") && frm.getS5g() != null) {
					Element FaxNumber = getElementWithDefaultNamespace("EmailAddress");
					FaxNumber.addContent(frm.getS5g());
					RContact.addContent(FaxNumber);
				}

				if (!frm.getS5i().trim().equals("0") && frm.getS5i() != null) {

					Element LSCCommission = getElementWithDefaultNamespace("LSCCommission");
					LSCCommission.addContent(frm.getS5i());
					Representative.addContent(LSCCommission);
				}
			}
			if (frm.getS6a() != null && !frm.getS6a().trim().equals("")) {
				Element Sponsors = getElementWithDefaultNamespace("Sponsor");
				// LegalAid.addContent("No");
				AAIC.addContent(Sponsors);

				// /Sponsor DetailsFamilyName
				Element Sponsor = getElementWithDefaultNamespace("SponsorPersonalDetails");
				// LegalAid.addContent("No");
				Sponsors.addContent(Sponsor);

				Element SponsorFamilyName = getElementWithDefaultNamespace("FamilyName");
				SponsorFamilyName.addContent(frm.getS6a());
				Sponsor.addContent(SponsorFamilyName);

				Element SponsorGivenName = getElementWithDefaultNamespace("GivenName");
				SponsorGivenName.addContent(frm.getS6b());
				Sponsor.addContent(SponsorGivenName);

				Element STitle = getElementWithDefaultNamespace("Title");
				STitle.addContent(frm.getS6c());
				Sponsor.addContent(STitle);

				Element SAddress = getElementWithDefaultNamespace("Address");
				// LegalAid.addContent("No");
				Sponsor.addContent(SAddress);
				if (!frm.getS6d_addr1().trim().equals("") && frm.getS6d_addr1() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS6d_addr1());
					SAddress.addContent(RLine);
				}

				if (!frm.getS6d_addr2().trim().equals("") && frm.getS6d_addr2() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS6d_addr2());
					SAddress.addContent(RLine);
				}

				if (!frm.getS6d_addr3().trim().equals("") && frm.getS6d_addr3() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS6d_addr3());
					SAddress.addContent(RLine);
				}

				if (!frm.getS6d_addr4().trim().equals("") && frm.getS6d_addr4() != null) {
					Element RCountry = getElementWithDefaultNamespace("Country");
					RCountry.addContent(Helper.returnIntegerValue(frm.getS6d_addr4()));
					SAddress.addContent(RCountry);
				}

				Element SPostCode = getElementWithDefaultNamespace("PostCode");
				SPostCode.addContent(frm.getS6d_postcode());
				SAddress.addContent(SPostCode);

				if ((!frm.getS6e().trim().equals("") && frm.getS6e() != null)
						|| (!frm.getS6f().trim().equals("") && frm.getS6f() != null)) {
					Element SContact = getElementWithDefaultNamespace("SponsorContactDetails");
					// LegalAid.addContent("No");
					Sponsors.addContent(SContact);
					if (!frm.getS6e().trim().equals("") && frm.getS6e() != null) {
						Element SPhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
						SPhoneNumber.addContent(frm.getS6e());
						SContact.addContent(SPhoneNumber);
					}
					if (!frm.getS6f().trim().equals("") && frm.getS6f() != null) {
						Element SMobileNumber = getElementWithDefaultNamespace("EmailAddress");
						SMobileNumber.addContent(frm.getS6f());
						SContact.addContent(SMobileNumber);
					}
				}
			}

			Element Interpreter = getElementWithDefaultNamespace("Interpreter");
			// logger.debug(frm.getS3f());
			if (frm.getS3f().equals("Yes")) {
				Interpreter.addContent("yes");
			} else {
				Interpreter.addContent("no");
			}
			AAIC.addContent(Interpreter);
			root.addNamespaceDeclaration(nm2);
			doc.setRootElement(root);
			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocNewAppeal", ex);
		}
		return doc;
	}

	/**IAFT2
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocNewAppeal(IAFT2Bean frm) {
		Document doc = new Document();
		try {
			Element root = getElementWithDefaultNamespace("NewAppeal");

			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);
			// root.appendChild(title);
			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("NEW APPEAL");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("IAFT-2");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("IAFT-2");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			// logger.debug(sdf.format(new Date()));
			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);

			Element naa = getElementWithDefaultNamespace("NewAppealApplications");
			root.addContent(naa);

			Element AAIC = getElementWithDefaultNamespace("AppealAgainstEntryClearanceOfficerDecision");
			naa.addContent(AAIC);

			// Childrens Act

			Element ApplicationDetails = getElementWithDefaultNamespace("ApplicationDetails");

			// ApplicationDetails.addContent("1.0");
			AAIC.addContent(ApplicationDetails);
			Attribute AppealType = new Attribute("AppealType", "IAFT-2");
			ApplicationDetails.setAttribute(AppealType);

			Element SubmissionDate = getElementWithDefaultNamespace("SubmissionDate");
			SubmissionDate.addContent(sdf.format(new Date()));
			ApplicationDetails.addContent(SubmissionDate);

			Element SubmissionURN = getElementWithDefaultNamespace("SubmissionURN");
			SubmissionURN.addContent(frm.getSubmissionURN());
			ApplicationDetails.addContent(SubmissionURN);

			Element PaymentRemissionRequested = getElementWithDefaultNamespace("PaymentRemissionRequested");
			PaymentRemissionRequested.addContent("no");
			ApplicationDetails.addContent(PaymentRemissionRequested);

			if (frm.getQb_lsc() != null) {
				if (frm.getQb_lsc().equals("Yes")) {

					// LegalAId
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Element LegalAidReferenceNumber = getElementWithDefaultNamespace("LegalAidReferenceNumber");
					LegalAidReferenceNumber.addContent(frm.getQb_LAR());
					LegalAid.addContent(LegalAidReferenceNumber);

					Attribute LSF = new Attribute("LegalAid", "yes");

					LegalAid.setAttribute(LSF);

					// asylum support

				} else {
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Attribute LSF = new Attribute("LegalAid", "no");

					LegalAid.setAttribute(LSF);

				}
			}
			Element HearingType = getElementWithDefaultNamespace("HearingType");
			if (frm.getAppeal_type().equals("Oral")) {
				HearingType.addContent("oral");
			} else {
				HearingType.addContent("paper");
			}
			ApplicationDetails.addContent(HearingType);

			// Payment details
			if (frm.getAggregatedpaymentURN() != null && !frm.getQb_lsc().equals("Yes") && frm.getPaymentvalue() != 0) {
				Element PaymentDetails = getElementWithDefaultNamespace("PaymentDetails");
				// LegalAid.addContent("No");
				AAIC.addContent(PaymentDetails);

				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				PaymentDetails.addContent(AggregatedPaymentURN);

			}
			/*
			 * <AppellantDetails> <FamilyName>string</FamilyName>
			 * <GivenName>string</GivenName> <Title>string</Title> <Address>
			 * <Line>string</Line> <Country /> <PostCode /> </Address>
			 * </AppellantDetails>
			 */

			// Appellant Details

			Element AppellantDetails = getElementWithDefaultNamespace("AppellantDetails");
			// LegalAid.addContent("No");
			AAIC.addContent(AppellantDetails);

			Element FamilyName = getElementWithDefaultNamespace("FamilyName");
			FamilyName.addContent(frm.getS1a());
			AppellantDetails.addContent(FamilyName);

			Element GivenName = getElementWithDefaultNamespace("GivenName");
			GivenName.addContent(frm.getS1b());
			AppellantDetails.addContent(GivenName);

			Element Title = getElementWithDefaultNamespace("Title");
			Title.addContent(frm.getS1c());
			AppellantDetails.addContent(Title);

			Element Address = getElementWithDefaultNamespace("Address");
			// LegalAid.addContent("No");
			AppellantDetails.addContent(Address);

			if (!frm.getS1f_addr1().equals("") && frm.getS1f_addr1() != null) {
				Element Line = getElementWithDefaultNamespace("Line");
				Line.addContent(frm.getS1f_addr1());
				Address.addContent(Line);

			}

			if (!frm.getS1f_addr2().equals("") && frm.getS1f_addr2() != null) {
				Element Line = getElementWithDefaultNamespace("Line");
				Line.addContent(frm.getS1f_addr2());
				Address.addContent(Line);

			}

			if (!frm.getS1f_addr3().equals("") && frm.getS1f_addr3() != null) {
				Element Line = getElementWithDefaultNamespace("Line");
				Line.addContent(frm.getS1f_addr3());
				Address.addContent(Line);

			}

			if (!frm.getS1f_addr4().equals("") && frm.getS1f_addr4() != null) {
				Element Country = getElementWithDefaultNamespace("Country");
				Country.addContent(Helper.returnIntegerValue(frm.getS1f_addr4()));
				Address.addContent(Country);
			}

			Element PostCode = getElementWithDefaultNamespace("PostCode");
			PostCode.addContent(frm.getS1f_postcode());
			Address.addContent(PostCode);


			if (!frm.getS1f_email().equals("") && frm.getS1f_email() != null) {
			Element email = getElementWithDefaultNamespace("Email");
			// LegalAid.addContent("No");
			email.addContent(frm.getS1f_email());
			AppellantDetails.addContent(email);
			}


			Element DateOfBirth = getElementWithDefaultNamespace("DateOfBirth");
			DateOfBirth.addContent(sdf.format(sdf.parse(frm.getS1d_dob_year() + "-" + frm.getS1d_dob_month() + "-"
					+ frm.getS1d_dob_day())));
			AAIC.addContent(DateOfBirth);

			Element Nationality = getElementWithDefaultNamespace("Nationality");
			Nationality.addContent(Helper.returnIntegerValue(frm.getS1g()));
			AAIC.addContent(Nationality);

			// Element DetainedReferenceNumber = new
			// Element("PrisonReferenceNumber");
			// DetainedReferenceNumber.addContent(frm.getS1g());
			// Detained.addContent(DetainedReferenceNumber);

			// Home Office Details

			/*
			 * <HomeOfficeDecision> <HomeOfficeRefNo>string</HomeOfficeRefNo>
			 * <PortReferenceNo>string</PortReferenceNo>
			 * <COHIDRefNo>string</COHIDRefNo>
			 * <PointsBasedRefusal>no</PointsBasedRefusal>
			 * <DateOfApplicationDecision>2006-12-20</DateOfApplicationDecision>
			 * </HomeOfficeDecision>
			 */

			Element HomeOfficeDecision = getElementWithDefaultNamespace("ECODecision");
			// LegalAid.addContent("No");
			AAIC.addContent(HomeOfficeDecision);

			Element PointsBasedRefusal = getElementWithDefaultNamespace("PointsBasedRefusal");
			if (frm.getS2a().equals("No")) {
				PointsBasedRefusal.addContent("no");
			} else {
				PointsBasedRefusal.addContent("yes");
			}
			HomeOfficeDecision.addContent(PointsBasedRefusal);

			Element PortReferenceNo = getElementWithDefaultNamespace("PostReferenceNo");
			PortReferenceNo.addContent(frm.getS2b());
			HomeOfficeDecision.addContent(PortReferenceNo);

			Element PostLocation = getElementWithDefaultNamespace("PostLocation");
			PostLocation.addContent(Helper.returnIntegerValue(frm.getS2c()));
			HomeOfficeDecision.addContent(PostLocation);

			Element DateOfApplicationDecision = getElementWithDefaultNamespace("DateOfApplicationDecision");
			DateOfApplicationDecision.addContent(sdf.format(sdf.parse(frm.getS2e_year() + "-" + frm.getS2e_month()
					+ "-" + frm.getS2e_day())));
			HomeOfficeDecision.addContent(DateOfApplicationDecision);

			// Appeal

			Element Appeal = getElementWithDefaultNamespace("Appeal");
			// LegalAid.addContent("No");
			AAIC.addContent(Appeal);
	//*********************************Late Appeal Removed.

			/*Element LateAppeal = getElementWithDefaultNamespace("LateAppeal");
			if (frm.getS3a() != null) {
				if (frm.getS3a().length() >= 2) {
					LateAppeal.addContent("yes");
				} else {
					LateAppeal.addContent("no");
				}

			}

			else {
				LateAppeal.addContent("no");
			}

			Appeal.addContent(LateAppeal);
             */
			Element AdditionalDocuments = getElementWithDefaultNamespace("AdditionalDocuments");
			if (frm.getS3b() != null && frm.getS3b().length() >= 2) {
				AdditionalDocuments.addContent("yes");
			} else {
				AdditionalDocuments.addContent("no");

			}
			Appeal.addContent(AdditionalDocuments);

			Element AdditionalDocumentsLater = getElementWithDefaultNamespace("AdditionalDocumentsLater");
			if (frm.getS3c() != null && frm.getS3c().length() >= 2) {
				AdditionalDocumentsLater.addContent("yes");
			} else {
				AdditionalDocumentsLater.addContent("no");

			}

			Appeal.addContent(AdditionalDocumentsLater);

			// Representative details
			/*
			 * <Representative> <RepresentativeName>string</RepresentativeName>
			 * <RepresentativeOrganisation>string</RepresentativeOrganisation> -
			 * <RepresentativeAddress> <Line>string</Line> <Country /> <PostCode
			 * /> </RepresentativeAddress>
			 * <RepresentativeReference>string</RepresentativeReference> -
			 * <RepresentativeContactDetails> <PhoneNumber>string</PhoneNumber>
			 * <MobileNumber>string</MobileNumber> <FaxNumber>string</FaxNumber>
			 * <EmailAddress>string</EmailAddress>
			 * </RepresentativeContactDetails>
			 * <LSCCommission>string</LSCCommission> </Representative>
			 */
			if ((frm.getS5a() != null && !frm.getS5a().trim().equals(""))
					|| (frm.getS5b() != null && !frm.getS5b().trim().equals("0"))) {
				Element Representative = getElementWithDefaultNamespace("Representative");
				// LegalAid.addContent("No");
				AAIC.addContent(Representative);


				if (frm.getS5b().equals("00")&&frm.getS5b_other()!=null &&!frm.getS5b_other().equals("")) {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5b_other());
					Representative.addContent(RepresentativeName);
				}

				else if (!frm.getS5b().equals("0")&&!frm.getS5b().equals("00")) {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(Helper.returnIntegerValue(frm.getS5b()));
					Representative.addContent(RepresentativeName);
				}
				else {

					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5a());
					Representative.addContent(RepresentativeName);
				}
				Element RAddress = getElementWithDefaultNamespace("RepresentativeAddress");
				// LegalAid.addContent("No");
				Representative.addContent(RAddress);
				if (!frm.getS5c_addr1().trim().equals("") && frm.getS5c_addr1() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS5c_addr1());
					RAddress.addContent(RLine);
				}

				if (!frm.getS5c_addr2().trim().equals("") && frm.getS5c_addr2() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS5c_addr2());
					RAddress.addContent(RLine);
				}

				if (!frm.getS5c_addr3().trim().equals("") && frm.getS5c_addr3() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS5c_addr3());
					RAddress.addContent(RLine);
				}

				if (!frm.getS5c_addr4().trim().equals("") && frm.getS5c_addr4() != null) {
					Element RCountry = getElementWithDefaultNamespace("Country");
					RCountry.addContent(Helper.returnIntegerValue(frm.getS5c_addr4()));
					RAddress.addContent(RCountry);
				}

				Element RPostCode = getElementWithDefaultNamespace("PostCode");
				RPostCode.addContent(frm.getS5c_postcode());
				RAddress.addContent(RPostCode);

				Element RepresentativeReference = getElementWithDefaultNamespace("RepresentativeReference");
				RepresentativeReference.addContent(frm.getS5d());
				Representative.addContent(RepresentativeReference);

				Element RContact = getElementWithDefaultNamespace("RepresentativeContactDetails");
				// LegalAid.addContent("No");
				Representative.addContent(RContact);

				if (!frm.getS5e().trim().equals("") && frm.getS5e() != null) {
					Element PhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
					PhoneNumber.addContent(frm.getS5e());
					RContact.addContent(PhoneNumber);
				}
				if (!frm.getS5f().trim().equals("") && frm.getS5f() != null) {
					Element MobileNumber = getElementWithDefaultNamespace("FaxNumber");
					MobileNumber.addContent(frm.getS5f());
					RContact.addContent(MobileNumber);
				}
				if (!frm.getS5g().trim().equals("") && frm.getS5g() != null) {
					Element FaxNumber = getElementWithDefaultNamespace("EmailAddress");
					FaxNumber.addContent(frm.getS5g());
					RContact.addContent(FaxNumber);
				}

				if (!frm.getS5i().trim().equals("0") && frm.getS5i() != null) {

					Element LSCCommission = getElementWithDefaultNamespace("LSCCommission");
					LSCCommission.addContent(frm.getS5i());
					Representative.addContent(LSCCommission);
				}
			}
			if (frm.getS6a() != null && !frm.getS6a().trim().equals("")) {
				Element Sponsors = getElementWithDefaultNamespace("Sponsor");
				// LegalAid.addContent("No");
				AAIC.addContent(Sponsors);

				// /Sponsor DetailsFamilyName
				Element Sponsor = getElementWithDefaultNamespace("SponsorPersonalDetails");
				// LegalAid.addContent("No");
				Sponsors.addContent(Sponsor);

				Element SponsorFamilyName = getElementWithDefaultNamespace("FamilyName");
				SponsorFamilyName.addContent(frm.getS6a());
				Sponsor.addContent(SponsorFamilyName);

				Element SponsorGivenName = getElementWithDefaultNamespace("GivenName");
				SponsorGivenName.addContent(frm.getS6b());
				Sponsor.addContent(SponsorGivenName);

				Element STitle = getElementWithDefaultNamespace("Title");
				STitle.addContent(frm.getS6c());
				Sponsor.addContent(STitle);

				Element SAddress = getElementWithDefaultNamespace("Address");
				// LegalAid.addContent("No");
				Sponsor.addContent(SAddress);
				if (!frm.getS6d_addr1().trim().equals("") && frm.getS6d_addr1() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS6d_addr1());
					SAddress.addContent(RLine);
				}

				if (!frm.getS6d_addr2().trim().equals("") && frm.getS6d_addr2() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS6d_addr2());
					SAddress.addContent(RLine);
				}

				if (!frm.getS6d_addr3().trim().equals("") && frm.getS6d_addr3() != null) {
					Element RLine = getElementWithDefaultNamespace("Line");
					RLine.addContent(frm.getS6d_addr3());
					SAddress.addContent(RLine);
				}

				if (!frm.getS6d_addr4().trim().equals("") && frm.getS6d_addr4() != null) {
					Element RCountry = getElementWithDefaultNamespace("Country");
					RCountry.addContent(Helper.returnIntegerValue(frm.getS6d_addr4()));
					SAddress.addContent(RCountry);
				}

				Element SPostCode = getElementWithDefaultNamespace("PostCode");
				SPostCode.addContent(frm.getS6d_postcode());
				SAddress.addContent(SPostCode);

				if ((!frm.getS6e().trim().equals("") && frm.getS6e() != null)
						|| (!frm.getS6f().trim().equals("") && frm.getS6f() != null)) {
					Element SContact = getElementWithDefaultNamespace("SponsorContactDetails");
					// LegalAid.addContent("No");
					Sponsors.addContent(SContact);
					if (!frm.getS6e().trim().equals("") && frm.getS6e() != null) {
						Element SPhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
						SPhoneNumber.addContent(frm.getS6e());
						SContact.addContent(SPhoneNumber);
					}
					if (!frm.getS6f().trim().equals("") && frm.getS6f() != null) {
						Element SMobileNumber = getElementWithDefaultNamespace("EmailAddress");
						SMobileNumber.addContent(frm.getS6f());
						SContact.addContent(SMobileNumber);
					}
				}
			}

			Element Interpreter = getElementWithDefaultNamespace("Interpreter");
			// logger.debug(frm.getS3f());
			if (frm.getS3f().equals("Yes")) {
				Interpreter.addContent("yes");
			} else {
				Interpreter.addContent("no");
			}
			AAIC.addContent(Interpreter);
			root.addNamespaceDeclaration(nm2);
			doc.setRootElement(root);
			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocNewAppeal", ex);
		}
		return doc;
	}

	/**IAFT5
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocNewAppeal(IAFT5Bean frm) {
		Document doc = new Document();
		try {
			Element root = getElementWithDefaultNamespace("NewAppeal");

			/*
			 * Attribute xmlns=new
			 * Attribute("xmlns","http://www.justice.gov.uk/IACFEES");
			 * root.setAttribute(xmlns); Attribute xmlnsxsi=new
			 * Attribute("xmlns:xsi"
			 * ,"http://www.w3.org/2001/XMLSchema-instance");
			 * root.setAttribute(xmlnsxsi);
			 */

			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);
			// root.appendChild(title);
			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("NEW APPEAL");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("IAFT-5");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("IAFT-5");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			// logger.debug(sdf.format(new Date()));
			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);

			// int i=0;
			// logger.debug(""+list.size());

			Element naa = getElementWithDefaultNamespace("NewAppealApplications");
			root.addContent(naa);

			Element AAIC = getElementWithDefaultNamespace("AppealAgainstInCountryDecision");
			naa.addContent(AAIC);

			if (frm.getQb_lsc().equals("Asylum Support")) {
				// Asylum Support
				Element AsylumSupportFinding = getElementWithDefaultNamespace("AsylumSupportFunding");
				// LegalAid.addContent("No");
				AAIC.addContent(AsylumSupportFinding);

				Element AsylumSupportReferenceNumber = getElementWithDefaultNamespace("ASFReferenceNumber");
				AsylumSupportReferenceNumber.addContent(frm.getQb_LAR());
				AsylumSupportFinding.addContent(AsylumSupportReferenceNumber);

				Attribute ASF = new Attribute("ASF", "yes");
				AsylumSupportFinding.setAttribute(ASF);

			} else {
				// ASF No
				Element AsylumSupportFinding = getElementWithDefaultNamespace("AsylumSupportFunding");
				// LegalAid.addContent("No");
				AAIC.addContent(AsylumSupportFinding);

				Attribute ASF = new Attribute("ASF", "no");
				AsylumSupportFinding.setAttribute(ASF);

			}
			if (frm.getQb_lsc().equals("Section17")) {
				// Asylum Support

				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensAct");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent(frm.getQb_LAR());
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "yes");
				ChildrensAct.setAttribute(ChildrensActs);

			} else {
				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensAct");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent("");
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "no");
				ChildrensAct.setAttribute(ChildrensActs);
			}
			if (frm.getQb_lsc().equals("Section20")) {
				// Asylum Support

				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensActS20");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent(frm.getQb_LAR());
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "yes");
				ChildrensAct.setAttribute(ChildrensActs);

			} else {
				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensActS20");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent("");
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "no");
				ChildrensAct.setAttribute(ChildrensActs);
			}

			// Childrens Act

			Element ApplicationDetails = getElementWithDefaultNamespace("ApplicationDetails");
			// ApplicationDetails.addContent("1.0");
			AAIC.addContent(ApplicationDetails);

			Attribute AppealType = new Attribute("AppealType", "IAFT-5");
			ApplicationDetails.setAttribute(AppealType);

			Element SubmissionDate = getElementWithDefaultNamespace("SubmissionDate");
			SubmissionDate.addContent(sdf.format(new Date()));
			ApplicationDetails.addContent(SubmissionDate);

			Element SubmissionURN = getElementWithDefaultNamespace("SubmissionURN");
			SubmissionURN.addContent(frm.getSubmissionURN());
			ApplicationDetails.addContent(SubmissionURN);

			Element PaymentRemissionRequested = getElementWithDefaultNamespace("PaymentRemissionRequested");
			PaymentRemissionRequested.addContent("no");
			ApplicationDetails.addContent(PaymentRemissionRequested);

			if (frm.getQb_lsc() != null) {
				if (frm.getQb_lsc().equals("LSC")) {

					// LegalAId
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Element LegalAidReferenceNumber = getElementWithDefaultNamespace("LegalAidReferenceNumber");
					LegalAidReferenceNumber.addContent(frm.getQb_LAR());
					LegalAid.addContent(LegalAidReferenceNumber);

					Attribute LSF = new Attribute("LegalAid", "yes");

					LegalAid.setAttribute(LSF);

					// asylum support

				} else {
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Attribute LSF = new Attribute("LegalAid", "no");

					LegalAid.setAttribute(LSF);

				}
			}
			Element HearingType = getElementWithDefaultNamespace("HearingType");
			if (frm.getAppeal_type().equals("Oral")) {
				HearingType.addContent("oral");
			} else {
				HearingType.addContent("paper");
			}
			ApplicationDetails.addContent(HearingType);

			// Payment details
			if (frm.getAggregatedpaymentURN() != null && frm.getQb_lsc().equals("No") && frm.getPaymentvalue() != 0) {

				Element PaymentDetails = getElementWithDefaultNamespace("PaymentDetails");
				// LegalAid.addContent("No");
				AAIC.addContent(PaymentDetails);

				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				PaymentDetails.addContent(AggregatedPaymentURN);
			}

			/*
			 * <AppellantDetails> <FamilyName>string</FamilyName>
			 * <GivenName>string</GivenName> <Title>string</Title> <Address>
			 * <Line>string</Line> <Country /> <PostCode /> </Address>
			 * </AppellantDetails>
			 */

			// Appellant Details

			Element AppellantDetails = getElementWithDefaultNamespace("AppellantDetails");
			// LegalAid.addContent("No");
			AAIC.addContent(AppellantDetails);

			Element FamilyName = getElementWithDefaultNamespace("FamilyName");
			FamilyName.addContent(frm.getS1a());
			AppellantDetails.addContent(FamilyName);

			Element GivenName = getElementWithDefaultNamespace("GivenName");
			GivenName.addContent(frm.getS1b());
			AppellantDetails.addContent(GivenName);

			Element Title = getElementWithDefaultNamespace("Title");
			Title.addContent(frm.getS1c());
			AppellantDetails.addContent(Title);

			Element Address = getElementWithDefaultNamespace("Address");
			// LegalAid.addContent("No");
			AppellantDetails.addContent(Address);
			try {
				if (!frm.getS1f_addr1().equals("") && frm.getS1f_addr1() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr1());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				if (!frm.getS1f_addr2().equals("") && frm.getS1f_addr2() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr2());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				// logger.debug("???"+frm.getS1f_addr3().trim().equals("")+"??");
				if (!frm.getS1f_addr3().equals("") && frm.getS1f_addr3() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr3());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}

			/*
			 * if(frm.getS1f_addr4()!=" " || frm.getS1f_addr4()!=null) { Element
			 * Line= getElementWithDefaultNamespace("Line");
			 * Line.addContent(frm.getS1f_addr4()); Address.addContent(Line);
			 *
			 * }
			 */
			try {
				if (!frm.getS1f_addr4().equals("") && frm.getS1f_addr4() != null) {
					Element Country = getElementWithDefaultNamespace("Country");
					Country.addContent(Helper.returnIntegerValue(frm.getS1f_addr4()));
					Address.addContent(Country);
				}
			} catch (Exception e) {

			}
			Element PostCode = getElementWithDefaultNamespace("PostCode");
			PostCode.addContent(frm.getS1f_postcode());
			Address.addContent(PostCode);


			if (!frm.getS1f_email().equals("") && frm.getS1f_email() != null) {
			Element email = getElementWithDefaultNamespace("Email");
			// LegalAid.addContent("No");
			email.addContent(frm.getS1f_email());
			AppellantDetails.addContent(email);
			}


			Element DateOfBirth = getElementWithDefaultNamespace("DateOfBirth");
			// logger.debug(">>.............."+sdf.format(sdf.parse(frm.getS1d_dob_year()+"-"+frm.getS1d_dob_month()+"-"+frm.getS1d_dob_day())));
			DateOfBirth.addContent(sdf.format(sdf.parse(frm.getS1d_dob_year() + "-" + frm.getS1d_dob_month() + "-"
					+ frm.getS1d_dob_day())));
			AAIC.addContent(DateOfBirth);

			Element Detained = getElementWithDefaultNamespace("Detained");
			// LegalAid.addContent("No");
			AAIC.addContent(Detained);

			Element Nationality = getElementWithDefaultNamespace("Nationality");
			Nationality.addContent(Helper.returnIntegerValue(frm.getS1h()));
			AAIC.addContent(Nationality);

			Element Interpreter = getElementWithDefaultNamespace("Interpreter");
			if (frm.getS1j().equals("Yes")) {
				Interpreter.addContent("yes");
			} else {
				Interpreter.addContent("no");

			}
			AAIC.addContent(Interpreter);

			// Element DetainedReferenceNumber = new
			// Element("PrisonReferenceNumber");
			// DetainedReferenceNumber.addContent(frm.getS1g());
			// Detained.addContent(DetainedReferenceNumber);

			// Home Office Details

			/*
			 * <HomeOfficeDecision> <HomeOfficeRefNo>string</HomeOfficeRefNo>
			 * <PortReferenceNo>string</PortReferenceNo>
			 * <COHIDRefNo>string</COHIDRefNo>
			 * <PointsBasedRefusal>no</PointsBasedRefusal>
			 * <DateOfApplicationDecision>2006-12-20</DateOfApplicationDecision>
			 * </HomeOfficeDecision>
			 *
			 * V22 Schemae
			 * <xsd:element name="HomeOfficeANRefNo" type="HomeOfficeANReferenceType" minOccurs="0"/>
			<xsd:element name="PortReferenceNo" type="PortReferenceType" minOccurs="0"/>
			<xsd:element name="COHIDRefNo" type="COHIDReferenceType" minOccurs="0"/>
			<xsd:element name="PointsBasedRefusal" type="YesNoType"/>
			<xsd:element name="DateOfApplicationDecision" type="DateType"/>
			<xsd:element name="DateApplicationLodged" type="DateType" minOccurs="0"/>
			<xsd:element name="HomeOfficeWaiver" type="YesNoType" minOccurs="0"/>
			 */

			Element HomeOfficeDecision = getElementWithDefaultNamespace("HomeOfficeDecision");
			// LegalAid.addContent("No");
			AAIC.addContent(HomeOfficeDecision);
            if(frm.getS2a().length()>1)
            {
			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeRefNo");
			HomeOfficeRefNo.addContent(frm.getS2a());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }
            if(frm.getS2hoan().length()>1)
            {
			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeANRefNo");
			HomeOfficeRefNo.addContent(frm.getS2hoan());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }

			Element PortReferenceNo = getElementWithDefaultNamespace("PortReferenceNo");
			PortReferenceNo.addContent(frm.getS2b());
			HomeOfficeDecision.addContent(PortReferenceNo);

			if(frm.getS2c().length()>1)
            {

			Element COHIDRefNo = getElementWithDefaultNamespace("COHIDRefNo");
			COHIDRefNo.addContent(frm.getS2c());
			HomeOfficeDecision.addContent(COHIDRefNo);
            }
			Element PointsBasedRefusal = getElementWithDefaultNamespace("PointsBasedRefusal");
			PointsBasedRefusal.addContent("no");
			HomeOfficeDecision.addContent(PointsBasedRefusal);

			Element DateOfApplicationDecision = getElementWithDefaultNamespace("DateOfApplicationDecision");
			DateOfApplicationDecision.addContent(sdf.format(sdf.parse(frm.getS2e_service_year() + "-"
					+ frm.getS2e_service_month() + "-" + frm.getS2e_service_day())));
			HomeOfficeDecision.addContent(DateOfApplicationDecision);
			if(frm.getS2j_service_year()>0)
            {
				Element dateapplicationlodged = getElementWithDefaultNamespace("DateApplicationLodged");
				dateapplicationlodged.addContent(sdf.format(sdf.parse(frm.getS2j_service_year() + "-"
						+ frm.getS2j_service_month() + "-" + frm.getS2j_service_day())));
				HomeOfficeDecision.addContent(dateapplicationlodged);

            }
			if(frm.getQb_lsc().equals("homeofficewaiver"))
			{
			Element homeofficewaiver = getElementWithDefaultNamespace("HomeOfficeWaiver");
			homeofficewaiver.addContent("yes");
			HomeOfficeDecision.addContent(homeofficewaiver);
			}
			// Appeal

			Element Appeal = getElementWithDefaultNamespace("Appeal");
			// LegalAid.addContent("No");
			AAIC.addContent(Appeal);

			//*********************************Late Appeal Removed.

			/*Element LateAppeal = getElementWithDefaultNamespace("LateAppeal");
			if (frm.getS3a() != null) {
				if (frm.getS3a().length() >= 2) {
					LateAppeal.addContent("yes");
				} else {
					LateAppeal.addContent("no");
				}

			}

			else {
				LateAppeal.addContent("no");
			}

			Appeal.addContent(LateAppeal);
             */
			Element AdditionalDocuments = getElementWithDefaultNamespace("AdditionalDocuments");
			if (frm.getS3b() != null && frm.getS3b().length() >= 2) {
				AdditionalDocuments.addContent("yes");
			} else {
				AdditionalDocuments.addContent("no");

			}
			Appeal.addContent(AdditionalDocuments);

			Element AdditionalDocumentsLater = getElementWithDefaultNamespace("AdditionalDocumentsLater");
			if (frm.getS3c() != null && frm.getS3c().length() >= 2) {
				AdditionalDocumentsLater.addContent("yes");
			} else {
				AdditionalDocumentsLater.addContent("no");

			}

			Appeal.addContent(AdditionalDocumentsLater);

			// Representative details
			/*
			 * <Representative> <RepresentativeName>string</RepresentativeName>
			 * <RepresentativeOrganisation>string</RepresentativeOrganisation> -
			 * <RepresentativeAddress> <Line>string</Line> <Country /> <PostCode
			 * /> </RepresentativeAddress>
			 * <RepresentativeReference>string</RepresentativeReference> -
			 * <RepresentativeContactDetails> <PhoneNumber>string</PhoneNumber>
			 * <MobileNumber>string</MobileNumber> <FaxNumber>string</FaxNumber>
			 * <EmailAddress>string</EmailAddress>
			 * </RepresentativeContactDetails>
			 * <LSCCommission>string</LSCCommission> </Representative>
			 */
			// logger.debug((frm.getS5a()!=null &&
			// !frm.getS5a().trim().equals(""))+">>>>>>>"+(frm.getS5b()!=null &&
			// !frm.getS5b().trim().equals("0")));
			if ((frm.getS5a() != null && !frm.getS5a().trim().equals(""))
					|| (frm.getS5b() != null && !frm.getS5b().trim().equals("0"))) {
				Element Representative = getElementWithDefaultNamespace("Representative");
				// LegalAid.addContent("No");
				AAIC.addContent(Representative);
				logger.debug("rep"+frm.getS5b());
				if (frm.getS5b().trim().equals("00")&&frm.getS5b_other()!=null &&!frm.getS5b_other().equals("")) {
					logger.debug("rep"+frm.getS5b_other());
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5b_other());
					Representative.addContent(RepresentativeName);
				}

				else if (!frm.getS5b().trim().equals("0")&&!frm.getS5b().trim().equals("00")) {
					logger.debug("rep");
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(Helper.returnIntegerValue(frm.getS5b()));
					Representative.addContent(RepresentativeName);

				}
				else {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5a());
					Representative.addContent(RepresentativeName);
				}
				Element RAddress = getElementWithDefaultNamespace("RepresentativeAddress");
				// LegalAid.addContent("No");
				Representative.addContent(RAddress);
				try {
					if (!frm.getS5c_addr1().trim().equals("") && frm.getS5c_addr1() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr1());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr2().trim().equals("") && frm.getS5c_addr2() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr2());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr3().trim().equals("") && frm.getS5c_addr3() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr3());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS1f_addr4().trim().equals("") && frm.getS1f_addr4() != null) {
						Element Country = getElementWithDefaultNamespace("Country");
						Country.addContent(Helper.returnIntegerValue(frm.getS5c_addr4()));
						RAddress.addContent(Country);
					}
				} catch (Exception e) {

				}

				Element RPostCode = getElementWithDefaultNamespace("PostCode");
				RPostCode.addContent(frm.getS5c_postcode());
				RAddress.addContent(RPostCode);

				Element RepresentativeReference = getElementWithDefaultNamespace("RepresentativeReference");
				RepresentativeReference.addContent(frm.getS5d());
				Representative.addContent(RepresentativeReference);

				Element RContact = getElementWithDefaultNamespace("RepresentativeContactDetails");
				// LegalAid.addContent("No");
				Representative.addContent(RContact);
				if (!frm.getS5e().trim().equals("") && frm.getS5e() != null) {
					Element PhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
					PhoneNumber.addContent(frm.getS5e());
					RContact.addContent(PhoneNumber);
				}
				if (!frm.getS5f().trim().equals("") && frm.getS5f() != null) {
					Element MobileNumber = getElementWithDefaultNamespace("MobileNumber");
					MobileNumber.addContent(frm.getS5f());
					RContact.addContent(MobileNumber);
				}
				if (!frm.getS5g().trim().equals("") && frm.getS5g() != null) {
					Element FaxNumber = getElementWithDefaultNamespace("FaxNumber");
					FaxNumber.addContent(frm.getS5g());
					RContact.addContent(FaxNumber);
				}
				if (!frm.getS5h().trim().equals("") && frm.getS5h() != null) {
					Element Email = getElementWithDefaultNamespace("EmailAddress");
					Email.addContent(frm.getS5h());
					RContact.addContent(Email);
				}
				if (!frm.getS5j().trim().equals("0") && frm.getS5j() != null) {
					Element LSCCommission = getElementWithDefaultNamespace("LSCCommission");
					LSCCommission.addContent(frm.getS5j());
					Representative.addContent(LSCCommission);
				}

			}

			root.addNamespaceDeclaration(nm2);

			doc.setRootElement(root);

			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocNewAppeal", ex);
		}
		return doc;
	}
	/**IAFT7
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocNewAppeal(IAFT7Bean frm) {
		Document doc = new Document();
		try {
			Element root = getElementWithDefaultNamespace("NewAppeal");

			/*
			 * Attribute xmlns=new
			 * Attribute("xmlns","http://www.justice.gov.uk/IACFEES");
			 * root.setAttribute(xmlns); Attribute xmlnsxsi=new
			 * Attribute("xmlns:xsi"
			 * ,"http://www.w3.org/2001/XMLSchema-instance");
			 * root.setAttribute(xmlnsxsi);
			 */

			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);
			// root.appendChild(title);
			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("NEW APPEAL");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("IAFT-7");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("IAFT-7");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			// logger.debug(sdf.format(new Date()));
			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);

			// int i=0;
			// logger.debug(""+list.size());

			Element naa = getElementWithDefaultNamespace("NewAppealApplications");
			root.addContent(naa);

			Element AAIC = getElementWithDefaultNamespace("AppealAgainstInCountryDecision");
			naa.addContent(AAIC);

			if (frm.getQb_lsc().equals("Asylum Support")) {
				// Asylum Support
				Element AsylumSupportFinding = getElementWithDefaultNamespace("AsylumSupportFunding");
				// LegalAid.addContent("No");
				AAIC.addContent(AsylumSupportFinding);

				Element AsylumSupportReferenceNumber = getElementWithDefaultNamespace("ASFReferenceNumber");
				AsylumSupportReferenceNumber.addContent(frm.getQb_LAR());
				AsylumSupportFinding.addContent(AsylumSupportReferenceNumber);

				Attribute ASF = new Attribute("ASF", "yes");
				AsylumSupportFinding.setAttribute(ASF);

			} else {
				// ASF No
				Element AsylumSupportFinding = getElementWithDefaultNamespace("AsylumSupportFunding");
				// LegalAid.addContent("No");
				AAIC.addContent(AsylumSupportFinding);

				Attribute ASF = new Attribute("ASF", "no");
				AsylumSupportFinding.setAttribute(ASF);

			}
			if (frm.getQb_lsc().equals("Section 17")) {
				// Asylum Support

				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensAct");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent(frm.getQb_LAR());
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "yes");
				ChildrensAct.setAttribute(ChildrensActs);

			} else {
				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensAct");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent("");
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "no");
				ChildrensAct.setAttribute(ChildrensActs);
			}

			// Childrens Act

			Element ApplicationDetails = getElementWithDefaultNamespace("ApplicationDetails");
			// ApplicationDetails.addContent("1.0");
			AAIC.addContent(ApplicationDetails);

			Attribute AppealType = new Attribute("AppealType", "IAFT-7");
			ApplicationDetails.setAttribute(AppealType);

			Element SubmissionDate = getElementWithDefaultNamespace("SubmissionDate");
			SubmissionDate.addContent(sdf.format(new Date()));
			ApplicationDetails.addContent(SubmissionDate);

			Element SubmissionURN = getElementWithDefaultNamespace("SubmissionURN");
			SubmissionURN.addContent(frm.getSubmissionURN());
			ApplicationDetails.addContent(SubmissionURN);

			Element PaymentRemissionRequested = getElementWithDefaultNamespace("PaymentRemissionRequested");
			PaymentRemissionRequested.addContent("no");
			ApplicationDetails.addContent(PaymentRemissionRequested);

			if (frm.getQb_lsc() != null) {
				if (frm.getQb_lsc().equals("LSC")) {

					// LegalAId
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Element LegalAidReferenceNumber = getElementWithDefaultNamespace("LegalAidReferenceNumber");
					LegalAidReferenceNumber.addContent(frm.getQb_LAR());
					LegalAid.addContent(LegalAidReferenceNumber);

					Attribute LSF = new Attribute("LegalAid", "yes");

					LegalAid.setAttribute(LSF);

					// asylum support

				} else {
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Attribute LSF = new Attribute("LegalAid", "no");

					LegalAid.setAttribute(LSF);

				}
			}
			Element HearingType = getElementWithDefaultNamespace("HearingType");
			if (frm.getAppeal_type().equals("Oral")) {
				HearingType.addContent("oral");
			} else {
				HearingType.addContent("paper");
			}
			ApplicationDetails.addContent(HearingType);

			// Payment details
			if (frm.getAggregatedpaymentURN() != null && frm.getQb_lsc().equals("No") && frm.getPaymentvalue() != 0) {

				Element PaymentDetails = getElementWithDefaultNamespace("PaymentDetails");
				// LegalAid.addContent("No");
				AAIC.addContent(PaymentDetails);

				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				PaymentDetails.addContent(AggregatedPaymentURN);
			}

			/*
			 * <AppellantDetails> <FamilyName>string</FamilyName>
			 * <GivenName>string</GivenName> <Title>string</Title> <Address>
			 * <Line>string</Line> <Country /> <PostCode /> </Address>
			 * </AppellantDetails>
			 */

			// Appellant Details

			Element AppellantDetails = getElementWithDefaultNamespace("AppellantDetails");
			// LegalAid.addContent("No");
			AAIC.addContent(AppellantDetails);

			Element FamilyName = getElementWithDefaultNamespace("FamilyName");
			FamilyName.addContent(frm.getS1a());
			AppellantDetails.addContent(FamilyName);

			Element GivenName = getElementWithDefaultNamespace("GivenName");
			GivenName.addContent(frm.getS1b());
			AppellantDetails.addContent(GivenName);

			Element Title = getElementWithDefaultNamespace("Title");
			Title.addContent(frm.getS1c());
			AppellantDetails.addContent(Title);

			Element Address = getElementWithDefaultNamespace("Address");
			// LegalAid.addContent("No");
			AppellantDetails.addContent(Address);
			try {
				if (!frm.getS1f_addr1().equals("") && frm.getS1f_addr1() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr1());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				if (!frm.getS1f_addr2().equals("") && frm.getS1f_addr2() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr2());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				// logger.debug("???"+frm.getS1f_addr3().trim().equals("")+"??");
				if (!frm.getS1f_addr3().equals("") && frm.getS1f_addr3() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr3());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}

			/*
			 * if(frm.getS1f_addr4()!=" " || frm.getS1f_addr4()!=null) { Element
			 * Line= getElementWithDefaultNamespace("Line");
			 * Line.addContent(frm.getS1f_addr4()); Address.addContent(Line);
			 *
			 * }
			 */
			try {
				if (!frm.getS1f_addr4().equals("") && frm.getS1f_addr4() != null) {
					Element Country = getElementWithDefaultNamespace("Country");
					Country.addContent(Helper.returnIntegerValue(frm.getS1f_addr4()));
					Address.addContent(Country);
				}
			} catch (Exception e) {

			}
			Element PostCode = getElementWithDefaultNamespace("PostCode");
			PostCode.addContent(frm.getS1f_postcode());
			Address.addContent(PostCode);


			if (!frm.getS1f_email().equals("") && frm.getS1f_email() != null) {
			Element email = getElementWithDefaultNamespace("Email");
			// LegalAid.addContent("No");
			email.addContent(frm.getS1f_email());
			AppellantDetails.addContent(email);
			}


			Element DateOfBirth = getElementWithDefaultNamespace("DateOfBirth");
			// logger.debug(">>.............."+sdf.format(sdf.parse(frm.getS1d_dob_year()+"-"+frm.getS1d_dob_month()+"-"+frm.getS1d_dob_day())));
			DateOfBirth.addContent(sdf.format(sdf.parse(frm.getS1d_dob_year() + "-" + frm.getS1d_dob_month() + "-"
					+ frm.getS1d_dob_day())));
			AAIC.addContent(DateOfBirth);

			Element Detained = getElementWithDefaultNamespace("Detained");
			// LegalAid.addContent("No");
			AAIC.addContent(Detained);

			Element Nationality = getElementWithDefaultNamespace("Nationality");
			Nationality.addContent(Helper.returnIntegerValue(frm.getS1h()));
			AAIC.addContent(Nationality);

			Element Interpreter = getElementWithDefaultNamespace("Interpreter");
			if (frm.getS1j().equals("Yes")) {
				Interpreter.addContent("yes");
			} else {
				Interpreter.addContent("no");

			}
			AAIC.addContent(Interpreter);

			// Element DetainedReferenceNumber = new
			// Element("PrisonReferenceNumber");
			// DetainedReferenceNumber.addContent(frm.getS1g());
			// Detained.addContent(DetainedReferenceNumber);

			// Home Office Details

			/*
			 * <HomeOfficeDecision> <HomeOfficeRefNo>string</HomeOfficeRefNo>
			 * <PortReferenceNo>string</PortReferenceNo>
			 * <COHIDRefNo>string</COHIDRefNo>
			 * <PointsBasedRefusal>no</PointsBasedRefusal>
			 * <DateOfApplicationDecision>2006-12-20</DateOfApplicationDecision>
			 * </HomeOfficeDecision>
			 *
			 * V22 Schemae
			 * <xsd:element name="HomeOfficeANRefNo" type="HomeOfficeANReferenceType" minOccurs="0"/>
			<xsd:element name="PortReferenceNo" type="PortReferenceType" minOccurs="0"/>
			<xsd:element name="COHIDRefNo" type="COHIDReferenceType" minOccurs="0"/>
			<xsd:element name="PointsBasedRefusal" type="YesNoType"/>
			<xsd:element name="DateOfApplicationDecision" type="DateType"/>
			<xsd:element name="DateApplicationLodged" type="DateType" minOccurs="0"/>
			<xsd:element name="HomeOfficeWaiver" type="YesNoType" minOccurs="0"/>
			 */

			Element HomeOfficeDecision = getElementWithDefaultNamespace("HomeOfficeDecision");
			// LegalAid.addContent("No");
			AAIC.addContent(HomeOfficeDecision);
            if(frm.getS2a().length()>1)
            {
			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeRefNo");
			HomeOfficeRefNo.addContent(frm.getS2a());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }
            if(frm.getS2hoan().length()>1)
            {
			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeANRefNo");
			HomeOfficeRefNo.addContent(frm.getS2hoan());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }

			Element PortReferenceNo = getElementWithDefaultNamespace("PortReferenceNo");
			PortReferenceNo.addContent(frm.getS2b());
			HomeOfficeDecision.addContent(PortReferenceNo);

			if(frm.getS2c().length()>1)
            {

			Element COHIDRefNo = getElementWithDefaultNamespace("COHIDRefNo");
			COHIDRefNo.addContent(frm.getS2c());
			HomeOfficeDecision.addContent(COHIDRefNo);
            }
			Element PointsBasedRefusal = getElementWithDefaultNamespace("PointsBasedRefusal");
			PointsBasedRefusal.addContent("no");
			HomeOfficeDecision.addContent(PointsBasedRefusal);

			Element DateOfApplicationDecision = getElementWithDefaultNamespace("DateOfApplicationDecision");
			DateOfApplicationDecision.addContent(sdf.format(sdf.parse(frm.getS2e_service_year() + "-"
					+ frm.getS2e_service_month() + "-" + frm.getS2e_service_day())));
			HomeOfficeDecision.addContent(DateOfApplicationDecision);
			if(frm.getS2j_service_year()>0)
            {
				Element dateapplicationlodged = getElementWithDefaultNamespace("DateApplicationLodged");
				dateapplicationlodged.addContent(sdf.format(sdf.parse(frm.getS2j_service_year() + "-"
						+ frm.getS2j_service_month() + "-" + frm.getS2j_service_day())));
				HomeOfficeDecision.addContent(dateapplicationlodged);

            }
			if(frm.getQb_lsc().equals("homeofficewaiver"))
			{
			Element homeofficewaiver = getElementWithDefaultNamespace("HomeOfficeWaiver");
			homeofficewaiver.addContent("yes");
			HomeOfficeDecision.addContent(homeofficewaiver);
			}
			// Appeal

			Element Appeal = getElementWithDefaultNamespace("Appeal");
			// LegalAid.addContent("No");
			AAIC.addContent(Appeal);

			//*********************************Late Appeal Removed.

			/*Element LateAppeal = getElementWithDefaultNamespace("LateAppeal");
			if (frm.getS3a() != null) {
				if (frm.getS3a().length() >= 2) {
					LateAppeal.addContent("yes");
				} else {
					LateAppeal.addContent("no");
				}

			}

			else {
				LateAppeal.addContent("no");
			}

			Appeal.addContent(LateAppeal);
             */
			Element AdditionalDocuments = getElementWithDefaultNamespace("AdditionalDocuments");
			if (frm.getS3b() != null && frm.getS3b().length() >= 2) {
				AdditionalDocuments.addContent("yes");
			} else {
				AdditionalDocuments.addContent("no");

			}
			Appeal.addContent(AdditionalDocuments);

			Element AdditionalDocumentsLater = getElementWithDefaultNamespace("AdditionalDocumentsLater");
			if (frm.getS3c() != null && frm.getS3c().length() >= 2) {
				AdditionalDocumentsLater.addContent("yes");
			} else {
				AdditionalDocumentsLater.addContent("no");

			}

			Appeal.addContent(AdditionalDocumentsLater);

			// Representative details
			/*
			 * <Representative> <RepresentativeName>string</RepresentativeName>
			 * <RepresentativeOrganisation>string</RepresentativeOrganisation> -
			 * <RepresentativeAddress> <Line>string</Line> <Country /> <PostCode
			 * /> </RepresentativeAddress>
			 * <RepresentativeReference>string</RepresentativeReference> -
			 * <RepresentativeContactDetails> <PhoneNumber>string</PhoneNumber>
			 * <MobileNumber>string</MobileNumber> <FaxNumber>string</FaxNumber>
			 * <EmailAddress>string</EmailAddress>
			 * </RepresentativeContactDetails>
			 * <LSCCommission>string</LSCCommission> </Representative>
			 */
			// logger.debug((frm.getS5a()!=null &&
			// !frm.getS5a().trim().equals(""))+">>>>>>>"+(frm.getS5b()!=null &&
			// !frm.getS5b().trim().equals("0")));
			if ((frm.getS5a() != null && !frm.getS5a().trim().equals(""))
					|| (frm.getS5b() != null && !frm.getS5b().trim().equals("0"))) {
				Element Representative = getElementWithDefaultNamespace("Representative");
				// LegalAid.addContent("No");
				AAIC.addContent(Representative);
				logger.debug("rep"+frm.getS5b());
				if (frm.getS5b().trim().equals("00")&&frm.getS5b_other()!=null &&!frm.getS5b_other().equals("")) {
					logger.debug("rep"+frm.getS5b_other());
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5b_other());
					Representative.addContent(RepresentativeName);
				}

				else if (!frm.getS5b().trim().equals("0")&&!frm.getS5b().trim().equals("00")) {
					logger.debug("rep");
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(Helper.returnIntegerValue(frm.getS5b()));
					Representative.addContent(RepresentativeName);

				}
				else {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5a());
					Representative.addContent(RepresentativeName);
				}
				Element RAddress = getElementWithDefaultNamespace("RepresentativeAddress");
				// LegalAid.addContent("No");
				Representative.addContent(RAddress);
				try {
					if (!frm.getS5c_addr1().trim().equals("") && frm.getS5c_addr1() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr1());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr2().trim().equals("") && frm.getS5c_addr2() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr2());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr3().trim().equals("") && frm.getS5c_addr3() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr3());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS1f_addr4().trim().equals("") && frm.getS1f_addr4() != null) {
						Element Country = getElementWithDefaultNamespace("Country");
						Country.addContent(Helper.returnIntegerValue(frm.getS5c_addr4()));
						RAddress.addContent(Country);
					}
				} catch (Exception e) {

				}

				Element RPostCode = getElementWithDefaultNamespace("PostCode");
				RPostCode.addContent(frm.getS5c_postcode());
				RAddress.addContent(RPostCode);

				Element RepresentativeReference = getElementWithDefaultNamespace("RepresentativeReference");
				RepresentativeReference.addContent(frm.getS5d());
				Representative.addContent(RepresentativeReference);

				Element RContact = getElementWithDefaultNamespace("RepresentativeContactDetails");
				// LegalAid.addContent("No");
				Representative.addContent(RContact);
				if (!frm.getS5e().trim().equals("") && frm.getS5e() != null) {
					Element PhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
					PhoneNumber.addContent(frm.getS5e());
					RContact.addContent(PhoneNumber);
				}
				if (!frm.getS5f().trim().equals("") && frm.getS5f() != null) {
					Element MobileNumber = getElementWithDefaultNamespace("MobileNumber");
					MobileNumber.addContent(frm.getS5f());
					RContact.addContent(MobileNumber);
				}
				if (!frm.getS5g().trim().equals("") && frm.getS5g() != null) {
					Element FaxNumber = getElementWithDefaultNamespace("FaxNumber");
					FaxNumber.addContent(frm.getS5g());
					RContact.addContent(FaxNumber);
				}
				if (!frm.getS5h().trim().equals("") && frm.getS5h() != null) {
					Element Email = getElementWithDefaultNamespace("EmailAddress");
					Email.addContent(frm.getS5h());
					RContact.addContent(Email);
				}
				if (!frm.getS5j().trim().equals("0") && frm.getS5j() != null) {
					Element LSCCommission = getElementWithDefaultNamespace("LSCCommission");
					LSCCommission.addContent(frm.getS5j());
					Representative.addContent(LSCCommission);
				}

			}

			root.addNamespaceDeclaration(nm2);

			doc.setRootElement(root);

			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocNewAppeal", ex);
		}
		return doc;
	}
	/**IAFT1
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocNewAppeal(IAFT1Bean frm) {
		Document doc = new Document();
		try {
			Element root = getElementWithDefaultNamespace("NewAppeal");

			/*
			 * Attribute xmlns=new
			 * Attribute("xmlns","http://www.justice.gov.uk/IACFEES");
			 * root.setAttribute(xmlns); Attribute xmlnsxsi=new
			 * Attribute("xmlns:xsi"
			 * ,"http://www.w3.org/2001/XMLSchema-instance");
			 * root.setAttribute(xmlnsxsi);
			 */

			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);
			// root.appendChild(title);
			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("NEW APPEAL");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("IAFT-1");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("IAFT-1");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			// logger.debug(sdf.format(new Date()));
			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);

			// int i=0;
			// logger.debug(""+list.size());

			Element naa = getElementWithDefaultNamespace("NewAppealApplications");
			root.addContent(naa);

			Element AAIC = getElementWithDefaultNamespace("AppealAgainstInCountryDecision");
			naa.addContent(AAIC);

			if (frm.getQb_lsc().equals("Asylum Support")) {
				// Asylum Support
				Element AsylumSupportFinding = getElementWithDefaultNamespace("AsylumSupportFunding");
				// LegalAid.addContent("No");
				AAIC.addContent(AsylumSupportFinding);

				Element AsylumSupportReferenceNumber = getElementWithDefaultNamespace("ASFReferenceNumber");
				AsylumSupportReferenceNumber.addContent(frm.getQb_LAR());
				AsylumSupportFinding.addContent(AsylumSupportReferenceNumber);

				Attribute ASF = new Attribute("ASF", "yes");
				AsylumSupportFinding.setAttribute(ASF);

			} else {
				// ASF No
				Element AsylumSupportFinding = getElementWithDefaultNamespace("AsylumSupportFunding");
				// LegalAid.addContent("No");
				AAIC.addContent(AsylumSupportFinding);

				Attribute ASF = new Attribute("ASF", "no");
				AsylumSupportFinding.setAttribute(ASF);

			}
			if (frm.getQb_lsc().equals("Section 17")) {
				// Asylum Support

				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensAct");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent(frm.getQb_LAR());
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "yes");
				ChildrensAct.setAttribute(ChildrensActs);

			} else {
				Element ChildrensAct = getElementWithDefaultNamespace("ChildrensAct");
				// LegalAid.addContent("No");
				AAIC.addContent(ChildrensAct);

				Element ChildrensActReferenceNumber = getElementWithDefaultNamespace("ChildrensActReference");
				ChildrensActReferenceNumber.addContent("");
				ChildrensAct.addContent(ChildrensActReferenceNumber);

				Attribute ChildrensActs = new Attribute("ChildrensAct", "no");
				ChildrensAct.setAttribute(ChildrensActs);
			}

			// Childrens Act

			Element ApplicationDetails = getElementWithDefaultNamespace("ApplicationDetails");
			// ApplicationDetails.addContent("1.0");
			AAIC.addContent(ApplicationDetails);

			Attribute AppealType = new Attribute("AppealType", "IAFT-1");
			ApplicationDetails.setAttribute(AppealType);

			Element SubmissionDate = getElementWithDefaultNamespace("SubmissionDate");
			SubmissionDate.addContent(sdf.format(new Date()));
			ApplicationDetails.addContent(SubmissionDate);

			Element SubmissionURN = getElementWithDefaultNamespace("SubmissionURN");
			SubmissionURN.addContent(frm.getSubmissionURN());
			ApplicationDetails.addContent(SubmissionURN);

			Element PaymentRemissionRequested = getElementWithDefaultNamespace("PaymentRemissionRequested");
			PaymentRemissionRequested.addContent("no");
			ApplicationDetails.addContent(PaymentRemissionRequested);

			if (frm.getQb_lsc() != null) {
				if (frm.getQb_lsc().equals("LSC")) {

					// LegalAId
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Element LegalAidReferenceNumber = getElementWithDefaultNamespace("LegalAidReferenceNumber");
					LegalAidReferenceNumber.addContent(frm.getQb_LAR());
					LegalAid.addContent(LegalAidReferenceNumber);

					Attribute LSF = new Attribute("LegalAid", "yes");

					LegalAid.setAttribute(LSF);

					// asylum support

				} else {
					Element LegalAid = getElementWithDefaultNamespace("LegalAid");
					// LegalAid.addContent("No");
					ApplicationDetails.addContent(LegalAid);

					Attribute LSF = new Attribute("LegalAid", "no");

					LegalAid.setAttribute(LSF);

				}
			}
			Element HearingType = getElementWithDefaultNamespace("HearingType");
			if (frm.getAppeal_type().equals("Oral")) {
				HearingType.addContent("oral");
			} else {
				HearingType.addContent("paper");
			}
			ApplicationDetails.addContent(HearingType);

			// Payment details
			if (frm.getAggregatedpaymentURN() != null && frm.getQb_lsc().equals("No") && frm.getPaymentvalue() != 0) {

				Element PaymentDetails = getElementWithDefaultNamespace("PaymentDetails");
				// LegalAid.addContent("No");
				AAIC.addContent(PaymentDetails);

				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				PaymentDetails.addContent(AggregatedPaymentURN);
			}

			/*
			 * <AppellantDetails> <FamilyName>string</FamilyName>
			 * <GivenName>string</GivenName> <Title>string</Title> <Address>
			 * <Line>string</Line> <Country /> <PostCode /> </Address>
			 * </AppellantDetails>
			 */

			// Appellant Details

			Element AppellantDetails = getElementWithDefaultNamespace("AppellantDetails");
			// LegalAid.addContent("No");
			AAIC.addContent(AppellantDetails);

			Element FamilyName = getElementWithDefaultNamespace("FamilyName");
			FamilyName.addContent(frm.getS1a());
			AppellantDetails.addContent(FamilyName);

			Element GivenName = getElementWithDefaultNamespace("GivenName");
			GivenName.addContent(frm.getS1b());
			AppellantDetails.addContent(GivenName);

			Element Title = getElementWithDefaultNamespace("Title");
			Title.addContent(frm.getS1c());
			AppellantDetails.addContent(Title);

			Element Address = getElementWithDefaultNamespace("Address");
			// LegalAid.addContent("No");
			AppellantDetails.addContent(Address);
			try {
				if (!frm.getS1f_addr1().equals("") && frm.getS1f_addr1() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr1());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				if (!frm.getS1f_addr2().equals("") && frm.getS1f_addr2() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr2());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}
			try {
				// logger.debug("???"+frm.getS1f_addr3().trim().equals("")+"??");
				if (!frm.getS1f_addr3().equals("") && frm.getS1f_addr3() != null) {
					Element Line = getElementWithDefaultNamespace("Line");
					Line.addContent(frm.getS1f_addr3());
					Address.addContent(Line);

				}
			} catch (Exception e) {

			}

			/*
			 * if(frm.getS1f_addr4()!=" " || frm.getS1f_addr4()!=null) { Element
			 * Line= getElementWithDefaultNamespace("Line");
			 * Line.addContent(frm.getS1f_addr4()); Address.addContent(Line);
			 *
			 * }
			 */
			try {
				if (!frm.getS1f_addr4().equals("") && frm.getS1f_addr4() != null) {
					Element Country = getElementWithDefaultNamespace("Country");
					Country.addContent(Helper.returnIntegerValue(frm.getS1f_addr4()));
					Address.addContent(Country);
				}
			} catch (Exception e) {

			}
			Element PostCode = getElementWithDefaultNamespace("PostCode");
			PostCode.addContent(frm.getS1f_postcode());
			Address.addContent(PostCode);

			if(null!=frm.getS1f_email())
			{
			if (!frm.getS1f_email().equals("") && frm.getS1f_email() != null) {
			Element email = getElementWithDefaultNamespace("Email");
			// LegalAid.addContent("No");
			email.addContent(frm.getS1f_email());
			AppellantDetails.addContent(email);
			}
			}

			Element DateOfBirth = getElementWithDefaultNamespace("DateOfBirth");
			// logger.debug(">>.............."+sdf.format(sdf.parse(frm.getS1d_dob_year()+"-"+frm.getS1d_dob_month()+"-"+frm.getS1d_dob_day())));
			DateOfBirth.addContent(sdf.format(sdf.parse(frm.getS1d_dob_year() + "-" + frm.getS1d_dob_month() + "-"
					+ frm.getS1d_dob_day())));
			AAIC.addContent(DateOfBirth);

			Element Detained = getElementWithDefaultNamespace("Detained");
			// LegalAid.addContent("No");
			AAIC.addContent(Detained);

			Element Nationality = getElementWithDefaultNamespace("Nationality");
			Nationality.addContent(Helper.returnIntegerValue(frm.getS1h()));
			AAIC.addContent(Nationality);

			Element Interpreter = getElementWithDefaultNamespace("Interpreter");
			if (frm.getS1j().equals("Yes")) {
				Interpreter.addContent("yes");
			} else {
				Interpreter.addContent("no");

			}
			AAIC.addContent(Interpreter);

			// Element DetainedReferenceNumber = new
			// Element("PrisonReferenceNumber");
			// DetainedReferenceNumber.addContent(frm.getS1g());
			// Detained.addContent(DetainedReferenceNumber);

			// Home Office Details

			/*
			 * <HomeOfficeDecision> <HomeOfficeRefNo>string</HomeOfficeRefNo>
			 * <PortReferenceNo>string</PortReferenceNo>
			 * <COHIDRefNo>string</COHIDRefNo>
			 * <PointsBasedRefusal>no</PointsBasedRefusal>
			 * <DateOfApplicationDecision>2006-12-20</DateOfApplicationDecision>
			 * </HomeOfficeDecision>
			 */

			Element HomeOfficeDecision = getElementWithDefaultNamespace("HomeOfficeDecision");
			// LegalAid.addContent("No");
			AAIC.addContent(HomeOfficeDecision);
            if(frm.getS2a().length()>1)
            {
			Element HomeOfficeRefNo = getElementWithDefaultNamespace("HomeOfficeRefNo");
			HomeOfficeRefNo.addContent(frm.getS2a());
			HomeOfficeDecision.addContent(HomeOfficeRefNo);
            }
			Element PortReferenceNo = getElementWithDefaultNamespace("PortReferenceNo");
			PortReferenceNo.addContent(frm.getS2b());
			HomeOfficeDecision.addContent(PortReferenceNo);

			if(frm.getS2c().length()>1)
            {

			Element COHIDRefNo = getElementWithDefaultNamespace("COHIDRefNo");
			COHIDRefNo.addContent(frm.getS2c());
			HomeOfficeDecision.addContent(COHIDRefNo);
            }
			Element PointsBasedRefusal = getElementWithDefaultNamespace("PointsBasedRefusal");
			PointsBasedRefusal.addContent("no");
			HomeOfficeDecision.addContent(PointsBasedRefusal);

			Element DateOfApplicationDecision = getElementWithDefaultNamespace("DateOfApplicationDecision");
			DateOfApplicationDecision.addContent(sdf.format(sdf.parse(frm.getS2e_service_year() + "-"
					+ frm.getS2e_service_month() + "-" + frm.getS2e_service_day())));
			HomeOfficeDecision.addContent(DateOfApplicationDecision);

			// Appeal

			Element Appeal = getElementWithDefaultNamespace("Appeal");
			// LegalAid.addContent("No");
			AAIC.addContent(Appeal);

			//*********************************Late Appeal Removed.

			/*Element LateAppeal = getElementWithDefaultNamespace("LateAppeal");
			if (frm.getS3a() != null) {
				if (frm.getS3a().length() >= 2) {
					LateAppeal.addContent("yes");
				} else {
					LateAppeal.addContent("no");
				}

			}

			else {
				LateAppeal.addContent("no");
			}

			Appeal.addContent(LateAppeal);
             */
			Element AdditionalDocuments = getElementWithDefaultNamespace("AdditionalDocuments");
			if (frm.getS3b() != null && frm.getS3b().length() >= 2) {
				AdditionalDocuments.addContent("yes");
			} else {
				AdditionalDocuments.addContent("no");

			}
			Appeal.addContent(AdditionalDocuments);

			Element AdditionalDocumentsLater = getElementWithDefaultNamespace("AdditionalDocumentsLater");
			if (frm.getS3c() != null && frm.getS3c().length() >= 2) {
				AdditionalDocumentsLater.addContent("yes");
			} else {
				AdditionalDocumentsLater.addContent("no");

			}

			Appeal.addContent(AdditionalDocumentsLater);

			// Representative details
			/*
			 * <Representative> <RepresentativeName>string</RepresentativeName>
			 * <RepresentativeOrganisation>string</RepresentativeOrganisation> -
			 * <RepresentativeAddress> <Line>string</Line> <Country /> <PostCode
			 * /> </RepresentativeAddress>
			 * <RepresentativeReference>string</RepresentativeReference> -
			 * <RepresentativeContactDetails> <PhoneNumber>string</PhoneNumber>
			 * <MobileNumber>string</MobileNumber> <FaxNumber>string</FaxNumber>
			 * <EmailAddress>string</EmailAddress>
			 * </RepresentativeContactDetails>
			 * <LSCCommission>string</LSCCommission> </Representative>
			 */
			// logger.debug((frm.getS5a()!=null &&
			// !frm.getS5a().trim().equals(""))+">>>>>>>"+(frm.getS5b()!=null &&
			// !frm.getS5b().trim().equals("0")));
			if ((frm.getS5a() != null && !frm.getS5a().trim().equals(""))
					|| (frm.getS5b() != null && !frm.getS5b().trim().equals("0"))) {
				Element Representative = getElementWithDefaultNamespace("Representative");
				// LegalAid.addContent("No");
				AAIC.addContent(Representative);
				logger.debug("rep"+frm.getS5b());
				if (frm.getS5b().trim().equals("00")&&frm.getS5b_other()!=null &&!frm.getS5b_other().equals("")) {
					logger.debug("rep"+frm.getS5b_other());
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5b_other());
					Representative.addContent(RepresentativeName);
				}

				else if (!frm.getS5b().trim().equals("0")&&!frm.getS5b().trim().equals("00")) {
					logger.debug("rep");
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(Helper.returnIntegerValue(frm.getS5b()));
					Representative.addContent(RepresentativeName);

				}
				else {
					Element RepresentativeName = getElementWithDefaultNamespace("RepresentativeName");
					RepresentativeName.addContent(frm.getS5a());
					Representative.addContent(RepresentativeName);
				}
				Element RAddress = getElementWithDefaultNamespace("RepresentativeAddress");
				// LegalAid.addContent("No");
				Representative.addContent(RAddress);
				try {
					if (!frm.getS5c_addr1().trim().equals("") && frm.getS5c_addr1() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr1());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr2().trim().equals("") && frm.getS5c_addr2() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr2());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS5c_addr3().trim().equals("") && frm.getS5c_addr3() != null) {
						Element RLine = getElementWithDefaultNamespace("Line");
						RLine.addContent(frm.getS5c_addr3());
						RAddress.addContent(RLine);
					}
				} catch (Exception e) {

				}
				try {
					if (!frm.getS1f_addr4().trim().equals("") && frm.getS1f_addr4() != null) {
						Element Country = getElementWithDefaultNamespace("Country");
						Country.addContent(Helper.returnIntegerValue(frm.getS5c_addr4()));
						RAddress.addContent(Country);
					}
				} catch (Exception e) {

				}

				Element RPostCode = getElementWithDefaultNamespace("PostCode");
				RPostCode.addContent(frm.getS5c_postcode());
				RAddress.addContent(RPostCode);

				Element RepresentativeReference = getElementWithDefaultNamespace("RepresentativeReference");
				RepresentativeReference.addContent(frm.getS5d());
				Representative.addContent(RepresentativeReference);

				Element RContact = getElementWithDefaultNamespace("RepresentativeContactDetails");
				// LegalAid.addContent("No");
				Representative.addContent(RContact);
				if (!frm.getS5e().trim().equals("") && frm.getS5e() != null) {
					Element PhoneNumber = getElementWithDefaultNamespace("PhoneNumber");
					PhoneNumber.addContent(frm.getS5e());
					RContact.addContent(PhoneNumber);
				}
				if (!frm.getS5f().trim().equals("") && frm.getS5f() != null) {
					Element MobileNumber = getElementWithDefaultNamespace("MobileNumber");
					MobileNumber.addContent(frm.getS5f());
					RContact.addContent(MobileNumber);
				}
				if (!frm.getS5g().trim().equals("") && frm.getS5g() != null) {
					Element FaxNumber = getElementWithDefaultNamespace("FaxNumber");
					FaxNumber.addContent(frm.getS5g());
					RContact.addContent(FaxNumber);
				}
				if (!frm.getS5h().trim().equals("") && frm.getS5h() != null) {
					Element Email = getElementWithDefaultNamespace("EmailAddress");
					Email.addContent(frm.getS5h());
					RContact.addContent(Email);
				}
				if (!frm.getS5j().trim().equals("0") && frm.getS5j() != null) {
					Element LSCCommission = getElementWithDefaultNamespace("LSCCommission");
					LSCCommission.addContent(frm.getS5j());
					Representative.addContent(LSCCommission);
				}

			}

			root.addNamespaceDeclaration(nm2);

			doc.setRootElement(root);

			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocNewAppeal", ex);
		}
		return doc;
	}

	/**
	 * Retreive a new element with the default namespace (avoids empty xlmns=""
	 * references appearing) nm1 =
	 * Namespace.getNamespace("http://www.justice.gov.uk/IACFEES");
	 *
	 * @param elementName
	 * @return
	 */
	protected Element getElementWithDefaultNamespace(String elementName) {
		return new Element(elementName, nm1);
	}

	/**
	 * Retreive a new element with the secondary namespace (avoids empty
	 * xlmns="" references appearing) nm2 = Namespace.getNamespace("xsi",
	 * "http://www.w3.org/2001/XMLSchema-instance");
	 *
	 * @param elementName
	 * @return
	 */
	protected Element getElementWithSecondaryNamespace(String elementName) {
		return new Element(elementName, nm2);
	}

	/**
	 *
	 * @param frm
	 * @return
	 */
	protected Document makeDocAggregatedpayment(AggregatedBean frm) {
		try {
			logger.info("DocWriteDOM.makeDocAggregatedpayment - Creating new payment");
			Document doc = new Document();
			Element root = getElementWithDefaultNamespace("AggregatedPayments");
			root.addNamespaceDeclaration(nm2);
			Attribute count = new Attribute("PaymentCount", frm.getCount() + "");
			root.setAttribute(count);

			Element documentid = getElementWithDefaultNamespace("DocumentID");
			root.addContent(documentid);

			Element documentname = getElementWithDefaultNamespace("DocumentName");
			documentname.addContent("AGGREGATED PAYMENT");
			documentid.addContent(documentname);

			Element uniqueid = getElementWithDefaultNamespace("UniqueID");
			uniqueid.addContent("1");
			documentid.addContent(uniqueid);

			Element documenttype = getElementWithDefaultNamespace("DocumentType");
			documenttype.addContent("Aggreagated Payment");
			documentid.addContent(documenttype);

			Element timestamp = getElementWithDefaultNamespace("TimeStamp");
			logger.debug(new Date().toString());

			timestamp.addContent(sdf.format(new Date()) + "T" + sdf1.format(new Date()));
			documentid.addContent(timestamp);

			Element version = getElementWithDefaultNamespace("Version");
			version.addContent("0.23");
			documentid.addContent(version);
			if (frm.getAggregatedpaymentURN() != null) {
				Element AggregatedPaymentURN = getElementWithDefaultNamespace("AggregatedPaymentURN");
				AggregatedPaymentURN.addContent(frm.getAggregatedpaymentURN());
				root.addContent(AggregatedPaymentURN);

				Element AggregatedPaymentValue = getElementWithDefaultNamespace("AggregatedPaymentDate");
				AggregatedPaymentValue.addContent(sdf.format(new Date()));
				root.addContent(AggregatedPaymentValue);
			}
			int frmCount = frm.getCount();
			if (frmCount > 0) {
				for (int i = 1; i <= frmCount; i++) {
					Element topuppayment = getElementWithDefaultNamespace("TopUpPayments");
					root.addContent(topuppayment);
					Element paymentreference = getElementWithDefaultNamespace("PaymentReference");
					paymentreference.addContent(getAggregatedBeanPrn(i, frm));
					topuppayment.addContent(paymentreference);
					Element RelationshipToAppellant = getElementWithDefaultNamespace("RelationshipToAppellant");
					RelationshipToAppellant.addContent(getAggregatedBeanRelationship(i, frm));
					topuppayment.addContent(RelationshipToAppellant);
				}
			}
			doc.setRootElement(root);
			return doc;

		} catch (Exception ex) {
			logger.error("DocWriteDOM.makeDocAggregatedpayment", ex);
			return null;
		}
	}

	/**
	 *
	 * @param pos
	 * @param frm
	 * @return
	 */
	private String getAggregatedBeanRelationship(int pos, AggregatedBean frm) {
		String relationship = "";
		if (pos == 1) {
			relationship = frm.getRelationship1();
		} else if (pos == 2) {
			relationship = frm.getRelationship2();
		} else if (pos == 3) {
			relationship = frm.getRelationship3();
		} else if (pos == 4) {
			relationship = frm.getRelationship4();
		} else if (pos == 5) {
			relationship = frm.getRelationship5();
		}
		return relationship;
	}

	/**
	 *
	 * @param pos
	 * @param frm
	 * @return
	 */
	private String getAggregatedBeanPrn(int pos, AggregatedBean frm) {
		String prn = "";
		if (pos == 1) {
			prn = frm.getPrn1();
		} else if (pos == 2) {
			prn = frm.getPrn2();
		} else if (pos == 3) {
			prn = frm.getPrn3();
		} else if (pos == 4) {
			prn = frm.getPrn4();
		} else if (pos == 5) {
			prn = frm.getPrn5();
		}
		return prn;
	}
}
