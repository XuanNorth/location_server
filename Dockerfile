FROM ubuntu:latest
LABEL authors="ttc"

ENTRYPOINT ["top", "-b"]