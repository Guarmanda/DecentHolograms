# Decent Holograms

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)


This fork is a library rather than a plugin, it is meant to be used in other plugins to create holograms.
I kept ONLY simple text holograms without animations and other things.

Usage:

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