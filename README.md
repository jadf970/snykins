## Snykins

Snykins is a super rudimentary Jenkins setup with the Snyk Jenkins plugin pre-installed and configured automatically. This can be used to quickly and easily test a Snyk/Jenkins setup without having to actually setup anything.

### Setup

Create a file in the root of this repository called `.env` and populate two keys:

```shell script
SNYK_API_TOKEN=f40cda15-3047-45eb-995c-0ec95cc0986e
PROJECT_DIR=/my/code/directory
```

You can get an API Token by following the instructions [here](https://support.snyk.io/hc/en-us/articles/360004499218). The project directory can be relative to the root of this repository, or a full path on your system.

### Build

Prerequisites:
- Docker
- Docker Compose

```shell script
make
make start
```

Jenkins will now be available at [localhost:8080](http://localhost:8080o). The username and password are both `admin`.

### Cleanup

```shell script
make stop
```
