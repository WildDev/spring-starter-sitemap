package fun.wilddev.spring.sitemap.api.news;

import fun.wilddev.spring.sitemap.api.SiteMapEntry;
import java.time.OffsetDateTime;

import lombok.*;

/**
 * Represents sitemap {@code <news>} entry
 */
@Getter
@ToString(callSuper = true)
public class SiteMapNewsEntry extends SiteMapEntry {

    /**
     * {@link SiteMapNews} instance
     */
    private final SiteMapNews news;

    /**
     * All-args constructor
     *
     * @param url - resource url (loc)
     * @param lastModified - last modification timestamp (lastmod)
     * @param news - {@link SiteMapNews} instance
     */
    public SiteMapNewsEntry(String url, OffsetDateTime lastModified, SiteMapNews news) {

        super(url, lastModified);
        this.news = news;
    }
}
