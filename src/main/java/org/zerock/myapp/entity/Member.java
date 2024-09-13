package org.zerock.myapp.entity;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.zerock.myapp.listener.CommonEntityLifecyleListener;

import lombok.Data;


@Data

@EntityListeners(CommonEntityLifecyleListener.class)

@Entity(name = "Member")
@Table(name = "member")
public class Member implements Serializable {
	@Serial private static final long serialVersionUID = 1L;

	// 1. Set PK
	@Id
	@SequenceGenerator(name = "MySequenceGenerator", sequenceName = "seq_member")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MySequenceGenerator")
	@Column(name = "member_id")
	private Long id;
	
	
	// 2. Set Generals.
	@Basic(optional = false, fetch = FetchType.EAGER)	// Not Null Constraint, Eager Loading
	private String name;
	
	
	
	// =============================================
	// OneToMany (1:N), Uni-directional Association
	// =============================================
	
	// FK property *Not necessary
	// because of OneToMany association.
	
	// No FK.	
	
   
	
	
} // end class


