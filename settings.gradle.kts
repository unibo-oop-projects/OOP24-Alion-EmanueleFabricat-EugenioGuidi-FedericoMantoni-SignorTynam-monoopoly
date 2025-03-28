rootProject.name = "oop-24-monoopoly"
plugins {
    id("com.gradle.develocity") version "3.19.2"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
        uploadInBackground = !System.getenv("CI").toBoolean()
        buildScanPublished {
            file("scan-journal.log").writeText("$buildScanId - $buildScanUri\n")
        }
    }
}
