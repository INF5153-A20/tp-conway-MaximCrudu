# Réponses aux questions

  - Auteur : Crudu, Maxim (`CRUM05038606`)
  - Temps passé sur le projet : `38` heures.

## Question 1
Suite à l’analyse, on a pu constater que le code en question répond aux exigences de base en termes d'affichage d'un 
résultat correspondant aux attentes. Ici, on ne considérera pas le bogue trouvé (voir détails à la Question 2) qui rend
 le résultat erroné dans certaines situations. 
En général, on ne peut pas dire que le code fourni est bien aligné avec la logique d’affaire en termes de notions et 
d'entités dont les noms ne rendent pas le code plus compréhensible. Mais quand même, si nous partons du fait que les 
cellules ne peuvent avoir que deux états vivants ou morts, leur représentation sous forme de valeurs booléennes pourrait
 être acceptable. Et surtout, ces valeurs seront attribuées en fonction de la représentation des cellules en utilisant 
 deux états `X` vivante ou `_` morte. Aussi, dans le code sont présentes les conditions qui correspondent aux règles 
 d’affaire qui permettent aux cellules de passer d'un état à un autre.

## Question 2
Dès le début de l'analyse de ce code, j'ai eu quelques difficultés à le comprendre. Tout d'abord à cause des noms des 
variables qui m'ont rendu confus et j'ai dû faire quelques commentaires entre les lignes pour comprendre l'idée. 
De même, n'utiliser que des données primitives (Primitive Obsession) rend le code moins lisible. De plus, l'utilisation 
de ces valeurs mentionnées ci-dessus dans les sections des structures de contrôle diminue également la clarté du code, 
comme par exemple:
```
Ligne
62                  if (y+1 < d && gs[x+1][y+1])
```
De même, un bug est identifié dans le source légataire. En fait, il s’agit de la partie qui analyse l’ état de cellules 
autour de chacune. Dans ce cas, on a fait l’ajustement suivant:
```
Ligne          code légataire               changement          
52      if (x-1 > 0)                      if (x > 0)  
53      if (y-1 > 0 && gs[x-1][y-1])      if (y > 0 && gs[x-1][y-1])
57      if (y-1 > 0 && gs[x][y-1])        if (y > 0 && gs[x][y-1]) 
60      if (y-1 > 0 && gs[x+1][y-1])      if (y > 0 && gs[x+1][y-1])
```
Dans le cas du code d'origine, lors de la vérification de l'état de cellules il est omise la première ligne et la 
première colonne de la grille, ce qui n'a pas conduit par la suite au résultat correct concernant le nombre de cellules 
autour de la cellule à évaluer.
En outre, il peut être mentionné comme un point négatif le fait que ce code est introduit dans le main. Donc, en 
l'absence d'une bonne structure et modularité (manque d'encapsulation), ce code ne peut pas être réutilisé et il est 
également difficile de le maintenir.

## Question 3
Bien entendu, la nouvelle version est basée sur le principe de conception orienté objet. Dans ce cas, on a identifié 
les concepts suivants: 
- **Read**. Vise à lire le contenu du fichier entré dans les paramètres. Dans ce cas, on a voulu créer cette entité 
pour la séparer de la classe Main. 
- **Validation**. Cette classe est destinée à valider les caractères contenus dans le fichier. Elle reçoit les lignes 
lues par la classe Read en validant son contenu. À ce stade, en fonction des caractères contenus, de nouveaux tableaux
contenant les valeurs booléenes correspondantes sont créés.
- **Plateau**. C'est l'un des concepts de base de ce modèle. En fait, il est composé d'une liste de listes de cellules
 qui reçoit l'information à entrer depuis la classe Read. Cette structure dynamique, à mon avis, serait un avantage dans 
le cas d'une extension de ce programme (avantage par rapport au tableau[][]). 
- **Cellule**. Également l'un des concepts de base qui contient une valeur concernant l'état de vie, ainsi que ses 
coordonnées.
- **Coordonnee**. On a introduit ce concept afin d'identifier plus facilement l'emplacement de la cellule.
- **JeuDeLaVie**. Le concept qui représente les règles d'affaire du jeu. 

Bien sûr, je ne peux pas dire que ce modèle de conception est d'une grande qualité et sans lacunes. Tout d'abord, 
il y a des endroits où il y a un couplage assez fort entre les classes (visible sur le diagramme de classes). Cela aura 
un impact négatif sur la réutilisation du code.
Deuxièmement, je ne suis pas sûr du choix correct de la structure des cellules, en fait il s'agit de la présence 
de l'attribut de coordonnées. Bien sûr, il y a des lacunes concernant l'entité Plateau. Ici, on trouve correct le fait 
d'implimenter l'interface Iterable qui permet d'itérer les éléments du Plateau, mais cela n'a été possible qu'après 
avoir créé une liste de pointeurs vers la grille. Donc pour avoir accès aux données du plateau, une structure 
supplémentaire est nécessaire. De même, j'ai des doutes concernant la classe Verification, qui me semble concerner 
non seulement la validation, mais aussi la création d'une nouvelle structure. 



## Question 4
À mon avis, ce code pourrait être adapté pour simuler ce genre de modèle. Premièrement, on peut créer une classe 
similaire à JeuDeLaVie mais avec ses propres règles de fonctionnement. Bien sûr, cela ne sera pas entièrement conforme 
aux règles d'affaire. Parce que, par exemple dans la classe Plateau, il est introduite la notion d'état de vie de la 
cellule, mais pas la couleur. Le même pour la classe Cellule, ses notions sont étroitement liées au concepts du jeu 
de la vie. Bien sûr, afin de pouvoir détacher le code d'un modèle de simulation particulier, il faut créer une classe 
abstraite Plateau qui contiendra les méthodes communes pour ces deux modèles, puis chaque modèle ajout ou/et redéfinit 
ses propres méthodes dans leurs classes.