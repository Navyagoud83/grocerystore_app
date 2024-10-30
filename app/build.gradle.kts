// App-level build.gradle

plugins {
    id("com.android.application")  // Applying the Android application plugin
    id("com.google.gms.google-services") // Applying the Google Services plugin
}

android {
    namespace = "com.example.grocerystoreapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.grocerystoreapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)  // AppCompat for backwards compatibility
    implementation(libs.material)  // Material design components
    implementation(libs.activity)  // Activity library
    implementation(libs.constraintlayout)  // ConstraintLayout for UI design
    implementation(libs.firebase.database)  // Firebase Database library
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    implementation("com.google.firebase:firebase-analytics")
    testImplementation(libs.junit)  // JUnit for unit testing
    androidTestImplementation(libs.ext.junit)  // Extended JUnit for Android tests
    androidTestImplementation(libs.espresso.core)  // Espresso for UI testing
}
