#!/bin/bash
read -p "Problem Number: " -r number
read -p "Generate Input File (y/N): " -r generateInput
filePath="src/main/scala/problems/Problem$number.scala"
touch "$filePath"
echo -e "package problems\n\nimport util.Problem\n\n/**\n  * A solution to the nth problem of Project Euler\n  */\nobject Problem$number extends Problem($number) {\n\n}" > "$filePath"
if [ "$generateInput" != "${generateInput#[Yy]}" ]; then
    touch "input/Problem$number.txt"
fi
git add -A
