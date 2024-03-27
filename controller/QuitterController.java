package controller;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterController implements ActionListener{
	private View v;
	public QuitterController(View v) {
		this.v = v;
		this.v.getMenuView().getBtnQuitter().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(1);
	}

}
