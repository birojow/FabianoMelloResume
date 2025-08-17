plugins {
    addPluginsForModule(Module.APP)
}

android {
    namespace = ProjectConfig.NAMESPACE
    compileSdk = ProjectConfig.COMPILE_SDK

    androidResources {
        generateLocaleConfig = true
    }

    defaultConfig {
        applicationId = ProjectConfig.NAMESPACE
        minSdk = ProjectConfig.MIN_SDK
        targetSdk = ProjectConfig.TARGET_SDK
        versionCode = ProjectConfig.VERSION_CODE
        versionName = ProjectConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resConfigs(*ProjectConfig.RES_CONFIGS)
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
    addDependenciesForModule(Module.APP)
    implementation(project(Module.ABOUT_ME.moduleName))
    implementation(project(Module.ACTIVITIES.moduleName))
    implementation(project(Module.GUEST_BOOK.moduleName))
}
