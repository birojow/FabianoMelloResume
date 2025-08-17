import DependencyConfiguration.ANDROID_TEST_ANNOTATION_PROCESSOR
import DependencyConfiguration.ANDROID_TEST_IMPLEMENTATION
import DependencyConfiguration.ANDROID_TEST_IMPLEMENTATION_PLATFORM
import DependencyConfiguration.DEBUG_IMPLEMENTATION
import DependencyConfiguration.IMPLEMENTATION
import DependencyConfiguration.IMPLEMENTATION_PLATFORM
import DependencyConfiguration.KSP
import DependencyConfiguration.TEST_ANNOTATION_PROCESSOR
import DependencyConfiguration.TEST_IMPLEMENTATION
import org.gradle.api.artifacts.dsl.DependencyHandler


enum class Dependency(
    val modules: List<Module>,
    val packageName: String,
    val configurations: List<DependencyConfiguration> = listOf(IMPLEMENTATION)
) {
    ANDROIDX_CORE_KTX(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.core:core-ktx:${Version.CORE_KTX}"
    ),
    ANDROIDX_LIFECYCLE_RUNTIME(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE_RUNTIME_KTX}"
    ),
    ANDROIDX_ACTIVITY_COMPOSE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.activity:activity-compose:${Version.ACTIVITY_COMPOSE}"
    ),
    ANDROIDX_APPCOMPAT(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.appcompat:appcompat:${Version.APPCOMPAT}"
    ),
    ANDROIDX_APPCOMPAT_RESOURCES(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.appcompat:appcompat-resources:${Version.APPCOMPAT}"
    ),
    ANDROIDX_COMPOSE_BOM(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose:compose-bom:${Version.COMPOSE_BOM}",
        configurations = listOf(
            IMPLEMENTATION_PLATFORM,
            ANDROID_TEST_IMPLEMENTATION_PLATFORM
        )
    ),
    ANDROIDX_UI(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui"
    ),
    ANDROIDX_UI_GRAPHICS(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui-graphics"
    ),
    ANDROIDX_UI_TOOLING_PREVIEW(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui-tooling-preview"
    ),
    ANDROIDX_MATERIAL3(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.material3:material3"
    ),
    ANDROIDX_GOOGLE_FONTS(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui-text-google-fonts:${Version.UI_TEXT_GOOGLE_FONTS}"
    ),
    ANDROIDX_LIFECYCLE_VIEWMODEL_COMPOSE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.LIFECYCLE_VIEWMODEL_COMPOSE}"
    ),
    ANDROIDX_NAVIGATION_COMPOSE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.navigation:navigation-compose:${Version.NAVIGATION_COMPOSE}"
    ),
    ANDROIDX_DATASTORE_PREFERENCES(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.datastore:datastore-preferences:${Version.DATASTORE_PREFERENCES}"
    ),
    ANDROIDX_HILT_NAVIGATION_COMPOSE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.hilt:hilt-navigation-compose:${Version.HILT_NAVIGATION_COMPOSE}"
    ),
    KOTLINX_SERIALIZATION_JSON(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.SERIALIZATION_JSON}"
    ),
    FIREBASE_BOM(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.firebase:firebase-bom:${Version.FIREBASE_BOM}",
        configurations = listOf(IMPLEMENTATION_PLATFORM)
    ),
    FIREBASE_ANALYTICS(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.firebase:firebase-analytics:${Version.FIREBASE_ANALYTICS}"
    ),
    FIREBASE_CRASHLYTICS(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.firebase:firebase-crashlytics:${Version.FIREBASE_CRASHLYTICS}"
    ),
    FIREBASE_DATABASE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.firebase:firebase-database:${Version.FIREBASE_DATABASE}"
    ),
    FIREBASE_FIRESTORE(
        modules = listOf(Module.APP, Module.GUEST_BOOK),
        packageName = "com.google.firebase:firebase-firestore:${Version.FIREBASE_FIRESTORE}"
    ),
    FIREBASE_PERF(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.firebase:firebase-perf:${Version.FIREBASE_PERF}"
    ),
    GRAPHQL(
        modules = listOf(Module.APP, Module.GUEST_BOOK),
        packageName = "com.apollographql.apollo:apollo-runtime:${Version.GRAPHQL}"
    ),
    DOTLOTTIE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.github.LottieFiles:dotlottie-android:${Version.DOTLOTTIE_ANDROID}"
    ),
    HILT_ANDROID(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.dagger:hilt-android:${Version.HILT_ANDROID}"
    ),
    ANDROIDX_UI_TOOLING(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui-tooling:${DEBUG_IMPLEMENTATION}"
    ),
    ANDROIDX_UI_TEST_MANIFEST(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui-test-manifest:${DEBUG_IMPLEMENTATION}"
    ),
    HILT_COMPILER(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.dagger:hilt-android-compiler:${Version.HILT_ANDROID}",
        configurations = listOf(
            KSP,
            TEST_ANNOTATION_PROCESSOR,
            ANDROID_TEST_ANNOTATION_PROCESSOR
        )
    ),
    JUNIT(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "junit:junit:${Version.JUNIT}",
        configurations = listOf(TEST_IMPLEMENTATION)
    ),
    HILT_TEST(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "com.google.dagger:hilt-android-testing:${Version.HILT_ANDROID}",
        configurations = listOf(
            TEST_IMPLEMENTATION,
            ANDROID_TEST_IMPLEMENTATION
        )
    ),
    ANDROIDX_ESPRESSO_CORE(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}",
        configurations = listOf(ANDROID_TEST_IMPLEMENTATION)
    ),
    ANDROIDX_JUNIT(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.test.ext:junit",
        configurations = listOf(ANDROID_TEST_IMPLEMENTATION)
    ),
    ANDROIDX_UI_TEST_JUNIT(
        modules = listOf(Module.APP, Module.ACTIVITIES, Module.ABOUT_ME, Module.GUEST_BOOK),
        packageName = "androidx.compose.ui:ui-test-junit4",
        configurations = listOf(ANDROID_TEST_IMPLEMENTATION)
    )
}

enum class DependencyConfiguration(val configurationName: String) {
    IMPLEMENTATION("implementation"),
    IMPLEMENTATION_PLATFORM(IMPLEMENTATION.configurationName),
    DEBUG_IMPLEMENTATION("degubImplementation"),
    TEST_IMPLEMENTATION("testImplementation"),
    ANDROID_TEST_IMPLEMENTATION("androidTestImplementation"),
    ANDROID_TEST_IMPLEMENTATION_PLATFORM(ANDROID_TEST_IMPLEMENTATION.configurationName),
    KSP("ksp"),
    TEST_ANNOTATION_PROCESSOR("testAnnotationProcessor"),
    ANDROID_TEST_ANNOTATION_PROCESSOR("androidTestAnnotationProcessor")
}

fun DependencyHandler.addDependenciesForModule(module: Module) {
    val platformConfigurations = DependencyConfiguration.values().filter {
        it.name.lowercase().contains("platform")
    }
    Dependency.values()
        .filter { module in it.modules }
        .forEach { dependency ->
            with(dependency) {
                configurations.forEach { configuration ->
                    add(
                        configuration.configurationName,
                        if (configuration in platformConfigurations) {
                            platform(packageName)
                        } else {
                            packageName
                        }
                    )
                }
            }
        }
}
