package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entitie.Person;

public class viewController implements Initializable{
	  
	@FXML
	private ComboBox<Person> comboBoxPerson;
	
	private ObservableList<Person> obsList;
	
	
	public void onComboBoxPerson () {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		 System.out.println(person);
	}
	
	@FXML
	private Button btAllAction;
	
	@FXML
	public void onBtAll () {
		for (Person person: comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 List <Person> list = new ArrayList<>();
		 list.add(new Person(1, "MARIA", "maria@gmail.com"));
		 list.add(new Person(1, "ALEX", "alex@gmail.com"));
		 list.add(new Person(1, "BOB", "bob@gmail.com"));
		 
		 
		 obsList = FXCollections.observableArrayList(list);
		 comboBoxPerson.setItems(obsList);
		 
		 
		 Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() { 
			 @Override
			 protected void updateItem(Person item, boolean empty) { 
			 super.updateItem(item, empty); 
			 setText(empty ? "" : item.getName()); 
			 } 
			}; 
			comboBoxPerson.setCellFactory(factory); 
			comboBoxPerson.setButtonCell(factory.call(null));
		 
	}
}
