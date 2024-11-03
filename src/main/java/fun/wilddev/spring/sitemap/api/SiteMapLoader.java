package fun.wilddev.spring.sitemap.api;

import java.util.List;

/**
 * Defines how sitemap data should be loaded
 */
public interface SiteMapLoader {

    /**
     * Loads sitemap data
     *
     * @return sitemap entries list
     */
    List<SiteMapEntry> load();
}
