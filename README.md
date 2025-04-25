# Connect Hub

**Connect Hub** is a Java-based social media application built with JavaFX for a modern UI and JSON for lightweight data persistence. It replicates key features of real-world platforms, offering users the ability to connect, share content, and interact within groups.

## 🛠️ Installation

### Requirements

-   Java 11 or later
-   Maven

### Steps to Install & Run

1. **Clone the repository:**

    ```bash
    git clone https://github.com/eng-abdelrahman-sharaf/Social-Media-APP
    cd SocialMediaApp

    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn clean javafx:run
    ```

## Features

-   **User Management**

    -   Sign up, log in, and log out
    -   Edit profile info, bio, and images
    -   Search users by name

-   **Content Sharing**

    -   Create/view text and image posts
    -   Share 24-hour stories
    -   Post in specific groups

-   **Social Features**
    -   Friend requests and blocking system
    -   View notifications for interactions
    -   Create and manage groups
    -   Join/request group membership

## Tech Stack

-   **Frontend:** JavaFX (FXML-based UI)
-   **Backend:** Pure Java
-   **Data Storage:** JSON files (no database required)

## Architecture & Design

-   Follows clean architecture with separation of UI, logic, and data layers
-   Custom UI components and smooth navigation using `PageLoader` and FXML
-   Utilizes design patterns:
    -   **Singleton** for shared instances (e.g., logged-in user)
    -   **Factory** for dynamic component creation
    -   **Strategy** for validation and search behaviors
    -   **DAO** for abstracting data persistence

## Project Structure

    📦 src/
    └── 📁 main/
        └── 📁 java/
            └── 📁 com/
                └── 📁 MediaApp/
                    ├── 📁 authentication/         # Login/Signup controllers
                    ├── 📁 ContentManagement/      # Post & Story models and logic
                    ├── 📁 DataHandlers/           # JSON-based data persistence
                    ├── 📁 GroupManagement/        # Group creation and interaction
                    ├── 📁 ProfileManagement/      # Profile editing & image updates
                    ├── 📁 RelationsManagement/    # Friends & blocking system
                    ├── 📁 RequestsPage/           # Friend & group requests
                    ├── 📁 SignPage/               # Auth services
                    ├── 📁 UserAccountManagement/  # User data models and roles
                    └── 📁 utils/                  # Helpers & shared utilities
                └── 📁 gui/
                    ├── 📁 content_management_components/  # UI widgets for posts/stories
                    └── 📄 PageLoader.java                # Screen navigation logic
        └── 📁 resources/
            ├── 📄 *.fxml                  # UI layouts
            └── 📁 images/                # Profile & cover images

## 💾 Data Persistence

All app data is stored locally using custom JSON handlers. Files are automatically generated in the project root:

-   `users.json` – Stores user accounts and profile data
-   `posts.json` – Stores user posts and stories
-   `groups.json` – Stores group information and memberships

This lightweight approach simplifies setup and makes the app easy to run without external databases.

## 📌 Summary

Connect Hub is a Java-based social media platform built with JavaFX and JSON. It replicates essential features like authentication, content sharing, user profiles, and social interaction through friends and groups. Designed with modularity in mind, the app follows clean architecture principles and applies key design patterns to ensure scalability and maintainability.

---
