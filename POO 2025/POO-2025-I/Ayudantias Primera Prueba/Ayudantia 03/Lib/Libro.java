package dominio;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private String estado;
	
	public Libro(int id, String titulo, String autor, int anio, String estado) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anio;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Titulo: " + titulo + ", Autor: " + autor + ", Año de Publicacion: " + anioPublicacion
				+ ", Estado: " + estado;
	}
	
	

}
