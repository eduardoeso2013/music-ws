package br.com.tech4me.musicws.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.musicws.shared.MusicaDto;

public interface MusicaService {
  List<MusicaDto> getAll();

  Optional<MusicaDto> getMusicById(String id);

  MusicaDto createMusic(MusicaDto music);

  void deleteMusicById(String id);

  Optional<MusicaDto> updateMusicById(String id, MusicaDto music);
}
