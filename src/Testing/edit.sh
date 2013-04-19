. definevars.sh

line=$(sed -n 2p test)
curl -d $line $h:$p/edit
echo