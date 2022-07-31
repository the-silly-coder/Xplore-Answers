awk 'BEGIN {FS ="|";}
(NR > 1){
  if($4 > 90){
    print $2, "Gold"
  } else if ($4 > 60){
    print $2, "Silver"
  } else {
    print $2, "Bronze"
  }
}'
