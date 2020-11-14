# Projet TOOTY en Java

Notre projet TOOTY est un projet programmé en Java. Une adaptation d’un jeu existant en
3D nommé TeamUP !

Ce projet consiste en un jeu collaboratif où une équipe de carreleurs
coopèrent pour paver un mur de 5 unités de largeur. L’équipe dispose de carreaux ayant des
largeurs et des hauteurs différentes comprises entre 1 et 3 unités.

Il existe deux jeux de 9 carreaux, un jeu bleu puis un jeu rouge. Mais une pièce neutre doit
d’abord être posé dans un des deux coins du mur, avec une orientation décidée par l’équipe.

À tour de rôle les carreleurs commencent par piocher une carte parmi 33 cartes fournies, qui
indique la contrainte de choix d’un carreau, couleur bleu ou rouge, taille 1,2 ou 3. Selon la
carte piochée l’équipe devra choisir parmi les carreaux qui correspondent à la consigne et
choisir où le placer (coordonnées). Pour une carte de couleur rouge l’équipe pourra poser
n’importe quel carreau ayant une lettre majuscule (A, B, C…, I), pour une taille de 2 l’équipe
pourra poser un carreau qui a une hauteur de 2 et/ou largeur de 2.

Enfin la partie s’achève lorsque tous les carreaux ont été posés ou que les cartes à piocher
sont épuisées ou alors que les joueurs décident de stopper la partie. Enfin le score sera
évalué à l’aide du nombre de niveaux ayant été complètement carrelés, le nombre de
carreaux non posés et les cartes dont la consigne n’a pu être réalisée.

### Crédits

Daniel Aguiar - Frédérico Lopez
