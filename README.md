# My Tasks App

## Overview

The My Tasks App is a Kotlin-based Android application designed to help users manage their tasks effectively. This app allows users to create, read, update, and delete tasks. The backend needed to run the application can be found on [to-do-app-server](https://github.com/GustavoPolicarpo/to-do-app-server) repository.

## Features
- **User Authentication**: Each user can register and log in to manage their tasks.
- **Task Management**: Create, view, update, and delete tasks.
- **Task Control**: Share, mark as complete, and sort tasks.
- **Task Dates**: Assign dates to tasks with easy viewing options.
- **Settings**: Customize task date formats and notification preferences.

## Future Work
- **User Tasks**: Each user can manage only their own tasks.
- **Layout**: Improvements on the layout to make the usability easier.
- **Task Notification**: Raise a notification when the task is about to be delayed.

## Technologies Used
- Android
- Kotlin
- Firebase

## Getting Started

### Prerequisites
- Android Studio
- Java Development Kit (JDK)
- Gradle
- Firebase Project

### Installation

#### Application setup
1. Clone the repository.
2. Open the project in Android Studio.
3. Download your `google-services.json` from your Firebase console and paste it inside the app module folder.
4. Update `build.gradle.tks` defaultConfig properly -- `applicationId` and backend `BASE_URL`
5. Sync the project with Gradle files.
6. Run the app on an emulator or physical device.

#### Backend Setup
Follow the instructions on [to-do-app-server](https://github.com/GustavoPolicarpo/to-do-app-server) repository.