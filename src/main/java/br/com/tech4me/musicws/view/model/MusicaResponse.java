package br.com.tech4me.musicws.view.model;

public class MusicaResponse {
  private String id;
  private String titulo;
  private String album;
  private String genero;
  private String anoLancamento;
  private String compositor;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAlbum() {
    return album;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public String getNomeCompleto() {
    return String.format("%s %s", this.titulo, this.album);
  }

  public void setAnoLancamento(String anoLancamento) {
    this.anoLancamento = anoLancamento;
  }

  public String getAnoLancamento() {
    return anoLancamento;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getGenero() {
    return genero;
  }

  public String getCompositor() {
    return compositor;
  }

  public void setCompositor(String compositor) {
    this.compositor = compositor;
  }
}
