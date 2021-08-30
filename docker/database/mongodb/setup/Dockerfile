FROM mongo:5.0.2

# Create app directory
WORKDIR /usr/src/configs

# Install app dependencies
COPY replicaSet.js .
COPY setup.sh .

RUN chmod 777 setup.sh \
    && sed -i -e 's/\r$//' setup.sh

CMD ["./setup.sh"]
