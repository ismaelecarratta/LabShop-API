# 🎮 LabShop API
Questo progetto è una REST API realizzata in **Spring Boot** e **Java** per il progetto frontend [LabShop](https://github.com/ismaelecarratta/LabShop-Frontend)



| 🛠️ Tecnologie usate | 🚀 Entità gestite |
|--------------------- |------------------------------|
| **Spring Boot**      | **Categorie** (`category`)   |
| **Spring Data JPA**  | **Piattaforme** (`platform`) |
| **MySQL**            | **Giochi** (`game`)          |


## 🧩 Struttura degli Endpoint

### 🕹️ `game`

| Metodo | Endpoint                     | Descrizione                                                    | Parametri            | Tipo   |
|--------|------------------------------|----------------------------------------------------------------|----------------------|--------|
| GET    | `/game/all`                  | Restituisce tutti i giochi                                     |                      |        |
| GET    | `/game/{id}`                 | Restituisce gioco con id indicato                              |                      |        |
| GET    | `/game/search`               | Restituisce giochi con titolo indicato                         | `text`               | string |
| GET    | `/game/range`                | Restituisce giochi nel range di prezzo                         | `start`  `end`       | int    | 
| GET    | `/game/filter`               | Filtra giochi per id categoria, piattaforma, prezzo            | `cat` `plat` `price` | int    | 
| POST   | `/game/save`                 | Salva un nuovo gioco                                           |                      |        |
| PUT    | `/game/update`               | Aggiorna un gioco esistente                                    |                      |        |
| DELETE | `/game/{id}`                 | Elimina gioco con id indicato                                  |                      |        |


### 📂 `category`

| Metodo | Endpoint            | Descrizione                  |
|--------|---------------------|------------------------------|
| GET    | `/category/all`     |  Restituisce tutti le categorie    |
| GET    | `/category/{id}`    |Restituisce categoria con id indicato    |
| POST   | `/category/save`    | Salva una nuova categoria    |
| PUT    | `/category/update`  | Aggiorna una categoria esistente       |
| DELETE | `/category/{id}`    | Elimina categoria con id indicato  |


### 💻 `platform`

| Metodo | Endpoint            | Descrizione                    |
|--------|---------------------|--------------------------------|
| GET    | `/platform/all`     | Restituisce tutte le piattaforme   |
| GET    | `/platform/{id}`    | Restituisce piattaforma con id indicato |
| POST   | `/platform/save`    | Salva una nuova piattaforma    |
| PUT    | `/platform/update`  | Aggiorna una piattaforma esistente      |
| DELETE | `/platform/{id}`    | Elimina piattaforma con id indicato |
