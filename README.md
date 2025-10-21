# Decent Holograms

This is a modification of decenthologram with ONLY the bare minimum for text holograms to work. This is made to be included within other plugins. If correctly reloacted to a different package name, it should be compatible with the real plugin.

In this version, no commans, no events, no head, entity, or clickable holograms.
## Building
Building DecentHolograms is very simple. All you need is JDK 8+, Gradle, Git and an IDE or Command Line.

1. Clone the project to your machine using Git.
2. Open the project using your IDE or open a command line at the projects' location.
3. Run `gradle clean shadowJar` and DecentHolograms will build.
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
        <groupId>com.github.decentsoftware-eu</groupId>
        <artifactId>decentholograms</artifactId>
        <version>VERSION</version>
        <scope>provided</scope>
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


