package controllers;

import models.ModelDirecciones;
import views.ViewDirecciones;

/**
 *
 * @author Azaelmglw
 */

public class ControllerDirecciones {
    private final ModelDirecciones model_direcciones;
    private final ViewDirecciones view_direcciones;
    
    public ControllerDirecciones(Object models[], Object views[], Object controllers[]){
        this.model_direcciones = (ModelDirecciones)models[2];
        this.view_direcciones = (ViewDirecciones)views[2];
        initView();
    }
    
    public void initView(){
        view_direcciones.jtf_id_direccion.setEnabled(false);
        Agregar_Action_Listeners();
        Actualizar_Display();
    }
    
    public void Agregar_Action_Listeners(){
        view_direcciones.jbtn_primero.addActionListener(e -> jbtn_primeroMouseClicked());
        view_direcciones.jbtn_anterior.addActionListener(e -> jbtn_anteriorMouseClicked());
        view_direcciones.jbtn_siguiente.addActionListener(e -> jbtn_siguienteMouseClicked());
        view_direcciones.jbtn_ultimo.addActionListener(e -> jbtn_ultimoMouseClicked());
        view_direcciones.jbtn_modificar.addActionListener(e -> jbtn_modificarMouseClicked());
        view_direcciones.jbtn_agregar.addActionListener(e -> jbtn_agregarMouseClicked());
        view_direcciones.jbtn_eliminar.addActionListener(e -> jbtn_eliminarMouseClicked());
        view_direcciones.jbtn_nuevo.addActionListener(e -> jbtn_nuevoMouseClicked());
    }
    
    public void getValores(){
        view_direcciones.jtf_id_direccion.setText(model_direcciones.getID_Direccion());
        view_direcciones.jtf_calle_direccion.setText(model_direcciones.getCalle_Direccion());
        view_direcciones.jtf_colonia_direccion.setText(model_direcciones.getColonia_Direccion());
        view_direcciones.jtf_numero_direccion.setText("" + model_direcciones.getNumero_Direccion());
        view_direcciones.jtf_ciudad_direccion.setText(model_direcciones.getCiudad_Direccion());
        view_direcciones.jtf_estado_direccion.setText(model_direcciones.getEstado_Direccion());
    }
    
    public void setValores(){
        model_direcciones.setId_Direccion(view_direcciones.jtf_id_direccion.getText());
        model_direcciones.setCalle_Direccion(view_direcciones.jtf_calle_direccion.getText());
        model_direcciones.setColonia_Direccion(view_direcciones.jtf_colonia_direccion.getText());
        model_direcciones.setNumero_Direccion(Integer.parseInt(view_direcciones.jtf_numero_direccion.getText()));
        model_direcciones.setCiudad_Direccion(view_direcciones.jtf_ciudad_direccion.getText());
        model_direcciones.setEstado_Direccion(view_direcciones.jtf_estado_direccion.getText());
    }
    
    public void Actualizar_Display(){
        model_direcciones.Consultar_Direcciones();
        model_direcciones.Mover_Primero();
        model_direcciones.Asignar_Valores();
        getValores();
    }
    
    public void jbtn_primeroMouseClicked(){
        model_direcciones.Mover_Primero();
        getValores();
    }
    
    public void jbtn_anteriorMouseClicked(){
        model_direcciones.Mover_Anterior();
        getValores();
    }
    
    public void jbtn_siguienteMouseClicked(){
        model_direcciones.Mover_Siguiente();
        getValores();
    }
    
    public void jbtn_ultimoMouseClicked(){
        model_direcciones.Mover_Ultimo();
        getValores();
    }
    
    public void jbtn_modificarMouseClicked(){
        setValores();
        model_direcciones.Modificar_Usuario();
        Actualizar_Display();
    }
    
    public void jbtn_agregarMouseClicked(){
        setValores();
        model_direcciones.Insertar_Usuario();
        Actualizar_Display();
    }
    
    public void jbtn_eliminarMouseClicked(){
        setValores();
        model_direcciones.Eliminar_Usuario();
        Actualizar_Display();
    }
    
    public void jbtn_nuevoMouseClicked(){
        view_direcciones.jtf_id_direccion.setText("");
        view_direcciones.jtf_calle_direccion.setText("");
        view_direcciones.jtf_colonia_direccion.setText("");
        view_direcciones.jtf_numero_direccion.setText("");
        view_direcciones.jtf_ciudad_direccion.setText("");
        view_direcciones.jtf_estado_direccion.setText("");
    }
}
