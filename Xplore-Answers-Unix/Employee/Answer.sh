#!/bin/bash
# your code goes here
awk 'BEGIN{FS=";"}
{
  tax=$3*0.1;
  print $3,tax;
}'|sort -r | cut -d " " -f 1|head -1
