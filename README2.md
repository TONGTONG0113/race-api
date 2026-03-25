**1. Description**

Ce projet est une API REST développée avec Spring Boot.
Elle permet de gérer des courses et d’inscrire des participants à ces courses.

**2. Lancer le projet**

- **Démarrer la base de données**

     -> docker compose up -d 

- **Lancer l’application**

     -> mvn spring-boot:run

     Le serveur est accessible à l’adresse suivante : http://localhost:8080

**3. Endpoints**

**Race**
- **GET /races**

     -> Récupérer toutes les courses

- **GET /races/{id}**

     -> Récupérer une course par son id

- **GET /races/location/{location}**

     -> Récupérer une course par son location

- **POST /races**

     -> Créer une nouvelle course

- **PUT /races/{id}**

     -> Mettre à jour une course

- **DELETE /races/{id}**
     -> Supprimer une course

**Runner**
- **GET /runners**  

     -> Récupérer tous les participants

- **GET /runners/{id}**  

     -> Récupérer un participant par son id

- **POST /runners**  

     -> Créer un participant

- **PUT /runners/{id}**  

     -> Mettre à jour un participant

- **DELETE /runners/{id}**  

     -> Supprimer un participant

**Rigistration**
- **POST /races/{raceId}/registrations?runnerId=1**

     -> Inscrire un participant à une course

- **GET /races/{raceId}/registrations**

     -> Récupérer toutes les inscriptions d’une course