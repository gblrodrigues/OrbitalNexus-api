# OrbitalNexus API
![API Version](https://img.shields.io/badge/API-v1.0-blue)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.3-7F52FF)](https://kotlinlang.org/)
[![Ktor](https://img.shields.io/badge/Ktor-3.5-087CFA)](https://ktor.io/)
[![Koin](https://img.shields.io/badge/Koin-4.2.1-purple)](https://insert-koin.io/)

OrbitalNexus API is a REST API built with Kotlin, Ktor, Exposed, Koin and H2 Database for managing planets, missions and astronauts in a fictional space exploration system.
> This API serves as the backend for the [OrbitalNexus Android application](https://github.com/gblrodrigues/OrbitalNexus-android).

* [Technologies Used](#technologies-used)
* [Features](#features)
* [Running the Project](#running-the-project)
* [API Endpoints](#api-endpoints)
* [Example Responses](#example-responses)
* [Localization](#localization)
* [Project Structure](#project-structure)
* [Contact](#contact)

## Technologies Used

| Category | Technology | Why |
|----------|------------|-----|
| Language | [![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge\&logo=kotlin\&logoColor=white)](https://kotlinlang.org/) | Main development language (my favorite 💜)
| Framework | [![Ktor](https://img.shields.io/badge/Ktor-087CFA?style=for-the-badge\&logo=ktor\&logoColor=white)](https://ktor.io/) | Backend framework for building REST APIs
| SQL Framework | ![Exposed](https://img.shields.io/badge/Exposed-FF6B6B?style=for-the-badge) | SQL framework used for database access and queries
| Database | ![H2](https://img.shields.io/badge/H2_Database-1E88E5?style=for-the-badge) | Embedded relational database for local persistence |
| Dependency Injection | [![Koin](https://img.shields.io/badge/Koin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://insert-koin.io/) | Dependency injection framework
| Serialization | ![Kotlinx Serialization](https://img.shields.io/badge/Kotlinx_Serialization-7F52FF?style=for-the-badge) | JSON serialization and deserialization

## Features

### Planets
* List all planets
* Find planet by ID
* List missions by planet
* Multilingual planet descriptions

### Missions
* List all missions
* Find mission by ID
* Mission objectives and descriptions
* Multilingual mission content
* Retrieve mission planet

### Astronauts
* List all astronauts
* Find astronaut by ID
* List astronauts by mission
* Provide astronaut profile image URLs

### Platform
* Locale-based API responses
* Automatic fallback to default locale
* Serve static image assets

## Running the Project

Clone the repository:

```bash
git clone https://github.com/gblrodrigues/OrbitalNexus-api.git
```

Navigate to the project folder:

```bash
cd OrbitalNexus-api
```

Run the application:

```bash
./gradlew run
```

The server will start at:

```text
http://localhost:8080
```

## API Endpoints

### Planets
| Method | Endpoint | Description |
|----------|------------|-----|
| GET | /v1/planets | List all planets
| GET | /v1/planets/{id} | Find planet by ID |
| GET | /v1/planets/{id}/missions | List missions by planet |

### Missions
| Method | Endpoint | Description |
|----------|------------|-----|
| GET | /v1/missions | List all missions
| GET | /v1/missions/{id} | Find mission by ID
| GET | /v1/missions/{id}/astronauts | List astronauts by mission
| GET | /v1/missions/{id}/planet | Retrieve mission planet

### Astronauts
| Method | Endpoint | Description |
|----------|------------|-----|
| GET | /v1/astronauts | List all astronauts
| GET | /v1/astronauts/{id} | Find astronaut by ID

### Localization Examples

| Endpoint | Description |
|----------|------------|
| GET /v1/planets?lang=pt-BR | Returns planets in Portuguese
| GET /v1/planets/1?lang=es-ES | Returns a planet in Spanish
| GET /v1/missions?lang=pt-BR | Returns missions in Portuguese
| GET /v1/missions/1?lang=es-ES | Returns a mission in Spanish

## Example Responses

GET /v1/missions/1

```json
{
  "id": 1,
  "name": "Aurora VII",
  "missionObjective": "Survey Kepler Prime and identify suitable landing zones for future expeditions.",
  "description": "The first manned mission to Kepler Prime, focused on planetary mapping and environmental analysis.",
  "planetId": 1,
  "launchYear": 2042
}
```

**GET /v1/missions/1/astronauts**

```json
[
  {
    "id": 1,
    "name": "Luna Carter",
    "nationality": "Terran",
    "missionId": 1,
    "image": "/assets/astronauts/Luna_Carter_image_profile.png"
  }
]
```

**GET /v1/missions/1/planet**

```json
{
  "id": 1,
  "name": "Kepler Prime",
  "description": "Rocky planet located in the Vega sector."
}
```

## Localization
All planet and mission endpoints support localization through the `lang` query parameter.
> If a translation is not available for the requested locale, the API automatically falls back to the default locale (`en-US`).

Supported locales:
* en-US (default)
* pt-BR
* es-ES

**GET /v1/missions/1?lang=es-ES**
```json
{
  "id": 1,
  "name": "Aurora VII",
  "missionObjective": "Explorar Kepler Prime e identificar zonas de aterrizaje adecuadas para futuras expediciones.",
  "description": "La primera misión tripulada a Kepler Prime, centrada en la cartografía planetaria y el análisis ambiental.",
  "planetId": 1,
  "launchYear": 2042
}
```

## Project Structure

```text
src/main/kotlin/com/gblrod/orbitalnexus
│
├── application
│   ├── Application.kt
│
├── database
│   ├── mapper
│   ├── seed
│   ├── AstronautsTable.kt
│   ├── DatabaseFactory.kt
│   ├── MissionsTable.kt
│   ├── MissionTranslationsTable.kt
│   ├── PlanetsTable.kt
│   └── PlanetTranslationsTable.kt
│
├── di
│   └── AppModule.kt
│
├── model
│   ├── Astronaut.kt
│   ├── ErrorResponse.kt
│   ├── Mission.kt
│   ├── Planet.kt
│
├── plugins
│   ├── Koin.kt
│   ├── Routing.kt
│   ├── Serialization.kt
│   └── StatusPages.kt
│
├── repository
│   ├── impl
│   └── interfaces
│
├── routes
│   ├── AstronautRoutes.kt
│   ├── MissionRoutes.kt
│   ├── PlanetRoutes.kt
│
├── service
│   ├── impl
│   └── interfaces
│
```

## Architecture

```text
Client Request
      ↓
Routes
      ↓
Services
      ↓
Repositories
      ↓
Database (Exposed + H2)

Dependencies managed by Koin
```

## Related Projects

### OrbitalNexus Android
Android client built with:
* Kotlin
* Jetpack Compose
* Retrofit
* Koin
* MVVM + StateFlow

🔗 [Repository](https://github.com/gblrodrigues/OrbitalNexus-android)

## Contact

🔗 [LinkedIn](https://www.linkedin.com/in/gblrodrigues/)
