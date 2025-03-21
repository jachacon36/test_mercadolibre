# MercadoLibre Test

## Overview

This project is a MercadoLibre test application that allows users to search for products, view product details, and navigate through different screens seamlessly.

## Technologies Used

- **Languages**: Kotlin, Java
- **Frameworks**: Jetpack Compose, Hilt for Dependency Injection
- **Build System**: Gradle
- **Logging**: Timber

## Architecture

The project follows the Clean Architecture principles, which include:

- **Presentation Layer**: Contains UI components and ViewModels.
- **Domain Layer**: Contains business logic and use cases.
- **Data Layer**: Manages data sources and repositories.

## Design Patterns

- **MVVM (Model-View-ViewModel)**: Used for structuring the presentation layer.
- **Repository Pattern**: Used for managing data access and operations.
- **Use Case Pattern**: Encapsulates business logic and makes it reusable.

## Project Structure

```
app/
├── src/main/java/com/example/testmercadolibre/
│   ├── activity/          # Contains Activity classes
│   ├── application/       # Application class for initializing components
│   ├── navigation/        # Navigation graph and related components
│   ├── presentation/      # UI components and ViewModels
│   ├── domain/            # Business logic and use cases
│   ├── data/              # Data sources and repositories
│   ├── ui/theme/          # UI theme definitions
│   ├── utils/             # Utility classes and functions
│   └── common/            # Common classes and enums
└── build.gradle           # Project build configuration
```

## Key Components

### Presentation Layer

- **Jetpack Compose**: Used for building the UI.
- **ViewModels**: Manage UI-related data and handle business logic.

### Domain Layer

- **Use Cases**: Encapsulate business logic and make it reusable across different parts of the application.

### Data Layer

- **Repositories**: Manage data operations and abstract data sources.

## Getting Started

1. Clone the repository:
   ```sh
   git clone https://github.com/jachacon36/test_mercadolibre.git
   ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

## Preview
<img src="https://github.com/user-attachments/assets/18f639c6-413a-4179-9db0-a65a78b5a2e1" width="200px">

## Screenshots
<img src="https://github.com/user-attachments/assets/2750209b-a2e0-47b2-8f50-8e3dbbcf382d" width="200px">
<img src="https://github.com/user-attachments/assets/1239192d-543b-4dca-8331-e724f802b95f" width="200px">
<img src="https://github.com/user-attachments/assets/b2816005-bf26-4db6-8eb4-c916d50e996b" width="200px">
<img src="https://github.com/user-attachments/assets/85defe3f-3da1-4800-801a-3a92ba57e015" width="200px">
