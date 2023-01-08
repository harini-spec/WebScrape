package io.WebScrape.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.WebScrape.models.DataModel;

public interface MongoRepo extends MongoRepository<DataModel, String> {

}
