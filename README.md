# Recherche-d-information---Multi-Agents
Université Abdelmalek Essaâdi
Faculté des Sciences et Techniques – Tanger
Département Génie Informatique



Projet IAD & SMA

Application agents pour la Recherche d’Information


Recherche des vols disponibles




Encadré par : Mr. El Mokhtar EN-NAIMI

Réalisé par : Saâd BOURYALN 










Table de matières
I.	INTRODUCTION	3
II.	BUT DU PROJET	4
III.	OUTILS UTILISÉS	5
1.	OUTILS DE DÉVELOPPEMENT	5
2.	OUTILS DE CONCEPTION	6
IV.	CARACTÉRISTIQUES ET COUCHES DE NETSA	6
1.	CARACTÉRISTIQUES DE NETSA	6
2.	LES TROIS COUCHES DE NETSA ET LES AGENTS LES COMPOSANT	7
3.	PROPRIÉTÉS DES AGENTS COMPOSANT NETSA	9
V.	CONCEPTION ET MODÉLISATION	10
1.	DIAGRAMME DE CLASSE	10
2.	DIAGRAMME D’ACTIVITÉ	11
3.	DIAGRAMME DE CAS D’UTILISATION	11
4.	DIAGRAMME DE SÉQUENCE	12
VI.	IMPLÉMENTATION DU SYSTÈME	12
L’INTERFACE JADE	13
L’INTERFACE UTILISATEUR GUI :	15
DONNÉES SUR LA BASE DE DONNÉES	17
VII.	CONCLUSION	18
VIII.	RÉFÉRENCES	19












I.	Introduction

Objet de recherche en intelligence artificielle distribuée, les systèmes multi-agents constituent une possibilité intéressante de modélisation de sociétés humaines et animales, et ont à ce titre des champs d'application larges, allant jusqu'aux sciences humaines.
L'une des grandes sources d'inspiration pour les systèmes multi-agents a été l'étude des comportements sociaux de certaines familles d'insectes. Dans ce domaine, on se référera utilement aux articles Intelligence collective et Intelligence distribuée.
Les SMA peuvent être vus comme la rencontre de divers domaines :
	L'intelligence artificielle pour les aspects prise de décision de l'agent.
	L'intelligence artificielle distribuée pour la distribution de l'exécution.
	Les systèmes distribués pour les interactions.
	Le génie logiciel pour l'approche agents et l'évolution vers des composants.
	Logiciels de plus en plus autonomes.
	Les objets communicants.










II.	But du projet
Une grande partie des applications de Système Multi-agents est dans le domaine de recherche d'information. Parmi ces nombreuses applications dans ce domaine, on peut trouver "NetSA" : une architecture de système multi-agents pour la recherche d'information dans des sources hétérogènes et réparties. Ce système comporte plusieurs types d'agents comme :
- Un agent utilisateur en charge de la cueillette et du filtrage des informations provenant et allant vers l'usager; 
-Un agent courtier servant de répertoire pour les agents qui évoluent au sein de NETSA. 
- Des agents ressources reliés chacun à une ressource d'informations et pouvant rapatrier et mettre à jour les données.
- Un agent d'exécution en charge de la décomposition des tâches et du suivi du déroulement d'exécution des différentes sous-tâches.
- Un agent ontologie en charge du maintien de la cohérence des concepts utilisés par les agents.
Développez votre système en suivant les étapes suivantes :
1. Elaborez la conception du système SMA en se basant sur les méthodologies AUML, AALAADIN, GAIA, Voyelles, MaSE, ADELEFE, INGENIAS.
2. Développer le système SMA en utilisant l’une des plateformes ZEUS, JADE, JACK, MadKit, AgentBuilder, AgentTool.







III.	Outils Utilisés

1.	Outils de développement
JADE (Java Agent Dévelopment Framework) est un framework logiciel entièrement implémenté en langage Java. Il simplifie la mise en œuvre de systèmes multi-agents grâce à un middleware qui prétend être conforme aux spécifications FIPA et à un ensemble d'outils qui prend en charge la phase de débogage et de déploiement. La plate-forme d'agent peut être distribuée sur plusieurs machines (qui n'ont même pas besoin de partager le même système d'exploitation) et la configuration peut être contrôlée via une interface graphique distante.


IntelliJ IDEA également appelé « IntelliJ », « IDEA » ou « IDJ » est un environnement de développement intégré (en anglais Integrated Development Environment - IDE) destiné au développement de logiciels informatiques reposant sur la technologie Java. Il est développé par JetBrains (anciennement « IntelliJ ») et disponible en deux versions, l'une communautaire, open source, sous licence Apache 2 et l'autre propriétaire, protégée par une licence commerciale.
2.	Outils de conception 

LucidChart est une plateforme de collaboration en ligne, basée sur le cloud, permettant la création de diagrammes et la visualisation de données, et autres schémas conceptuels





AUML ou Agent UML Agent UML est une notation de soutien pour les systèmes de développement orientés agent. Il consiste à utiliser le langage de modélisation UML et de son extension afin de représenter les agents, leurs comportements et leurs interactions entre eux. Elle supporte tous les diagrammes des phases d’analyse et de conception avec une modification de ces diagrammes afin de représenter l’état interne d’un agent.
IV.	Caractéristiques et couches de NetSA

1.	Caractéristiques de NetSA
	NetSA est une architecture multi-agent conçue pour œuvrer particulièrement sur des sources hétérogènes placées dans un environnement ouvert et dynamique.  En la développant, nous l’avons dotée de certaines caractéristiques utiles.
-	Réutilisabilité et portabilité.
-	Communication entre agents basée sur JATLite.
-	HTML, formulaires et JavaScript.

2.	Les trois couches de NetSA et les agents les composant	
Le fait qu'on a affaire à des sources d’information hétérogènes nous a fait opter pour le développement d’agents ressources capables d’accéder à ces sources. Il nous a paru également intuitif d’interfacer l’utilisateur au moyen d’agent utilisateur.
 Finalement, et comme nous l’avons souligné plus haut, le fait qu’on a affaire à des environnements ouverts et dynamiques nous a fait opter pour le développement d’une couche d’agents intermédiaires. On voit donc apparaître trois niveaux d’abstraction au niveau de NetSA :
1.	L’unité de communication avec l’utilisateur.
2.	L’unité de traitement et de médiation
3.	L’unité d’interrogation et d’extraction des données.
Il convient de noter ici que ce découpage est le même que celui qu’on trouve habituellement dans les BDs classiques, mais il est très différent quant au contenu de ces unités.
Dans NetSA, les trois unités font référence à la technologie-agent et à la médiation entre ces mêmes agents:


Au niveau du contenu précisément, les trois unités sont comme suit:
	Unité de communication avec l’utilisateur : Cette unité est chargée des communications entre NetSA et l’usager. Elle comprend des agents interagissant avec l’utilisateur pour l’aider à réaliser une tâche bien précise. Cette interaction se traduit par une transformation des requêtes de l’usager qui, transformées en des actes du langage KQML, facilitent la communication avec les agents de l’unité de traitement. L’unité vérifie également la consistance des données fournies par l’utilisateur.
 
	Unité de traitement et de médiation : Cette unité reçoit de l’unité de communication les requêtes à satisfaire ainsi que les informations fournies par l’utilisateur. Elle décompose ces requêtes en sous-plans. Un sous-plan est une succession d’actions à exécuter dans le but d’atteindre un objectif intermédiaire et une série de sous-plans forme un plan global. L’unité comporte également une partie ‹‹ médiation ›› pour rechercher des données dans le système multiagent. Tel un patrouilleur, elle dirige les agents vers la ressource désirée en fournissant le nom de l’agent chargé de cette ressource.
 
	Unité d’interrogation et d’extraction d’informations : Cette unité est composée d’agents formant une interface entre les bases de données et l’unité de traitement d’informations. Ces agents transforment les requêtes KQML reçues et les traduisent en requêtes SQL pour interroger des bases de données. De ces bases de données, les agents retirent l’information pertinente et la redirigent vers l’unité de traitement de l’information sous un format KQML. Ces agents peuvent également retirer l’information contenue dans une page HTML de l’Internet.

3.	Propriétés des agents composant NetSA
Les agents de NetSA possèdent plusieurs propriétés qui sont conformes aux propriétés générales des agents. Ces propriétés sont pour l’essentiel :
	Portabilité : pour assurer sa portabilité, l’agent est programmé avec le langage Java.
	Autonomie : l’agent fonctionne sans l’intervention de l’utilisateur.
	Stabilité : une bonne gestion des exceptions permet à l’agent de demeurer dans un état        stable.
	Persistance : l’agent reprend le cours normal de ses opérations après une panne du système informatique.
	Flexibilité : les agents de NetSA doivent être en mesure de pouvoir être reconfigurés afin qu’ils puissent être facilement utilisés pour rechercher des informations dans la plupart des applications.

V.	Conception et modélisation 
1.	Diagramme de classe
Ce diagramme de classe schéma utilisé en génie logiciel pour présenter les classes et les interfaces des systèmes dans notre cas permet de donner une idée sur les entités manipulées par l’agent.







2.	Diagramme d’activité
Le diagramme d’activité sert à décrire le fonctionnement de notre système multi-agents, en montrant les étapes.	  
3.	Diagramme de cas d’utilisation
Ce diagramme est utilisés pour une représentation du comportement fonctionnel d'un système multi-agent.

4.	Diagramme de séquence
Les diagrammes de séquences sont la représentation graphique des interactions entre les acteurs et le système selon un ordre chronologique dans la formulation Unified Modeling Language.


VI.	Implémentation du système

L’application fonctionne comme suite :
1.	L’utilisateur saisit le lieu de départ, lieu d’arrivée et la date du départ du vol à chercher.
2.	L’agent Utilisateur transmet la requête à l’agent intermédiaire qui fonctionne comme messagère à l’agent chercheur.
3.	L’agent chercheur lance la requête pour chercher le vol demandé, et il envoie le résultat à l’agent intermédiaire.
4.	L’agent intermédiaire transmet le message à l’agent utilisateur pour l’afficher.
5.	L’agent utilisateur affiche le résultat au utilisateur 

Notre application se compose de 5 packages :
	Main : est le main container de notre application
	DAO : l’accès à la base de données MySQL
	Chercheur Container : contient le fonctionnement de l’agent chercheur.
	Utilisateur Container : contient le fonctionnement de l’agent Utilisateur.
	Intermédiaire Container : contient le fonctionnement de l’agent Intermédiaire.



L’interface JADE
L’interface JADE nous permet d’avoir une vision sur les agents de notre système ainsi que surveiller leur fonctionnement en utilisant la fonction Sniffer.



L’interface Utilisateur GUI :


Après que l’utilisateur clique sur le bouton Chercher on lance la requête et après quelque instant on affiche soit le résultat s’il existe, ou bien un message qui dit « Aucun résultat n’est trouvé » ; ainsi qu’il peut cliquer sur le bouton Effacer pour effacer les résultats affichés au tableau.










Données sur la base de données


VII.	Conclusion
l'architecture proposée dans ce travail est une approche basée agents mobiles conçue pour la recherche d'information dans des
sources hétérogènes et réparties. Elle définit l'ensemble des composants (agents) et modules fonctionnels décrits en terme de leurs comportements et interfaces, ainsi que la façon d'interaction de ces composants afin d'accomplir correctement l'ensemble des tâches du système.
Afin de montrer la faisabilité de l'architecture proposée d'un côté, et pour mieux comprendre son fonctionnement d'autre côté, nous avons choisi comme cas à étudier la recherche des vols disponibles car elle est considérée comme un exemple typique pour la recherche d'information.

















VIII.	Références
	https://excerpts.numilog.com/books/9782746217850.pdf
	https://www.researchgate.net/publication/226791220_Jade_-_A_Java_Agent_Development_Framework
	https://www.researchgate.net/publication/282555178_Developing_A_Multi-Agent_System_in_JADE_for_Information_Management_in_Educational_Competence_Domains
	https://computerscience.unicam.it/merelli/Calcolo/PAAM.pdf
	https://jade.tilab.com/download/jade/license/jade-download/?x=24&y=13
	https://www.collectionscanada.gc.ca/obj/s4/f2/dsk1/tape7/PQDD_0006/MQ41874.pdf
	https://hal.archives-ouvertes.fr/hal-01295000
	https://www.researchgate.net/publication/242623967_Les_systemes_multi-agents_un_apercu_general
	http://www.accesocongresos.com/wp-content/uploads/2015/03/Tutorial-Jade.pdf

