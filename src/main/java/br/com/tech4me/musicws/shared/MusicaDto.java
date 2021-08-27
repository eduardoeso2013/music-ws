package br.com.tech4me.musicws.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaDto {
    private String id;

    @NotEmpty(message = "O titulo deve ser preenchido")
    @NotBlank(message = "Titulo não pode ter apenas espaços em branco")
    @Size(min = 3, message = "Titulo tem que ter pelo menos 3 caracteres")
    private String titulo;

    @NotEmpty(message = "O album deve ser preenchido")
    @NotBlank(message = "Nome do artista não pode ter apenas espaços em branco")
    @Size(min = 3, message = "Nome do artista tem que ter pelo menos 3 caracteres")
    private String album;

    @NotEmpty(message = "O genero deve ser preenchido")
    @NotBlank(message = "Genero não pode ter apenas espaços em branco")
    @Size(min = 3, message = "Genero tem que ter pelo menos 3 caracteres")
    private String genero;

    // @org.springframework.format.annotation.DateTimeFormat(style = "${dateStyle}")
    @NotEmpty(message = "O ano de lancamento deve ser preenchido")
    @NotBlank(message = "O ano de lancamento não pode ficar em branco")
    @Size(min = 4, message = "O ano tem que ter pelo menos 4 caracteres")
    private String anoLancamento;

    @NotEmpty(message = "O compositor deve ser preenchido")
    @NotBlank(message = "O compositor não pode ficar em branco")
    @Size(min = 4, message = "O nome do compositor tem que ter pelo menos 4 caracteres")
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
