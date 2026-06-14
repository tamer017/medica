# Medica — Flutter Healthcare App

> **Flutter medical application with appointment booking, doctor profiles, symptom checker, and prescription management — designed with accessibility-first healthcare UX principles.**

[![Flutter](https://img.shields.io/badge/Flutter-3.x-blue.svg)](https://flutter.dev/)
[![Dart](https://img.shields.io/badge/Dart-3.x-blue.svg)](https://dart.dev/)
[![Domain](https://img.shields.io/badge/Domain-Healthcare-green.svg)]()

---

## Overview

**Medica** is a Flutter mobile healthcare application providing a complete patient-facing interface for medical services. The app prioritizes **accessibility-first design** — high-contrast text, minimum 44dp touch targets, simplified navigation patterns — making it usable for elderly and non-technical medical patients.

---

## Features

### Appointment Booking
- Browse doctors by specialty (Cardiology, Dermatology, General Practice, etc.)
- Calendar-based availability picker with real-time slot selection
- Appointment confirmation with SMS/push notification mockup
- Upcoming and past appointments history view

### Doctor Profile Cards
- Name, specialty, years of experience, clinic location
- Star rating with patient review count
- Profile photo with fallback avatar
- "Book Now" CTA with one-tap booking entry

### Symptom Checker
- Body region selector (head, chest, abdomen, limbs)
- Symptom multi-select with severity slider
- Suggested specialist routing based on symptom combination
- Emergency flag for critical symptom patterns

### Prescription Management
- Active prescription list with medication name, dosage, frequency
- Refill reminder scheduling
- Prescription history with doctor notes
- QR code export for pharmacy integration

---

## Accessibility Design Principles

| Principle | Implementation |
|---|---|
| **Touch targets** | Minimum 44dp for all interactive elements |
| **Color contrast** | WCAG AA ≥ 4.5:1 for all text |
| **Font sizing** | Dynamic text size respecting system settings |
| **Navigation** | Max 3 taps to reach any feature |
| **Error states** | Plain-language error messages (no technical codes) |

---

## App Structure

```
lib/
├── main.dart
├── screens/
│   ├── home_screen.dart
│   ├── doctors_screen.dart
│   ├── appointment_screen.dart
│   ├── symptom_checker_screen.dart
│   └── prescriptions_screen.dart
├── widgets/
│   ├── doctor_card.dart
│   ├── appointment_tile.dart
│   └── symptom_selector.dart
└── models/
    ├── doctor.dart
    ├── appointment.dart
    └── prescription.dart
```

---

## Installation

```bash
git clone https://github.com/tamer017/medica.git
cd medica
flutter pub get
flutter run
```

---

## Skills & Concepts

`Flutter` `Dart` `Healthcare UX` `Accessibility` `UI Design Patterns` `Mobile Development` `Appointment Systems` `Form Design` `Prescription Management`

---

## Author

**Ahmed Tamer Assy** — [GitHub](https://github.com/tamer017) | Machine Learning Researcher @ Volkswagen AG
