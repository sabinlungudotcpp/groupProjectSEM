version: '3'
services:
  # Application Dockerfile is in same folder which is .
  app:
    build: .

  # db is is db folder
  db:
    build: db/.
    command: --default-authentication-plugin=mysql_native_password
    restart: always