package nagyhf;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
/**
 * 
 * @author szombat
 *Az osztálynak van egy grafikus megjelenése, illetve adatkezelő függvényei.
 *A GUI direkt nódon (CarTable) a "Kocsi" adathalmazra van optimalizálva.
 *A gombok listenerei ennek az osztálynak a módosítófüggvényeit hívják meg.
 *
 */
public class Layout extends JFrame implements Runnable{
	public ArrayList<Car> data;
	protected JPanel up;
	protected Button load_button;
	protected Button save_button;
	protected Button add_button;
	protected JPanel down;
	protected CustomTable dataTable;
	protected JMenu menuFile;
	protected JMenuItem menuItemAdd;
	protected JMenuItem menuItemLoad;
	protected JMenuItem menuItemSave;
	protected JMenuBar menuBar;
	protected JButton[] editButtons;
	
	public Layout(ArrayList<Car> idata){
		this.setSize(600, 400);
		this.data = idata;
		/**Input modulok dinicializálása**/
		up = new JPanel();
		down = new JPanel();
		
		menuFile = new JMenu("File");
		menuItemAdd = new JMenuItem("Add");
		menuItemLoad = new JMenuItem("Load");
		menuItemSave = new JMenuItem("Save");
		menuBar = new JMenuBar();
		
		
		
		/**Menu Betöltések**/
		menuBar.add(menuFile);
		menuFile.add(menuItemAdd);
		menuFile.add(menuItemLoad);
		menuFile.add(menuItemSave);
		
		/**Table Betoltes**/
		
		String[] headers = {"id","tipus","szin","motor"};
		dataTable = new  CustomTable(data,headers);
		
		
		/**Listener hozzáadása a gombokhoz*/
		ButtonListener bl = new ButtonListener();
		
		
		/**Listener hozzáadása menükhöz**/
		menuItemAdd.setActionCommand("add");
		menuItemAdd.addActionListener(bl);
		menuItemSave.setActionCommand("save");
		menuItemSave.addActionListener(bl);
		menuItemLoad.setActionCommand("load");
		menuItemLoad.addActionListener(bl);
		
		/**Felrajzolas**/
		
		down.add(dataTable);

		this.add(up,SpringLayout.NORTH);
		this.add(down,BorderLayout.CENTER);
		this.setJMenuBar(menuBar);
		this.pack();
		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Register");
		
		
		this.pack();
	}
	public void addCar(Car in){
		data.add(in);
		
	}
	public void run(){}
	/**Serialization**/
	
	
	/**Listeners**/
	class ButtonListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();
			if(command.equals("add")){
				MultipleInputDialog inputDialog = new MultipleInputDialog();
				data.add(inputDialog.getDialogCar());
				dataTable.repaint();
				}
			else
			if(command.equals("save")){
				try {
					FileOutputStream fileOut = new FileOutputStream("save.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(data);
					out.close();
					fileOut.close();
					System.out.println("save OK");
					System.out.println("Kiirva 1/1 adat "+data.get(1).getOne());
					
				}catch (IOException i){i.printStackTrace();}
			}
			else
			if(command.equals("load")){
				try {
					FileInputStream fileIn = new FileInputStream("load.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					
					ArrayList<Car> tmp = (ArrayList<Car>) in.readObject();
					data = tmp;
					
					System.out.println("olvasva 1/1 adat "+tmp.get(1).getOne());
					fileIn.close();
					in.close();
					System.out.println("beolvasva");
					dataTable.repaint();
					dataTable.scrollPane.repaint();
					System.out.println("olvasva 1/1 adat data-ban "+data.get(1).getOne());
				}catch(IOException i){i.printStackTrace();} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
