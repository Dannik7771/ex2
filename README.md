Задание для Я профессионал №2

Для развёртывания контейнера используйте команду docker-compose up

API доступно на порте 9024

Если локально:
localhost:9024

Добавить сервер:
POST /add - {id:number}

Выделить машину:
POST / - {"id": <unique machine id, numeric>, "size": <RAM, Gb, numeric>, "task": <payload, string>}
