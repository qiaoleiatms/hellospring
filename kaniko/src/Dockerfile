#first stage - builder
FROM golang:1.19-bookworm as builder
WORKDIR /dir
COPY . .
RUN apt update
RUN apt install sudo -y
# RUN go get -d -v
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app .
#second stage
FROM debian:bookworm
WORKDIR /root/
COPY --from=builder /dir/app .
CMD ["./app"]
