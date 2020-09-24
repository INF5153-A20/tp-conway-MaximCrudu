# Réponses aux questions

  - Auteur : Crudu, Maxim (`CRUM05038606`)
  - Temps passé sur le projet : `x` heures.

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

## Question 4
