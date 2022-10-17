package Intermediaire;

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
import java.util.ArrayList;
import java.util.List;

import DAO.Information;

public class IntermediaireAgent extends Agent {

	@Override
	protected void setup() {

		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {

			@Override
			public void action() {
				MessageTemplate messageTemplate = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
						MessageTemplate.MatchOntology("intermed"));
				ACLMessage aclMessage = receive(messageTemplate);
				MessageTemplate messageTemplate1 = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.INFORM),
						MessageTemplate.MatchOntology("resultatfin"));
				ACLMessage aclMessage11 = receive(messageTemplate1);

				if (aclMessage != null) {
					// traitement
					Information information = null;
					List<String> nom_info;

					try {
						nom_info = (List<String>) aclMessage.getContentObject();

						// send message
						ACLMessage aclMessage1 = new ACLMessage(ACLMessage.REQUEST);
						aclMessage1.addReceiver(new AID("chercheur1", AID.ISLOCALNAME));

						aclMessage1.setContentObject((Serializable) nom_info);
						aclMessage1.setOntology("info");

						send(aclMessage1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				else if (aclMessage11 != null)
				{
					
					String InfosMessage = aclMessage11.getUserDefinedParameter("infos");
					System.out.println("intermediaire : " + InfosMessage);
					ACLMessage aclMessage2 = new ACLMessage(ACLMessage.INFORM);
					aclMessage2.addReceiver(new AID("utilisateur1", AID.ISLOCALNAME));

					try {
						aclMessage2.addUserDefinedParameter("infos",InfosMessage);
						aclMessage2.setOntology("resfin");

					} catch (NullPointerException e)
					{
						aclMessage2.addUserDefinedParameter("infos", "NotFound");
					}

					send(aclMessage2);

				} else {
					block();
				}

			}

		});

	}
}
