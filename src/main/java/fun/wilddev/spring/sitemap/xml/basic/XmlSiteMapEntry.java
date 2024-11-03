package fun.wilddev.spring.sitemap.xml.basic;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.time.LocalDateTime;

import lombok.*;

/**
 * {@code <url>} schema
 */
@Setter
@Getter
@ToString
public class XmlSiteMapEntry {

    /**
     * Sitemap {@code <loc>}
     */
    @JacksonXmlProperty
    protected String loc;

    /**
     * Sitemap {@code <lastmod>}
     */
    @JacksonXmlProperty(localName = "lastmod")
    protected LocalDateTime lastModified;
}
