# Login Project

An Android app built with Kotlin and Jetpack Compose, showcasing a simple welcome / sign in / sign up authentication flow with a custom Material 3 theme.

## Features

- **Welcome screen** with sign in / sign up entry points and social login icons
- **Sign in screen** with email and password fields
- **Sign up screen** with name, email/phone, password, and confirm password fields
- Client-side form validation (empty fields, email format, password match)
- Custom gradient theme and reusable UI components
- Compose `@Preview` support for all screens and shared components

## Tech stack

- Kotlin
- Jetpack Compose (Material 3)
- Gradle Kotlin DSL / Version Catalog

## Project structure

```
app/src/main/java/com/example/loginproject/
├── MainActivity.kt          # App entry point
├── LoginProjectApp.kt       # Screen navigation state machine
├── screens/                 # WelcomeScreen, LoginScreen, SignUpScreen
├── components/              # Shared reusable Compose components
└── ui/theme/                # Colors, gradients, typography, Material theme
```

## Getting started

1. Open the project in Android Studio.
2. Let Gradle sync the dependencies.
3. Run the `app` configuration on an emulator or physical device (minSdk 24).

## Building from the command line

```bash
./gradlew assembleDebug
```