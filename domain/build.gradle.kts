plugins {
    id("java-library")
    id("kotlin")
}

dependencies {

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    // Injection
    implementation("javax.inject:javax.inject:1")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // Test
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.12.5")
}
