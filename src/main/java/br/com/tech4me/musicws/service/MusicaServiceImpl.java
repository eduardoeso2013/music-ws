package br.com.tech4me.musicws.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.musicws.model.Musica;
import br.com.tech4me.musicws.repository.MusicaRepository;
import br.com.tech4me.musicws.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService {
  @Autowired
  MusicaRepository repository;

  @Override
  public List<MusicaDto> getAll() {
    List<Musica> musica = repository.findAll();
    return musica.stream().map(p -> new ModelMapper().map(p, MusicaDto.class)).collect(Collectors.toList());
  }

  @Override
  public Optional<MusicaDto> getMusicById(String id) {
    Optional<Musica> music = repository.findById(id);
    if (music.isPresent()) {
      return Optional.of(new ModelMapper().map(music.get(), MusicaDto.class));
    }
    return Optional.empty();
  }

  @Override
  public MusicaDto createMusic(MusicaDto musica) {
    ModelMapper mapper = new ModelMapper();
    Musica musicForSave = mapper.map(musica, Musica.class);
    musicForSave = repository.save(musicForSave);
    return mapper.map(musicForSave, MusicaDto.class);
  }

  @Override
  public void deleteMusicById(String id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<MusicaDto> updateMusicById(String id, MusicaDto musica) {
    ModelMapper mapper = new ModelMapper();
    Optional<Musica> musicas = repository.findById(id);
    Musica musicaForSave = mapper.map(musica, Musica.class);

    if (musicas.isPresent()) {
      musicaForSave.setId(id);
      musicaForSave = repository.save(musicaForSave);
      return Optional.of(mapper.map(musicaForSave, MusicaDto.class));
    }

    return Optional.empty();
  }

}
