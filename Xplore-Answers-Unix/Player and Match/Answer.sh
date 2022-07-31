#!/bin/bash
# your code goes here
awk 'BEGIN{FS="#";OFS=" , ";COUNT=0}{
  if(substr($4,4,4) == 2017){
    count += 1;
    print $1,$2,$3,$4;
  }
}
END{
  if(count == 0)
    print "No player found";
}'
