package com.gs.alagamenos.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Esta classe irá representar a entidade Alerta")
@Data
@Entity
@Table(name = "ALERTA")
public class Alerta {

	@Schema(description = "Este atributo representa a chave primária ID", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Schema(description = "Este atributo representa a mensagem de um alerta")
	@NotEmpty(message = "Não é permitido a inserção de alerta sem uma mensagem")
	private String mensagem;
	
	@Schema(description = "Este atributo representa a data de criação de um alerta")
	@NotNull(message = "Não é permitido a inserção de alerta sem data de criação")
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name= "RUA_ID", nullable = false)
	@NotNull(message = "Não é permitido incluir alerta sem rua")
	@Schema(description = "Este atributo representa a instância de uma rua.")
	private Rua rua;
	
}
