#!/bin/bash

times=""
totalTime=0
for outputFileName in output/*.txt; do
    lineNumber=0
    while IFS='' read -r line || [[ -n "$line" ]]; do
        ((lineNumber++))
        if [ $lineNumber -eq 2 ]; then
            time=${line%"ms"}
            time=${time#"Time: "}
            times+=" $time"
            ((totalTime+=$time))
        fi
    done < $outputFileName
done
times=$(echo $(printf "%s\n" $times | sort -n))
times=( $times )

amount=${#times[@]}
firstQuartileIndex=$((amount / 4))
medianIndex=$((amount / 2))
thirdQuartileIndex=$((3 * amount / 4))

average=$((totalTime / amount))
smallest=${times[0]}
firstQuartile=${times[$firstQuartileIndex]}
median=${times[$medianIndex]}
thirdQuartile=${times[$thirdQuartileIndex]}
largest=${times[-1]}
numberOfBad=`bin/BadlySolved.sh`
numberOfBad=( $numberOfBad )
numberOfBad=${#numberOfBad[@]}
range=$((largest - smallest))

echo "Number of problems solved: ${amount}"
echo "Average runtime: ${average}ms"
echo "Smallest runtime: ${smallest}ms"
echo "25th percentile of runtimes: ${firstQuartile}ms"
echo "Median runtime: ${median}ms"
echo "75th percentile of runtimes: ${thirdQuartile}ms"
echo "Largest runtime: ${largest}ms"
echo "Range of runtimes: ${range}ms"
echo "Number of runtimes greater than a minute: ${numberOfBad}"
