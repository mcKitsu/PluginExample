package net.mckitsu.yamlloader.yaml.config;

import lombok.Data;

public @Data class Network {
    private String hostAddress;
    private int port;
    private String cryptoKey;
    private String verifyKey;
}

