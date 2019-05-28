package main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MainContainer {

	public static void main(String[] args) {
		try {
			//creer une instance de jade
			Runtime runtime = Runtime.instance();
			//Crer un objet de type properties 
			Properties properties = new ExtendedProperties();
			
			//Configuration du main container et demarrrage deu main container avec l'interface graphique
			properties.setProperty(Profile.GUI, "true"); // permet de demarrer l'interface graphique
			
			// Creation du container 
			Profile profile = new ProfileImpl(properties);		
			AgentContainer mainConatiner = runtime.createMainContainer(profile);
			
			mainConatiner.start();
			
			//Demarrage du leadNegociationContainer 
			LeadNegociationContainer Lc = new LeadNegociationContainer();
			Lc.LeadNegociationContainer();
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
