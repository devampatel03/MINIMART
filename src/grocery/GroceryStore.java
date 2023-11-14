package grocery;

import billing.Bill;
import items.Item;
import java.util.Scanner;

public class GroceryStore extends database {


    //Grocery Store
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GroceryStore store_object = new GroceryStore();


        System.out.println("          ||-- WELCOME  TO  MINIMART --||          ");
        System.out.println();
        System.out.println(" -- System currently in Secure Mode --");


        while (true) {

            System.out.println("Enter the access key : ");
            String key = sc.nextLine();
            if (key.equals("101010")) {
                System.out.println();
                System.out.println("  Greetings for the day!! -- You are now logged in --");
                System.out.println("        What would you like to do now ?");
                System.out.println();
                while (true) {
                    System.out.println();
                    System.out.println("1. Make a new bill");
                    System.out.println("2. Customers registered at MINIMART");
                    System.out.println("3. List of items available at mart");
                    System.out.println("4. Get Bill Receipt of a Customer ");
                    System.out.println("5. Log Out and enter into Secure mode");
                    System.out.println();
                    int main_choice = getUserChoice();
                    if (main_choice == 1) {
                        Bill bill = new Bill();

                        System.out.println("-- Firstly register the customer to MINIMART -- ");
                        System.out.println();
                        System.out.println("Enter the following details:");
                        System.out.println("Customer Id: ");
                        int new_cust_id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Name: ");
                        String new_name = sc.nextLine();

                        System.out.println("Address: ");
                        String new_address = sc.nextLine();

                        System.out.println("Pincode: ");
                        int new_pincode = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Phone No.: ");
                        long new_number = sc.nextLong();
                        sc.nextLine();

                        System.out.println("Email Id: ");
                        String new_email = sc.nextLine();

                        store_object.CustomerDetails(new_cust_id, new_name, new_address, new_pincode, new_number, new_email);


                        store_object.create_cust_table(new_cust_id);

                        while (true) {
                            System.out.println();
                            System.out.println("Select an item:");
                            System.out.println("1. Amul Butter (200g) ");
                            System.out.println("2. Amul Gold Milk (1L) ");
                            System.out.println("3. Malkist Cheese Biscuits (100g) ");
                            System.out.println("4. Amul Mozorella Cheese (200g) ");
                            System.out.println("5. Tata Salt (500g) ");
                            System.out.println("6. WheatKart Whole Wheat Flour (10Kg) ");
                            System.out.println();
                            System.out.println("--- Enter 0 to generate bill ---");


                            int choice = getUserChoice();
                            if (choice == 0) {
                                break;
                            }

                            Item selectedItem = getItemByChoice(choice);
                            if (selectedItem != null) {
                                System.out.println("Item : "+store_object.name_list(choice-1));
                                int quantity = getQuantity();
                                store_object.add_item_into_cust_cart(new_cust_id,choice,quantity);
                                bill.addItem(selectedItem, quantity);
                            } else {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }

                        store_object.get_bill_cust(new_cust_id);


                    }
                    else if (main_choice == 2) {
                        System.out.println("1. Get list of all customers registered at MINIMART");
                        System.out.println("2. Get details of a particular customer");
                        System.out.println("3. Register a new customer at MINIMART");
                        System.out.println("4. Delete a customer from MINIMART");
                        System.out.println();
                        int cust_choice = getUserChoice();
                        if (cust_choice == 1) {
                            store_object.CustomerDetails();
                        } else if (cust_choice == 2) {
                            System.out.print("Enter the name of Customer : ");
                            String specific_cust = sc.nextLine();
                            store_object.CustomerDetails(specific_cust);
                        } else if (cust_choice == 3) {
                            System.out.println("Enter the following details:");
                            System.out.println("Customer Id: ");
                            int new_cust_id = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Name: ");
                            String new_name = sc.nextLine();

                            System.out.println("Address: ");
                            String new_address = sc.nextLine();

                            System.out.println("Pincode: ");
                            int new_pincode = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Phone No.: ");
                            long new_number = sc.nextLong();
                            sc.nextLine();

                            System.out.println("Email Id: ");
                            String new_email = sc.nextLine();

                            store_object.CustomerDetails(new_cust_id, new_name, new_address, new_pincode, new_number, new_email);


                        } else if (cust_choice==4) {
                            System.out.println("Enter Customer Id:");
                            int id=sc.nextInt();
                            store_object.delete_cust(id);

                        }


                    }
                    else if (main_choice == 3) {
                        store_object.Items_list();

                    }
                    else if (main_choice == 4) {
                        System.out.println("Enter Customer Id :");
                        int id= sc.nextInt();
                        store_object.get_bill_cust(id);


                    }
                    else if (main_choice == 5) {
                        System.out.println("System entered back into secure mode !");
                        break;

                    }
                }

                break;
            } else {
                System.out.println("Wrong access key entered , try again ");
            }


        }



    }
    private static int getUserChoice () {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter your choice : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }


    private static Item getItemByChoice ( int choice){
        GroceryStore object = new GroceryStore();

        switch (choice) {
            case 1:
                return new Item(object.name_list(0), object.price_list(0));
            case 2:
                return new Item(object.name_list(1), object.price_list(1));
            case 3:
                return new Item(object.name_list(2), object.price_list(2));
            case 4:
                return new Item(object.name_list(3), object.price_list(3));
            case 5:
                return new Item(object.name_list(4), object.price_list(4));
            case 6:
                return new Item(object.name_list(5), object.price_list(5));
            default:
                return null;
        }
    }


    private static int getQuantity () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quantity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }


}