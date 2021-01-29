package daos_interfaces;


import java.sql.SQLException;
import java.util.List;

import entities.Shop;

public interface ShopDAO {
	
	public List<Shop> getAllShops() throws SQLException;
	public boolean lookForShopByEmailAndPassword(String email, String password) throws SQLException;
	public void insertShop(Shop shop) throws SQLException;
	public void deleteShop(Shop shop) throws SQLException;
	public void updateShop(Shop shop, String old_email) throws SQLException;
	
}
