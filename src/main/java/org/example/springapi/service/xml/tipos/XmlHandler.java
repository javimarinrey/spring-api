package org.example.springapi.service.xml.tipos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface XmlHandler {
    static final Logger logger = LoggerFactory.getLogger(XmlHandler.class);
    void processar();
}
