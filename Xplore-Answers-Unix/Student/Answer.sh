#!/bin/bash
# your code goes here

awk 'BEGIN{FS="|"}
{
  if($3<50 && $3>=45)
  {
    grace=50-$3;
    print $1,$2,grace
  }
}'
