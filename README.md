### Description

Sitemap exposure starter for [Spring](https://spring.io) apps.

[![Java CI with Maven](https://github.com/WildDev/spring-starter-sitemap/actions/workflows/maven.yml/badge.svg)](https://github.com/WildDev/spring-starter-sitemap/actions/workflows/maven.yml)

### How to use

1. Implement `fun.wilddev.spring.sitemap.api.SiteMapLoader`:

```java
@Component
public class ExampleSiteMapLoader implements SiteMapLoader {

    @Override
    public List<SiteMapEntry> load() {
        return List.of(
                new SiteMapEntry("https://test.website/test_1", LocalDateTime.now()),
                new SiteMapEntry("https://test.website/test_2", LocalDateTime.now()),
                new SiteMapEntry("https://test.website/test_3", LocalDateTime.now())
        );
    }
}
```

2. Access the sitemap endpoint by `https://test.website/sitemap/xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
    <url>
        <loc>https://test.website/test_1</loc>
        <lastmod>2024-11-03T15:14:19.848022688</lastmod>
    </url>
    <url>
        <loc>https://test.website/test_2</loc>
        <lastmod>2024-11-03T15:14:19.848036447</lastmod>
    </url>
    <url>
        <loc>https://test.website/test_3</loc>
        <lastmod>2024-11-03T15:14:19.848041186</lastmod>
    </url>
</urlset>
```

### Get started

Build requirements:
* latest JDK and Maven

Also available in Maven central:

```xml
<dependency>
    <groupId>fun.wilddev.lib</groupId>
    <artifactId>spring-starter-sitemap</artifactId>
    <version>1.0.0.RELEASE</version>
</dependency>
```
