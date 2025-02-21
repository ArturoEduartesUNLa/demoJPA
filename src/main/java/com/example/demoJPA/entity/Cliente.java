
package com.example.demoJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// @Column(name = "clientePremium")
	private boolean clientePremium;

	public Cliente(boolean clientePremium) {
		super();
		this.clientePremium = clientePremium;
	}

}
