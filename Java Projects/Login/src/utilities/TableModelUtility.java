package utilities;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import entities.Customer;
import entities.Meal;
import entities.Rider;
import entities.Shop;
import gui.AdminCustomerFrame;
import gui.AdminMealFrame;
import gui.AdminRiderFrame;
import gui.AdminShopFrame;

public class TableModelUtility {
	
	public void initializeShopTable(AdminShopFrame admin_shop_frame,  List<Shop> shop_list)
	{
		
		Object[] row = new Object[6];
		for(Shop shop : shop_list) {
			row[0] = shop.getId();
			row[1] = shop.getPassword();
			row[2] = shop.getName();
			row[3] = shop.getAddress();
			row[4] = shop.getWorking_hours();
			row[5] = shop.getClosing_days();
			admin_shop_frame.getModel().addRow(row);
		}
		return;
	}
	
	public void initializeCustomerTable(AdminCustomerFrame admin_customer_frame,  List<Customer> customer_list)
	{
		Object[] row = new Object[10];
		InputUtility date_util = new InputUtility();
		for(Customer customer : customer_list) {
			   
			row[0] = customer.getCf();
			row[1] = customer.getName();
			row[2] = customer.getSurname();
			row[3] = date_util.formatDate(customer.getBirth_date());
			row[4] = customer.getBirth_place();
			row[5] = customer.getAddress().toString();
			row[6] = customer.getGender();
			row[7] = customer.getCellphone();
			row[8] = customer.getEmail();
			row[9] = customer.getPassword();
			admin_customer_frame.getModel().addRow(row);
		}
		return;
	}
	
	public void initializeMealTable(AdminMealFrame admin_meal_frame, List<Meal> meal_list) {
		Object[] row = new Object[5];
		InputUtility input_util = new InputUtility();
		for(Meal meal : meal_list) {
			row[0] = meal.getName();
			row[1] = meal.getCategory();
			row[2] = meal.getPrice();
			row[3] = meal.getIngredients();
			row[4] = input_util.arrayListToTokenizedString(meal.getAllergen_list(), ", ");
			admin_meal_frame.getModel().addRow(row);
		}
	}
	
	public void initializeRiderTable(AdminRiderFrame admin_rider_frame,  List<Rider> rider_list)
	{
		InputUtility date_util = new InputUtility();
		Object[] row = new Object[10];
		for(Rider rider : rider_list) {
			row[0] = rider.getCf();
			row[1] = rider.getName();
			row[2] = rider.getSurname();
			row[3] = date_util.formatDate(rider.getBirth_date());
			row[4] = rider.getBirth_place();
			row[5] = rider.getAddress().toString();
			row[6] = rider.getGender();
			row[7] = rider.getCellphone();
			row[8] = rider.getVehicle();
			row[9] = rider.getWorking_hours();
			admin_rider_frame.getModel().addRow(row);
		}
	}

}
