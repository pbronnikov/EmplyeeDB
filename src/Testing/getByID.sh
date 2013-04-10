echo -n 'Input employee id = '
read i
curl -d $i localhost:9091/getByID
echo