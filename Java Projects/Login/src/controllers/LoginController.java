package controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import daos_implementation.ShopDAOPostgresImplementation;
import daos_interfaces.ShopDAO;
import gui.AdminFrame;
import gui.LoginFrame;
public class LoginController{
	

	private ShopDAO shop_dao = new ShopDAOPostgresImplementation();
	LoginFrame login_frame;
	public LoginController()
	{
		
	}
	//Metodo per aprire login frame dopo essersi disconnessi dall' admin frame
	public void openLoginFrame(AdminFrame admin_frame)
	{
		admin_frame.dispose();
		login_frame = new LoginFrame();
		login_frame.setVisible(true);
		return;
	}
	//Metodo per aprire login frame per la prima volta
	public void openLoginFrame()
	{
		login_frame = new LoginFrame();
		login_frame.setVisible(true);
		return;
	}
	
	@SuppressWarnings("deprecation")
	public void accessAuthentication(LoginFrame login_frame)
	{
		//SE ACCEDE L' ADMIN
		AdminController admin_controller = new AdminController();
		boolean access_succeded = false;
		if(login_frame.getLogoLabel().getIcon() == login_frame.getAdminLogoImage())
		{
			
		if (!login_frame.getUsernameTF().getText().equals("admin") || !login_frame.getPasswordTF().getText().equals("admin"))
		{
			
			JOptionPane.showMessageDialog(null, "Credenziali errate! Riprovare","Errore",JOptionPane.ERROR_MESSAGE);
			login_frame.getUsernameTF().setText("");
			login_frame.getPasswordTF().setText("");
		}
		else
		{
			//Chiudo il login frame e passo all' admin frame
			access_succeded=true;
			admin_controller.openAdminFrame(login_frame);
		}
		}
		//SE ACCEDE LO SHOP
		else
		{
			try {
				access_succeded = shop_dao.lookForShopByIdAndPassword(login_frame.getUsernameTF().getText(), login_frame.getPasswordTF().getText());
				if(access_succeded)
				{
					login_frame.setVisible(false);
					ShopController shop_controller = new ShopController();
					shop_controller.openShopFrame();
				}
				else
				{
					access_succeded=false;
					JOptionPane.showMessageDialog(null, "Credenziali errate! Riprovare","Errore",JOptionPane.ERROR_MESSAGE);
					login_frame.getUsernameTF().setText("");
					login_frame.getPasswordTF().setText("");
				}
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, "Errore durante il controllo dei dati");
			}
			
	}
		return;
	
}
	}
