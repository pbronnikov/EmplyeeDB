h=$(cat ../Main/resources/application.conf  | grep host | sed -n 2p | sed 's/[^0-9.]//g')
p=$(cat ../Main/resources/application.conf  | grep port | sed -n 1p | sed 's/[^0-9.]//g')

curl -g $h:$p/getAll