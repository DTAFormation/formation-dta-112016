package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.model.Pizza;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PizzaDaoFichier implements PizzaDao {

	@Override
	public List<Pizza> findAll() {
		// TODO FindAll PizzaDaoFichier 
		System.out.println(AccesLocal() + "\\data");
		
		File curDir = new File(AccesLocal() +"/data");
		File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isFile()){
            	//System.out.println(f.getName());
            	try {
//					FileInputStream inputFile = new FileInputStream(new File(AccesLocal() +"/data/"+ f.getName()));
            		BufferedReader in = new BufferedReader(new FileReader(new File(AccesLocal() +"/data/"+ f.getName())));
					String line; 
					try {
						while((line = in.readLine()) != null)
						{
						    System.out.println(line);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					in.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }

        
		
		
		
		return new ArrayList<Pizza>() ;
	}

	@Override
	public void save(Pizza p) {
		// TODO save PizzaDaoFichier
		System.out.println("save");

	}

	@Override
	public void updatePizza(int id, Pizza p) {
		// TODO updatePizza PizzaDaoFichier
		System.out.println("update");
	}

	@Override
	public void deletePizza(int id) {
		// TODO deletePizza PizzaDaoFichier

	}
	
	public String AccesLocal() {
		URL location = PizzaDaoFichier.class.getProtectionDomain().getCodeSource()
	            .getLocation();
	    String path = location.getFile();

	    return new File(path).getParent();
	}

}
