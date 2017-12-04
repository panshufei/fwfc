package com.bosy.fwfc.bean;

public class Dealer {
    private Integer dealerId;

    private String dealerCode;

    private String dealerName;

    private String dealerGrade;

    private String dealerContact;

    private String dealerNum;

    private String dealerSheng;

    private String dealerShi;

    private String dealerXian;

    private String firmCode;

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode == null ? null : dealerCode.trim();
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getDealerGrade() {
        return dealerGrade;
    }

    public void setDealerGrade(String dealerGrade) {
        this.dealerGrade = dealerGrade == null ? null : dealerGrade.trim();
    }

    public String getDealerContact() {
        return dealerContact;
    }

    public void setDealerContact(String dealerContact) {
        this.dealerContact = dealerContact == null ? null : dealerContact.trim();
    }

    public String getDealerNum() {
        return dealerNum;
    }

    public void setDealerNum(String dealerNum) {
        this.dealerNum = dealerNum == null ? null : dealerNum.trim();
    }

    public String getDealerSheng() {
        return dealerSheng;
    }

    public void setDealerSheng(String dealerSheng) {
        this.dealerSheng = dealerSheng == null ? null : dealerSheng.trim();
    }

    public String getDealerShi() {
        return dealerShi;
    }

    public void setDealerShi(String dealerShi) {
        this.dealerShi = dealerShi == null ? null : dealerShi.trim();
    }

    public String getDealerXian() {
        return dealerXian;
    }

    public void setDealerXian(String dealerXian) {
        this.dealerXian = dealerXian == null ? null : dealerXian.trim();
    }

    public String getFirmCode() {
        return firmCode;
    }

    public void setFirmCode(String firmCode) {
        this.firmCode = firmCode == null ? null : firmCode.trim();
    }
}