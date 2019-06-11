/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.dtos;

/**
 *
 * @author Thien Phuc
 */
public class AccessoriesError {
    private String errorID, errorName, errorBrand, errorDes, errorPrice;

    public AccessoriesError() {
    }

    public String getErrorID() {
        return errorID;
    }

    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorBrand() {
        return errorBrand;
    }

    public void setErrorBrand(String errorBrand) {
        this.errorBrand = errorBrand;
    }

    public String getErrorDes() {
        return errorDes;
    }

    public void setErrorDes(String errorDes) {
        this.errorDes = errorDes;
    }

    public String getErrorPrice() {
        return errorPrice;
    }

    public void setErrorPrice(String errorPrice) {
        this.errorPrice = errorPrice;
    }
    
    
}
