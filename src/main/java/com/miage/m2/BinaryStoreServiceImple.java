package com.miage.m2;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BinaryStoreServiceImple implements BinaryStoreService {

    private static BinaryStoreServiceImple ourInstance = new BinaryStoreServiceImple();
    private Map<String, byte[]> data = new HashMap<>();

    public static BinaryStoreServiceImple getInstance() {
        return ourInstance;
    }

    private BinaryStoreServiceImple() {
    }

    @Override
    public boolean exists(String key) throws BinaryStoreServiceException {
        return data.containsKey(key);
    }

    @Override
    public String put(InputStream is) throws BinaryStoreServiceException {
        String uuid = UUID.randomUUID().toString();
        try {
            byte[] bytes = IOUtils.toByteArray(is);
            data.put(uuid, bytes);
            return uuid;
        } catch (IOException e) {
            throw new BinaryStoreServiceException("error during put");
        }

    }

    @Override
    public InputStream get(String key) throws BinaryStoreServiceException, BinaryStreamNotFoundException {
        if (!data.containsKey(key)){
            throw new BinaryStreamNotFoundException("Unable to find this key");
        } else {
            return new ByteArrayInputStream(data.get(key));
        }
    }
}
