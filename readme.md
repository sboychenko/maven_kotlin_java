# Kotlin + Java Maven project

Демонстрация настройки maven для случая, когда у вас есть java код и нужно использовать его внутри kotlin

В основе туториал:
https://kotlinlang.org/docs/maven.html#compile-kotlin-and-java-sources

При таком наборе плагинов, как описано в статье, при сборке классы из `scr/main/java` не попадут в `target/classes`

Для исправления стоит использовать дополнительно настроенный плагин
```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>3.2.0</version>
    <executions>
        <execution>
            <id>add-source</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>add-source</goal>
            </goals>
            <configuration>
                <sources>
                    <source>src/main/java</source>
                </sources>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Тут важной является часть `configuration/sources/source` где нужно указать путь к вашим исходникам java, так как по умолчанию плагин потянет исходники из секции `build/sourceDirectory`
