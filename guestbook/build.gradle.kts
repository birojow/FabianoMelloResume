plugins {
    addPluginsForModule(Module.GUEST_BOOK)
}

android {
    namespace = "app.birojow.guestbook"
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

apollo {
    service("service") {
        packageName.set("app.birojow")
    }
}

dependencies {
    addDependenciesForModule(Module.GUEST_BOOK)
}