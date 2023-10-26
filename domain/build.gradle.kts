plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21")
    implementation("io.reactivex.rxjava2:rxjava:2.2.10")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("javax.inject:javax.inject:1")
    testImplementation("junit:junit:4.13.2")
}
