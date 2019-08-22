#!/bin/bash
badlySolvedProblems=""
for outputFileName in output/*.txt; do
    problem=${outputFileName%".txt"}
    problem=${problem#"output/Problem"}
    lineNumber=0
    while IFS='' read -r line || [[ -n "$line" ]]; do
        ((lineNumber++))
        if [ $lineNumber -eq 2 ]; then
            time=${line%"ms"}
            time=${time#"Time: "}
            if [ "$time" -ge 60000 ]; then
                badlySolvedProblems+=" $problem"
            fi
        fi
    done < "$outputFileName"
done
badlySolvedProblems=$(printf "%s\n" "$badlySolvedProblems" | sort -n)
echo "$badlySolvedProblems"
