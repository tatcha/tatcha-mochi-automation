package com.tatcha.jscripts.dao;

import com.tatcha.jscripts.TcConstants;

public class TestCase {

	private String testNo;
	private String mocNo;
	private String functionality;
	private String status;
	private String remarks;

	public TestCase() {

	}

	public TestCase(String testNo) {
		this.testNo = testNo;
	}

	public TestCase(String testNo, String mocNo, String functionality, String status, String remarks) {

		this.testNo = testNo;
		this.mocNo = mocNo;
		this.functionality = functionality;
		this.status = status;
		this.remarks = remarks;
	}

	public static TestCase getFunctionalityTestCase(String FLOW_ID, String FUN_ID) {
		TestCase testCase = null;

		if (null != FLOW_ID && !FLOW_ID.isEmpty() && null != FUN_ID && !FUN_ID.isEmpty()) {

			testCase = new TestCase(TcConstants.BLANK, TcConstants.BLANK, TcConstants.BLANK, TcConstants.BLANK,
					TcConstants.BLANK);

			/** if else works for @Test Main methods */
			
			if ("FLOW_1".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_1_TC);
				testCase.setMocNo(TcConstants.FLOW_1_MOC);
				testCase.setFunctionality(TcConstants.FLOW_1_FUN);
			} else if ("FLOW_2".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_2_TC);
				testCase.setMocNo(TcConstants.FLOW_2_MOC);
				testCase.setFunctionality(TcConstants.FLOW_2_FUN);
			} else if ("FLOW_3".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_3_TC);
				testCase.setMocNo(TcConstants.FLOW_3_MOC);
				testCase.setFunctionality(TcConstants.FLOW_3_FUN);
			} else if ("FLOW_4".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_4_TC);
				testCase.setMocNo(TcConstants.FLOW_4_MOC);
				testCase.setFunctionality(TcConstants.FLOW_4_FUN);
			} else if ("FLOW_5".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_5_TC);
				testCase.setMocNo(TcConstants.FLOW_5_MOC);
				testCase.setFunctionality(TcConstants.FLOW_5_FUN);
			} else if ("FLOW_6".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_6_TC);
				testCase.setMocNo(TcConstants.FLOW_6_MOC);
				testCase.setFunctionality(TcConstants.FLOW_6_FUN);
			} else if ("FLOW_7".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_7_TC);
				testCase.setMocNo(TcConstants.FLOW_7_MOC);
				testCase.setFunctionality(TcConstants.FLOW_7_FUN);
			} else if ("FLOW_8".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_8_TC);
				testCase.setMocNo(TcConstants.FLOW_8_MOC);
				testCase.setFunctionality(TcConstants.FLOW_8_FUN);
			} else if ("FLOW_9".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_9_TC);
				testCase.setMocNo(TcConstants.FLOW_9_MOC);
				testCase.setFunctionality(TcConstants.FLOW_9_FUN);
			} else if ("FLOW_10".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_10_TC);
				testCase.setMocNo(TcConstants.FLOW_10_MOC);
				testCase.setFunctionality(TcConstants.FLOW_10_FUN);
			} else if ("FLOW_11".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_11_TC);
				testCase.setMocNo(TcConstants.FLOW_11_MOC);
				testCase.setFunctionality(TcConstants.FLOW_11_FUN);
			} else if ("FLOW_12".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_12_TC);
				testCase.setMocNo(TcConstants.FLOW_12_MOC);
				testCase.setFunctionality(TcConstants.FLOW_12_FUN);
			} else if ("FLOW_13".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_13_TC);
				testCase.setMocNo(TcConstants.FLOW_13_MOC);
				testCase.setFunctionality(TcConstants.FLOW_13_FUN);
			} else if ("FLOW_14".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_14_TC);
				testCase.setMocNo(TcConstants.FLOW_14_MOC);
				testCase.setFunctionality(TcConstants.FLOW_14_FUN);
			} else if ("FLOW_15".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_15_TC);
				testCase.setMocNo(TcConstants.FLOW_15_MOC);
				testCase.setFunctionality(TcConstants.FLOW_15_FUN);
			} else if ("FLOW_16".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_16_TC);
				testCase.setMocNo(TcConstants.FLOW_16_MOC);
				testCase.setFunctionality(TcConstants.FLOW_16_FUN);
			} else if ("FLOW_17".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_17_TC);
				testCase.setMocNo(TcConstants.FLOW_17_MOC);
				testCase.setFunctionality(TcConstants.FLOW_17_FUN);
			} else if ("FLOW_18".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_18_TC);
				testCase.setMocNo(TcConstants.FLOW_18_MOC);
				testCase.setFunctionality(TcConstants.FLOW_18_FUN);
			} else if ("FLOW_19".equalsIgnoreCase(FLOW_ID)) {
				testCase.setTestNo(TcConstants.FLOW_19_TC);
				testCase.setMocNo(TcConstants.FLOW_19_MOC);
				testCase.setFunctionality(TcConstants.FLOW_19_FUN);
			}
			
			/** switch case works for nested Test case methods */

			switch (FUN_ID) {

			/** LOGIN */
			case "FUN_CL":
				testCase.setFunctionality(TcConstants.FUN_CL);
				break;
			case "FUN_CG":
				testCase.setFunctionality(TcConstants.FUN_CG);
				break;
			case "FUN_L":
				testCase.setFunctionality(TcConstants.FUN_L);
				break;

			/** MY ACCOUNT */
			case "FUN_VAB":
				testCase.setFunctionality(TcConstants.FUN_VAB);
				break;
			case "FUN_AAD":
				testCase.setFunctionality(TcConstants.FUN_AAD);
				break;
			case "FUN_PAB":
				testCase.setFunctionality(TcConstants.FUN_PAB);
				break;
			case "FUN_RAD":
				testCase.setFunctionality(TcConstants.FUN_RAD);
				break;
			case "FUN_CPW":
				testCase.setFunctionality(TcConstants.FUN_CPW);
				break;
			case "FUN_CEM":
				testCase.setFunctionality(TcConstants.FUN_CEM);
				break;
			case "FUN_EPR":
				testCase.setFunctionality(TcConstants.FUN_EPR);
				break;
			case "FUN_VOH":
				testCase.setFunctionality(TcConstants.FUN_VOH);
				break;
			case "FUN_VOD":
				testCase.setFunctionality(TcConstants.FUN_VOD);
				break;

			/** BAG */
			case "FUN_ASP":
				testCase.setFunctionality(TcConstants.FUN_ASP);
				break;
			case "FUN_AGC":
				testCase.setFunctionality(TcConstants.FUN_AGC);
				break;
			case "FUN_APC":
				testCase.setFunctionality(TcConstants.FUN_APC);
				break;
			case "FUN_UIQ":
				testCase.setFunctionality(TcConstants.FUN_UIQ);
				break;

			case "FUN_VSB":
				testCase.setFunctionality(TcConstants.FUN_VSB);
				break;
			case "FUN_VSA":
				testCase.setFunctionality(TcConstants.FUN_VSA);
				break;
			case "FUN_VPD":
				testCase.setFunctionality(TcConstants.FUN_VPD);
				break;
			case "FUN_VGW":
				testCase.setFunctionality(TcConstants.FUN_VGW);
				break;
			case "FUN_VSM":
				testCase.setFunctionality(TcConstants.FUN_VSM);
				break;
			case "FUN_VPSM":
				testCase.setFunctionality(TcConstants.FUN_VPSM);
				break;
			case "FUN_VPR":
				testCase.setFunctionality(TcConstants.FUN_VPR);
				break;

			/** SHIPPING */
			case "FUN_VSHA":
				testCase.setFunctionality(TcConstants.FUN_VSHA);
				break;
			case "FUN_VSHA2":
				testCase.setFunctionality(TcConstants.FUN_VSHA2);
				break;
			case "FUN_VSHA3":
				testCase.setFunctionality(TcConstants.FUN_VSHA3);
				break;
			case "FUN_VSHA4":
				testCase.setFunctionality(TcConstants.FUN_VSHA4);
				break;

			case "FUN_SSHO":
				testCase.setFunctionality(TcConstants.FUN_SSHO);
				break;

			case "FUN_AFSHA":
				testCase.setFunctionality(TcConstants.FUN_AFSHA);
				break;
			case "FUN_ASHA":
				testCase.setFunctionality(TcConstants.FUN_ASHA);
				break;
			case "FUN_SSHA":
				testCase.setFunctionality(TcConstants.FUN_SSHA);
				break;

			/** PAYMENT */
			case "FUN_PY":
				testCase.setFunctionality(TcConstants.FUN_PY);
				break;
			case "FUN_EPY":
				testCase.setFunctionality(TcConstants.FUN_EPY);
				break;
			case "FUN_EPB":
				testCase.setFunctionality(TcConstants.FUN_EPB);
				break;
			case "FUN_REP":
				testCase.setFunctionality(TcConstants.FUN_REP);
				break;
			case "FUN_RPY":
				testCase.setFunctionality(TcConstants.FUN_RPY);
				break;

			case "FUN_AFCC":
				testCase.setFunctionality(TcConstants.FUN_AFCC);
				break;
			case "FUN_ACC":
				testCase.setFunctionality(TcConstants.FUN_ACC);
				break;
			case "FUN_SCC":
				testCase.setFunctionality(TcConstants.FUN_SCC);
				break;

			case "FUN_AGCD":
				testCase.setFunctionality(TcConstants.FUN_AGCD);
				break;
			case "FUN_CGCB":
				testCase.setFunctionality(TcConstants.FUN_CGCB);
				break;
			case "FUN_RGCD":
				testCase.setFunctionality(TcConstants.FUN_RGCD);
				break;

			case "FUN_BA":
				testCase.setFunctionality(TcConstants.FUN_BA);
				break;
			case "FUN_ABA":
				testCase.setFunctionality(TcConstants.FUN_ABA);
				break;
			case "FUN_SBA":
				testCase.setFunctionality(TcConstants.FUN_SBA);
				break;

			case "FUN_VPO":
				testCase.setFunctionality(TcConstants.FUN_VPO);
				break;
			case "FUN_VPO2":
				testCase.setFunctionality(TcConstants.FUN_VPO2);
				break;

			/** CONFIRMATION */
			case "FUN_VOC":
				testCase.setFunctionality(TcConstants.FUN_VOC);
				break;

			/** REVIEW */
			case "FUN_SH":
				testCase.setFunctionality(TcConstants.FUN_SH);
				break;
			case "FUN_RSH":
				testCase.setFunctionality(TcConstants.FUN_RSH);
				break;
			case "FUN_ESH":
				testCase.setFunctionality(TcConstants.FUN_ESH);
				break;
			case "FUN_VRO1":
				testCase.setFunctionality(TcConstants.FUN_VRO1);
				break;
			case "FUN_VRO2":
				testCase.setFunctionality(TcConstants.FUN_VRO2);
				break;
			case "FUN_VRO3":
				testCase.setFunctionality(TcConstants.FUN_VRO3);
				break;
			case "FUN_VRO4":
				testCase.setFunctionality(TcConstants.FUN_VRO4);
				break;
			case "FUN_VERO":
				testCase.setFunctionality(TcConstants.FUN_VERO);
				break;
			case "FUN_VGRO":
				testCase.setFunctionality(TcConstants.FUN_VGRO);
				break;

			case "FUN_CAC":
				testCase.setFunctionality(TcConstants.FUN_CAC);
				break;

			case "FUN_RO":
				testCase.setFunctionality(TcConstants.FUN_RO);
				break;
			case "FUN_GRO":
				testCase.setFunctionality(TcConstants.FUN_GRO);
				break;

			/** SUMMARY */
			case "FUN_S":
				testCase.setFunctionality(TcConstants.FUN_S);
				break;
			case "FUN_BS":
				testCase.setFunctionality(TcConstants.FUN_BS);
				break;
			case "FUN_ES":
				testCase.setFunctionality(TcConstants.FUN_ES);
				break;

			case "FUN_IT":
				testCase.setFunctionality(TcConstants.FUN_IT);
				break;
			case "FUN_EIT":
				testCase.setFunctionality(TcConstants.FUN_EIT);
				break;

			}
		}

		return testCase;
	}

	public String getTestNo() {
		return testNo;
	}

	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}

	public String getMocNo() {
		return mocNo;
	}

	public void setMocNo(String mocNo) {
		this.mocNo = mocNo;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		// return super.toString();
		return "Test No:" + testNo + " of MOC " + mocNo + " for Functionality " + functionality + " is having status: "
				+ status + " !! ";
	}
}