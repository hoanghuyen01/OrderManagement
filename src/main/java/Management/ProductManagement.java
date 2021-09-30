package Management;

import Objects.Product;
import Utils.BasePage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ProductManagement extends BasePage {
    final String PATH_JSON_FILE_PRODUCT="C:\\Users\\Admin\\Downloads\\OrderManager\\src\\main\\resources\\Data\\products";

    public ArrayList<Product> getProductFromJSonFile(){
        JSONObject obj = readFileJson(PATH_JSON_FILE_PRODUCT);
        JSONArray prodJson = (JSONArray)obj.get("products");
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < prodJson.size(); i++) {
            JSONObject productJson = (JSONObject) prodJson.get(i);
            String productName = (String) productJson.get("productName");
            String productCode = (String) productJson.get("productCode");
            String priceJson = productJson.get("price").toString();
            BigDecimal price= null;
            String discountCode= (String) productJson.get("discountCode");
            Date fromDate = null;
            Date toDate= null;
            try {
                fromDate= new SimpleDateFormat("dd/MM/yyyy").parse((String) productJson.get("fromDate"));
                toDate=  new SimpleDateFormat("dd/MM/yyyy").parse((String) productJson.get("toDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (!priceJson.matches("^[a-zA-Z]*$")){
                price = new BigDecimal(priceJson);
                Product product = new Product(productCode,productName,price,discountCode,fromDate,toDate);
                if(product.getProductName()!=null&& product.getProductCode()!= null && product.getPrice() !=null){
                    products.add(product);
                }
            }
        }
        return products;
    }
    public void displayListProduct(ArrayList<Product> products){
        int count = 1;
        for (Product pro : products) {
            System.out.println(count + pro.toString());
            count++;
        }
    }
    public String searchProductByName(ArrayList<Product> products,String productName){
        for (Product pro : products) {
            if (pro.getProductName().equalsIgnoreCase(productName)){
                return pro.toString();
            }
        }
        return null;
    }
    public String searchProductByCode(ArrayList<Product> products,String productCode){
        for (Product pro : products) {
            if (pro.getProductCode().equalsIgnoreCase(productCode)){
                return pro.toString();
            }
        }
        return null;
    }
}
