package com.algaworks.brewer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotBlank;


@Entity//mapeamento da entidade
@Table(name = "redacao")
public class Redacao  implements Serializable{

	private static final long serialVersionUID = 1L;

		//identificador da entidade
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long codigo;
	
		@NotBlank(message = "Descrição é obrigatório")
		private String descricao;
		
		@Enumerated(EnumType.STRING)
		private Competencia1 competencia1;
		
		
		@Enumerated(EnumType.STRING)
		private Competencia2 competencia2;
		
		
		@Enumerated(EnumType.STRING)
		private Competencia3 competencia3;
		
		
		@Enumerated(EnumType.STRING)
		private Competencia4 competencia4;
		
		
		@Enumerated(EnumType.STRING)
		private Competencia5 competencia5;
		
		@Enumerated(EnumType.STRING)
		private Situacao situacao;
		
		private double total;

		
		
		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Competencia1 getCompetencia1() {
			return competencia1;
		}

		public void setCompetencia1(Competencia1 competencia1) {
			this.competencia1 = competencia1;
		}

		
		
		public Competencia2 getCompetencia2() {
			return competencia2;
		}

		public void setCompetencia2(Competencia2 competencia2) {
			this.competencia2 = competencia2;
		}

		public Competencia3 getCompetencia3() {
			return competencia3;
		}

		public void setCompetencia3(Competencia3 competencia3) {
			this.competencia3 = competencia3;
		}

		public Competencia4 getCompetencia4() {
			return competencia4;
		}

		public void setCompetencia4(Competencia4 competencia4) {
			this.competencia4 = competencia4;
		}

		public Competencia5 getCompetencia5() {
			return competencia5;
		}

		public void setCompetencia5(Competencia5 competencia5) {
			this.competencia5 = competencia5;
		}
		
		public Situacao getSituacao() {
			return situacao;
		}
		
		public void setSituacao(Situacao situacao) {
			this.situacao = situacao;
		}
		
		public double getTotal() {
			return total;
		}
		
		public void setTotal(double total) {
			this.total = total;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Redacao other = (Redacao) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			return true;
		}

	
	
		
		
		

}
