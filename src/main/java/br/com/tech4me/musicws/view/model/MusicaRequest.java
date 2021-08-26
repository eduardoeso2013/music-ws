package br.com.tech4me.musicws.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class MusicaRequest {
  @NotEmpty(message = "O nome deve ser informado")
  private String titulo;
  private String artista;
  private String album;
  @NotEmpty(message = "O genero deve ser informado")
  @NotBlank(message = "O genero não pode ficar em branco")
  private String genero;
  private String anoLancamento;
  private String compositor;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getArtista() {
    return artista;
  }

  public void setArtista(String artista) {
    this.artista = artista;
  }

  public String getAlbum() {
    return album;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getGenero() {
    return genero;
  }

  public String getAnoLancamento() {
    return anoLancamento;
  }

  public void setAnoLancamento(String anoLancamento) {
    this.anoLancamento = anoLancamento;
  }

  public String getCompositor() {
    return compositor;
  }

  public void setCompositor(String compositor) {
    this.compositor = compositor;
  }

}
