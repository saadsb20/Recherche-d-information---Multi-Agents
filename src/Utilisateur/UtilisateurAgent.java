package Utilisateur;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import DAO.Information;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class UtilisateurAgent extends GuiAgent
{
	private UtilisateurGUI gui;

	@Override
	protected void setup()
	{
			gui = new UtilisateurGUI();
		gui.setUtilisateurAgent(this);
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour()
		{
			Integer i = 0;

			@Override
			public void action()
			{
				MessageTemplate messageTemplate = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
						MessageTemplate.MatchOntology("utilisateur"));
				ACLMessage aclMessage = receive(messageTemplate);
				MessageTemplate messageTemplate1 = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("resfin"));
				ACLMessage aclMessage1 = receive(messageTemplate1);
				if(aclMessage1 == null)
				{
					block();
					return;
				}
				
				String infos = aclMessage1.getUserDefinedParameter("infos");
				if(infos.equals("NotFound"))
				{
					gui.showNotFound();
				}
				else
				{
					gui.showMessage(infos);
				}
				
			}

		});

	}

	@Override
	public void onGuiEvent(GuiEvent ev)
	{
		
		System.out.println("ev.getype : " + ev.getType());
		switch (ev.getType())
		{
		case 1:
			String depart = (String) ev.getParameter(0);
			String arrivee = (String) ev.getParameter(1);
			String date = (String) ev.getParameter(2);
			List<String> list = new ArrayList<String>();
			list.add(depart);
			list.add(arrivee);
			list.add(date);
			System.out.println(depart + "      " + arrivee + "      " + date);

			ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
			aclMessage.addReceiver(new AID("intermediaire1", AID.ISLOCALNAME));
			try {
				aclMessage.setContentObject((Serializable) list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// aclMessage.setContent(type);
			aclMessage.setOntology("intermed");
			send(aclMessage);
			break;

		}

	}
}