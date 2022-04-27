package model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table (name="carrera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
	
	@Id
	private String idcar;
	private String idescripcion;
	private String iduracion;	
}
