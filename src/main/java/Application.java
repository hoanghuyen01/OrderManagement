import Management.ProductManagement;
import Objects.Product;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/java/Objects/log4j.properties");
        ProductManagement product = new ProductManagement();
        ArrayList<Product> products = product.getProductFromJSonFile();
        product.displayListProduct(products);
        Scanner input = new Scanner(System.in);
        String decisionOptions = null;
        do {
            System.out.println("Please input product name to get information: ");
            String nameProduct = input.nextLine();
            String resultSearch = product.searchProductByName(products,nameProduct);
            System.out.println("The result of searching: \n " + resultSearch);
            System.out.println("Do you want to search product name to get information? Y/N ");
            decisionOptions = input.nextLine();
        } while(decisionOptions.equalsIgnoreCase("y"));
        System.out.println("Please input your name: ");
        String nameCustomer = input.nextLine();
        System.out.println("Welcome "+ nameCustomer+ " to shopping! Please input code product and quantity.");
        String continuesOptions = null;
        do {
            System.out.println("Please input code product: ");
            String productCodeInput = input.nextLine();
            if (product.searchProductByCode(products,productCodeInput)!=null){
                System.out.println("Please input quantity: ");
                int quantityProduct = input.nextInt();

            }else{
                System.out.println("Product code does not exit in list product.");
            }
        }while (continuesOptions.equalsIgnoreCase("y"));

    }
}
