# Use the official Ubuntu base image
FROM ubuntu:24.04


# Install necessary packages
RUN apt-get update && \
    apt-get install -y build-essential cmake git libjson-c-dev libwebsockets-dev openjdk-11-jdk && \
    rm -rf /var/lib/apt/lists/*

# Create the app directory
RUN mkdir -p /usr/src/app

# Copy the project files to the app directory
COPY . /usr/src/app 

# Set the working directory
WORKDIR /usr/src/app

# Clone the ttyd repository and build it
RUN cd ttyd && \
    mkdir build && \
    cd build && \
    cmake .. && \
    make && \
    make install

# Compile the Java application
RUN javac $(find src -name "*.java")

# Command to run ttyd with the Java Hello World application
# ttyd --writable -p 8080 -t fontSize=25 java Main
CMD ["ttyd", "--writable", "-p" , "8080", "-t", "fontSize=25", "java", "-cp", "src", "Main"]
