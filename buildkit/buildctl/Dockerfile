FROM debian:bullseye

RUN apt update && apt install ca-certificates -y

ADD https://github.com/moby/buildkit/releases/download/v0.12.4/buildkit-v0.12.4.linux-amd64.tar.gz /

RUN mkdir -p buildkit && tar xvzf buildkit-v0.12.4.linux-amd64.tar.gz -C buildkit

WORKDIR /workspace

ADD src /workspace

# Create the 'cnb' user that will be used
RUN groupadd cnb --gid 1000 && \
  useradd --uid 1000 --gid 1000 -m -s /bin/bash cnb

RUN chown cnb:cnb /buildkit/bin/buildctl

RUN chmod +x /buildkit/bin/buildctl

RUN ln -s /buildkit/bin//buildctl /usr/bin/buildctl

USER cnb

ENTRYPOINT [ "tail", "-f", "/dev/null" ]