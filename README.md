# stock : TD Spring Boot / JPA

Petite API REST de gestion de stock d'articles, faite dans le cadre du TD d'application Spring Boot / JPA.

## Technologies

- Java 17
- Spring Boot 4.1.2 (généré sur start.spring.io)
- Spring Data JPA (Hibernate)
- Spring Web (MVC)
- MySQL
- Spring Boot DevTools

## Base de données

Créer la base dans MySQL :

```sql
CREATE DATABASE stock;
```

La configuration se trouve dans `src/main/resources/application.properties` : `localhost:3306`, utilisateur `root`, mot de passe vide. Les tables sont créées automatiquement au démarrage (`spring.jpa.hibernate.ddl-auto=update`).

## Lancer l'application

```bash
./mvnw spring-boot:run
```

L'API écoute sur `http://localhost:8080`.

## Routes de l'API

| Méthode | URL | Action |
|---|---|---|
| POST | `/api/articles` | Ajouter un article |
| GET | `/api/articles` | Lister tous les articles |
| GET | `/api/articles/{id}` | Afficher un article |
| DELETE | `/api/articles/{id}` | Supprimer un article |

Exemple d'ajout :

```bash
curl -X POST http://localhost:8080/api/articles -H "Content-Type: application/json" -d '{"nom":"Microphone Pro","categorie":"Dispositif interactif - DI","prixUni":75.00,"qte":15}'
```

## Structure

- `model/Article.java` : l'entité JPA (table `article`)
- `repository/ArticleRepository.java` : interface qui étend `CrudRepository<Article, Long>`
- `service/ArticleService.java` : logique métier
- `controller/ArticleController.java` : routes REST sur `/api/articles`

## Diagramme de classes

Voir [diagramme-classes.md](diagramme-classes.md).
