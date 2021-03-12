package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Visualizacao {
	private int id;
	private String datahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private int nota;
	private Usuario usuario;
	private Video video;

	public Visualizacao(int id, int nota, Usuario usuario, Video video) {
		this.id = id;
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}

	public int getId() {
		return id;
	}

	public String getdatahora() {
		return datahora;
	}

	public Usuario getusuario() {
		return this.usuario;
	}

	public String getvideo() {
		return this.video.getlink();
	}

	public int getnota() {
		return this.nota;
	}


	@Override
	public String toString() {
		return "Visualizacao [id=" + id +
				", datahora=" + datahora +
				", nota=" + nota +
				"\n usuario=" + usuario+ ", video=" + video.getNome() + "]";
	}

}
