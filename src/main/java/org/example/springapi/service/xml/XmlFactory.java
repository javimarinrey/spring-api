package org.example.springapi.service.xml;

import org.example.springapi.service.xml.tipos.XmlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class XmlFactory {

    @Autowired
    private ApplicationContext context;

    public XmlHandler crearHandler(Class<? extends  XmlHandler> clazz) {
        return context.getBean(clazz);
    }
}
