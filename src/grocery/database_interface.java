package grocery;

public interface database_interface {
    public void CustomerDetails();
    public void CustomerDetails(String specific_name);
    public void CustomerDetails(int new_cust_id, String new_name, String new_address, int new_pincode, long new_number, String new_email);
    public void Items_list();
    public String name_list(int index);
    public Integer price_list(int index);
    public void get_bill_cust(int id);
    public void create_cust_table(int id);
    public void add_item_into_cust_cart(int id,int choice,int quantity);
    public void delete_cust(int id);

}
