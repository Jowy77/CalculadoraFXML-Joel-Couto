package dad.javafx.calculadora;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dad.javafx.CalcProfe.Calculadora;;


public class CalculadoraController implements Initializable {
	
	private Calculadora calculadoraPrincipal = new Calculadora();
	
	
	private StringProperty numero = new SimpleStringProperty("0.0");
	
	@FXML
	private GridPane view;
	
	@FXML
	private List<Button> listaButtons;
	
	@FXML
	private TextField numeroTexto;
	
	@FXML
	private Button sumarButton, restarButton, multiplicarButton, dividirButton,comaButton, igualButton, borrarButton, borrarTodoButton;	
	
	
	public CalculadoraController() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		numeroTexto.textProperty().bind(numero);
		
		//Funciones botones
		
		sumarButton.setOnAction( e -> onSeleccionAction('+'));
		
		restarButton.setOnAction( e -> onSeleccionAction('-'));
		
		multiplicarButton.setOnAction( e -> onSeleccionAction('*'));
		
		dividirButton.setOnAction( e -> onSeleccionAction('/'));
		
		comaButton.setOnAction( e -> onSeleccionAction('.'));
		
		igualButton.setOnAction( e -> onSeleccionAction('='));
		
		borrarButton.setOnAction( e -> onSeleccionAction('0'));
		
		borrarTodoButton.setOnAction( e -> onSeleccionAction('b'));
		
		//recolector numeros
		
		for( Button numeroButtons : listaButtons ) {
			numeroButtons.setOnAction( e -> onNumeroAction(numeroButtons.getText()));
		}
	}
	
	private void onNumeroAction(String textoButton) {
		
		calculadoraPrincipal.insertar(textoButton.charAt(0));  
		numero.set(calculadoraPrincipal.getPantalla());
	}
	
	private void onSeleccionAction(char operator) {
		
		switch(operator) {
		
		case '+':
			
		case '-':
			
		case '*':
			
		case '/':
			
		case '=':
			calculadoraPrincipal.operar(operator);
			break;
			
		case '.':
			calculadoraPrincipal.insertarComa();
			break;
			
		case '0':
			calculadoraPrincipal.borrar();
			break;
			
		case 'b':
			calculadoraPrincipal.borrarTodo();
			break;
			
		default:
			break;
		}
		
		numero.set(calculadoraPrincipal.getPantalla());
	}


	public GridPane getView() {
		return view;
	}
}
