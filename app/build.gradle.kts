plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.doctour"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.doctour"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.androidTestInstrumentation
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

    dependencies {

        // Android
        implementation(Deps.UI.androidCore)
        implementation(Deps.UI.appcompat)
        implementation(Deps.UI.material)

        // Container layout
        implementation(Deps.UI.constraint)
        implementation(Deps.UI.appcompat)
        implementation(Deps.UI.material)
        implementation(Deps.UI.constraint)

        // Test
        testImplementation(Deps.UI.junit)
        androidTestImplementation(Deps.UI.extJunit)
        androidTestImplementation(Deps.UI.espresso)

        // Fragment
        implementation(Deps.UI.fragment)

        // Room
        implementation(Deps.Room.room)
        implementation(Deps.Room.roomRuntime)
        kapt(Deps.Room.compiler)

        // Hilt
        implementation(Deps.DaggerHilt.hilt)
        kapt(Deps.DaggerHilt.compiler)

        // Coroutines
        implementation(Deps.Coroutines.android)

        // Nav component
        implementation(Deps.NavComponent.fragment)
        implementation(Deps.NavComponent.ui)

        // View Binding property delegate (reflection-free flavor)
        implementation(Deps.ViewBindingDelegate.viewBindingDelegate)

        // Lifecycle
        implementation(Deps.Lifecycle.lifecycle)
    }
}