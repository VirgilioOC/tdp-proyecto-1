package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//Se crea una instancia de tipo Student con mis datos
            	Student Virgilio = new Student(126941,"Ocampos Crudeli","Virgilio Nehuén","VirgilioocamposUNS@gmail.com","https://github.com/VirgilioOC","/images/ImageStudent.png");
            	
            	//Se crea y muestra un objeto de la clase encargada de la GUI 
            	SimplePresentationScreen window = new SimplePresentationScreen(Virgilio);
            	window.setVisible(true);
            }
        });
    }
}