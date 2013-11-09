package nagyhf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Car car1 = new Car(1,"Volvo","kék",44);
		Car car2 = new Car(2,"Fiat","fekete",44);
		Car car3 = new Car(3,"Ferrari","zöld",44);
		Car car4 = new Car(4,"Opel","kék",44);
		Car car5 = new Car(5,"BMW","zöld",44);
		
		
		ArrayList<Car> carsList = new ArrayList();
		carsList.add(car1);
		carsList.add(car2);
		carsList.add(car3);
		carsList.add(car4);
		
		
		Layout windows = new Layout(carsList);
		
		windows.setVisible(true);
		
	}
}
