// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    Plugin.values()
        .filter { Module.PROJECT in it.modules }
        .forEach { plugin ->
            plugin.version?.let { version ->
                id(plugin.packageName) version version apply plugin.apply
            } ?: (id(plugin.packageName) apply plugin.apply)
        }
}
