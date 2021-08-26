package br.com.tech4me.musicws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.musicws.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String> {

}