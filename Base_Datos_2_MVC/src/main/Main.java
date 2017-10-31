package main;

import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author Azaelmglw
 */
public class Main {
    
    public static void main(String oamg[]){
        ModelPrincipal model_principal = new ModelPrincipal();
        ModelPersonas model_personas = new ModelPersonas();
        ModelDirecciones model_direcciones = new ModelDirecciones();
        
        ViewPrincipal view_principal = new ViewPrincipal();
        ViewPersonas view_personas = new ViewPersonas();
        ViewDirecciones view_direcciones = new ViewDirecciones();
        
        Object models[] = new Object[3];
        Object views[] = new Object[3];
        Object controllers[] = new Object[3];
        
        models[0] = model_principal;
        models[1] = model_personas;
        models[2] = model_direcciones;
        
        views[0] = view_principal;
        views[1] = view_personas;
        views[2] = view_direcciones;
        
        ControllerPrincipal controller_principal = new ControllerPrincipal(models, views, controllers);
        controllers[0] = controller_principal;
        ControllerPersonas controller_personas = new ControllerPersonas(models, views, controllers);
        controllers[1] = controller_personas;
        ControllerDirecciones controller_direcciones = new ControllerDirecciones(models, views, controllers);
        controllers[2] = controller_direcciones;
    }
}
