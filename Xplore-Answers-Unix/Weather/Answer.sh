#!/bin/bash
# your code goes here
awk 'BEGIN{FS="-";IGNORECASE=1;OFS=","}
{
  if($4=="Karnataka")
  {
    print $1,$2,$3;
    c=c+1;
    sum=sum+$2;
  }
  #avg=sum/c;
  
}END{if(c==0)
{print("No records found")}
else
{print("Average temperature in karnataka:"sum/c)}}'|sort -nrk3 -t "-"
