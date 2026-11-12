# stock

tp spring boot jpa, une api pour gerer un stock d'articles (ajouter, lister, voir, supprimer)

techno utilisees : java 17, spring boot 4.1.2, spring data jpa, spring web, mysql, devtools

## base de donnees

il faut creer la base stock dans mysql :

```sql
CREATE DATABASE stock;
```

la config est dans src/main/resources/application.properties (localhost:3306, user root, mdp vide). les tables se creent toutes seules au lancement.

## lancer

```bash
./mvnw spring-boot:run
```

l'api ecoute sur localhost:8080

## routes

- POST /api/articles : ajoute un article
- GET /api/articles : liste les articles
- GET /api/articles/{id} : affiche un article
- DELETE /api/articles/{id} : supprime un article

exemple pour ajouter un article :

```bash
curl -X POST http://localhost:8080/api/articles -H "Content-Type: application/json" -d '{"nom":"Microphone Pro","categorie":"Dispositif interactif - DI","prixUni":75.00,"qte":15}'
```

## fichiers

- model/Article.java : l'entite
- repository/ArticleRepository.java
- service/ArticleService.java
- controller/ArticleController.java

diagramme : diagramme-classes.md
