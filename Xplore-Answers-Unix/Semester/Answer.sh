#!/bin/bash
# your code goes here
awk 'BEGIN{FS="|"}
{
  a[$2]++
}END{for (i in a)
print i,a[i];
}'|sort -nk1 -t " "
