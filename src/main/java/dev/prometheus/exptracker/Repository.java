package dev.prometheus.exptracker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Model, String> {

}
