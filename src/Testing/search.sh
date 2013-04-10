echo -n 'Input employee field = '
read i
curl -d $i localhost:9091/search
echo