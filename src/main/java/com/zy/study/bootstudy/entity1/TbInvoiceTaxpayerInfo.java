package com.zy.study.bootstudy.entity1;

public class TbInvoiceTaxpayerInfo {

    private String invoiceNo;
    private String taxpayerName;
    private TbTaxpayer taxpayer;

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public void setTaxpayerName(String taxpayerName) {
        this.taxpayerName = taxpayerName;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public TbTaxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(TbTaxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }
}
