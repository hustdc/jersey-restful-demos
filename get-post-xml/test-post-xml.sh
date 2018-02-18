#! /bin/bash

curl -X POST -H 'Content-type:application/xml' -d @./planet http://192.168.43.2:8888/rest2/rest2/xmls/post_planet
