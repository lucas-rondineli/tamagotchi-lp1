@echo off

set programa=bin/Tamagotchi.jar
set criador=tools/CriarJar.java

if exist %programa% (
    java -jar %programa%
) else (
    javac tools/FolderFinder.java %criador%
    java %criador%
    java -jar %programa%
)

pause