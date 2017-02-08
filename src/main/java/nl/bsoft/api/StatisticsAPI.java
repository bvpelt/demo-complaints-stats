package nl.bsoft.api;

import nl.bsoft.events.ComplaintFileEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by bvpelt on 2/7/17.
 */

@ProcessingGroup("statistics")
@RestController
public class StatisticsAPI {
    private final Logger log = LoggerFactory.getLogger(StatisticsAPI.class);

    private final ConcurrentMap<String, AtomicLong> statistics = new ConcurrentHashMap<>();

    @EventHandler
    public void on(ComplaintFileEvent event) {
        log.info("Received complaint id: {}, company: {}, description: {}", event.getId(), event.getCompany(), event.getDescription());
        statistics.computeIfAbsent(event.getCompany(), k -> new AtomicLong()).incrementAndGet();
    }

    @GetMapping
    public ConcurrentMap<String, AtomicLong> showStatistics() {
        return statistics;
    }
}