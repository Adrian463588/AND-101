# AND-101

Merupakan Beberapa Challenge Android

# TipCalculator Project

## Project Overview
The **TipCalculator** project is a simple Android application designed to calculate tips based on the service cost entered by the user. The layout consists of text fields, radio buttons for selecting tip percentages, and a switch to round up the tip. The application supports localization in both English and Indonesian.

## Key Objectives
1. **SOLID Principles**: The project follows SOLID principles by ensuring that the code is modular, easy to maintain, and scalable.
2. **Android Studio Installation**: The user must be able to install and configure Android Studio on their local PC and use it to develop Android applications.
3. **Naming Conventions**: The project adheres to standard Android Studio naming conventions for resources, classes, and variables.
4. **Layout Creation**: A basic layout is created using various Android UI components such as `TextView`, `EditText`, and `RadioButton`, while using `ConstraintLayout` for responsive positioning.
5. **Vector Image Integration**: The project demonstrates the ability to include vector images in the layout, providing scalable image resources.
6. **Localization**: The app supports two languages: English and Indonesian. Text resources are localized to ensure the application can switch between the two languages based on the user's device settings.
7. **GIT Integration**: The project demonstrates the implementation of version control using Git. Users are expected to push their code to a remote repository (e.g., GitHub or GitLab).

## Application Functionality
The **TipCalculator** allows users to:
- Enter the cost of a service.
- Select the tip percentage (20%, 18%, or 15%) using radio buttons.
- Toggle an option to round up the tip.
- Calculate the final tip amount based on user input.

## Development Steps

### 1. Create an Android Project
- Start a new project in Android Studio using Kotlin as the programming language.
- Set up the project structure by organizing files and folders according to Android conventions.

### 2. Layout Components
- Use `ConstraintLayout` for positioning elements responsively.
- Add the following UI elements:
  - **EditText** for user input (service cost).
  - **RadioGroup** with multiple `RadioButton`s for selecting tip percentages.
  - **Switch** for rounding up the tip.
  - **Button** to trigger the calculation.
  - **TextView** to display the calculated tip result.

### 3. Customize Views
- Change the text, color, and styling of the views to make the app visually appealing.
- Set input constraints for the cost field (e.g., restrict to decimal input).

### 4. Localization
- Set up `strings.xml` files for both English (`res/values/strings.xml`) and Indonesian (`res/values-in/strings.xml`).
- Ensure that all hardcoded strings are replaced with references to string resources to support localization.

### 5. Vector Image Support
- Add vector assets (SVG) to the `res/drawable` directory to use in the layout, such as icons for buttons or backgrounds.

## Localization Example

Below is an example of `strings.xml` for English and Indonesian localization:

### `res/values/strings.xml` (English)
```xml
<resources>
    <string name="app_name">Tip Calculator</string>
    <string name="cost_of_service">Cost of Service</string>
    <string name="how_was_the_service">How was the service?</string>
    <string name="amazing_service">Amazing (20%)</string>
    <string name="good_service">Good (18%)</string>
    <string name="ok_service">Okay (15%)</string>
    <string name="round_up_tip">Round up tip?</string>
    <string name="calculate">Calculate</string>
    <string name="tip_amount">Tip Amount:</string>
</resources>
```
### `res/values-in/strings.xml` (Indonesian)

```xml
<resources>
    <string name="app_name">Kalkulator Tip</string>
    <string name="cost_of_service">Biaya Layanan</string>
    <string name="how_was_the_service">Bagaimana pelayanannya?</string>
    <string name="amazing_service">Luar Biasa (20%)</string>
    <string name="good_service">Bagus (18%)</string>
    <string name="ok_service">Cukup (15%)</string>
    <string name="round_up_tip">Pembulatan Tip?</string>
    <string name="calculate">Hitung</string>
    <string name="tip_amount">Jumlah Tip:</string>
</resources>
```

### Conclusion

The TipCalculator project demonstrates essential skills in Android development, including working with layouts, UI components, localization, vector image integration, and Git version control. The focus is on creating a functional and user-friendly app with support for multiple languages.



