package io.harini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.harini.models.DataModel;

public interface MongoRepo extends MongoRepository<DataModel, String>{

}
