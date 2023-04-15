package rw.producer.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class XmlUtils {
  
  public static String toXml(Object obj) throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    return xmlMapper.writeValueAsString(obj);
  }

  public static <T> T fromXml(String xml, Class<T> clazz) throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    return xmlMapper.readValue(xml, clazz);
  }

}

