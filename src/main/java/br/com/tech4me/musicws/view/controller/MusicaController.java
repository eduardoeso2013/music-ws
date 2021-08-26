package br.com.tech4me.musicws.view.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.musicws.service.MusicaService;
import br.com.tech4me.musicws.shared.MusicaDto;
import br.com.tech4me.musicws.view.model.MusicaRequest;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/musicas")
@CrossOrigin
public class MusicaController {
  @Autowired
  MusicaService service;

  @GetMapping
  public ResponseEntity<List<MusicaDto>> getMusics() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<MusicaDto> getMusicById(@PathVariable String id) {
    Optional<MusicaDto> mus = service.getMusicById(id);

    if (mus.isPresent()) {
      return new ResponseEntity<>(mus.get(), HttpStatus.FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<MusicaDto> createMusic(@RequestBody @Valid MusicaDto music) {
    return new ResponseEntity<>(service.createMusic(music), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteMusic(@PathVariable String id) {
    service.deleteMusicById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<MusicaDto> updateMusic(@PathVariable String id, @RequestBody @Valid MusicaRequest music) {
    MusicaDto dto = new ModelMapper().map(music, MusicaDto.class);
    Optional<MusicaDto> mus = service.updateMusicById(id, dto);
    if (mus.isPresent()) {
      return new ResponseEntity<>(mus.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
  }
}
