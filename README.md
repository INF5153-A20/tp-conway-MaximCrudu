# TP Individuel - Le Jeu de la Vie

  - Auteur : Sébastien Mosser
  - Version : 2020.09
  - Date de remise : dimanche 4 octobre, 23h55

**Lisez bien le sujet jusqu'au bout avant de commencer à travailler sur le projet.**

## Objectifs du projet

  1. Prendre en main les outils utilisés en support du cours;
  2. Analyser un code légataire en vue de le faire évoluer;
  3. Transformer ce code en véritable application orientée objet;
  4. Faire évoluer un code objet en respectant dans la mesure du possible :
  5. Décrire une application orientée objet avec le langage UML (diagrammes d'_objets_, de _séquences_ et de _classes_).

Les ateliers sont des temps où l'équipe enseignante (prof / auxilliaires) est présente pour vous donner de la rétro-action sur votre projet. Il est vital de profiter de ce temps de travail prévu dans votre emploi du temps pour améliorer vos projets avant la remise finale.

### Consignes 

  1. Votre projet doit être sur GitHub à 23:55 (heure de Montréal) le jour de la date de remise, où un script le récupèrera automatiquement. 
  2. Vous devez répondre en français aux quatre (4) questions posées dans ce sujet dans le fichier `Reponses.md`
  3. Vous devez enregistrer votre code dans Git sous votre vrai nom, et lier votre compte _Classroom_ à votre code permanent. 
  4. Vos trois modèles (`object_diagram.puml`, `sequence_diagram.puml` et `class_diagram.puml`) doivent se trouver à la racine, au format `PUML`.  
  5. Votre code doit compiler et tester (sans échouer) en lançant la commande `mvn clean package` à la racine de votre projet (voir résultats de l'intégration continue).
  6. Votre code doit se lancer depuis la ligne de commande, toujours depuis la racine :
      * `mvn -q exec:java -Dexec.args="_examples/beehive.txt 42"` 

**Toute remise ne respectant pas ces consignes ne sera pas évaluée et obtiendra la note de zéro (0).**

N'oubliez pas de configurer Git pour que l'on puisse faire le lien entre votre travail sur ce projet et votre identité à l'Université. Pour vous en assurer, lancez les commandes suivantes dans le repertoire du projet, **sur toutes les machines utilisées pour travailler sur le projet**. 

Si vous ne voulez pas répéter cette opération a chaque fois que vous réalisez un nouveau projet, ajoutez l'option `--global` pour dire à git que ces informations sont globales à votre système et non locale à ce projet en particulier.

```
mosser@lucifer tp$ git config user.email "mon_addresse@courriel.ca"
mosser@lucifer tp$ git config user.name  "MonVraiPrénom MonVraiNom"
```


### Environnement nécessaire et outillage

  1. Java (version 13)
  2. Maven (version 3.x)
  3. Git (version 2.x)
  4. Un environment de développement récent (_p.-ex_, IntelliJ)
  5. PlantUML (environnement de modélisation)
  6. Un compte GitHub

## Spécifications

On s'intéresse ici au [jeu de la vie](https://fr.wikipedia.org/wiki/Jeu_de_la_vie) de Conway. Cette simulation se joue sur un plateau carré de dimension `n`, ou chaque case (_cellule_)du plateau peut être ou vivante, ou morte. Des règles d'affaire permettent de faire passer les cellules d'un état à l'autre : 

1.	Une cellule morte devient « vivante » si elle est entourée d’exactement 3 cellule vivantes voisines (naissance) ;
2.	Une cellule « vivante » qui a 2 ou 3 cellule vivantes voisine reste vivante (maintien) ;
3.	Une cellule « vivante » meurt si elle a moins de 2 cellule vivantes voisines (sous-population) ;
4.	Une cellule « vivante » qui a plus de 3 cellule vivantes voisine meurt (surpopulation).

Vous disposez dans ce projet d'un code fonctionnel implémentant ces règles d'affaires, dans le fichier `src/main/java/conway/Main.java`.

### Lecture de la situation initiale

Les situations initiales (l'état du plateau avant le début de la simulation) est décrit dans un fichier texte, au format suivant : 

- La première ligne est la dimension du plateau
- Puis, chaque ligne décrit la ligne associée du plateau :
  - le caractère `_` indique une cellule morte
  - le caractère `X` indique une cellule vivante

Ainsi, le fichier suivant décrit une situation initiale où le plateau de jeu est de taille `4`, et où les cellules (0,0) et (3,3) sont vivantes.

```
4
X _ _ _
_ _ _ _
_ _ _ _
_ _ _ X
```

### Exécution du programme

Le programme prend en paramètres : _(i)_ le fichier de situation initiale à utiliser et _(ii)_ le nombre de pas de simulation à effectuer. Une fois la simulation terminée, le programme affiche sur la sortie standard le plateau final, dans le même format que celui utilisé pour lire la situation initiale.

Vous trouverez des exemples de situations initiales dans le repertoire `_examples`


## Travail 1 : Analyse du Code Légataire

Le code source légataire fourni est stocké dans le repertoire `src/main/java`, en respect des conventions Maven. La classe `conway.Main` contient l'implémentation de départ d'un programme répondant (on l'espère) aux spécifications.

### Question 1: Audit du code légataire

Le service juridique a reçu une plainte concernant notre Jeu de la vie. Nous devons prouver que les règles d'affaire officielle du Jeu sont bien implémentée dans notre code, et qu'il n'y a pas de fraude dans nos simulations. 

Em vous appuyant sur la base du code fourni, expliquez en un paragraphe et en des termes compréhensibles par des non-informaticiens comment le programme respecte les quatre règles d'affaires.

### Question 2 : Analyse des défauts du code légataire

Identifiez dans le code fourni tous les défauts que celui-ci possède. Pointez précisément dans le code la localisation de ces défauts.

## Travail 2 : Ré-usinage en code objet 

Proposez une nouvelle version du Jeu de la vie, qui possédera une meilleure conception orientée objet. Votre nouveau programme doit être iso-fonctionnel avec celui fourni initialement.
 
A l'aide de PlantUML, définissez un diagramme de classes, un diagramme d'objet et un diagramme de séquence qui serviront de support à l'explication de votre conception. Ces diagrammes n'ont pas pour but d'être exausthif, mais de supporter les points clés de votre conception objet, d'un point de vue statique et dynamique.
 
## Travail 3 : Justification de vos choix de conception

### Question 3: Justification des choix de conceptions

Justifiez le choix des concepts que vous avez identifié dans votre modèle de conception, particulièrement en expliquant comment votre modèle respecte les propriétés architecturale demandées.

Si vous pensez que votre conception souffre de certaines faiblesses, indiquez les, et expliquez pourquoi ce sont des faiblesses.
 
### Question 4 : Évolution du code objet
  
Votre conception permettrait-elle de mettre en oeuvre une autre simulation que le jeu de la vie ? Par exemple, comment intégrez un mode de simulation qui implémenterai le modèle de la [Fourmi de Langton](https://fr.wikipedia.org/wiki/Fourmi_de_Langton) ?

Indiquez en un court paragraphe comment votre cocneption permettrai de le faire.
  
## Grille d'évaluation

Les trois éléments suivants sont évalués : _(i)_ vos réponses aux questions (pour 35%), _(ii)_ vos modèles de conception (pour 35%), et enfin _(iii)_ votre code Java et les tests associés (pour 30%). La qualité du français dans les réponses aux questions est prise en compte (avec un malus maximal de 25%).

| Élement      | Critère d'évaluation                       | Note (/100) |
| :---:        | :---                                       | :---: |
|  _Questions_ | (#1) Audit du code légataire               | /5    |
|              | (#2) Analyse des défauts du code légataire | /10   |
|              | (#3) Justification des choix de conception | /15   |
|              | (#4) Évolution du code objet               | /5    |
|  _Modèles_   | Justesse & Pertinence de la conception     | /15   |
|              | Cohérence inter-modèles                    | /5    |
|              | Respect des principes de conception        | /15   |
|  _Code_      | Qualité du code Java et du dépôt Git       | /10   |
|              | Cohérence du code avec les modèles         | /10   | 
|              | Qualité des tests                          | /10   | 
| **Malus**    | Non respect des consignes de livraisons    | -100% |


Si vous êtes arrivé à ce stade du document, c'est que vous l'avez lu en entier, comme demandé dans la consigne au tout début du sujet. Envoyez en message privé au professeur sur le Mattermost la photo d'un animal mignon (p.-ex. une loutre, un chaton, un chiot, un capybara) pour en témoigner. 

Les cinq (5) premiers étudiants à remplir cette condition bénéficieront de cinq (5) points bonus sur l'évaluation de ce projet (la note maximale reste de 100).