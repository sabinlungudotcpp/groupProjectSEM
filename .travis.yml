sudo: required

language: java

services:
  - docker

after_success:
  - docker build -t se_methods .
  - docker run se_methods