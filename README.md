Cette application est une API REST Spring Boot permettant de gérer un panier d’achat (produits, items, sous‑total, taxe, total).
Elle utilise une base H2 en mémoire, des migrations Flyway, une documentation Swagger, et peut être exécutée avec ou sans Docker.

Technologies principales
Java 17 , Spring Boot 3 (Web, JPA, Validation) ,H2 Database (mode mémoire) ,Flyway (migration automatique) ,Lombok ,MapStruct ,Swagger / OpenAPI ,Docker (exécution simplifiée) ,Base de données H2 (en mémoire)
Aucune installation requise

La base est recréée à chaque démarrage

Flyway applique automatiquement les scripts SQL

HTTPS activé
Port sécurisé : 8443

Certificat auto‑signé inclus dans le projet (cart-keystore.p12)

▶️ Exécuter l’application sans Docker
Prérequis
Java 17 + Maven +Un IDE (IntelliJ recommandé)

Commandes bash

mvn clean install

mvn spring-boot:run
L’application démarre sur :8443

Code
https://localhost:8443
🐳 Exécuter l’application avec Docker
1. Construire l’image
bash
docker build -t shopping-cart .
2. Lancer le conteneur
bash
docker run -p 8443:8443 shopping-cart
L’API est accessible immédiatement via :

Code
https://localhost:8443
Aucune installation Java/Maven n’est nécessaire côté manager.

📘 Accès utiles
Swagger UI (documentation API)
https://localhost:8443/swagger-ui.html

H2 Console (visualiser la base)
https://localhost:8443/h2-console

JDBC URL : jdbc:h2:mem:cartdb

User : sa

Password : (vide)

📦 Fonctionnalités exposées par l’API
Produits

Ajouter un produit

Lister les produits

Panier

Ajouter un item

Modifier un item

Supprimer un item

Obtenir le résumé du panier (sous‑total, taxe, total, items
