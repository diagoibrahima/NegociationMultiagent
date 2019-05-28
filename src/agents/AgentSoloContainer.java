package agents;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import main.LeadNegociationAgent;

public class AgentSoloContainer {
	
	// Cette classe repressente le container generique des agents. initialement chaque agent generer sera dans son propre container
	// La fonction ci dessous prend en parametre un nombre entier qui servira de diferencier le nom des agents pour eviter les conflits
	
	public void AgentSoloModele(int number, int nbAttribut){
		
		try {
			Runtime runtime = Runtime.instance();
			ProfileImpl profileImpl = new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost"); // parametre pour specifier ou se trouve le main container
			
			AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
			
			AgentController agentController = agentContainer.createNewAgent("AgentSolo"+number, AgentSolo.class.getName() , new Object[]{nbAttribut});
			agentController.start();
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
