/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.kolo.dto;

/**
 * DTO para el mapeo objeto relacional de la Entidad CarritoEntidad
 * @author Jaime Lasso
 */
public class CarritoComprasDTO {

    /**
     * Construimos atributos de la clase con las columnas de la entidad
     */    
    
    private Long id;
    private FacturaDTO factura;
    //private ProductoDTO producto;
    private Long valorUnitario;
    private Long cantidad;
    private Long total;
}
