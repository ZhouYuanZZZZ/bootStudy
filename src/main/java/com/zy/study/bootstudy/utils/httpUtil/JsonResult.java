package com.zy.study.bootstudy.utils.httpUtil;

public class JsonResult {

    private boolean successFlag;
    private String result;

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
