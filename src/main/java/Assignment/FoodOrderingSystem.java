/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class FoodOrderingSystem {

    static String username;
    static String[] product = {"Bubble Tea", "Hawaii Pizza", "Roasted Duck",
        "Lemon Tea", "Cheese Cake"};
    static int[] price_list = {3000, 21000, 16000, 2500, 8000};
    static int[] in_stock = {15, 15, 20, 20, 10};
    static int product_size;
    static String[] buy_product;
    static int index = 0;
    static int[] quantity;
    static int option;
    static char search;
    static int s_index;
    static String search_product;
    static String user_ans;
    static int[] total;
    static int final_total;
    static String yesNo;

    static void menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Choose One option! (1 or 2)");
        System.out.println("1.View Items");
        System.out.println("2.Order items");
        option = s.nextInt(); // to choose option
        if (option > 2 || option < 1) {   //checking to detect wrong inputs
            System.out.println("Input error! \nProgram has stopped! ");
        }
    }

    static void viewItems() {
        if (option == 1) {
            Scanner s = new Scanner(System.in);
            System.out.println("We have these products.....");
            for (int j = 0; j < product.length; j++) {
                System.out.println((j + 1) + "." + product[j]);
            }
            System.out.println("Enter p for searching by product name or "
                    + "Enter n for searching by product number");
            search = s.next().charAt(0);

        }
    }

    static void searchByNumber() {
        if (search == 'n') {
            Scanner s = new Scanner(System.in);
            int v_product = 0;
            System.out.println("Which item would you like to view");
            v_product = s.nextInt();
            if (v_product < 6) { //showing user chose product info by looping arrays
                System.out.println("Product Name: "
                        + product[v_product - 1]);
                System.out.println("Price Per Each: "
                        + price_list[v_product - 1] + " mmk");
                System.out.println("Quantity In stock: "
                        + in_stock[v_product - 1]);
                System.out.println("would you like to order? (Press 2 "
                        + "to move order page)"); // this coding will forward you to order page
                option = s.nextInt();
            } else {
                System.out.println("Input error! \nProgram has stopped!");
            }
        }
    }

    static void searchByName() {
        if (search == 'p') {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the product name(Product name are case"
                    + "-sensitive)");
            search_product = sc.nextLine();
            for (int n = 0; n < product.length; n++) {
                if (search_product.equals(product[n])) {
                    s_index = n;
                }
            }
            if (search_product.equals(product[0]) || search_product.equals(product[1])
                    || search_product.equals(product[2]) || search_product.equals(product[3])
                    || search_product.equals(product[4])) {
                System.out.println("Product Name: "
                        + product[s_index]);
                System.out.println("Price Per Each: "
                        + price_list[s_index] + " mmk");
                System.out.println("Quantity In stock: "
                        + in_stock[s_index]);
                System.out.println("would you like to order? (Press 2 "
                        + "to move order page)"); // this coding will forward you to order page
                option = sc.nextInt();

            } else {
                System.out.println("Input error");

            }

        }
    }

static void dataSaving() {
        Scanner s = new Scanner(System.in);

        if (option == 2) {
            System.out.println("How Many Product Would you buy?");
            product_size = Integer.parseInt(s.nextLine());
            buy_product = new String[product_size]; //define array size by using input data 
            quantity = new int[product_size];
            total = new int[product_size];
            for (int k = 0; k < buy_product.length; k++) {

                System.out.println("Which item would you like to order (Product"
                        + " names are case-sensitive!!)");
                buy_product[k] = s.nextLine(); // input data will save in buy_product array
                for (int i = 0; i < product.length; i++) {
                    if (buy_product[k].equals(product[i])) {
                        index = i;  //finding the product index number to use for calculation
                    }
                }
                if (buy_product[k].equals(product[0]) || buy_product[k].equals(product[1])
                        || buy_product[k].equals(product[2]) || buy_product[k].equals(product[3])
                        || buy_product[k].equals(product[4])) {
                    System.out.println("How many would you buy?");
                    quantity[k] = Integer.parseInt(s.nextLine());
                    total[k] = quantity[k] * price_list[index];
                    System.out.println("Processing to cart(Enter Y "
                            + "to continue)");  //for connecting dataDisplay Method
                    user_ans = s.nextLine();
                } else {
                    System.out.println("Input error!\n Try again!");
                }
            }

        }

    }

    static void dataDisplay() {
        final_total = 0;
        if ("Y".equals(user_ans) || "y".equals(user_ans)) {
            System.out.println("*******Your Order*******");
            System.out.println("Product\t\tQuantity\t\tTotal");
            for (int l = 0; l < buy_product.length; l++) {  //output ordered data with looping
                System.out.print((l + 1) + " " + buy_product[l] + "\t\t");
                System.out.print(quantity[l] + "\t\t");
                System.out.println(total[l] + " mmk");
            }
            for (int m = 0; m < quantity.length; m++) {
                final_total = final_total + total[m]; // calculate final total by derived data from total and addtion by looping
            }
            System.out.println("\t\t\t   " + "Final Total " + final_total
                    + " mmk");
        }
    }

    public static void main(String[] args) {
        menu();
        viewItems();
        searchByNumber();
        searchByName();
        dataSaving();
        dataDisplay();
    }
}
