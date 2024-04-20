package ru.kpfu.itis.gnt.okno.services.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class HashGenerator {

    public String hash(String data) {
        return DigestUtils
                .md5Hex(data);
    }
}
