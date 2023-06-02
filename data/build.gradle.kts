plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.Kotlin.hilt)
}

android {
    namespace = "com.example.data"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Module
    implementation(project(":domain"))

    // Android
    implementation(Deps.UI.androidCore)

    // Test
    testImplementation(Deps.UI.junit)
    androidTestImplementation(Deps.UI.extJunit)

    // Dublicate
    implementation(Deps.Dublicate.dublicate)

    // Room
    implementation(Deps.Room.room)
    implementation(Deps.Room.roomRuntime)
    kapt(Deps.Room.compiler)

    // Nav Component
    implementation(Deps.NavComponent.fragment)
    implementation(Deps.NavComponent.ui)

    // Javax
    implementation(Deps.JavaX.inject)

    // Coroutines
    implementation(Deps.Coroutines.android)

    // Paging3
    implementation(Deps.Paging3.paging3)
    implementation(Deps.Paging3.paging3Runtime)

    // Glide
    implementation(Deps.Glide.glide)

    // Retrofit2
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.retrofitConverterGson)

    // Hilt
    implementation(Deps.DaggerHilt.hilt)
    kapt(Deps.DaggerHilt.compiler)
}