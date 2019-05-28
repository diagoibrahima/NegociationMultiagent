package main;



import agents.AgentSolo;
import agentsMetier.INegociationMetier;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class LeadNegociationContainer {
	
	
	private INegociationMetier NegociationMetier;
	
	public void LeadNegociationContainer(){
		
		try {
			Runtime runtime = Runtime.instance();
			ProfileImpl profileImpl = new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost"); // parametre pour specifier ou se trouve le main container
			
			AgentContainer agentContainer = runtime.createAgentContainer(profileImpl);
			
			AgentController agentController = agentContainer.createNewAgent("LeadNegociationAgent", LeadNegociationAgent.class.getName() , new Object[]{});
			agentController.start();
			
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
