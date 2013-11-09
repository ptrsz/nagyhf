package nagyhf;

import javax.swing.*;
public class MultipleInputDialog {
	JTextField inname = new JTextField(10);
	JTextField icolor = new JTextField(10);
	JTextField inpower = new JTextField(3);
	
	/**Visszado adatok**/
	Car rCar;
	/**Visszaado fg**/
	public Car getDialogCar(){
		return rCar;
	}
	
	JPanel panel = new JPanel();
	public MultipleInputDialog(){
		panel.add(new JLabel("Nev:"));
		panel.add(inname);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(new JLabel("Szin:"));
		panel.add(icolor);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(new JLabel("Motor:"));
		panel.add(inpower);
		
		int result = JOptionPane.showConfirmDialog(null,panel, "Kérjük adja meg az új elem adatait!",JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION){
			rCar  = new Car(99,inname.getText(),icolor.getText(),Integer.parseInt(inpower.getText()));
		}
	}
}
