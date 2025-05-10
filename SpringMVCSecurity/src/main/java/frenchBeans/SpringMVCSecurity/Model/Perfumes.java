package frenchBeans.SpringMVCSecurity.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Perfumes")
public class Perfumes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int perfumeId;
	
	private String perfumeName;
	
	private double mililitres;
	
	public Perfumes() {
		
	}

	public Perfumes( String perfumeName, double mililitres) {
		
		
		this.perfumeName = perfumeName;
		this.mililitres = mililitres;
	}

	public int getPerfumeId() {
		return perfumeId;
	}

	public void setPerfumeId(int perfumeId) {
		this.perfumeId = perfumeId;
	}

	public String getPerfumeName() {
		return perfumeName;
	}

	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}

	public double getMililitres() {
		return mililitres;
	}

	public void setMililitres(double mililitres) {
		this.mililitres = mililitres;
	}
	
	
}
