package org.carrito.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.carrito.utils.BaseEntity;



@Entity
@Table(name = "tb_produto")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class Producto extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="tb_nome", length = 80)
	private String nombre;
	
	@Column(name="tb_img", length = 255)
    private String img;
	
	@Column(name="tb_categoria")
    private int categoria;
	
	@Column(name="tb_preco", length = 10)
    private double precio;
	
	@Column(name="tb_stock", length = 10)
    private int stock;
	
	private int cantidad;
	
	private double subtotal;
	
	private double totalvalor;
	
	
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(String nombre, String img, int categoria, double precio, int stock,int cantidad,double subtotal,double totalvalor) {
		super();
		
		this.nombre = nombre;
		this.img = img;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.totalvalor = totalvalor;
		
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {

		this.subtotal = subtotal;
	}
	
	public double setSub(double subtotal) {

		return this.subtotal = subtotal;
	}
	
    
	public double getTotalvalor() {
		return totalvalor;
	}
	public void setTotalvalor(double totalvalor) {
		this.totalvalor = totalvalor;
	}
	public double setTotal(double totalvalor) {
		return this.totalvalor = totalvalor;
	} 
    

}
