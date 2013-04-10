line=$(sed -n 2p test)
curl -d $line localhost:9091/create
echo