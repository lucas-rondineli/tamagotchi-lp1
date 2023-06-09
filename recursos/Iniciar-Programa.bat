@echo off

set executavel=Tamagotchi.jar

if exist %executavel% (
    java -jar %executavel%
) else (
    rem Executável não existe.
)

pause