build:
	docker-compose build --pull

jenkins: start

start:
	docker-compose up -d

stop:
	docker-compose down -v