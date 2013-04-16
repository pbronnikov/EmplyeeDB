h=$(cat ../Main/resources/application.conf  | grep host | sed -n 2p | sed 's/[^0-9.]//g')
p=$(cat ../Main/resources/application.conf  | grep port | sed -n 1p | sed 's/[^0-9.]//g')

echo -n 'Input employee field = '
read i
curl -d $i $h:$p/search
echo