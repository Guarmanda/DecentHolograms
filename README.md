# Decent Holograms

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)


This fork is a library rather than a plugin, it is meant to be used in other plugins to create holograms.
I kept ONLY simple text holograms without animations and other things.

Usage:
(the package relocation is to not conflict with the original plugin)

       <repositories>
            <repository>
                <id>jitpack.io</id>
                <url>https://jitpack.io</url>
            </repository>
        </repositories>
        </plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.5.0</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <relocations>
                                <relocation>
                                    <pattern>eu.decentsoftware.holograms</pattern>
                                    <shadedPattern>fr.black_eyes.holograms</shadedPattern>
                                </relocation>
                            </relocations>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <dependency>
            <groupId>com.github.Guarmanda</groupId>
            <artifactId>DecentHolograms</artifactId>
            <version>2.9.5-2</version>
        </dependency>

then to start it, put this in your plugin's onEnable:

```java
DecentHologramsPlugin hologramPlugin = new DecentHologramsPlugin();
DecentHolograms hologramImpl = hologramPlugin.onEnable(this);
```
Of course you have to declare the two variables somewhere else, in a way that  allows  you to access them later.
to use it:
```java
DHAPI.createHologram(...)
```
to stop it:
```java
hologramPlugin.onDisable();
```