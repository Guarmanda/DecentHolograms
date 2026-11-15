# Decent Holograms

This is a modification of decenthologram with ONLY the bare minimum for text holograms to work. This is made to be included within other plugins. If correctly reloacted to a different package name, it should be compatible with the real plugin.

In this version, no commans, no events, no head, entity, or clickable holograms.
## Building
Building DecentHolograms requires JDK 21+ and Git. The Gradle wrapper downloads Gradle and the required Java toolchains, including Java 25 for Minecraft 26.x adapters. The shared API and older adapters retain their existing Java targets.

1. Clone the project to your machine using Git.
2. Open the project using your IDE or open a command line at the projects' location.
3. Run `./gradlew clean shadowJar` (`gradlew.bat clean shadowJar` on Windows) and DecentHolograms will build.
4. You can find the jar at `./plugin/build/libs/DecentHolograms-VERSION.jar`

> Replace `VERSION` with the current version of DecentHolograms. (Latest release)

<details>
<summary>Maven</summary>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>com.github.Guarmanda</groupId>
        <artifactId>decentholograms</artifactId>
        <version>2.9.8</version>
    </dependency>
</dependencies>
```
</details>

<details>
<summary>Gradle</summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.decentsoftware-eu:decentholograms:VERSION'
}
```
</details>


