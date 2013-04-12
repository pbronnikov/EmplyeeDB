. _definevars.sh

echo -n 'Input employee field = '
read i
curl -d $i $h:$p/search
echo