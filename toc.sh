#!/usr/bin/env bash


#<!-- TOC -->
#
#- [script for devops](#script-for-devops)
#  - [usage](#usage)
#    - [clone repo](#clone-repo)

echo "<!-- TOC -->"
for f in $(ls -d [0-9]*); do
if [ "$(ls -A "$f" | wc -l)" -gt 0 ]; then

  echo "- [$f](#${f//./-})"
  for x in $(ls -A "$f"); do
    echo "  - [$f/$x]($f/$x)"
  done

fi
done

echo "<!-- /TOC -->"
