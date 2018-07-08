package com.zy.study.bootstudy.entity1;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "TB_INVOICE")
public class TbInvoice {
    @Id
    @Column(name = "INVOICE_UID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select SEQ_TB_INVOICE.nextval from dual")
    private BigDecimal invoiceUid;

    @Column(name = "INVOICE_NO")
    private String invoiceNo;

    @Column(name = "INVOICE_SHORT_CODE")
    private String invoiceShortCode;

    @Column(name = "TAXPAYER_UID")
    private BigDecimal taxpayerUid;

    @Column(name = "DEVICE_UID")
    private BigDecimal deviceUid;

    @Column(name = "INVOICE_MADE_BY")
    private String invoiceMadeBy;

    @Column(name = "INVOICE_FROM")
    private String invoiceFrom;

    @Column(name = "INVOICE_TYPE_UID")
    private BigDecimal invoiceTypeUid;

    @Column(name = "INVOICE_TYPE_CODE")
    private String invoiceTypeCode;

    @Column(name = "INVOICE_TYPE_NAME")
    private String invoiceTypeName;

    @Column(name = "DRAWER_NAME")
    private String drawerName;

    @Column(name = "CLIENT_INVOICE_DATETIME")
    private Date clientInvoiceDatetime;

    @Column(name = "PURCHASER_TIN")
    private String purchaserTin;

    @Column(name = "PURCHASER_NAME")
    private String purchaserName;

    @Column(name = "PURCHASER_ADDRESS")
    private String purchaserAddress;

    @Column(name = "PURCHASER_PHONE")
    private String purchaserPhone;

    @Column(name = "PURCHASER_ID_TYPE")
    private String purchaserIdType;

    @Column(name = "PURCHASER_ID_NUMBER")
    private String purchaserIdNumber;

    @Column(name = "SELLER_TIN")
    private String sellerTin;

    @Column(name = "SELLER_NAME")
    private String sellerName;

    @Column(name = "SELLER_ADDRESS")
    private String sellerAddress;

    @Column(name = "SELLER_PHONE")
    private String sellerPhone;

    @Column(name = "SELLER_BRANCH_ADDR")
    private String sellerBranchAddr;

    @Column(name = "IS_LOCAL_CURRENCY")
    private String isLocalCurrency;

    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "EXCHANGE_RATE")
    private BigDecimal exchangeRate;

    @Column(name = "TOTAL_FINAL")
    private BigDecimal totalFinal;

    @Column(name = "TOTAL_VAT")
    private BigDecimal totalVat;

    @Column(name = "TOTAL_STAMP")
    private BigDecimal totalStamp;

    @Column(name = "TOTAL_BPT")
    private BigDecimal totalBpt;

    @Column(name = "TOTAL_TAX1")
    private BigDecimal totalTax1;

    @Column(name = "TOTAL_TAX2")
    private BigDecimal totalTax2;

    @Column(name = "TOTAL_TAX3")
    private BigDecimal totalTax3;

    @Column(name = "TOTAL_TAX4")
    private BigDecimal totalTax4;

    @Column(name = "TOTAL_TAX5")
    private BigDecimal totalTax5;

    @Column(name = "TOTAL_TAXABLE_AMOUNT_ORG")
    private BigDecimal totalTaxableAmountOrg;

    @Column(name = "TOTAL_TAXABLE_AMOUNT")
    private BigDecimal totalTaxableAmount;

    @Column(name = "TOTAL_TAX_DUE")
    private BigDecimal totalTaxDue;

    @Column(name = "TOTAL_ALL")
    private BigDecimal totalAll;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "NEGATIVE_FLAG")
    private String negativeFlag;

    @Column(name = "DEDUCTION_STATUS")
    private String deductionStatus;

    @Column(name = "APPLIED_NEGATIVE_TOTAL_AMOUNT")
    private BigDecimal appliedNegativeTotalAmount;

    @Column(name = "ORG_INVOICE_UID")
    private BigDecimal orgInvoiceUid;

    @Column(name = "NEGATIVE_APPRIVAL_USER_ID")
    private String negativeApprivalUserId;

    @Column(name = "NEGATIVE_APPROVAL_REMARK")
    private String negativeApprovalRemark;

    @Column(name = "NEGATIVE_APPROVAL_DATETIME")
    private Date negativeApprovalDatetime;

    @Column(name = "INVALID_FLAG")
    private String invalidFlag;

    @Column(name = "INVALID_DATETIME")
    private Date invalidDatetime;

    @Column(name = "INVALID_USER_UID")
    private String invalidUserUid;

    @Column(name = "INVALID_REMARK")
    private String invalidRemark;

    @Column(name = "IS_RAFFLED")
    private String isRaffled;

    @Column(name = "IS_LUCKY")
    private String isLucky;

    @Column(name = "CASH_DATE")
    private Date cashDate;

    @Column(name = "IS_UPLOADED")
    private String isUploaded;

    @Column(name = "PRINT_FLAG")
    private String printFlag;

    @Column(name = "IS_DEDUCTABLE")
    private String isDeductable;

    @Column(name = "CRT_DATETIME")
    private Date crtDatetime;

    @Column(name = "IS_EINVOICE")
    private String isEinvoice;

    @Column(name = "INVOICE_PROCESS_STATUS")
    private String invoiceProcessStatus;

    @Column(name = "INVOICE_REQUEST_TYPE")
    private String invoiceRequestType;

    @Column(name = "SIGN")
    private String sign;

    /**
     * @return INVOICE_UID
     */
    public BigDecimal getInvoiceUid() {
        return invoiceUid;
    }

    /**
     * @param invoiceUid
     */
    public void setInvoiceUid(BigDecimal invoiceUid) {
        this.invoiceUid = invoiceUid;
    }

    /**
     * @return INVOICE_NO
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    /**
     * @return INVOICE_SHORT_CODE
     */
    public String getInvoiceShortCode() {
        return invoiceShortCode;
    }

    /**
     * @param invoiceShortCode
     */
    public void setInvoiceShortCode(String invoiceShortCode) {
        this.invoiceShortCode = invoiceShortCode == null ? null : invoiceShortCode.trim();
    }

    /**
     * @return TAXPAYER_UID
     */
    public BigDecimal getTaxpayerUid() {
        return taxpayerUid;
    }

    /**
     * @param taxpayerUid
     */
    public void setTaxpayerUid(BigDecimal taxpayerUid) {
        this.taxpayerUid = taxpayerUid;
    }

    /**
     * @return DEVICE_UID
     */
    public BigDecimal getDeviceUid() {
        return deviceUid;
    }

    /**
     * @param deviceUid
     */
    public void setDeviceUid(BigDecimal deviceUid) {
        this.deviceUid = deviceUid;
    }

    /**
     * @return INVOICE_MADE_BY
     */
    public String getInvoiceMadeBy() {
        return invoiceMadeBy;
    }

    /**
     * @param invoiceMadeBy
     */
    public void setInvoiceMadeBy(String invoiceMadeBy) {
        this.invoiceMadeBy = invoiceMadeBy == null ? null : invoiceMadeBy.trim();
    }

    /**
     * @return INVOICE_FROM
     */
    public String getInvoiceFrom() {
        return invoiceFrom;
    }

    /**
     * @param invoiceFrom
     */
    public void setInvoiceFrom(String invoiceFrom) {
        this.invoiceFrom = invoiceFrom == null ? null : invoiceFrom.trim();
    }

    /**
     * @return INVOICE_TYPE_UID
     */
    public BigDecimal getInvoiceTypeUid() {
        return invoiceTypeUid;
    }

    /**
     * @param invoiceTypeUid
     */
    public void setInvoiceTypeUid(BigDecimal invoiceTypeUid) {
        this.invoiceTypeUid = invoiceTypeUid;
    }

    /**
     * @return INVOICE_TYPE_CODE
     */
    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    /**
     * @param invoiceTypeCode
     */
    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode == null ? null : invoiceTypeCode.trim();
    }

    /**
     * @return INVOICE_TYPE_NAME
     */
    public String getInvoiceTypeName() {
        return invoiceTypeName;
    }

    /**
     * @param invoiceTypeName
     */
    public void setInvoiceTypeName(String invoiceTypeName) {
        this.invoiceTypeName = invoiceTypeName == null ? null : invoiceTypeName.trim();
    }

    /**
     * @return DRAWER_NAME
     */
    public String getDrawerName() {
        return drawerName;
    }

    /**
     * @param drawerName
     */
    public void setDrawerName(String drawerName) {
        this.drawerName = drawerName == null ? null : drawerName.trim();
    }

    /**
     * @return CLIENT_INVOICE_DATETIME
     */
    public Date getClientInvoiceDatetime() {
        return clientInvoiceDatetime;
    }

    /**
     * @param clientInvoiceDatetime
     */
    public void setClientInvoiceDatetime(Date clientInvoiceDatetime) {
        this.clientInvoiceDatetime = clientInvoiceDatetime;
    }

    /**
     * @return PURCHASER_TIN
     */
    public String getPurchaserTin() {
        return purchaserTin;
    }

    /**
     * @param purchaserTin
     */
    public void setPurchaserTin(String purchaserTin) {
        this.purchaserTin = purchaserTin == null ? null : purchaserTin.trim();
    }

    /**
     * @return PURCHASER_NAME
     */
    public String getPurchaserName() {
        return purchaserName;
    }

    /**
     * @param purchaserName
     */
    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName == null ? null : purchaserName.trim();
    }

    /**
     * @return PURCHASER_ADDRESS
     */
    public String getPurchaserAddress() {
        return purchaserAddress;
    }

    /**
     * @param purchaserAddress
     */
    public void setPurchaserAddress(String purchaserAddress) {
        this.purchaserAddress = purchaserAddress == null ? null : purchaserAddress.trim();
    }

    /**
     * @return PURCHASER_PHONE
     */
    public String getPurchaserPhone() {
        return purchaserPhone;
    }

    /**
     * @param purchaserPhone
     */
    public void setPurchaserPhone(String purchaserPhone) {
        this.purchaserPhone = purchaserPhone == null ? null : purchaserPhone.trim();
    }

    /**
     * @return PURCHASER_ID_TYPE
     */
    public String getPurchaserIdType() {
        return purchaserIdType;
    }

    /**
     * @param purchaserIdType
     */
    public void setPurchaserIdType(String purchaserIdType) {
        this.purchaserIdType = purchaserIdType == null ? null : purchaserIdType.trim();
    }

    /**
     * @return PURCHASER_ID_NUMBER
     */
    public String getPurchaserIdNumber() {
        return purchaserIdNumber;
    }

    /**
     * @param purchaserIdNumber
     */
    public void setPurchaserIdNumber(String purchaserIdNumber) {
        this.purchaserIdNumber = purchaserIdNumber == null ? null : purchaserIdNumber.trim();
    }

    /**
     * @return SELLER_TIN
     */
    public String getSellerTin() {
        return sellerTin;
    }

    /**
     * @param sellerTin
     */
    public void setSellerTin(String sellerTin) {
        this.sellerTin = sellerTin == null ? null : sellerTin.trim();
    }

    /**
     * @return SELLER_NAME
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * @param sellerName
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    /**
     * @return SELLER_ADDRESS
     */
    public String getSellerAddress() {
        return sellerAddress;
    }

    /**
     * @param sellerAddress
     */
    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress == null ? null : sellerAddress.trim();
    }

    /**
     * @return SELLER_PHONE
     */
    public String getSellerPhone() {
        return sellerPhone;
    }

    /**
     * @param sellerPhone
     */
    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone == null ? null : sellerPhone.trim();
    }

    /**
     * @return SELLER_BRANCH_ADDR
     */
    public String getSellerBranchAddr() {
        return sellerBranchAddr;
    }

    /**
     * @param sellerBranchAddr
     */
    public void setSellerBranchAddr(String sellerBranchAddr) {
        this.sellerBranchAddr = sellerBranchAddr == null ? null : sellerBranchAddr.trim();
    }

    /**
     * @return IS_LOCAL_CURRENCY
     */
    public String getIsLocalCurrency() {
        return isLocalCurrency;
    }

    /**
     * @param isLocalCurrency
     */
    public void setIsLocalCurrency(String isLocalCurrency) {
        this.isLocalCurrency = isLocalCurrency == null ? null : isLocalCurrency.trim();
    }

    /**
     * @return CURRENCY_CODE
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode == null ? null : currencyCode.trim();
    }

    /**
     * @return EXCHANGE_RATE
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @param exchangeRate
     */
    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * @return TOTAL_FINAL
     */
    public BigDecimal getTotalFinal() {
        return totalFinal;
    }

    /**
     * @param totalFinal
     */
    public void setTotalFinal(BigDecimal totalFinal) {
        this.totalFinal = totalFinal;
    }

    /**
     * @return TOTAL_VAT
     */
    public BigDecimal getTotalVat() {
        return totalVat;
    }

    /**
     * @param totalVat
     */
    public void setTotalVat(BigDecimal totalVat) {
        this.totalVat = totalVat;
    }

    /**
     * @return TOTAL_STAMP
     */
    public BigDecimal getTotalStamp() {
        return totalStamp;
    }

    /**
     * @param totalStamp
     */
    public void setTotalStamp(BigDecimal totalStamp) {
        this.totalStamp = totalStamp;
    }

    /**
     * @return TOTAL_BPT
     */
    public BigDecimal getTotalBpt() {
        return totalBpt;
    }

    /**
     * @param totalBpt
     */
    public void setTotalBpt(BigDecimal totalBpt) {
        this.totalBpt = totalBpt;
    }

    /**
     * @return TOTAL_TAX1
     */
    public BigDecimal getTotalTax1() {
        return totalTax1;
    }

    /**
     * @param totalTax1
     */
    public void setTotalTax1(BigDecimal totalTax1) {
        this.totalTax1 = totalTax1;
    }

    /**
     * @return TOTAL_TAX2
     */
    public BigDecimal getTotalTax2() {
        return totalTax2;
    }

    /**
     * @param totalTax2
     */
    public void setTotalTax2(BigDecimal totalTax2) {
        this.totalTax2 = totalTax2;
    }

    /**
     * @return TOTAL_TAX3
     */
    public BigDecimal getTotalTax3() {
        return totalTax3;
    }

    /**
     * @param totalTax3
     */
    public void setTotalTax3(BigDecimal totalTax3) {
        this.totalTax3 = totalTax3;
    }

    /**
     * @return TOTAL_TAX4
     */
    public BigDecimal getTotalTax4() {
        return totalTax4;
    }

    /**
     * @param totalTax4
     */
    public void setTotalTax4(BigDecimal totalTax4) {
        this.totalTax4 = totalTax4;
    }

    /**
     * @return TOTAL_TAX5
     */
    public BigDecimal getTotalTax5() {
        return totalTax5;
    }

    /**
     * @param totalTax5
     */
    public void setTotalTax5(BigDecimal totalTax5) {
        this.totalTax5 = totalTax5;
    }

    /**
     * @return TOTAL_TAXABLE_AMOUNT_ORG
     */
    public BigDecimal getTotalTaxableAmountOrg() {
        return totalTaxableAmountOrg;
    }

    /**
     * @param totalTaxableAmountOrg
     */
    public void setTotalTaxableAmountOrg(BigDecimal totalTaxableAmountOrg) {
        this.totalTaxableAmountOrg = totalTaxableAmountOrg;
    }

    /**
     * @return TOTAL_TAXABLE_AMOUNT
     */
    public BigDecimal getTotalTaxableAmount() {
        return totalTaxableAmount;
    }

    /**
     * @param totalTaxableAmount
     */
    public void setTotalTaxableAmount(BigDecimal totalTaxableAmount) {
        this.totalTaxableAmount = totalTaxableAmount;
    }

    /**
     * @return TOTAL_TAX_DUE
     */
    public BigDecimal getTotalTaxDue() {
        return totalTaxDue;
    }

    /**
     * @param totalTaxDue
     */
    public void setTotalTaxDue(BigDecimal totalTaxDue) {
        this.totalTaxDue = totalTaxDue;
    }

    /**
     * @return TOTAL_ALL
     */
    public BigDecimal getTotalAll() {
        return totalAll;
    }

    /**
     * @param totalAll
     */
    public void setTotalAll(BigDecimal totalAll) {
        this.totalAll = totalAll;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return NEGATIVE_FLAG
     */
    public String getNegativeFlag() {
        return negativeFlag;
    }

    /**
     * @param negativeFlag
     */
    public void setNegativeFlag(String negativeFlag) {
        this.negativeFlag = negativeFlag == null ? null : negativeFlag.trim();
    }

    /**
     * @return DEDUCTION_STATUS
     */
    public String getDeductionStatus() {
        return deductionStatus;
    }

    /**
     * @param deductionStatus
     */
    public void setDeductionStatus(String deductionStatus) {
        this.deductionStatus = deductionStatus == null ? null : deductionStatus.trim();
    }

    /**
     * @return APPLIED_NEGATIVE_TOTAL_AMOUNT
     */
    public BigDecimal getAppliedNegativeTotalAmount() {
        return appliedNegativeTotalAmount;
    }

    /**
     * @param appliedNegativeTotalAmount
     */
    public void setAppliedNegativeTotalAmount(BigDecimal appliedNegativeTotalAmount) {
        this.appliedNegativeTotalAmount = appliedNegativeTotalAmount;
    }

    /**
     * @return ORG_INVOICE_UID
     */
    public BigDecimal getOrgInvoiceUid() {
        return orgInvoiceUid;
    }

    /**
     * @param orgInvoiceUid
     */
    public void setOrgInvoiceUid(BigDecimal orgInvoiceUid) {
        this.orgInvoiceUid = orgInvoiceUid;
    }

    /**
     * @return NEGATIVE_APPRIVAL_USER_ID
     */
    public String getNegativeApprivalUserId() {
        return negativeApprivalUserId;
    }

    /**
     * @param negativeApprivalUserId
     */
    public void setNegativeApprivalUserId(String negativeApprivalUserId) {
        this.negativeApprivalUserId = negativeApprivalUserId == null ? null : negativeApprivalUserId.trim();
    }

    /**
     * @return NEGATIVE_APPROVAL_REMARK
     */
    public String getNegativeApprovalRemark() {
        return negativeApprovalRemark;
    }

    /**
     * @param negativeApprovalRemark
     */
    public void setNegativeApprovalRemark(String negativeApprovalRemark) {
        this.negativeApprovalRemark = negativeApprovalRemark == null ? null : negativeApprovalRemark.trim();
    }

    /**
     * @return NEGATIVE_APPROVAL_DATETIME
     */
    public Date getNegativeApprovalDatetime() {
        return negativeApprovalDatetime;
    }

    /**
     * @param negativeApprovalDatetime
     */
    public void setNegativeApprovalDatetime(Date negativeApprovalDatetime) {
        this.negativeApprovalDatetime = negativeApprovalDatetime;
    }

    /**
     * @return INVALID_FLAG
     */
    public String getInvalidFlag() {
        return invalidFlag;
    }

    /**
     * @param invalidFlag
     */
    public void setInvalidFlag(String invalidFlag) {
        this.invalidFlag = invalidFlag == null ? null : invalidFlag.trim();
    }

    /**
     * @return INVALID_DATETIME
     */
    public Date getInvalidDatetime() {
        return invalidDatetime;
    }

    /**
     * @param invalidDatetime
     */
    public void setInvalidDatetime(Date invalidDatetime) {
        this.invalidDatetime = invalidDatetime;
    }

    /**
     * @return INVALID_USER_UID
     */
    public String getInvalidUserUid() {
        return invalidUserUid;
    }

    /**
     * @param invalidUserUid
     */
    public void setInvalidUserUid(String invalidUserUid) {
        this.invalidUserUid = invalidUserUid == null ? null : invalidUserUid.trim();
    }

    /**
     * @return INVALID_REMARK
     */
    public String getInvalidRemark() {
        return invalidRemark;
    }

    /**
     * @param invalidRemark
     */
    public void setInvalidRemark(String invalidRemark) {
        this.invalidRemark = invalidRemark == null ? null : invalidRemark.trim();
    }

    /**
     * @return IS_RAFFLED
     */
    public String getIsRaffled() {
        return isRaffled;
    }

    /**
     * @param isRaffled
     */
    public void setIsRaffled(String isRaffled) {
        this.isRaffled = isRaffled == null ? null : isRaffled.trim();
    }

    /**
     * @return IS_LUCKY
     */
    public String getIsLucky() {
        return isLucky;
    }

    /**
     * @param isLucky
     */
    public void setIsLucky(String isLucky) {
        this.isLucky = isLucky == null ? null : isLucky.trim();
    }

    /**
     * @return CASH_DATE
     */
    public Date getCashDate() {
        return cashDate;
    }

    /**
     * @param cashDate
     */
    public void setCashDate(Date cashDate) {
        this.cashDate = cashDate;
    }

    /**
     * @return IS_UPLOADED
     */
    public String getIsUploaded() {
        return isUploaded;
    }

    /**
     * @param isUploaded
     */
    public void setIsUploaded(String isUploaded) {
        this.isUploaded = isUploaded == null ? null : isUploaded.trim();
    }

    /**
     * @return PRINT_FLAG
     */
    public String getPrintFlag() {
        return printFlag;
    }

    /**
     * @param printFlag
     */
    public void setPrintFlag(String printFlag) {
        this.printFlag = printFlag == null ? null : printFlag.trim();
    }

    /**
     * @return IS_DEDUCTABLE
     */
    public String getIsDeductable() {
        return isDeductable;
    }

    /**
     * @param isDeductable
     */
    public void setIsDeductable(String isDeductable) {
        this.isDeductable = isDeductable == null ? null : isDeductable.trim();
    }

    /**
     * @return CRT_DATETIME
     */
    public Date getCrtDatetime() {
        return crtDatetime;
    }

    /**
     * @param crtDatetime
     */
    public void setCrtDatetime(Date crtDatetime) {
        this.crtDatetime = crtDatetime;
    }

    /**
     * @return IS_EINVOICE
     */
    public String getIsEinvoice() {
        return isEinvoice;
    }

    /**
     * @param isEinvoice
     */
    public void setIsEinvoice(String isEinvoice) {
        this.isEinvoice = isEinvoice == null ? null : isEinvoice.trim();
    }

    /**
     * @return INVOICE_PROCESS_STATUS
     */
    public String getInvoiceProcessStatus() {
        return invoiceProcessStatus;
    }

    /**
     * @param invoiceProcessStatus
     */
    public void setInvoiceProcessStatus(String invoiceProcessStatus) {
        this.invoiceProcessStatus = invoiceProcessStatus == null ? null : invoiceProcessStatus.trim();
    }

    /**
     * @return INVOICE_REQUEST_TYPE
     */
    public String getInvoiceRequestType() {
        return invoiceRequestType;
    }

    /**
     * @param invoiceRequestType
     */
    public void setInvoiceRequestType(String invoiceRequestType) {
        this.invoiceRequestType = invoiceRequestType == null ? null : invoiceRequestType.trim();
    }

    /**
     * @return SIGN
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }
}