package model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table (name="alumnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumnos {
	
	@Id
	private String idcod;
	private String inombre;
	private String iapellido;
	private String isexo;
	private int iedad;
	private double ipeso;
	private int idcar;
	
}
