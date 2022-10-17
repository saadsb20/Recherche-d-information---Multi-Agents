package Chercheur;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import DAO.InformationDAO;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import DAO.Information;

public class ChercheurAgent extends Agent {

	@Override
	protected void setup() {

		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {

			@Override
			public void action() {
				MessageTemplate messageTemplate = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("info"));
				ACLMessage aclMessage = receive(messageTemplate);
				MessageTemplate messageTemplate1 = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.INFORM),
						MessageTemplate.MatchOntology("resultat"));
				ACLMessage aclMessage11 = receive(messageTemplate1);

				if (aclMessage == null) {
					block();
					return;
				}

				List<Information> infos = null;
				List<String> nom_info;

				try {
					nom_info = (List<String>) aclMessage.getContentObject();

					InformationDAO informationDAO = new InformationDAO();
					System.out.println(nom_info.get(0));
					System.out.println(nom_info.get(1));
					System.out.println(nom_info.get(1));

					infos = informationDAO.FindInformationByNom(nom_info.get(0), nom_info.get(1),nom_info.get(2));
					
					System.out.println("chercheur : " + infos);
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnreadableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// send message
				ACLMessage aclMessage1 = new ACLMessage(ACLMessage.INFORM);
				aclMessage1.addReceiver(new AID("intermediaire1", AID.ISLOCALNAME));
				aclMessage1.setContent(aclMessage.getContent());
				aclMessage1.setOntology("resultatfin");
				try
				{
					aclMessage1.addUserDefinedParameter("infos",Information.ListToString(infos));
				} catch (Exception e)
				{
					aclMessage1.addUserDefinedParameter("infos","NotFound");
				}

				send(aclMessage1);
			}

		});

	}

}