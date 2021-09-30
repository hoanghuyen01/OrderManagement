package Objects;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.log4j.Logger;

public class Product {
    private String productCode;
    private String productName;
    private BigDecimal price;
    private String discountCode;
    private Date fromDate;
    private Date toDate;
    final static Logger logger = Logger.getLogger(Product.class);

    public  Product(){}
    public Product(String productCode,String productName,BigDecimal price,String discountCode,Date fromDate,Date toDate){
        if (validateProductCode(productCode)&& validateProductName(productName)&&validatePrice(price)
                &&validateDiscountCode(discountCode)){
            this.productCode = productCode;
            this.productName = productName;
            this.price = price;
            this.discountCode = discountCode;
            this.toDate = toDate;
            this.fromDate = fromDate;
        }else{
            logger.warn("Data input invalid. The system will not set this product information: "+ productName);
        }
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        if (validateProductCode(productCode)){
            this.productCode = productCode;
        }else{
            logger.debug(productCode + "can not set on Product List.");
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (validateProductName(productName)){
            this.productName = productName;
        }else{
            logger.debug(productName + " can not set on Product List.");
        }

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (validatePrice(price)){
            this.price = price;
        }else {
            logger.debug(productName + " can not set on Product List.");
        }
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public boolean validateProductCode(String productCode){
        if (productCode.matches("^\\bPD[0-9]{5}$")){
            return true;
        }
        logger.info(productCode + " is invalid data.");
        return false;
    }
    public boolean validateProductName(String productName){
        if (productName.length()<=50){
            return true;
        }
        logger.info(productName + " has length more than 50 characters.");
        return false;
    }
    public boolean validatePrice(BigDecimal price){
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        } else {
            logger.info(price + " must greater than 0");
            return false;
        }
    }
    public boolean validateDiscountCode(String discountCode){
        if (discountCode.matches("^\\bDC[0-9]{5}$")){
            return true;
        }else {
            return false;
        }
    }
    public String toString(){
        return "|| Product Name: " +productName +"||"+"  Product Code: " + productCode +"||"+ " Price: " + price+"||"
                + " Discount Code: " + discountCode +"||"+ " From Date: " + fromDate+"||" + " From Date: " + toDate +"||" ;
    }
}
