enum class Plugin(
    val modules: List<Module>,
    val packageName: String,
    val version: String? = null,
    val apply: Boolean = false
) {
    ANDROID_APPLICATION(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "com.android.application",
        version = Version.AGP,

    ),
    ANDROID_LIBRARY(
        modules = listOf(Module.PROJECT, Module.ABOUT_ME, Module.ACTIVITIES, Module.GUEST_BOOK),
        packageName = "com.android.library",
        version = Version.AGP,

    ),
    KOTLIN_ANDROID(
        modules = listOf(Module.PROJECT, Module.APP, Module.ABOUT_ME, Module.ACTIVITIES, Module.GUEST_BOOK),
        packageName = "org.jetbrains.kotlin.android",
        version = Version.KOTLIN,

    ),
    KOTLIN_COMPOSE(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "org.jetbrains.kotlin.plugin.compose",
        version = Version.KOTLIN,

    ),
    GOOGLE_SERVICES(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "com.google.gms.google-services",
        version = Version.GOOGLE_SERVICES,
    ),
    FIREBASE_CRASHLYTICS(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "com.google.firebase.crashlytics",
        version = Version.GOOGLE_FIREBASE_CRASHLYTICS,
    ),
    FIREBASE_PERF(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "com.google.firebase.firebase-perf",
        version = Version.GOOGLE_FIREBASE_PERF,
    ),
    DAGGER_HILT(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "com.google.dagger.hilt.android",
        version = Version.HILT_ANDROID,
    ),
    KSP(
        modules = listOf(Module.PROJECT, Module.APP),
        packageName = "com.google.devtools.ksp",
        version = Version.KSP,
    ),
    GRAPHQL(
        modules = listOf(Module.APP),
        packageName = "com.apollographql.apollo",
        version = Version.GRAPHQL
    ),
    KOTLIN_SERIALIZATION(
        modules = listOf(Module.APP),
        packageName = "org.jetbrains.kotlin.plugin.serialization",
        version = Version.KOTLIN
    )
}
