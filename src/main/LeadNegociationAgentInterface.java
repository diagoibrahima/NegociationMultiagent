package main;

public interface LeadNegociationAgentInterface {
	
	public void createAgent();           // fonction qui permet de creer une agent sans le demarrer
	public int selectNbAttributs(int n); // permet a l'agent de choisir le nombre d'attribut qui l'interesse
	public void createListAttribut();
	
	
}
