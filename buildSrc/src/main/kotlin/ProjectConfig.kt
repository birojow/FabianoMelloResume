import org.gradle.api.JavaVersion

object ProjectConfig {
    const val NAMESPACE = "app.birojow.fabianomelloresume"
    const val COMPILE_SDK = 35
    const val MIN_SDK = 26
    const val TARGET_SDK = 35
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    val RES_CONFIGS = arrayOf("en", "es", "pt")
    val SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
    val TARGET_COMPATIBILITY = JavaVersion.VERSION_17
    const val JVM_TARGET = "17"
}
