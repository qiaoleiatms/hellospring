FROM kaniko:parenta

WORKDIR /workspace

ADD . /workspace

ADD config.json /kaniko/.docker/config.json

ENV PATH $PATH:/kaniko
