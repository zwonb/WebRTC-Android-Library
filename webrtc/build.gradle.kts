import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "org.webrtc"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
}

dependencies {
    implementation(libs.androidx.appcompat)
}


mavenPublishing {
    coordinates("io.github.zwonb", "webrtc-android", "130.0.6723.40")

    pom {
        name.set("webrtc-android")
        description.set("WebRTC Android Library")
        inceptionYear.set("2024")
        url.set("https://github.com/zwonb/WebRTC Android Library/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("zwonb")
                name.set("zhou yuan bin")
                url.set("https://github.com/zwonb/")
            }
        }
        scm {
            url.set("https://github.com/zwonb/WebRTC Android Library/")
            connection.set("scm:git:git://github.com/zwonb/WebRTC Android Library.git")
            developerConnection.set("scm:git:ssh://git@github.com/zwonb/WebRTC Android Library.git")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, true)
    signAllPublications()
}
