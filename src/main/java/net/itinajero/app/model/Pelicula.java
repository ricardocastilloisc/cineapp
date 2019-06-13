package net.itinajero.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private int duracion = 100;
	private String genero;
	private String clasificacion = "B";
	private String imagen = "cinema.png";
	private Date fechaEstreno;
	private String estatus = "Activa";
	
	private Detalle detalle;
	
	public Detalle getDetalle() {
		return detalle;
	}


	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}


	public int getId() {
		return id;
	}
	
	
	public Pelicula() {
		System.out.println("Contructor pelicula");
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero
				+ ", clasificacion=" + clasificacion + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", estatus=" + estatus + ", detalle=" + detalle + "]";
	}
	
	
	


}
