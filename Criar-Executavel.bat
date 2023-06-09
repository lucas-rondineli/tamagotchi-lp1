@echo off

set executavel=bin/Tamagotchi.jar
set criador=tools/CriarJar.java

if not exist %executavel% (
    javac tools/FolderFinder.java %criador%
    java %criador%
    copy recursos\Iniciar-Programa.bat bin
) else (
    rem Executável já existe.
)

pause