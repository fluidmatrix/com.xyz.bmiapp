# *BMI Calculator Android App*

A simple Android application developed in **Kotlin** that calculates the **Body Mass Index (BMI)** of a person and displays whether they are **underweight**, **normal weight**, or **overweight**. This app was created as part of an assignment for **123 Start Up** to help staff monitor their health after resuming work from office post-Covid.

---

## *Table of Contents*
* [Features](#features)
* [Screenshots](#screenshots)
* [Technologies Used](#technologies-used)
* [Project Structure](#project-structure)
* [How It Works](#how-it-works)
* [Installation](#installation)
* [Usage](#usage)
* [License](#license)

---

## *Features*
* Calculate BMI based on **weight (kg)** and **height (m)**.
* Determines if the user is:
    * **Underweight** (BMI < 18.5)
    * **Normal weight** (BMI 18.5 – 24.9)
    * **Overweight** (BMI > 24.9)
* Displays the result in **color-coded text**:
    * **Red** for Underweight or Overweight
    * **Green** for Normal weight
* Input includes **age**, **gender**, **weight**, and **height**.
* User-friendly interface with validation and error messages.

---

## *Screenshots*

*Insert your screenshot here to show the working app*

<img width="408" height="738" alt="img" src="https://github.com/user-attachments/assets/4f184038-83ee-4c1d-bec6-95fc4a4173ec" />
<img width="944" height="827" alt="Screenshot 2026-02-19 113034" src="https://github.com/user-attachments/assets/002f7e4d-6441-4191-8bcb-3356a86c9128" />


---

## *Technologies Used*
* **Language:** Kotlin
* **Platform:** Android
* **Minimum SDK:** API 21 (Android 5.0 Lollipop)
* **Android Components:** AppCompatActivity, ConstraintLayout, RadioGroup, EditText, Button, TextView

---

## *Project Structure*

```python 
com.xyz.bmiapp
│
├── MainActivity.kt # Main activity handling UI & user interaction
├── model/
│ ├── Person.kt # Class with age, gender, weight, height & BMI calculation
│ └── BMIStatus.kt # Enum class for BMI categories
├── util/
│ └── Constants.kt # Stores BMI thresholds
└── res/
├── layout/
│ └── activity_main.xml # UI layout using ConstraintLayout
└── values/
├── colors.xml
├── strings.xml
└── themes.xml
```

---

## *How It Works*

1. User enters their **age**, **weight**, **height**, and selects **gender**.
2. Press the **Calculate** button.
3. The app creates a **Person** object and calls the `calculateBMI()` method.
4. The BMI is evaluated using the `BMIStatus` enum:
    * **UNDERWEIGHT** → BMI < 18.5
    * **NORMAL** → 18.5 ≤ BMI ≤ 24.9
    * **OVERWEIGHT** → BMI > 24.9
5. The result is displayed with **2 decimal precision** and color-coded message.

---

## *Installation*

1. Clone the repository:
```python
git clone https://github.com/yourusername/BMI-Calculator-Android.git
```


2. Open the project in **Android Studio**.
3. Make sure **Gradle** syncs properly.
4. Build and run on an **emulator** or **physical device** with minimum API 21.

---

## *Usage*

1. Launch the app.
2. Enter your **age**, **weight (kg)**, **height (m)**.
3. Select your **gender**.
4. Tap **Calculate**.
5. View your **BMI** and **health status** color-coded on the screen.

---

## *License*

This project is **open-source** and available for educational purposes. You can modify or distribute it as needed.

---

*Enjoy tracking your health with this lightweight Kotlin Android app!*
