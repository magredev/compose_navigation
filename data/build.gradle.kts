plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.magre.compose.navigation.example.data"
    compileSdk = 34

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":domain"))

    // kotlin
    implementation("androidx.core:core-ktx:1.9.0")
    // Injection
    implementation("javax.inject:javax.inject:1")
    // Network
    implementation("com.squareup.okhttp3:okhttp:4.5.0")
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.0")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // Test
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.12.5")
}