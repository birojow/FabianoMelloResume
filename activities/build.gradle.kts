plugins {
    addPluginsForModule(Module.ACTIVITIES)
}

android {
    namespace = "app.birojow.activities"
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfig.MIN_SDK

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
        sourceCompatibility = ProjectConfig.SOURCE_COMPATIBILITY
        targetCompatibility = ProjectConfig.TARGET_COMPATIBILITY
    }

    kotlinOptions {
        jvmTarget = ProjectConfig.JVM_TARGET
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    addDependenciesForModule(Module.ACTIVITIES)
}