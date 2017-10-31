package controllers;

import models.ModelPrincipal;
import views.ViewPrincipal;
import views.ViewPersonas;
import views.ViewDirecciones;

/**
 *
 * @author Azaelmglw
 */

public class ControllerPrincipal {
    private final ModelPrincipal model_principal;
    private final ViewPrincipal view_principal;
    private final ViewPersonas view_personas;
    private final ViewDirecciones view_direcciones;
    
    public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
        this.model_principal = (ModelPrincipal)models[0];
        this.view_principal = (ViewPrincipal)views[0];
        this.view_personas = (ViewPersonas)views[1];
        this.view_direcciones = (ViewDirecciones)views[2];
        initView();
    }
    
    public void initView(){
        view_principal.setTitle("Base de Datos MVC");
        view_principal.setLocationRelativeTo(null);
        view_principal.setVisible(true);
        Agregar_Action_Listeners();
    }
    
    public void Agregar_Action_Listeners(){
        view_principal.jmi_personas.addActionListener(e -> jmi_personasMouseClicked());
        view_principal.jmi_direcciones.addActionListener(e -> jmi_direccionesMouseClicked());
    }
    
    public void jmi_personasMouseClicked(){
        view_principal.setContentPane(view_personas);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
    public void jmi_direccionesMouseClicked(){
        view_principal.setContentPane(view_direcciones);
        view_principal.revalidate();
        view_principal.repaint();
    }
    
}
