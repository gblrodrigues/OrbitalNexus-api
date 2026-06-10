# OrbitalNexus

OrbitalNexus is a REST API built with Kotlin, Ktor, Exposed, Koin and H2 Database for managing planets, missions and astronauts in a fictional space exploration system.
> This API serves as the backend for the [OrbitalNexus Android application](https://github.com/gblrodrigues/OrbitalNexus-android).

* [Technologies Used](#technologies-used)
* [Features](#features)
* [Running the Project](#running-the-project)
* [API Endpoints](#api-endpoints)
* [Example Responses](#example-responses)
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

* List all planets
* Find planet by ID
* List missions by planet
* List all missions
* Find mission by ID
* Retrieve mission planet
* List astronauts by mission
* List all astronauts
* Find astronaut by ID

## Running the Project

Clone the repository:

```bash
git clone https://github.com/gblrodrigues/orbitalnexus.git
```

Navigate to the project folder:

```bash
cd orbitalnexus
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

## Example Responses

GET /v1/missions/1

```json
{
  "id": 1,
  "name": "Aurora VII",
  "planetId": 1,
  "launchYear": 2042
}
```

GET /v1/missions/1/astronauts

```json
[
  {
    "id": 1,
    "name": "Luna Carter",
    "nationality": "Terran",
    "missionId": 1,
    "image": null
  }
]
```

GET /v1/missions/1/planet

```json
{
  "id": 1,
  "name": "Kepler Prime",
  "description": "Rocky planet located in the Vega sector."
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
│   ├── AstronautsTable.kt
│   ├── DatabaseFactory.kt
│   ├── MissionsTable.kt
│   └── PlanetsTable.kt
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
