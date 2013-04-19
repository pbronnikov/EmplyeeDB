. definevars.sh

echo -n 'Input employee id = '
read i
curl -d $i $h:$p/getByID
echo