#!/bin/bash
for ((c=0; c<$@; c++))
do
	run=$(($c+19000000))
	declare first_name="CloneName$c"
	declare last_name="CloneSurname$c"
	declare last_name2="CloneSurname(2)$c"
	declare email="carlos.henriquez.r@usach.cl"
	curl -d '{"run":"'$run-k'", "first_name":"'$first_name'", "last_name":"'$last_name'", "last_name2":"'$last_name2'", "reason_id":2, "email":"'$email'"}' -H 'Content-Type: application/json' http://127.0.0.1:8080/form/add
done