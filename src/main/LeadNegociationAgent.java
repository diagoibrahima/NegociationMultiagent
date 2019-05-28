package main;

import java.util.ArrayList;
import java.util.Random;

import agents.AgentSolo;
import agents.AgentSoloContainer;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import modele.Attributs;

public class LeadNegociationAgent extends Agent implements LeadNegociationAgentInterface {
	
	public static int nbagent = 2; // le nombre d'agent a creer au demarage de la simulation
	public static ArrayList<AgentSolo> listAllAgent = new ArrayList<AgentSolo>(); // la liste des agents cree pour la simulation
	public int nbAttribut=6;
	
	public static ArrayList<Attributs> listAttribut = new ArrayList<Attributs>();
	
	
	

	
	@Override
	protected void setup() {
		// cette entité est l'agent principale qui demarre en premier lieu
		
		System.out.println("Demarrage du LeadNegociateurAgent");

		// _______________________________Parallele Behaviour permet de pouvoir executer les comportements de l'agent en parallele
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		
		//CyclicBehaviour Ce comportement s"execute en permanance durant toute la vie de l'agent
				parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
					
					@Override
					public void action() {
						//System.out.println("Comportement CyclicBehaviour");
					}
				});
		
				
		//OneShotBehaviour Ce comportement s'execute une seule fois apres le demarrage 
		parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
			
			
			private int i;
			
			@Override
			public void action() {
				//System.out.println("Comportement OneshotBehaviour");
				
			createAgent();	
				
				
			}
		});
		
		
		//TickerBehaviour Ce comportement s'execute tout les 1 seconde
		parallelBehaviour.addSubBehaviour(new TickerBehaviour(this, 5000) {
			
			private int counter;
			@Override
			protected void onTick() {
				// Création d'un nouveau agent tout les 5 secondes
			//	++counter;
			//	System.out.println("Bonjour je suis le nouveau Agent : "+counter);
				//Creation de deux agents
			//	AgentSoloContainer ags = new AgentSoloContainer();
			//	ags.AgentSoloModele(counter,5);
				
			}
		});

	}

	// BeforeMove() et AfterMove() sont utilises avec les projet SMA pour la
	// mobilité des agents
	@Override
	protected void beforeMove() {
		// methode qui sexecute avant le deplacement de l'agent
	}

	@Override
	protected void afterMove() {
		// methode qui sexecute apres le deplacement de l'agent
	}

	@Override
	protected void takeDown() {
		// methode qui sexecute avant le destruction de l'agent

	}


	//Implementation des fonctions annexes
	
	@Override
	public void createAgent() {
		int i;
		// Création initiale des agents 
		for(i = 0; i < nbagent; i++)
		{				
			System.out.println("Bonjour je suis le nouveau Agent : "+i+"j'ai "+nbAttribut+" attributs");
			//Creation de deux agents
			AgentSoloContainer ags = new AgentSoloContainer();
			ags.AgentSoloModele(i,nbAttribut);
		} 
		
	}

	@Override
	public int selectNbAttributs(int n) {
		int nbAttribut;
		Random rand = new Random();
		nbAttribut = rand.nextInt(n) + 1;
		return nbAttribut;
	}

	@Override
	public void createListAttribut() {
		int i;
		for(i = 0; i < nbAttribut; i++)
		{	
			listAttribut.add(new Attributs(i, "e"+i));
		}
	}

	
	
	
	
	
	
	
	
	

}
