package com.mycompany.aplicacionclinica;

public final class Paciente {
    
    // DECLARO LOS ATRIBUTOS CORRESPONDIENTES A LA CLASE DEL PACIENTE
    private String nombre;
    private String documento;
    private int edad;
    private String motivoConsulta;
    private String telefonos;
    private String tipoPaciente;
    private String estado;
    
    
  
    
    
    // CREO EL CONSTRUCTOR CON SUS ATRIBUTOS 
    public Paciente(String nombre, String documento, int edad, String motivoConsulta, String telefonos){
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.motivoConsulta = motivoConsulta;
        this.telefonos = telefonos;
        this.estado = "registrado";    
        validarEdad(); // USO ESTA FUNCIÓN PARA VALIDAR SI ES MAYOR O MENOR Y ASIGNAR SU VALOR EN EL ATRIBUTO DE "TipoPaciente"
    }
    
      // CREO LA FUNCIÓN QUE VALIDARÁ SI ES MAYOR O MENOR DE EDAD
    public void validarEdad(){
        tipoPaciente = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
    }
    
    // GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
        validarEdad();
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}