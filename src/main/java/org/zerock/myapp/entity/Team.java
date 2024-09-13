package org.zerock.myapp.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zerock.myapp.listener.CommonEntityLifecyleListener;

import lombok.Data;


@Data

@EntityListeners(CommonEntityLifecyleListener.class)

@Entity(name = "Team")
@Table(name = "team")
public class Team implements Serializable {	
	@Serial private static final long serialVersionUID = 1L;

	// 1. Set PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")	// Set mapping column name
	private Long id;			// PK
	
	
	// 2. Set Generals
	@Basic(optional = false)	// Not Null Constraint
	private String name;
	
	
	
	// =============================================
	// OneToMany (1:N), Uni-directional Association
	// =============================================
	
//	@OneToMany									// 1
//	@OneToMany(mappedBy)						// 2, XX - In case of @OneToMany, UNI, NOT specified.
	@OneToMany(targetEntity = Member.class)		// 3
//	@OneToMany(targetEntity = Member.class, cascade = CascadeType.ALL)	// 4
	
	/**
	 * -------------------------------
	 * @JoinColumn
	 * -------------------------------
	 * (1) Set the FK column name of Many (Child) table. (***)
	 * (2) If @JoinColumn annotation abbreviated,
	 * 	   The default FK column name = 
	 * 			The name of the entity + "_" + The name of the referenced primary key column.
	 * (3) @JoinColumn(table): The name of the table that contains the FK column.
	 * 	   If `table` propery *Not specified,
	 * 	   The FK column is assumed to be in the primary table of the applicable entity. 
	 * -------------------------------
	 */
	
//	@JoinColumn														// 1
	@JoinColumn(name = "my_team", referencedColumnName = "team_id")	// 2
	
	// @OneToMany, UNI 매핑에서는, @JoinColumn 어노테이션 속성중에, table 속성을 지정해서는 안됩니다. (***)
//	@JoinColumn(name = "my_team", referencedColumnName = "team_id", table = "member")	// 3
	
	private List<Member> members = new ArrayList<>();
	
		
	
	
} // end class

