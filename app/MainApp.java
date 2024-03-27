package app;

import model.*;

import java.sql.SQLException;

import controller.*;
import view.*;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		View v = new View();
		LoginModel m = new LoginModel();
		v.setVisible(true);

		LoginController c = new LoginController(m, v);

	}

}
