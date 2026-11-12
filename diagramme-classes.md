# Diagramme de classes

Le diagramme se lit du haut vers le bas : le Controller appelle le Service, le Service appelle le Repository, et le Repository gère l'entité `Article`.

```mermaid
classDiagram
    direction TB

    class StockApplication {
        +main(args) void
    }

    class ArticleController {
        -ArticleService articleService
        +createArticle(article) Article
        +getAllArticles() Iterable~Article~
        +getArticleById(id) Article
        +deleteArticle(id) void
    }

    class ArticleService {
        -ArticleRepository articleRepository
        +saveArticle(article) Article
        +getAllArticles() Iterable~Article~
        +getArticleById(id) Article
        +deleteArticleById(id) void
    }

    class ArticleRepository {
        <<interface>>
    }

    class CrudRepository~T, ID~ {
        <<interface>>
        +save(entity) S
        +findAll() Iterable~T~
        +findById(id) Optional~T~
        +deleteById(id) void
    }

    class Article {
        -Long id
        -String nom
        -String categorie
        -double prixUni
        -int qte
        +Article(nom, categorie, prixUni, qte)
        +Article()
        +getId() Long
        +getNom() String
        +setNom(nom) void
        +getCategorie() String
        +setCategorie(categorie) void
        +getPrixUni() double
        +setPrixUni(prixUni) void
        +getQte() int
        +setQte(qte) void
    }

    ArticleController --> ArticleService : utilise
    ArticleService --> ArticleRepository : utilise
    ArticleRepository --|> CrudRepository : étend
    CrudRepository ..> Article : T = Article, ID = Long
    ArticleController ..> Article : reçoit et renvoie
```

## Légende

- `-` : attribut privé
- `+` : méthode publique
- `-->` : une classe utilise l'autre
- `--|>` : une interface en étend une autre
- `..>` : dépendance (une classe manipule l'autre sans la stocker)
