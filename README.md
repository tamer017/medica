# Medica — COVID-19 PCR Consultation & Hospital Locator App

> A Flutter mobile application connecting patients with medical facilities during the COVID-19 pandemic — enabling symptom submission, PCR test scheduling, and real-time hospital location lookup without physical crowding.

[![Language](https://img.shields.io/badge/Language-Dart-blue?style=flat-square)](https://dart.dev/)
[![Framework](https://img.shields.io/badge/Framework-Flutter-teal?style=flat-square)](https://flutter.dev/)
[![Domain](https://img.shields.io/badge/Domain-Healthcare%20Technology-green?style=flat-square)]()

---

## Overview

**Medica** was developed to address a critical healthcare logistics problem during the COVID-19 pandemic: overwhelming demand at PCR testing labs causing dangerous crowd conditions. The app creates a **digital triage and consultation layer** — patients submit symptoms remotely, receive medical guidance, and are directed to the nearest available hospital — reducing unnecessary physical visits and protecting both patients and healthcare workers.

---

## App Architecture — Two-Part System

### Part 1: Patient Interface
The patient-facing module allows individuals to:
- **Submit symptoms** via a structured form (fever, cough, fatigue, loss of smell/taste, shortness of breath, etc.)
- **Receive preliminary guidance** based on symptom severity (self-isolate / book PCR / seek emergency care)
- **Schedule a PCR test appointment** at a nearby hospital without physically queueing
- **Track test status** and receive result notifications
- **Consult a doctor remotely** via in-app messaging to avoid unnecessary lab visits

### Part 2: Hospital & Location Module
The hospital discovery module provides:
- **Real-time map view** of nearby hospitals and PCR testing centers
- **Exact GPS coordinates** and navigation integration for routing
- **Facility capacity indicators** to help users choose less-crowded testing sites
- **Contact information** (phone, address) for each listed facility

---

## Key Features

| Feature | Description |
|---|---|
| Symptom checker | Structured form with severity scoring |
| Doctor consultation | Remote messaging without physical visit |
| PCR test booking | Appointment scheduling to reduce crowding |
| Hospital locator | GPS-based map with facility details |
| Navigation integration | Direct routing to selected hospital |
| Result tracking | Push notification on test result availability |

---

## Technical Stack

```
Frontend:  Flutter (Dart)
State Mgmt: setState / Provider
Maps:       Google Maps Flutter plugin
Location:   Geolocator package
Backend:    Firebase Firestore (real-time database)
Auth:       Firebase Authentication
Notif:      Firebase Cloud Messaging (FCM)
```

### Flutter Packages Used

| Package | Purpose |
|---|---|
| `google_maps_flutter` | Embedded map with hospital markers |
| `geolocator` | Real-time GPS location of the user |
| `firebase_firestore` | Symptom data storage and doctor responses |
| `firebase_auth` | Patient and doctor account management |
| `firebase_messaging` | Push notifications for test results |
| `flutter_local_notifications` | In-app notification display |

---

## UI/UX Design Principles

- **High-contrast text** for readability across age groups and accessibility needs
- **Large touch targets** (minimum 48×48dp) for users with motor impairments
- **Simplified navigation hierarchy** — 3-step maximum to reach any core function
- **Color-coded severity indicators** (green / yellow / red) for symptom assessment results
- **Offline-friendly** symptom form with local caching before sync

---

## Getting Started

```bash
git clone https://github.com/tamer017/medica.git
cd medica
flutter pub get
flutter run
```

> **Note:** Firebase configuration files (`google-services.json` for Android, `GoogleService-Info.plist` for iOS) and a valid Google Maps API key are required to run the full app.

---

## Demo

See the demo video in the repository for a live walkthrough of the symptom submission and hospital locator flows.

---

## Skills Demonstrated

`Flutter` `Dart` `Firebase Firestore` `Firebase Auth` `Google Maps API` `GPS/Geolocator` `Push Notifications` `Healthcare App Design` `Mobile UX` `Real-Time Data` `State Management`
