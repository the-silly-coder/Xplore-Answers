#!/bin/bash
# your code goes here
awk 'BEGIN{FS=";";IGNORECASE=1}
{
  if($3=="available")
  print $0;
}'|awk 'BEGIN{FS=";"}
{
  a[$2]++;
  c++;
}END{if(c>0){for (i in a)
  print(i,":",a[i])}
  else{print "No course available";}
}'|sort -nrk2 -t ":"
